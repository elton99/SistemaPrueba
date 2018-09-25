/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercico1;

/**
 *
 * @author elton
 */
public class Cuenta {
     private String titular;
    private double cantidad;

    public Cuenta(String titular) {
        this.titular=titular;
    }

    public Cuenta(String titular, double cantidad) {
        this.titular = titular;
        if (cantidad < 0) {
            this.cantidad = 0;
        } 
        else {
            this.cantidad = cantidad;
        }

    }

    public Cuenta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            this.cantidad += cantidad;
        }
    }

    public void retirar(double cantidad) {
        if (this.cantidad - cantidad <= 0) {
            this.cantidad = 0;

        } else {
            this.cantidad -= cantidad;
        }
    }

    @Override
    public String toString() {
        return "El titular " + titular + " tiene " + cantidad + " guaranies en la cuenta";
    }
    
}
