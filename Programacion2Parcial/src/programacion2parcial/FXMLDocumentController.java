/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion2parcial;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author elton
 */
public class FXMLDocumentController implements Initializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Programacion2ParcialPU");
    EntityManager em = emf.createEntityManager();

    private Label label;
    @FXML
    private TableView<Personajes> tablaPersonas;
    @FXML
    private TableColumn<Personajes, String> nombreCL;
    @FXML
    private TableColumn<Personajes, String> aliasCL;
    @FXML
    private TableColumn<Personajes, String> poderCL;
    @FXML
    private TableColumn<Personajes, String> direccionCL;
    @FXML
    private TableColumn<Personajes, String> telefonoCL;
    @FXML
    private TableColumn<Personajes, String> correoCL;
    //private final ObservableList<Persona> personas = FXCollections.observableArrayList();//Almacena los datos en forma de Lista de arreglos//
    private final ObservableList<Personajes> lista = FXCollections.observableArrayList();//Almacena los datos en forma de Lista de arreglos//
    private final List<Personajes> listaPersona = new ArrayList<>();
    private int posicionPersonaEnTabla;//Se declara una variable de tipo entero (identifica la posicion o indice de la persona en la tabla)
    //Declaramos los TextField//

    @FXML
    private TextField nombreTF;
    @FXML
    private TextField aliasTF;
    @FXML
    private TextField poderTF;
    @FXML
    private TextField direccionTF;
    @FXML
    private TextField telefonoTF;
    @FXML
    private TextField correoTF;
    @FXML
    private Button eliminarBT;
    @FXML
    private Button aniadirBT;
    @FXML
    private Button nuevoBT;
    @FXML
    private Button modificarBT;
    @FXML
    private AnchorPane raiz;

    // List<Personajes> lista=new ArrayList();
    @FXML
    private void aniadir() {
        em.getTransaction().begin();
        Personajes persona = new Personajes();
        persona.setNombre(nombreTF.getText());//lo que haya en el nombreTF que me lo traiga como texto(getText) y lo ponga en el atributo nombre
        persona.setAlias(aliasTF.getText());
        persona.setPoder(poderTF.getText());//en vez de getText se usa parseInt para valores entero//
        persona.setPoder(direccionTF.getText());//en vez de getText se usa parseInt para valores entero//
        persona.setTelefono(telefonoTF.getText());
        persona.setCorreo(correoTF.getText());
        em.persist(persona);
        em.getTransaction().commit();
        Platform.runLater(() -> {
            this.iniciarDatos();
            //em.close();
        });
        // Integer ci = Integer.parseInt(ciTF.getText());
        // persona.setCi(ci);

    }

    @FXML
    private void modificar(ActionEvent event) {
        em.getTransaction().begin();

        //lista.set(posicionPersonaEnTabla, persona);//Se selecciona una fila en la tabla y trae todos los datos guardados de esa fila para poder modificar//
        //em.persist(persona);
        em.getTransaction().commit();
        Platform.runLater(() -> {
            this.iniciarDatos();
        });
    }

    @FXML
    private void nuevo(ActionEvent event) {
        nombreTF.setText("");
        aliasTF.setText("");
        poderTF.setText("");
        direccionTF.setText("");
        telefonoTF.setText("");
        correoTF.setText("");
        modificarBT.setDisable(true);//Disable true (No da la opcion de modificar)
        eliminarBT.setDisable(true);//Disable true (No da la opcion de eliminar)
        aniadirBT.setDisable(false);//Disable false (Da la opcion de añadir)
    }

    @FXML
    private void eliminar(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ELIMINAR Personajes");
        alert.setHeaderText("ALERTA, ALERTA, ALERTA");
        alert.setContentText("Estás seguro de eliminar el registro?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            em.getTransaction().begin();
            Personajes p = tablaPersonas.getSelectionModel().getSelectedItem();
            System.out.println("Se ha seleccionado: " + p.getNombre());
            em.remove(p);
            em.getTransaction().commit();
            Platform.runLater(() -> {
                this.iniciarDatos();
            });
        } else {
            System.out.println("NO");
        }
    }

    public Personajes getTablaPersonasSeleccionada() {
        if (tablaPersonas != null) {
            List<Personajes> tabla = tablaPersonas.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Personajes competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    private void ponerPersonaSeleccionada() {
        final Personajes persona = getTablaPersonasSeleccionada();
        posicionPersonaEnTabla = lista.indexOf(persona);
        if (persona != null) {
            //Se pone los TextField con los Datos Correspondientes//
            nombreTF.setText(persona.getNombre());
            aliasTF.setText(persona.getAlias());
            poderTF.setText(persona.getPoder());
            direccionTF.setText(persona.getDireccion());
            telefonoTF.setText(persona.getTelefono());
            correoTF.setText(persona.getCorreo());
            //Se pone los botones en su estado correspondiente//
            modificarBT.setDisable(false);
            eliminarBT.setDisable(false);
            aniadirBT.setDisable(true);

        }
    }

    public void inicializarTablaPersonas() {
        tablaPersonas.setItems(lista);
        nombreCL.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        aliasCL.setCellValueFactory(new PropertyValueFactory<>("alias"));
        poderCL.setCellValueFactory(new PropertyValueFactory<>("poder"));
        direccionCL.setCellValueFactory(new PropertyValueFactory<>("poder"));
        telefonoCL.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        correoCL.setCellValueFactory(new PropertyValueFactory<>("correo"));

        /*FilteredList<Personajes> Centinela = new FilteredList<>(personas, persona -> true);
        BuscarTF.textProperty().addListener((Observar, Lista, Evaluar) -> {
            Centinela.setPredicate(persona -> {
                // El componente TextField(Buscar) esta vacio muestra los datos de las personas en la tabla//
                if (Evaluar == null || Evaluar.isEmpty()) {
                    return true;
                }

                // Compara campos de la tabla, condicionales creadas para nombre, apellido y ciudad
                String lowerCaseFilter = Evaluar.toLowerCase();

                if (persona.getNombre().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Al ingresar el nombre empieza a buscar en la tabla y lo trae
                } else if (persona.getAlias().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Al ingresar el apellido empieza a buscar en la tabla y lo trae
                } else if (persona.getDireccion().toLowerCase().contains(lowerCaseFilter)) {
                    return true;    // Al ingresar la ciudad empieza a buscar en la tabla y lo trae 
                }
                return false; // si no hay nada coincidencias en nombre,apellido y ciudad la tabla desaparece por un momento hasta que se deje vacio la parte de buscar
            });
        });*/
        // 3. Asignacion de la lista FilteredList a SortedList(libreria)        SortedList<Personajes> BuscarDato = new SortedList<>(Centinela);*/
        // 4.crea una conexion ordenada de la lista de personas con textfield de buscar
        // BuscarDato.comparatorProperty().bind(tablaPersonas.comparatorProperty());
        // 5. Trae los datos de las personas ordenados a las filas de la tabla.
        // tablaPersonas.setItems(BuscarDato);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.iniciarDatos();
        Platform.runLater(() -> {
            nombreTF.requestFocus();
        });
        this.inicializarTablaPersonas();
        modificarBT.setDisable(true);
        //eliminarBT.setDisable(true);

        //Seleccionar las tuplas de la tabla persona(Tupla: Es la secuencia de valores agrupados en la tabla)//
        //  final ObservableList<Persona> tablaPersonaSel = tablaPersonas.getSelectionModel().getSelectedItems();
        // tablaPersonaSel.addListener(selectorTablaPersonas);
    }

    public void iniciarDatos() {
        lista.clear();
        TypedQuery<Personajes> consulta = em.createQuery("SELECT p FROM Personajes p ", Personajes.class);
        lista.addAll(consulta.getResultList());

    }

    /*@FXML
    public void modificarlista() {
        em.getTransaction().begin();
        Personajes persona = tablaPersonas.getSelectionModel().getSelectedItem();
        persona.setNombre(nombreTF.getText());
        em.merge(persona);
        em.getTransaction().commit();
        Platform.runLater(() -> {
            this.iniciarDatos();
            //em.close();
        });

        System.out.println("Nombre: " + persona.getNombre());
        nombreTF.setText(persona.getNombre());
        modificarBT.setDisable(false);
        eliminarBT.setDisable(false);*/
        //persona.setNombre(nombreTF.getText());//lo que haya en el nombreTF que me lo traiga como texto(getText) y lo ponga en el atributo nombre
        //persona.setApellido(apellidoTF.getText());
        //persona.setCi(ciTF.getText());//en vez de getText se usa parseInt para valores entero//
        //persona.setTelefono(telefonoTF.getText());
        //persona.setDireccion(ciudadTF.getText());
    //}
  /*  private void ani(KeyEvent bot) {
        KeyCombination btonuevo = new KeyCodeCombination(KeyCode.ENTER, KeyCombination.ALT_ANY);
            //this.aniadir();
            if(bot.equals(btonuevo)){
                System.out.println("OK");
                this.aniadir();
            }else{
                System.out.println("error");
            }
    }

    //  @FXML
    //  private void nuevo(ActionEvent event) {
    //  }
*/
    @FXML
    private void ani() {
         KeyCombination btonuevo = new KeyCodeCombination(KeyCode.ENTER, KeyCombination.ALT_ANY);
         raiz.setOnKeyPressed((KeyEvent event1Event)->{
             aniadir();
         });
    }
}
