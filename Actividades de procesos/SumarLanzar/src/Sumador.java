import java.util.Arrays;

public class Sumador {
    public static void main(String[] args) {
        Arrays.sort(args);
        int suma = 0;
        for (int i = Integer.parseInt(args[0]); i <= Integer.parseInt(args[1]); i++) {
            suma += i;
        }
        System.out.println(suma);
    }
}
