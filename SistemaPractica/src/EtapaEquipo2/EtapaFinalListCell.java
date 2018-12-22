/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EtapaEquipo2;

import javafx.scene.control.ListCell;
import sistemapractica.EtapaFinal;

/**
 *
 * @author elton
 */
public class EtapaFinalListCell extends ListCell<EtapaFinal>{
    @Override
    protected void updateItem(EtapaFinal fi, boolean va){ 
        if (fi != null) {
            super.setText(fi.getIdetapaFinal().toString());
        } else {
           super.setText("");
        }
        super.updateItem(fi, va);
    
    }
    
}
