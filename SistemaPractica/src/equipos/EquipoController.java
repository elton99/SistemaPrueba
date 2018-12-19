/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipos;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
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
import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;

/**
 * FXML Controller class
 *
 * @author elton
 */
public class EquipoController implements Initializable {
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("SistemaPracticaPU");
    EntityManager em=emf.createEntityManager();
    
    @FXML
    private TableView<Equipo> tablaEquipos;//Equipo (es de la clase equipo)
    @FXML
    private TableColumn<Equipo, String> idnumeroCL;
    @FXML
    private TableColumn<Equipo, String> nomequipoCL;
    @FXML
    private Button agregarBT;
    @FXML
    private Button eliminarBT;
    
    private final ObservableList<Equipo>lista=FXCollections.observableArrayList();
    private final List<Equipo>listaEquipo=new ArrayList<>();
    int posicionEquipoEnTabla;
    
    @FXML
    private TextField nombreTF;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.iniciarDatos();
        Platform.runLater(() -> {
        nombreTF.requestFocus();
        });
        this.inicializarTablaEquipo();
        
    }
    @FXML
    public void agregar(){
    em.getTransaction().begin();
    Equipo eq=new Equipo();
    eq.setNombreEquipo(nombreTF.getText());
    em.persist(eq);
    em.getTransaction().commit();
    Platform.runLater(() -> {
        this.iniciarDatos();
    });
    }    
    public Equipo getTablaEquipoSeleccionado() {
        if (tablaEquipos != null) {
            List<Equipo> tabla = tablaEquipos.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Equipo competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    private void ponerPersonaSeleccionada() {
        final Equipo equipo = getTablaEquipoSeleccionado();
        posicionEquipoEnTabla = lista.indexOf(equipo);
        if (equipo != null) {
            //Se pone los TextField con los Datos Correspondientes//
            nombreTF.setText(equipo.getNombreEquipo());
            eliminarBT.setDisable(true);
        }
    }
   
    public void inicializarTablaEquipo() {
        tablaEquipos.setItems(lista);
        idnumeroCL.setCellValueFactory(new PropertyValueFactory<>("idequipo"));
        nomequipoCL.setCellValueFactory(new PropertyValueFactory<>("nombreEquipo"));
    }
    
    public void iniciarDatos() {
        lista.clear();
        TypedQuery<Equipo> consulta = em.createQuery("SELECT e FROM Equipo e ", Equipo.class);
        lista.addAll(consulta.getResultList());
    }
}
