package TCP.ListaCompra;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyFileWriter {
    String currentDate;

    public MyFileWriter() {
        currentDate = currentDate();
    }

    public void escribir(String texto) {
        try {
            final String dir = System.getProperty("user.dir");
            String dirFile = dir + "/src/TCP.ListaCompra/" + currentDate + ".txt";
            File myObj = new File(dirFile);
            if (!myObj.exists()) {
                myObj.createNewFile();
            }
            FileWriter myWriter = new FileWriter(dirFile ,true);
            myWriter.write(texto + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String currentDate(){
        LocalDate fechaHoy = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return fechaHoy.format(formato);
    }
}
