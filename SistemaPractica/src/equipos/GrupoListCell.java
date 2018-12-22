/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipos;

import javafx.scene.control.ListCell;
import sistemapractica.Grupos;

/**
 *
 * @author elton
 */
public class GrupoListCell extends ListCell<Grupos>{
    @Override
    protected void updateItem(Grupos g, boolean vacio){
       if (g != null) {
            super.setText(g.getIdgrupos().toString());
        } else {
           super.setText("");
        }
        super.updateItem(g, vacio);
    }
    
}
