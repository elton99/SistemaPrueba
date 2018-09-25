package Ejercicio5;


public class Persona {
    private String nombre;
    private String apellido;
    private int telefono;
    public Persona(){
        
    }
    public Persona(String nom,String ape,int tel){
        this.nombre=nom;
        this.apellido=ape;
        this.telefono=tel;
    }
    public void setnombre(String nom){
        this.nombre=nom;
    }
    public String getnombre(){
    return this.nombre;
    }
    public void setapellido(String ape){
    this.apellido=ape;
    }
    public String getapellido(){
    return this.apellido;
    }
    public void settelefono(int tel){
    this.telefono=tel;
    }
    public int gettelefono(){
    return this.telefono;
    }
    @Override
    public String toString(){
        return "Nombre : " +nombre+ "  Apellido: " +apellido+   "   Telefono: " +telefono;
    }
}
