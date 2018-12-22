/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;

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
import sistemapractica.Jugadores;

/**
 * FXML Controller class
 *
 * @author elton
 */
public class JugadoresController implements Initializable {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("SistemaPracticaPU");
    EntityManager em=emf.createEntityManager();
    
    @FXML
    private TableView<Jugadores> tablaJugador;
    @FXML
    private TableColumn<Jugadores, String> nombreCL;
    @FXML
    private TableColumn<Jugadores, String> apellidoCL;
    @FXML
    private TableColumn<Jugadores, String> promoCL;
    @FXML
    private Button agregarBT;
    @FXML
    private Button modificarBT;
    @FXML
    private Button eliminarBT;
    @FXML
    private ComboBox<Equipo> comboEQ;
    @FXML
    private TextField nombreTF;
    @FXML
    private TextField apellidoTF;
    @FXML
    private TextField promoTF;
    
    private final ObservableList<Jugadores>lista=FXCollections.observableArrayList();
    private final List<Jugadores>listaJugador=new ArrayList<>();
    private final ObservableList<Equipo> listaEquipo=FXCollections.observableArrayList();
    int posicionEquipoEnTabla;
    public Jugadores eq=new Jugadores();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.getEquipo();
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
  //  Grupos g=new Grupos();
   // g = comboGP.getSelectionModel().getSelectedItem();
    em.getTransaction().begin();
    Jugadores eq=new Jugadores();
    eq.setNombreJugador(nombreTF.getText());
    //eq.setGruposIdgrupos(g);
    em.persist(eq);
    em.getTransaction().commit();
    Platform.runLater(() -> {
      //  this.iniciarDatos();
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
            Jugadores p = tablaJugador.getSelectionModel().getSelectedItem();
            System.out.println("Se ha seleccionado: " + p.getNombreJugador());
            em.remove(p);
            em.getTransaction().commit();
            Platform.runLater(() -> {
                this.iniciarDatos();
            });
        } else {
            System.out.println("NO");
        }
    }
    public Jugadores getTablaEquipoSeleccionado() {
        if (tablaJugador != null) {
            List<Jugadores> tabla = tablaJugador.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Jugadores competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    private void ponerPersonaSeleccionada() {
        final Jugadores equipo = getTablaEquipoSeleccionado();
        posicionEquipoEnTabla = lista.indexOf(equipo);
        if (equipo != null) {
            //Se pone los TextField con los Datos Correspondientes//
            nombreTF.setText(equipo.getNombreJugador());
            modificarBT.setDisable(false);
            eliminarBT.setDisable(false);
            agregarBT.setDisable(true);
        }
    }
    
    public void inicializarTablaEquipo() {
        tablaJugador.setItems(lista);
        nombreCL.setCellValueFactory(new PropertyValueFactory<>("nombreJugador"));
        apellidoCL.setCellValueFactory(new PropertyValueFactory<>("apellidoJugador"));
        promoCL.setCellValueFactory(new PropertyValueFactory<>("promocion"));

    }
    
    public void iniciarDatos() {
        lista.clear();
        TypedQuery<Jugadores> consulta = em.createQuery("SELECT e FROM Jugadores e ", Jugadores.class);
        lista.addAll(consulta.getResultList());
    }
    @FXML
    private void modificarlista() {
        eq = tablaJugador.getSelectionModel().getSelectedItem();
        System.out.println("Nombre = " + eq.getNombreJugador());
        nombreTF.setText(eq.getNombreJugador());
        modificarBT.setDisable(false);
        eliminarBT.setDisable(false);

    }

    @FXML
    private void mod(ActionEvent event) {
        Jugadores e = eq;
        em.getTransaction().begin();
        e.setNombreJugador(nombreTF.getText());
        em.merge(e);
        em.getTransaction().commit();
        Platform.runLater(() -> {
            this.iniciarDatos();
        });
    }
    public List<Equipo> getEquipo(){
        TypedQuery<Equipo> q=em.createQuery("SELECT g FROM Equipo g",Equipo.class);
        listaEquipo.addAll(q.getResultList());
        comboEQ.setItems(listaEquipo);
        this.comboEQ.setCellFactory((ListView<Equipo> param) -> new EquipoListCell());
        //this.comboGP.getSelectionModel().select(0);
        //this.comboGP.setButtonCell(new GrupoListCell());
        //this.comboGP.setConverter();
        return null;
    }
    
    
    
}
