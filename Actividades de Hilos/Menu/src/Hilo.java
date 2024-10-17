import java.io.*;

public class Primeros extends Thread {
    @Override
    public void run() {
        FileReader fr = null;
        try {
            fr = new FileReader("menu.txt");
            int i;
            while ((i = fr.read()) != -1)

                System.out.print((char)i);

            GuardarPalabra(fichero,palabra);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


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
