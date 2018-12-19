/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EtapaEquipo;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import sistemapractica.Equipo;
import sistemapractica.EtapaFinal;

/**
 * FXML Controller class
 *
 * @author elton
 */
public class EtapaEquiposController implements Initializable {

    @FXML
    private TableView<EtapaFinal> tablaCantidad;
    @FXML
    private TableColumn<EtapaFinal, String> idEtapaCL;
    @FXML
    private TableColumn<EtapaFinal, String> CantidadCL;
    
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("SistemaPracticaPU");
    EntityManager em=emf.createEntityManager();
    
    @FXML
    private TextField CantidadTF;
    @FXML
    private Button agregarBT;
    @FXML
    private Button eliminarBT;

    private final ObservableList<EtapaFinal>lista=FXCollections.observableArrayList();
    private final List<EtapaFinal>listaEtapa=new ArrayList<>();
    int posicionEquipoEnTabla;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.iniciarDatos();
        Platform.runLater(() -> {
        CantidadTF.requestFocus();
        });
        this.inicializarTablaEquipo();
    }    
    @FXML
    public void agregar(){
    em.getTransaction().begin();
    EtapaFinal etapa=new EtapaFinal();
    etapa.setCantidadpart(Integer.parseInt(CantidadTF.getText()));
    em.persist(etapa);
    em.getTransaction().commit();
    Platform.runLater(() -> {
        this.iniciarDatos();
    });
    }    
    public EtapaFinal getTablaEquipoSeleccionado() {
        if (tablaCantidad != null) {
            List<EtapaFinal> tabla = tablaCantidad.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final EtapaFinal competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    private void ponerPersonaSeleccionada() {
        final EtapaFinal etapa = getTablaEquipoSeleccionado();
        posicionEquipoEnTabla = lista.indexOf(etapa);
        if (etapa != null) {
            //Se pone los TextField con los Datos Correspondientes//
           // nombreTF.setText(equipo.getNombreEquipo());
            etapa.setCantidadpart(Integer.parseInt(CantidadTF.getText()));
            eliminarBT.setDisable(true);
        }
    }
   
    public void inicializarTablaEquipo() {
        tablaCantidad.setItems(lista);
        idEtapaCL.setCellValueFactory(new PropertyValueFactory<>("idetapaFinal"));
        CantidadCL.setCellValueFactory(new PropertyValueFactory<>("cantidadpart"));
    }
    
    public void iniciarDatos() {
        lista.clear();
        TypedQuery<EtapaFinal> consulta = em.createQuery("SELECT e FROM EtapaFinal e ", EtapaFinal.class);
        lista.addAll(consulta.getResultList());
    }
}


