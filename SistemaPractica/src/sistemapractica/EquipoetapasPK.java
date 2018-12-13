/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapractica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author elton
 */
@Embeddable
public class EquipoetapasPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "etapaFinal_idetapaFinal")
    private int etapaFinalidetapaFinal;
    @Basic(optional = false)
    @Column(name = "equipo_idequipo")
    private int equipoIdequipo;

    public EquipoetapasPK() {
    }

    public EquipoetapasPK(int etapaFinalidetapaFinal, int equipoIdequipo) {
        this.etapaFinalidetapaFinal = etapaFinalidetapaFinal;
        this.equipoIdequipo = equipoIdequipo;
    }

    public int getEtapaFinalidetapaFinal() {
        return etapaFinalidetapaFinal;
    }

    public void setEtapaFinalidetapaFinal(int etapaFinalidetapaFinal) {
        this.etapaFinalidetapaFinal = etapaFinalidetapaFinal;
    }

    public int getEquipoIdequipo() {
        return equipoIdequipo;
    }

    public void setEquipoIdequipo(int equipoIdequipo) {
        this.equipoIdequipo = equipoIdequipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) etapaFinalidetapaFinal;
        hash += (int) equipoIdequipo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipoetapasPK)) {
            return false;
        }
        EquipoetapasPK other = (EquipoetapasPK) object;
        if (this.etapaFinalidetapaFinal != other.etapaFinalidetapaFinal) {
            return false;
        }
        if (this.equipoIdequipo != other.equipoIdequipo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemapractica.EquipoetapasPK[ etapaFinalidetapaFinal=" + etapaFinalidetapaFinal + ", equipoIdequipo=" + equipoIdequipo + " ]";
    }
    
}
