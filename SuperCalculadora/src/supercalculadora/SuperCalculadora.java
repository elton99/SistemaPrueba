/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercalculadora;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
//import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SuperCalculadora extends Application {

    Label mensaje1 = new Label("Ingrese primer valor");
    Label mensaje2 = new Label("Ingrese segundo valor");
    TextField nro1 = new TextField();
    TextField nro2 = new TextField();
    Label total = new Label();
    Label totalmul = new Label();
    Label totalresta = new Label();
    RadioButton multiplicar = new RadioButton("Multiplicar");
    RadioButton sumar = new RadioButton("Sumar");
    RadioButton restar = new RadioButton("Restar");
    HBox botonO = new HBox(multiplicar, sumar, restar);
    Integer res = 0;
    private final ChangeListener<String> validar = (ObservableValue<? extends String> obs, String ol, String n) -> {
        if (n != null) {
            if (!n.isEmpty()) {
                try {
                    Integer var = Integer.parseInt(n);
                    nro2.setText(var.toString());
                } catch (NumberFormatException e) {
                    System.out.println("ERROR AL CONVERIR" + e);
                }
            } else {
                nro2.setText("0");
            }
        }

    };

    @Override
    public void start(Stage primaryStage) {
        Button boton = new Button();
        boton.setText("resultado");
        this.nro2.textProperty().addListener(validar);
        sumar.setSelected(true);
        boton.setOnAction((ActionEvent event) -> {
            this.respuesta();
        });

        multiplicar.setOnAction(
                (ActionEvent event) -> {
                    if (multiplicar.isSelected()) {
                        this.rdbMultiplicar();
                        //this.respuesta();
                    }
                }
        );

        restar.setOnAction(
                (ActionEvent event) -> {
                    if (restar.isSelected()) {
                        this.rdbRestar();
                    }

                }
        );
        
        sumar.setOnAction((ActionEvent event)->{
            if (sumar.isSelected()) {
                rdbSumar();
            }
    });

        VBox root = new VBox();

        root.getChildren()
                .add(botonO);
        root.getChildren()
                .add(mensaje1);
        root.getChildren()
                .add(nro1);
        root.getChildren()
                .add(mensaje2);
        root.getChildren()
                .add(nro2);
        root.getChildren()
                .add(boton);
        root.getChildren()
                .add(total);
        root.getChildren()
                .add(totalmul);
        root.getChildren()
                .add(totalresta);

        Scene scene = new Scene(root, 500, 400);

        primaryStage.setTitle("Calculadora");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public void respuesta() {
        try {

            Integer var1 = Integer.parseInt(nro1.getText());
            Integer var2 = Integer.parseInt(nro2.getText());
            if (multiplicar.isSelected()) {
                res = var1 * var2;
                totalmul.setText(res.toString());
                this.respuestanegativo();
            } else if (sumar.isSelected()) {
                res = var1 + var2;
                total.setText(res.toString());

                this.respuestanegativo();
            } else if (restar.isSelected()) {
                res = var1 - var2;
                totalmul.setText(res.toString());
                this.respuestanegativo();
            }
            
        } catch (NumberFormatException e) {
            Alert dialogoAlerta = new Alert(AlertType.WARNING);
            dialogoAlerta.setContentText("CUIDADO: Por favor ingrese valores numericos");
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta.showAndWait();
            System.out.println("ERROR" + e);
        }
    }

    public void rdbMultiplicar() {
        if (multiplicar.isSelected()) {
            //Integer res=var1+var2;
            sumar.setSelected(false);
            restar.setSelected(false);
        }
    }

    public void rdbSumar() {
        if (sumar.isSelected()) {
            //Integer res=var1+var2;
            multiplicar.setSelected(false);
            restar.setSelected(false);

        }
    }

    public void rdbRestar() {
        if (restar.isSelected()) {
            //Integer res=var1-var2;
            sumar.setSelected(false);
            multiplicar.setSelected(false);
        }
        
        }
    public void respuestanegativo(){
        if(res<0){
                  Alert dialogoAlerta = new Alert(AlertType.WARNING);
            dialogoAlerta.setContentText("TOTAL NEGATIVO");
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta.showAndWait();
            }
    }

    }

