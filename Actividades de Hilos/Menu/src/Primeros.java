import java.io.FileNotFoundException;
import java.io.FileReader;

public class Primeros extends Thread {
    @Override
    public void run() {
        FileReader fr = null;
        try {
            fr = new FileReader("menu.txt");
            int i;
            while ((i = fr.read()) != -1)

                System.out.print((char)i);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
