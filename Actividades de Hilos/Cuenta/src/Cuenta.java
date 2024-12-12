public class Cuenta {
    int saldo;

    public Cuenta(int saldo) {
        this.saldo = saldo;
    }
    public int getSaldo() {
        return saldo;
    }
    public void restar(int cantidad) {
        saldo = saldo - cantidad;
    }
    public synchronized void RetirarDinero(int cantidad,String nombre) {
        if (saldo >= cantidad) {
            System.out.println(nombre + ": SE VA A RETIRAR SALDO (ACTUAL ES:" + this.getSaldo() + ")");
            restar(cantidad);
            System.out.println("Saldo ACTUAL: " + this.getSaldo());
        }else {
            System.out.println("No puede retirar dinero, NO HAY SALDO (ACTUAL ES:" + this.getSaldo() + ")");
        }

    }
}
