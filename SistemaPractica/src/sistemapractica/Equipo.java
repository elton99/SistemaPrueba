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
@Table(name = "equipo")
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idequipo")
    private Integer idequipo;
    @Column(name = "nombre_equipo")
    private String nombreEquipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipo")
    private List<Equipoetapas> equipoetapasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoIdequipo")
    private List<Inscripcion> inscripcionList;
    @JoinColumn(name = "grupos_idgrupos", referencedColumnName = "idgrupos")
    @ManyToOne(optional = false)
    private Grupos gruposIdgrupos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoIdequipo")
    private List<Jugadores> jugadoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoIdequipo")
    private List<Partidos> partidosList;

    public Equipo() {
    }

    public Equipo(Integer idequipo) {
        this.idequipo = idequipo;
    }

    public Integer getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(Integer idequipo) {
        this.idequipo = idequipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public List<Equipoetapas> getEquipoetapasList() {
        return equipoetapasList;
    }

    public void setEquipoetapasList(List<Equipoetapas> equipoetapasList) {
        this.equipoetapasList = equipoetapasList;
    }

    public List<Inscripcion> getInscripcionList() {
        return inscripcionList;
    }

    public void setInscripcionList(List<Inscripcion> inscripcionList) {
        this.inscripcionList = inscripcionList;
    }

    public Grupos getGruposIdgrupos() {
        return gruposIdgrupos;
    }

    public void setGruposIdgrupos(Grupos gruposIdgrupos) {
        this.gruposIdgrupos = gruposIdgrupos;
    }

    public List<Jugadores> getJugadoresList() {
        return jugadoresList;
    }

    public void setJugadoresList(List<Jugadores> jugadoresList) {
        this.jugadoresList = jugadoresList;
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
        hash += (idequipo != null ? idequipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.idequipo == null && other.idequipo != null) || (this.idequipo != null && !this.idequipo.equals(other.idequipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemapractica.Equipo[ idequipo=" + idequipo + " ]";
    }
    
}
