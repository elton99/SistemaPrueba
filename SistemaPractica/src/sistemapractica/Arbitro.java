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
@Table(name = "arbitro")
@NamedQueries({
    @NamedQuery(name = "Arbitro.findAll", query = "SELECT a FROM Arbitro a")})
public class Arbitro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idarbitro")
    private Integer idarbitro;
    @Column(name = "nombre_arbitro")
    private String nombreArbitro;
    @Column(name = "apellido_arbitro")
    private String apellidoArbitro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "arbitroIdarbitro")
    private List<Partidos> partidosList;

    public Arbitro() {
    }

    public Arbitro(Integer idarbitro) {
        this.idarbitro = idarbitro;
    }

    public Integer getIdarbitro() {
        return idarbitro;
    }

    public void setIdarbitro(Integer idarbitro) {
        this.idarbitro = idarbitro;
    }

    public String getNombreArbitro() {
        return nombreArbitro;
    }

    public void setNombreArbitro(String nombreArbitro) {
        this.nombreArbitro = nombreArbitro;
    }

    public String getApellidoArbitro() {
        return apellidoArbitro;
    }

    public void setApellidoArbitro(String apellidoArbitro) {
        this.apellidoArbitro = apellidoArbitro;
    }

    public List<Partidos> getPartidosList() {
        return partidosList;
    }

    public void setPartidosList(List<Partidos> partidosList) {
        this.partidosList = partidosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idarbitro != null ? idarbitro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arbitro)) {
            return false;
        }
        Arbitro other = (Arbitro) object;
        if ((this.idarbitro == null && other.idarbitro != null) || (this.idarbitro != null && !this.idarbitro.equals(other.idarbitro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemapractica.Arbitro[ idarbitro=" + idarbitro + " ]";
    }
    
}
