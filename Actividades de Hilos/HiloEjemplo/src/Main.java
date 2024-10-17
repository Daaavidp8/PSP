import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cuantos Hilos quieres");

        int num = scanner.nextInt();
        int contador;
        ArrayList<Hilo> hilos = new ArrayList<>();

        for (int i = 1; i <= num; i++) {
            System.out.println("Introduce el numero de veces del bucle " + i);
            contador = scanner.nextInt();
            hilos.add(new Hilo(contador,i));
        }

        for (int i = 1; i <= num; i++) {
            System.out.println("CREANDO HILO:Hilo " + i);
        }

        for (Hilo hilo : hilos) {
            hilo.start();
            hilo.join();
        }
    }
}