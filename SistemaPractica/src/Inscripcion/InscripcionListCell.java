/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inscripcion;

import javafx.scene.control.ListCell;
import sistemapractica.Equipo;

/**
 *
 * @author elton
 */
public class InscripcionListCell extends ListCell<Equipo>{
    @Override
    protected void updateItem(Equipo e, boolean vacio){
       if (e != null) {
            super.setText(e.getIdequipo().toString());
        } else {
           super.setText("");
        }
        super.updateItem(e, vacio);
    }
}
    
