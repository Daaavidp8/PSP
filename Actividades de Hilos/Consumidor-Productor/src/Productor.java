public class Productor extends Thread {
    final static int MAX = 50;
    DatoCompartido dato;
    public Productor(DatoCompartido dato) {
        this.dato = dato;
    }

    public void run() {
        for (int i = 0; i < MAX; i++) {
            dato.poner(i);
        }
    }
}
