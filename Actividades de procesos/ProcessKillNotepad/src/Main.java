import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
       ProcessBuilder pb = new ProcessBuilder("bash","-c","kwrite");
       Process p=pb.start();
       Thread.sleep(10000);
       p.destroy();
    }
}