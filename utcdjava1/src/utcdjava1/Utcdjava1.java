package utcdjava1;

import Ejercicio4.Futbol;
import Ejercicio5.Persona;
import Ejercicio5.Cuenta5;
import ejercico1.Cuenta;

public class Utcdjava1 {
     public static void ejercicio1(){
        Cuenta c1=new Cuenta("Juanito");
        Cuenta c2=new Cuenta("Estela",300);
        Cuenta c3 = new Cuenta();
        //Ingresa dinero en las cuentas//
        c1.ingresar(1000);
        c2.ingresar(400);
        //Retiramos dinero de las cunetas//
        c1.retirar(1500);
        c2.retirar(100);
        //VER ESTADO DE CUENTAS
        System.out.println(c1);
        System.out.println(c2);
    }
     public static void ejercicio4(){
        Futbol Boca = new Futbol("Boca", 15);
        Futbol River = new Futbol("River", 12);
        Futbol Racing = new Futbol("Racing", 9);
        Futbol Velez = new Futbol("Velez", 8);
        Futbol SanLorenzo = new Futbol("San Lorenzo", 3);
        System.out.println(Boca);
        System.out.println(River);
        System.out.println(Racing);
        System.out.println(Velez);
        System.out.println(SanLorenzo);
     }
     public static void ejercicio5(){
     Persona p1=new Persona("Juan","Perez",72141913);
        Persona p2=new Persona("Liliana","Lopez",84987325);
        Cuenta5 c1 = new Cuenta5(369,500000,"Juanito");
        Cuenta5 c2 = new Cuenta5(498,500000,"LupeGarcia");
        
        
        
        System.out.println(p1);
        c1.tipotransaccion("retiro", 100000);
        System.out.println(c1);
        
        
        
        
        
        System.out.println(p2);
        c2.tipotransaccion("deposito", 100000);
        System.out.println(c2);
}
    public static void main(String[] args) {
        ejercicio1();
        ejercicio4();
        ejercicio5();
        //EJERCICIO NUMERO TRES//
        estudiante e = new estudiante("Elias", 7, 0);
        e.puntos(150);
        System.out.print(e);
        e.resultado(0);
    }
    
    
    
}
