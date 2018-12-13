/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapractica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "inscripcion")
@NamedQueries({
    @NamedQuery(name = "Inscripcion.findAll", query = "SELECT i FROM Inscripcion i")})
public class Inscripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtable1")
    private Integer idtable1;
    @Column(name = "inscripcion_precio")
    private Integer inscripcionPrecio;
    @JoinColumn(name = "equipo_idequipo", referencedColumnName = "idequipo")
    @ManyToOne(optional = false)
    private Equipo equipoIdequipo;

    public Inscripcion() {
    }

    public Inscripcion(Integer idtable1) {
        this.idtable1 = idtable1;
    }

    public Integer getIdtable1() {
        return idtable1;
    }

    public void setIdtable1(Integer idtable1) {
        this.idtable1 = idtable1;
    }

    public Integer getInscripcionPrecio() {
        return inscripcionPrecio;
    }

    public void setInscripcionPrecio(Integer inscripcionPrecio) {
        this.inscripcionPrecio = inscripcionPrecio;
    }

    public Equipo getEquipoIdequipo() {
        return equipoIdequipo;
    }

    public void setEquipoIdequipo(Equipo equipoIdequipo) {
        this.equipoIdequipo = equipoIdequipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtable1 != null ? idtable1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscripcion)) {
            return false;
        }
        Inscripcion other = (Inscripcion) object;
        if ((this.idtable1 == null && other.idtable1 != null) || (this.idtable1 != null && !this.idtable1.equals(other.idtable1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemapractica.Inscripcion[ idtable1=" + idtable1 + " ]";
    }
    
}
