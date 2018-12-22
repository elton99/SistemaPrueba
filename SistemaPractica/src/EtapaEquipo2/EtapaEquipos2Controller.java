/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EtapaEquipo2;

import equipos.GrupoListCell;
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
import sistemapractica.Equipoetapas;
import sistemapractica.EtapaFinal;
import sistemapractica.Grupos;

/**
 * FXML Controller class
 *
 * @author elton
 */
public class EtapaEquipos2Controller implements Initializable {

    @FXML
    private TableView<Equipoetapas> tablaFase;
    private TableColumn<Equipoetapas, String> idFaseCL;
    private TableColumn<Equipoetapas, String> faseCL;
    
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("SistemaPracticaPU");
    EntityManager em=emf.createEntityManager();
    
    
    @FXML
    private TextField faseTF;
    
    private final ObservableList<Equipoetapas>lista=FXCollections.observableArrayList();
    private final List<Equipoetapas>listaFase=new ArrayList<>();
    private final ObservableList<Equipo> listaEquipo=FXCollections.observableArrayList();
    private final ObservableList<EtapaFinal> listaEtapa=FXCollections.observableArrayList();
    int posicionFaseEnTabla;
    public Equipoetapas etapa=new Equipoetapas();
    @FXML
    private Button agregarBT;
    @FXML
    private Button modificarBT;
    @FXML
    private Button eliminarBT;
    @FXML
    private ComboBox<Equipo> comboEQ1;
    @FXML
    private ComboBox<EtapaFinal> comboEQ2;
    @FXML
    private TableColumn<EtapaFinal,String > EquipoCL;
    @FXML
    private TableColumn<EtapaFinal, String> etapaFinalCL;
    @FXML
    private TableColumn<EtapaFinal, String> FaseCL;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.getEquipo();
        this.getEtapaFinal();
        this.iniciarDatos();
        Platform.runLater(() -> {
        faseTF.requestFocus();
        });
        this.inicializarTablaEquipo();
        modificarBT.setDisable(true);
        eliminarBT.setDisable(true);
    }    
    @FXML
    public void agregar(){
    em.getTransaction().begin();
    Equipo e=new Equipo();
    e = comboEQ1.getSelectionModel().getSelectedItem();
    EtapaFinal f=new EtapaFinal();
    f =comboEQ2.getSelectionModel().getSelectedItem();
    Equipoetapas etapa=new Equipoetapas();
    etapa.setEtapas(faseTF.getText());
    em.persist(etapa);
    em.getTransaction().commit();
    Platform.runLater(() -> {
        this.iniciarDatos();
    });
    }    
    @FXML
    private void eliminar(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ELIMINAR EtapaRegistro");
        alert.setHeaderText("ALERTA, ALERTA, ALERTA");
        alert.setContentText("Estás seguro de eliminar el registro?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            em.getTransaction().begin();
            Equipoetapas p = tablaFase.getSelectionModel().getSelectedItem();
            System.out.println("Se ha seleccionado: " + p.getEtapas());
            em.remove(p);
            em.getTransaction().commit();
            Platform.runLater(() -> {
                this.iniciarDatos();
            });
        } else {
            System.out.println("NO");
        }
    }
    public Equipoetapas getTablaEquipoSeleccionado() {
        if (tablaFase != null) {
            List<Equipoetapas> tabla = tablaFase.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Equipoetapas competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    private void ponerPersonaSeleccionada() {
        final Equipoetapas etapa = getTablaEquipoSeleccionado();
        posicionFaseEnTabla = lista.indexOf(etapa);
        if (etapa != null) {
            //Se pone los TextField con los Datos Correspondientes//
           // nombreTF.setText(equipo.getNombreEquipo());
            //etapa.setCantidadpart(Integer.parseInt(CantidadTF.getText()));
            faseTF.setText(etapa.getEtapas());
            eliminarBT.setDisable(false);
            modificarBT.setDisable(false);
            agregarBT.setDisable(true);
        }
    }
   
    public void inicializarTablaEquipo() {
        tablaFase.setItems(lista);
        EquipoCL.setCellValueFactory(new PropertyValueFactory<>("etapaFinal"));
        etapaFinalCL.setCellValueFactory(new PropertyValueFactory<>("etapaFinalidetapaFinal"));
        faseCL.setCellValueFactory(new PropertyValueFactory<>("etapas"));
    }
     public void iniciarDatos() {
        lista.clear();
        TypedQuery<Equipoetapas> consulta = em.createQuery("SELECT f FROM Equipoetapas f ", Equipoetapas.class);
        lista.addAll(consulta.getResultList());
    }
    @FXML
    private void modificarlista() {
        etapa = tablaFase.getSelectionModel().getSelectedItem();
        System.out.println("Fase numero = " + etapa.getEtapas());
       // etapa.setEtapaFinal(etapa);
        etapa.setEtapas(etapa.getEtapas());
        modificarBT.setDisable(false);
        eliminarBT.setDisable(false);
    }
    @FXML
    private void mod(ActionEvent event) {
        Equipoetapas e = etapa;
        em.getTransaction().begin();
        e.setEtapas(etapa.getEtapas());
        em.merge(e);
        em.getTransaction().commit();
        Platform.runLater(() -> {
        this.iniciarDatos();
        });
    }
    public List<Equipo> getEquipo(){
        TypedQuery<Equipo> o=em.createQuery("SELECT e FROM Equipo e",Equipo.class);
        listaEquipo.addAll(o.getResultList());
        comboEQ1.setItems(listaEquipo);
        this.comboEQ1.setCellFactory((ListView<Equipo> param) -> new EquipoListCell());
        //this.comboGP.getSelectionModel().select(0);
        //this.comboGP.setButtonCell(new GrupoListCell());
        //this.comboGP.setConverter();
        return null;
    }
    public List<EtapaFinal> getEtapaFinal(){
        TypedQuery<EtapaFinal> a=em.createQuery("SELECT f FROM EtapaFinal f",EtapaFinal.class);
        listaEtapa.addAll(a.getResultList());
        comboEQ2.setItems(listaEtapa);
        this.comboEQ2.setCellFactory((ListView<EtapaFinal> param) -> new EtapaFinalListCell());
        //this.comboGP.getSelectionModel().select(0);
        //this.comboGP.setButtonCell(new GrupoListCell());
        //this.comboGP.setConverter();
        return null;
    }
}
