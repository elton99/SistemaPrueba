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
@Table(name = "campeonato")
@NamedQueries({
    @NamedQuery(name = "Campeonato.findAll", query = "SELECT c FROM Campeonato c")})
public class Campeonato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcampeonato")
    private Integer idcampeonato;
    @Column(name = "edicion")
    private Integer edicion;
    @Column(name = "eslogan")
    private String eslogan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campeonatoIdcampeonato")
    private List<Grupos> gruposList;

    public Campeonato() {
    }

    public Campeonato(Integer idcampeonato) {
        this.idcampeonato = idcampeonato;
    }

    public Integer getIdcampeonato() {
        return idcampeonato;
    }

    public void setIdcampeonato(Integer idcampeonato) {
        this.idcampeonato = idcampeonato;
    }

    public Integer getEdicion() {
        return edicion;
    }

    public void setEdicion(Integer edicion) {
        this.edicion = edicion;
    }

    public String getEslogan() {
        return eslogan;
    }

    public void setEslogan(String eslogan) {
        this.eslogan = eslogan;
    }

    public List<Grupos> getGruposList() {
        return gruposList;
    }

    public void setGruposList(List<Grupos> gruposList) {
        this.gruposList = gruposList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcampeonato != null ? idcampeonato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campeonato)) {
            return false;
        }
        Campeonato other = (Campeonato) object;
        if ((this.idcampeonato == null && other.idcampeonato != null) || (this.idcampeonato != null && !this.idcampeonato.equals(other.idcampeonato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemapractica.Campeonato[ idcampeonato=" + idcampeonato + " ]";
    }
    
}
