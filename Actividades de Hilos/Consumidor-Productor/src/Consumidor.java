public class Consumidor extends Thread {
    DatoCompartido dato;
    public Consumidor(DatoCompartido dato) {
        this.dato = dato;
    }

    public void run() {
        for (int i = 0; i < Productor.MAX; i++) {
            dato.dato.remove(dato.obtener(i));
        }
    }
}
