package examen3;

public class Peliculas {

    private final static int HORAS_ESTIMADAS_DEF = 100;

    public final static int MAYOR = 1;

    public final static int MENOR = -1;

    public final static int IGUAL = 0;

    private String titulo;

    private int horasEstimadas;
    private boolean visto;

    private String genero;

    private String año;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    public void setHorasEstimadas(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getaño() {
        return año;
    }

    public void setcompañia(String año) {
        this.año = año;
    }

    public void entregar() {
        visto = true;
    }

    public void devolver() {
        visto = false;
    }

    public boolean isEntregado() {
        if (visto) {
            return true;
        }
        return false;
    }

    public int compareTo(Object a) {
        int estado = MENOR;

        Peliculas ref = (Peliculas) a;
        if (horasEstimadas > ref.getHorasEstimadas()) {
            estado = MAYOR;
        } else if (horasEstimadas == ref.getHorasEstimadas()) {
            estado = IGUAL;
        }

        return estado;
    }

    @Override
    public String toString() {
        return "Informacion de la pelicula: \n"
                + "\tTitulo: " + titulo + "\n"
                + "\tDuración: " + horasEstimadas + "minutos" + "\n"
                + "\tGenero: " + genero + "\n"
                + "\tAño: " + año;
    }

    public boolean equals(Peliculas a) {
        if (titulo.equalsIgnoreCase(a.getTitulo()) && año.equalsIgnoreCase(a.getaño())) {
            return true;
        }
        return false;
    }

    public Peliculas() {
        this("", HORAS_ESTIMADAS_DEF, "", "");
    }

    public Peliculas(String titulo, String compañia) {
        this(titulo, HORAS_ESTIMADAS_DEF, "", compañia);
    }

    public Peliculas(String titulo, int horasEstimadas, String genero, String año) {
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
        this.genero = genero;
        this.año = año;
        this.visto = false;
    }

}
