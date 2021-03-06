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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
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
import sistemapractica.Grupos;
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
    private final ObservableList<Grupos> listaGrupo=FXCollections.observableArrayList();
    int posicionEquipoEnTabla;
    
    
    @FXML
    private TextField nombreTF;
    @FXML
    private Button modificarBT;
    @FXML
    private Button BuscarTF;
    
    public Equipo eq=new Equipo();
    @FXML
    private ComboBox<Grupos> comboGP;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.getGrupos();
        this.iniciarDatos();
        Platform.runLater(() -> {
        nombreTF.requestFocus();
        });
        this.inicializarTablaEquipo();
        modificarBT.setDisable(true);
        eliminarBT.setDisable(true);
        
    }
    @FXML
    public void agregar(){
    Grupos g=new Grupos();
    g = comboGP.getSelectionModel().getSelectedItem();
    em.getTransaction().begin();
    Equipo eq=new Equipo();
    eq.setNombreEquipo(nombreTF.getText());
    eq.setGruposIdgrupos(g);
    em.persist(eq);
    em.getTransaction().commit();
    Platform.runLater(() -> {
        this.iniciarDatos();
    });
    }   
     @FXML
    private void eliminar(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ELIMINAR EQUIPO");
        alert.setHeaderText("ALERTA, ALERTA, ALERTA");
        alert.setContentText("Seguro de eliminar el nombre del equipo?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            em.getTransaction().begin();
            Equipo p = tablaEquipos.getSelectionModel().getSelectedItem();
            System.out.println("Se ha seleccionado: " + p.getNombreEquipo());
            em.remove(p);
            em.getTransaction().commit();
            Platform.runLater(() -> {
                this.iniciarDatos();
            });
        } else {
            System.out.println("NO");
        }
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
            modificarBT.setDisable(false);
            eliminarBT.setDisable(false);
            agregarBT.setDisable(true);
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
    @FXML
    private void modificarlista() {
        eq = tablaEquipos.getSelectionModel().getSelectedItem();
        System.out.println("Nombre = " + eq.getNombreEquipo());
        nombreTF.setText(eq.getNombreEquipo());
        modificarBT.setDisable(false);
        eliminarBT.setDisable(false);

    }

    @FXML
    private void mod(ActionEvent event) {
        Equipo e = eq;
        em.getTransaction().begin();
        e.setNombreEquipo(nombreTF.getText());
        em.merge(e);
        em.getTransaction().commit();
        Platform.runLater(() -> {
            this.iniciarDatos();
        });
    }
    public List<Grupos> getGrupos(){
        TypedQuery<Grupos> q=em.createQuery("SELECT g FROM Grupos g",Grupos.class);
        listaGrupo.addAll(q.getResultList());
        comboGP.setItems(listaGrupo);
        this.comboGP.setCellFactory((ListView<Grupos> param) -> new GrupoListCell());
        //this.comboGP.getSelectionModel().select(0);
        //this.comboGP.setButtonCell(new GrupoListCell());
        //this.comboGP.setConverter();
        return null;
    }
    
}
