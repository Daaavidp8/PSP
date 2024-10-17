import java.util.Random;

public class Hilo extends Thread {
    static int entradasDisponibles = 100,entradasVendidas = 0;
    private int cliente;
    Random rand = new Random();

    @Override
    public void run() {
        int entradas = rand.nextInt(10);
        if (entradasDisponibles - entradas > 0){
            entradasVendidas += entradas;
            entradasDisponibles -= entradas;
            System.out.println(entradas + " reservadas para Cliente " + this.cliente);
        }
    }

    public Hilo(int cliente) {
        this.cliente = cliente;
    }
}
