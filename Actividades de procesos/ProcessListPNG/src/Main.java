import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        String regex = "^(/[^/ ]*)+/?$";
        Pattern pattern = Pattern.compile(regex);

        System.out.println("Ruta para encontrar las fotos:");
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();

        Matcher matcher = pattern.matcher(path);

        if (matcher.find()) {
            if (Files.exists(Path.of(path))){
                ProcessBuilder pb = new ProcessBuilder("bash" , "-c" , "ls " + path + "/*.png ");
                Process p = pb.start();
                try {
                    InputStream is = p.getInputStream();
                    int c;
                    while((c = is.read())!=-1)
                        System.out.print((char)c);
                    is.close();
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println("El directorio no existe");
            }
        }else {
            System.out.println("Formato de directorio incorrecto, prueba con algo parecido a \"/home/user/carpeta/\"");
        }

    }
}