import java.io.*;
import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) throws IOException {

        String palabra = args[0];

        char[] frase = palabra.toLowerCase().replaceAll("\\s", "").toCharArray();


        boolean isPalindroma = true;
        int longitud = frase.length - 1;
        for (int i = 0; i < frase.length / 2; i++) {
            if (frase[i] != frase[longitud]) {
                isPalindroma = false;
            }
            longitud--;
        }

        System.out.println(isPalindroma ? "Es Palindroma" : "No es Palindroma");
    }
}
