package Ejercicio4;


public class Futbol {
    
    private String equipo;
    public int Puntos_Ganados = 0;
    public int GolesFavor = 0;
    public int GolesContra = 0;

    public Futbol(String equipo, int Puntos_Ganados) {
        this.equipo = equipo;
        this.Puntos_Ganados = Puntos_Ganados;

    }

    public void equipos(String equipo, int Ganados, int Goles_a_Favor, int Goles_en_Contra) {
        this.equipo = equipo;
        this.Puntos_Ganados = Ganados;
        this.GolesFavor = Goles_a_Favor;
        this.GolesContra = Goles_en_Contra;
    }

    @Override
    public String toString() {
        return "El equipo de  " + equipo + " tiene partidos ganados = " + Puntos_Ganados;
    }
}
