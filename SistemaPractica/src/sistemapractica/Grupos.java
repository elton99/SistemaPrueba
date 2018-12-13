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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author elton
 */
@Entity
@Table(name = "grupos")
@NamedQueries({
    @NamedQuery(name = "Grupos.findAll", query = "SELECT g FROM Grupos g")})
public class Grupos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgrupos")
    private Integer idgrupos;
    @Column(name = "cantidad_partidos")
    private Integer cantidadPartidos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gruposIdgrupos")
    private List<Equipo> equipoList;
    @JoinColumn(name = "campeonato_idcampeonato", referencedColumnName = "idcampeonato")
    @ManyToOne(optional = false)
    private Campeonato campeonatoIdcampeonato;

    public Grupos() {
    }

    public Grupos(Integer idgrupos) {
        this.idgrupos = idgrupos;
    }

    public Integer getIdgrupos() {
        return idgrupos;
    }

    public void setIdgrupos(Integer idgrupos) {
        this.idgrupos = idgrupos;
    }

    public Integer getCantidadPartidos() {
        return cantidadPartidos;
    }

    public void setCantidadPartidos(Integer cantidadPartidos) {
        this.cantidadPartidos = cantidadPartidos;
    }

    public List<Equipo> getEquipoList() {
        return equipoList;
    }

    public void setEquipoList(List<Equipo> equipoList) {
        this.equipoList = equipoList;
    }

    public Campeonato getCampeonatoIdcampeonato() {
        return campeonatoIdcampeonato;
    }

    public void setCampeonatoIdcampeonato(Campeonato campeonatoIdcampeonato) {
        this.campeonatoIdcampeonato = campeonatoIdcampeonato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgrupos != null ? idgrupos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupos)) {
            return false;
        }
        Grupos other = (Grupos) object;
        if ((this.idgrupos == null && other.idgrupos != null) || (this.idgrupos != null && !this.idgrupos.equals(other.idgrupos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemapractica.Grupos[ idgrupos=" + idgrupos + " ]";
    }
    
}
