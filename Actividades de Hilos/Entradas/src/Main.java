import java.util.Random;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Hilo(i + 1).start();
        }
        Thread.sleep(1000);

        System.out.println("Total entradas vendidas " + Hilo.entradasVendidas);

    }
}