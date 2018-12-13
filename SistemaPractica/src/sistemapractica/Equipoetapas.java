/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapractica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author elton
 */
@Entity
@Table(name = "equipoetapas")
@NamedQueries({
    @NamedQuery(name = "Equipoetapas.findAll", query = "SELECT e FROM Equipoetapas e")})
public class Equipoetapas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EquipoetapasPK equipoetapasPK;
    @Column(name = "etapas")
    private String etapas;
    @JoinColumn(name = "equipo_idequipo", referencedColumnName = "idequipo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipo equipo;
    @JoinColumn(name = "etapaFinal_idetapaFinal", referencedColumnName = "idetapaFinal", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EtapaFinal etapaFinal;

    public Equipoetapas() {
    }

    public Equipoetapas(EquipoetapasPK equipoetapasPK) {
        this.equipoetapasPK = equipoetapasPK;
    }

    public Equipoetapas(int etapaFinalidetapaFinal, int equipoIdequipo) {
        this.equipoetapasPK = new EquipoetapasPK(etapaFinalidetapaFinal, equipoIdequipo);
    }

    public EquipoetapasPK getEquipoetapasPK() {
        return equipoetapasPK;
    }

    public void setEquipoetapasPK(EquipoetapasPK equipoetapasPK) {
        this.equipoetapasPK = equipoetapasPK;
    }

    public String getEtapas() {
        return etapas;
    }

    public void setEtapas(String etapas) {
        this.etapas = etapas;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public EtapaFinal getEtapaFinal() {
        return etapaFinal;
    }

    public void setEtapaFinal(EtapaFinal etapaFinal) {
        this.etapaFinal = etapaFinal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equipoetapasPK != null ? equipoetapasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipoetapas)) {
            return false;
        }
        Equipoetapas other = (Equipoetapas) object;
        if ((this.equipoetapasPK == null && other.equipoetapasPK != null) || (this.equipoetapasPK != null && !this.equipoetapasPK.equals(other.equipoetapasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemapractica.Equipoetapas[ equipoetapasPK=" + equipoetapasPK + " ]";
    }
    
}
