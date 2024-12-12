import java.io.*;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        boolean valido = false;
        int intentos = 0;


        File directorio = new File("src/");

        while (!valido && intentos < 3){

            System.out.println("Introduce un email valido. INTENTOS: " + (3 -intentos));
            String email = entrada.nextLine();

            ProcessBuilder pb = new ProcessBuilder("java","ValidaMail.java",email);
            pb.directory(directorio);

            try{
                Process p=pb.start();
                OutputStream os = p.getOutputStream();
                os.write(email.getBytes());
                os.flush();
                os.close();


                InputStream is = p.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line = br.readLine();

                InputStream es = p.getErrorStream();
                BufferedReader bre = new BufferedReader(new InputStreamReader(es));
                String errLine;

                while ((errLine = bre.readLine()) != null){
                    System.err.println(errLine);
                }

                if (Objects.equals(line, "true")){
                    valido = true;
                    System.out.println("Email validado correctamente.");
                }else {
                    while ((line) != null){
                        System.out.println(line);
                        line = br.readLine();
                    }
                    is.close();
                }

            }catch(Exception e) {
                System.out.println(e.getMessage());
            }

            intentos++;
        }

    }
}