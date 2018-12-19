/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapractica;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 *
 * @author elton
 */
public class VistaSistemaController implements Initializable {
    
    private Label label;
    @FXML
    private MenuButton adminM;
    @FXML
    private MenuButton transM;
    @FXML
    private MenuItem campeonatoM;
    @FXML
    private MenuItem gruposM;
    @FXML
    private MenuItem equipoM;
    @FXML
    private MenuItem jugadoresM;
    @FXML
    private MenuItem arbitroM;
    @FXML
    private MenuItem EtapaFinalM;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cargarJugador(ActionEvent event) throws IOException {
        FXMLLoader jugadorLoader= new FXMLLoader(getClass().getResource("/administracion/RegistroJugadores.fxml"));
        Parent jugadorParent=jugadorLoader.load();
        Scene jugadorScene=new Scene(jugadorParent);
        Stage jugadorStage=new Stage();
        jugadorStage.setScene(jugadorScene);
        jugadorStage.show();    
    }
    @FXML
    private void cargarEquipo(ActionEvent event) throws IOException{
        FXMLLoader equipoLoader=new FXMLLoader(getClass().getResource("/equipos/equipo.fxml"));
        Parent equipoParent=equipoLoader.load();
        Scene equipoScene=new Scene(equipoParent);
        Stage equipoStage=new Stage();
        equipoStage.setScene(equipoScene);
        equipoStage.show();
          
    }
    @FXML
    private void cargarEtapaFinal(ActionEvent event) throws IOException{
    FXMLLoader etapaFinalLoader=new FXMLLoader(getClass().getResource("/EtapaEquipo/EtapaEquipos.fxml"));
    Parent etapaParent=etapaFinalLoader.load();
    Scene etapaScene=new Scene(etapaParent);
    Stage etapaStage=new Stage();
    etapaStage.setScene(etapaScene);
    etapaStage.show();
    }
    
}
