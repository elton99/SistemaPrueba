/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inscripcion;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
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
import sistemapractica.Inscripcion;

/**
 * FXML Controller class
 *
 * @author elton
 */
public class InscripcionesController implements Initializable {

    @FXML
    private TableView<Inscripcion> tablaInscripcion;
    @FXML
    private TableColumn<Inscripcion, String> idCL;
    @FXML
    private TableColumn<Inscripcion, String> montoCL;
    
    
    @FXML
    private ComboBox<Equipo> comboEQ;
    @FXML
    
    private TextField montoTF;
   
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("SistemaPracticaPU");
    EntityManager em=emf.createEntityManager();
   
    @FXML
    private Button agregarBT;
    @FXML
    private Button modificarBT;
    @FXML
    private Button eliminarBT;
    @FXML
    private Button buscarBT;
    
    private final ObservableList<Inscripcion>lista=FXCollections.observableArrayList();
    private final List<Inscripcion>listaMonto=new ArrayList<>();
    private final ObservableList<Equipo> listaEquipo=FXCollections.observableArrayList();
    int posicionEquipoEnTabla;
    public Inscripcion is=new Inscripcion();

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.getEquipo();
        this.iniciarDatos();
        Platform.runLater(() -> {
        montoTF.requestFocus();
        });
        this.inicializarTablaInscripcion();
        modificarBT.setDisable(true);
        eliminarBT.setDisable(true);
    }    
    @FXML
    public void agregar(){
    Equipo g = new Equipo();
    g = comboEQ.getSelectionModel().getSelectedItem();
    em.getTransaction().begin();
    Inscripcion mon=new Inscripcion();
    mon.setInscripcionPrecio(Integer.parseInt(montoTF.getText()));
    mon.setIdtable1(g);
    em.persist(mon);
    em.getTransaction().commit();
    Platform.runLater(() -> {
        this.iniciarDatos();
    });
    }
    @FXML
    private void eliminar(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ELIMINAR Inscripcion Registro");
        alert.setHeaderText("ALERTA, ALERTA, ALERTA");
        alert.setContentText("Estás seguro de eliminar el registro?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            em.getTransaction().begin();
            Inscripcion p = tablaInscripcion.getSelectionModel().getSelectedItem();
            System.out.println("Se ha seleccionado: " + p.getInscripcionPrecio());
            em.remove(p);
            em.getTransaction().commit();
            Platform.runLater(() -> {
                this.iniciarDatos();
            });
        } else {
            System.out.println("NO");
        }
    }
    public Inscripcion getTablaEquipoSeleccionado() {
        if (tablaInscripcion != null) {
            List<Inscripcion> tabla = tablaInscripcion.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Inscripcion competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }
    private void ponerPersonaSeleccionada() {
        final Inscripcion etapa = getTablaEquipoSeleccionado();
        posicionEquipoEnTabla = lista.indexOf(etapa);
        if (etapa != null) {
            //Se pone los TextField con los Datos Correspondientes//
           // nombreTF.setText(equipo.getNombreEquipo());
            etapa.setInscripcionPrecio(Integer.parseInt(montoTF.getText()));
            eliminarBT.setDisable(false);
            modificarBT.setDisable(false);
            agregarBT.setDisable(true);
        }
        
    }
     public void inicializarTablaInscripcion() {
        tablaInscripcion.setItems(lista);
        idCL.setCellValueFactory(new PropertyValueFactory<>("idtable1"));
        montoCL.setCellValueFactory(new PropertyValueFactory<>("inscripcionPrecio"));
    }
    
    public void iniciarDatos() {
        lista.clear();
        TypedQuery<Inscripcion> consulta = em.createQuery("SELECT i FROM Inscripcion i ", Inscripcion.class);
        lista.addAll(consulta.getResultList());
    }
    @FXML
    private void modificarlista() {
        is = tablaInscripcion.getSelectionModel().getSelectedItem();
        System.out.println("Cantidad de dinero = " + is.getInscripcionPrecio());
        //etap.setCantidadpart(Integer.parseInt(CantidadTF.getText()));
        is.setInscripcionPrecio(posicionEquipoEnTabla);
        modificarBT.setDisable(false);
        eliminarBT.setDisable(false);
    }
    @FXML
    private void mod(ActionEvent event) {
        Inscripcion e = is;
        em.getTransaction().begin();
        e.setInscripcionPrecio(Integer.parseInt(montoTF.getText()));
        em.merge(e);
        em.getTransaction().commit();
        Platform.runLater(() -> {
        this.iniciarDatos();
        });
    }
    public List<Equipo> getEquipo(){
        TypedQuery<Equipo> e=em.createQuery("SELECT e FROM Equipo e",Equipo.class);
        listaEquipo.addAll(e.getResultList());
        comboEQ.setItems(listaEquipo);
        this.comboEQ.setCellFactory((ListView<Equipo> param) -> new InscripcionListCell());
        //this.comboGP.getSelectionModel().select(0);
        //this.comboGP.setButtonCell(new GrupoListCell());
        //this.comboGP.setConverter();
        return null;
    }
    
    
}
