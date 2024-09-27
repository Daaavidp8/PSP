import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Lanzador {
    public static void main(String[] args) {
        File directorio = new File("src");
        ProcessBuilder pb = new ProcessBuilder("java", "Sumador.java","5","2");
        pb.directory(directorio);

        try {
            Process p = pb.start();
            InputStream is = p.getInputStream();

            int c;
            while ((c = is.read()) != -1) {
                System.out.print((char)c);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
