import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class LeerWeb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe páginas web,(Ej: youtube.com@marca.es)");
        String paginas = scanner.nextLine();

        File directory = new File("src");
        ProcessBuilder pb = new ProcessBuilder("java","VisitaWeb.java",paginas);
        pb.directory(directory);

        try {
            Process p = pb.start();

            InputStream is = p.getInputStream();
            int c;
            while ((c = is.read()) != -1)
                System.out.print((char) c);
            is.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}