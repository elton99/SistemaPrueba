/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapractica;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author elton
 */
@Entity
@Table(name = "jugadores")
@NamedQueries({
    @NamedQuery(name = "Jugadores.findAll", query = "SELECT j FROM Jugadores j")})
public class Jugadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idjugadores")
    private Integer idjugadores;
    @Column(name = "nombre_jugador")
    private String nombreJugador;
    @Column(name = "apellido_jugador")
    private String apellidoJugador;
    @Column(name = "ci")
    private String ci;
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "promocion")
    private String promocion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jugadoresIdjugadores")
    private List<Goleador> goleadorList;
    @JoinColumn(name = "equipo_idequipo", referencedColumnName = "idequipo")
    @ManyToOne(optional = false)
    private Equipo equipoIdequipo;

    public Jugadores() {
    }

    public Jugadores(Integer idjugadores) {
        this.idjugadores = idjugadores;
    }

    public Integer getIdjugadores() {
        return idjugadores;
    }

    public void setIdjugadores(Integer idjugadores) {
        this.idjugadores = idjugadores;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getApellidoJugador() {
        return apellidoJugador;
    }

    public void setApellidoJugador(String apellidoJugador) {
        this.apellidoJugador = apellidoJugador;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPromocion() {
        return promocion;
    }

    public void setPromocion(String promocion) {
        this.promocion = promocion;
    }

    public List<Goleador> getGoleadorList() {
        return goleadorList;
    }

    public void setGoleadorList(List<Goleador> goleadorList) {
        this.goleadorList = goleadorList;
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
        hash += (idjugadores != null ? idjugadores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugadores)) {
            return false;
        }
        Jugadores other = (Jugadores) object;
        if ((this.idjugadores == null && other.idjugadores != null) || (this.idjugadores != null && !this.idjugadores.equals(other.idjugadores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemapractica.Jugadores[ idjugadores=" + idjugadores + " ]";
    }
    
}
