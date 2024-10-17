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

        GuardarPalabra(isPalindroma ? "palindromos.txt": "nopalindromos.txt",palabra);
        GuardarPalabra("Allwords.txt",palabra);
    }

    public static void GuardarPalabra(String fichero, String palabra) throws IOException {
        try {
            final String dir = System.getProperty("user.dir");
            String dirFile = dir + "/" + fichero;
            File myObj = new File(dirFile);
            if (!myObj.exists()) {
                myObj.createNewFile();
            }
            FileWriter myWriter = new FileWriter(dirFile,true);
            myWriter.write(palabra + "\n");
            myWriter.close();


        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
