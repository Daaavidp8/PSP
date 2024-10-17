import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hilo extends Thread {
    private int numero;

    @Override
    public void run() {
        String palabra;
        try {
                File myObj = new File("menu.txt");
                Scanner myReader = new Scanner(myObj);
                ArrayList<String> tipos = new ArrayList<>(List.of("PRIMEROS","SEGUNDOS","POSTRES"));
                ArrayList<String> ficheros = new ArrayList<>(List.of("primeros.txt","segundos.txt","postres.txt"));
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    palabra = data.split("-")[1];
                    if (!tipos.contains(palabra) && this.numero == Integer.parseInt(data.split("-")[0])) {
                        GuardarPalabra(ficheros.get(this.numero - 1),palabra);
                        System.out.println("El hilo" + this.numero + " escribe..." + palabra);
                    }
                }
                myReader.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public Hilo(int numero) {
        this.numero = numero;
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
