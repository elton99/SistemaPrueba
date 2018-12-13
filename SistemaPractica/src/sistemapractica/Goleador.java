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
@Table(name = "goleador")
@NamedQueries({
    @NamedQuery(name = "Goleador.findAll", query = "SELECT g FROM Goleador g")})
public class Goleador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgoleador")
    private Integer idgoleador;
    @Column(name = "cantidad_goles")
    private String cantidadGoles;
    @JoinColumn(name = "jugadores_idjugadores", referencedColumnName = "idjugadores")
    @ManyToOne(optional = false)
    private Jugadores jugadoresIdjugadores;

    public Goleador() {
    }

    public Goleador(Integer idgoleador) {
        this.idgoleador = idgoleador;
    }

    public Integer getIdgoleador() {
        return idgoleador;
    }

    public void setIdgoleador(Integer idgoleador) {
        this.idgoleador = idgoleador;
    }

    public String getCantidadGoles() {
        return cantidadGoles;
    }

    public void setCantidadGoles(String cantidadGoles) {
        this.cantidadGoles = cantidadGoles;
    }

    public Jugadores getJugadoresIdjugadores() {
        return jugadoresIdjugadores;
    }

    public void setJugadoresIdjugadores(Jugadores jugadoresIdjugadores) {
        this.jugadoresIdjugadores = jugadoresIdjugadores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgoleador != null ? idgoleador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Goleador)) {
            return false;
        }
        Goleador other = (Goleador) object;
        if ((this.idgoleador == null && other.idgoleador != null) || (this.idgoleador != null && !this.idgoleador.equals(other.idgoleador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemapractica.Goleador[ idgoleador=" + idgoleador + " ]";
    }
    
}
