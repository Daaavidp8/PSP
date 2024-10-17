import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        boolean finalizado = false;
        ArrayList<Hilo> hilos = new ArrayList<>();


        System.out.println("Introduce numero de coches a competir");
        int numcoches = scanner.nextInt();

        String marca;
        for (int i = 1; i <= numcoches; i++) {
            System.out.println("Introduce la marca del coche " + i);
            marca = scanner.next();
            hilos.add(new Hilo(new Coche(marca,i)));
        }

        for (Hilo hilo : hilos) {
            hilo.start();
        }

        for (Hilo hilo : hilos) {
            hilo.join();
        }

    }
}