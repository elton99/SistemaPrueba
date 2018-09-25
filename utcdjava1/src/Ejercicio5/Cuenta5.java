package Ejercicio5;


public class Cuenta5 {
   private int numero_cuenta;
    private int saldo;
    private String propietario;

    public Cuenta5(int numero_cuenta, int saldo, String propietario) {
        this.numero_cuenta = numero_cuenta;
        this.saldo = saldo;
        this.propietario = propietario;

    }

    public void Cuenta(int numero_cuenta, int saldo, String propietario) {
        this.numero_cuenta = numero_cuenta;
        this.saldo = saldo;
        this.propietario = propietario;
    }

    public int get_nrocuenta() {
        return numero_cuenta;
    }

    public int get_saldo() {
        return saldo;
    }

    public String get_propietario() {
        return propietario;
    }

    public void set_nrocuenta(int numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public void set_saldo(int saldo) {
        this.saldo = saldo;

    }

    public void set_propietario(String propietario) {
        this.propietario = propietario;
    }



    public void tipotransaccion(String tipo, int cantidad) {
        if (tipo == "retiro") {
            this.saldo = saldo - cantidad;
        } else {
            if (tipo == "deposito") {
                this.saldo = saldo + cantidad;
            }
        }
    }
        public boolean validarsaldo(int s) {
        if (this.saldo > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "NRO DE CUENTA = " + this.numero_cuenta + " SALDO = " + this.saldo + " PROPIETARIO = " + this.propietario;
    } 
}
