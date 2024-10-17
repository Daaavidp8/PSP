public class Hilo extends Thread {
    Corredor corredor;
    public Hilo(Corredor corredor) {
        this.corredor = corredor;
    }
    public void run() {
        while (!corredor.finalizado()) {
            corredor.sumarMetro();
        }
        System.out.println("El corredor " + corredor.nombre  + " ha finalizado");
    }
}
