import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        boolean valido = false;
        int intentos = 0;


        File directorio = new File("src/");

        while (!valido && intentos < 4){

            String email = entrada.nextLine();

            ProcessBuilder pb = new ProcessBuilder("java","ValidaMail.java",email);
            pb.directory(directorio);

            try{
                Process p=pb.start();
                InputStream is = p.getInputStream();
                int c;
                while ((c = is.read()) != -1)
                    System.out.print((char) c);
                is.close();

                p.waitFor();
                valido = p.exitValue() == 0;

            }catch(Exception e) {
                e.getMessage();
            }

            intentos++;
        }

    }
}