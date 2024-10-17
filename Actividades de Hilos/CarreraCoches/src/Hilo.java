public class Hilo extends Thread {
    Coche coche;
    public Hilo(Coche coche) {
        this.coche = coche;
    }
    @Override
    public void run() {
        try {
            while (!this.coche.finalizado()){
                this.coche.sumarKm();
                sleep(1000);
                if (!this.coche.finalizado()){
                    System.out.println(this.coche.getKm());
                }
            }

            System.out.println(this.coche.marca + " ha finalizado al recorrer " + this.coche.km + "km");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
