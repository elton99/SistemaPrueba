/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;

import javafx.scene.control.ListCell;
import sistemapractica.Equipo;

/**
 *
 * @author elton
 */
public class EquipoListCell extends ListCell<Equipo>{
    @Override
    protected void updateItem(Equipo g, boolean vacio){
       if (g != null) {
            super.setText(g.getIdequipo().toString());
        } else {
           super.setText("");
        }
        super.updateItem(g, vacio);
    }
}

