package utcdjava1;

public class estudiante {

    private String nombre;
    private int id;
    private int unidad;

    public estudiante(String nombre, int id, int unidad) {
        this.nombre = nombre;
        this.id = id;
        this.unidad = unidad;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public void setci(int id) {
        this.id = id;
    }

    public void setunidad(int unidad) {
        this.unidad = unidad;
    }

    public String nom() {
        return nombre;
    }

    public int id() {
        return id;
    }

    public int unidad() {
        return unidad;
    }

    public void puntos(int unidad) {
        if (unidad > 0) {
            this.unidad += unidad;
        }
    }

    public void resultado(int unidad) {
        if (this.unidad >= 180) {
            System.out.println(" \n Esta graduado con = " + this.unidad + " puntos");
        } else {
            System.out.println(" \n No esta graduado con = " + this.unidad + " puntos");
        }
    }

    @Override
    public String toString() {
        return " Nombre= " + nombre + " ID = " + id;
    }
}
