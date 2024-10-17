import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        String[] corredores = {"Hicham El Guerrouj","Noah Ngeny", "Mohamed Farah", "Bernard Lagat", "Rashid Ramzi", "Ryan Gregson", "Fermín Cacho", "Teddy Flack"};
        ArrayList<Hilo> hilos = new ArrayList<>();
        for (String corredor : corredores) {
            hilos.add(new Hilo(new Corredor(corredor)));
        }

        for (Hilo hilo : hilos) {
            hilo.start();
        }

        for (Hilo hilo : hilos) {
            hilo.join();
        }

    }
}