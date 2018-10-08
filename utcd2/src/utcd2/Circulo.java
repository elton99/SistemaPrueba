package utcd2;

public class Circulo {
    private double radio = 1.0;
    private String color="Rojo";
    private double area=3.14;
    public Circulo(){
    
    }
    public Circulo(double radio,double area){
        this.radio=radio;
        this.area=area;
    }
    public double getradio(){
        return radio;
    }
    public double getarea(){
        return area;
    }
    @Override
    public String toString (){
        return "El radio es = "+radio+" el area = "+area+" y color = "+color;
    }
    
}
