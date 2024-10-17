public class SacarDinero extends Thread {
    private final Cuenta cuenta;
    String nombre;
    int cantidad;

    public SacarDinero(Cuenta cuenta,String nombre, int cantidad) {
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        cuenta.RetirarDinero(this.cantidad,this.nombre);
    }
}
