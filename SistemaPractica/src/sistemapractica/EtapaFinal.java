/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapractica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author elton
 */
@Entity
@Table(name = "etapaFinal")
@NamedQueries({
    @NamedQuery(name = "EtapaFinal.findAll", query = "SELECT e FROM EtapaFinal e")})
public class EtapaFinal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idetapaFinal")
    private Integer idetapaFinal;
    @Column(name = "cantidadpart")
    private Integer cantidadpart;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etapaFinal")
    private List<Equipoetapas> equipoetapasList;

    public EtapaFinal() {
    }

    public EtapaFinal(Integer idetapaFinal) {
        this.idetapaFinal = idetapaFinal;
    }

    public Integer getIdetapaFinal() {
        return idetapaFinal;
    }

    public void setIdetapaFinal(Integer idetapaFinal) {
        this.idetapaFinal = idetapaFinal;
    }

    public Integer getCantidadpart() {
        return cantidadpart;
    }

    public void setCantidadpart(Integer cantidadpart) {
        this.cantidadpart = cantidadpart;
    }

    public List<Equipoetapas> getEquipoetapasList() {
        return equipoetapasList;
    }

    public void setEquipoetapasList(List<Equipoetapas> equipoetapasList) {
        this.equipoetapasList = equipoetapasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idetapaFinal != null ? idetapaFinal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtapaFinal)) {
            return false;
        }
        EtapaFinal other = (EtapaFinal) object;
        if ((this.idetapaFinal == null && other.idetapaFinal != null) || (this.idetapaFinal != null && !this.idetapaFinal.equals(other.idetapaFinal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemapractica.EtapaFinal[ idetapaFinal=" + idetapaFinal + " ]";
    }
    
}
