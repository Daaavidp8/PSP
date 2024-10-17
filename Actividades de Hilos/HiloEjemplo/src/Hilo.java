public class Hilo extends Thread {
    int numHilo;
    int veces;

    public Hilo(int veces,int numHilo) {
        this.veces = veces;
        this.numHilo = numHilo;
    }

    @Override
    public void run() {
        int contador = 0;
        for (int i = 0; i < this.veces; i++) {
            System.out.println("Hilo:Hilo " + numHilo + " = " + contador);
            contador++;
        }
    }
}
