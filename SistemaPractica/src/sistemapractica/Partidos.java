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
@Table(name = "partidos")
@NamedQueries({
    @NamedQuery(name = "Partidos.findAll", query = "SELECT p FROM Partidos p")})
public class Partidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpartidos")
    private Integer idpartidos;
    @Column(name = "resultadoFinal")
    private String resultadoFinal;
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "arbitro_idarbitro", referencedColumnName = "idarbitro")
    @ManyToOne(optional = false)
    private Arbitro arbitroIdarbitro;
    @JoinColumn(name = "equipo_idequipo", referencedColumnName = "idequipo")
    @ManyToOne(optional = false)
    private Equipo equipoIdequipo;

    public Partidos() {
    }

    public Partidos(Integer idpartidos) {
        this.idpartidos = idpartidos;
    }

    public Integer getIdpartidos() {
        return idpartidos;
    }

    public void setIdpartidos(Integer idpartidos) {
        this.idpartidos = idpartidos;
    }

    public String getResultadoFinal() {
        return resultadoFinal;
    }

    public void setResultadoFinal(String resultadoFinal) {
        this.resultadoFinal = resultadoFinal;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Arbitro getArbitroIdarbitro() {
        return arbitroIdarbitro;
    }

    public void setArbitroIdarbitro(Arbitro arbitroIdarbitro) {
        this.arbitroIdarbitro = arbitroIdarbitro;
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
        hash += (idpartidos != null ? idpartidos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partidos)) {
            return false;
        }
        Partidos other = (Partidos) object;
        if ((this.idpartidos == null && other.idpartidos != null) || (this.idpartidos != null && !this.idpartidos.equals(other.idpartidos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemapractica.Partidos[ idpartidos=" + idpartidos + " ]";
    }
    
}
