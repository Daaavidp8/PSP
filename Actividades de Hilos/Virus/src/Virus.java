import java.util.Random;
import java.util.Scanner;

public class Virus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Cuantos virus?");
        int virus = input.nextInt();

        for (int i = 1; i <= virus; i++) {
            int numVirus = i;
            new Thread(() -> {
                Random random = new Random();
                int carga = 0;
                System.out.print("Virus " + numVirus + ": ");
                while (carga < 100){
                    try {
                        boolean sumaCarga = random.nextBoolean();
                        System.out.print(sumaCarga ? "X" : "XX");
                        carga += sumaCarga ? 5 : 10;
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(" 100%");
            }).run();
        }
    }
}
