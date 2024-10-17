import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Se ejecutan 5 hilos diferentes, pero no se guardan
        for (int i = 0; i < 5; i++) {
            new Hilo().start();
        }

        System.out.println("Contador=" + Hilo.contador);
        System.out.println("Reflexionando...");
    }
}