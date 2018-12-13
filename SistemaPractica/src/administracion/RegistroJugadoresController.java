/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author elton
 */
public class RegistroJugadoresController implements Initializable {

    @FXML
    private TableView<?> tablaJugadores;
    @FXML
    private TableColumn<?, ?> nombreCL;
    @FXML
    private TableColumn<?, ?> apellidoCL;
    @FXML
    private TableColumn<?, ?> ciCL;
    @FXML
    private TableColumn<?, ?> sexoCL;
    @FXML
    private TableColumn<?, ?> promoCL;
    @FXML
    private TextField nombreTF;
    @FXML
    private TextField apellidoTF;
    @FXML
    private TextField ciTF;
    @FXML
    private TextField promoTF;
    @FXML
    private RadioButton MasBT;
    @FXML
    private ToggleGroup buttonT;
    @FXML
    private RadioButton FemBT;
    @FXML
    private Button agregarBT;
    @FXML
    private Button nuevoBT;
    @FXML
    private Button modificarBT;
    @FXML
    private Button eliminarBT;
    @FXML
    private Button salirBT;
    @FXML
    private Button volverBT;

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
