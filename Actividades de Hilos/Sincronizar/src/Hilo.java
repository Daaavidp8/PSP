public class Hilo extends Thread {

    boolean accion;
    Contador contador;


    public void run() {
        for (int i = 0; i < 5; i++) {
            if (accion) {
                contador.incrementar();
            } else {
                contador.decrementar();
            }
        }
    }

    public Hilo(boolean accion,Contador contador) {
        this.accion = accion;
        this.contador = contador;
    }
}
