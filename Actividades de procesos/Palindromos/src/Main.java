import org.w3c.dom.TypeInfo;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String palabra = scanner.nextLine();

        String dir =  System.getProperty("user.dir") + "/Actividades de procesos/Palindromos/";

        File directorio = new File(dir + "src");
        ProcessBuilder pb = new ProcessBuilder("java", "Palindromo.java", palabra);

        pb.directory(directorio);
        ProcessBuilder pb2 = new ProcessBuilder("java", "Mayusculas.java", palabra);

        pb2.directory(directorio);

        try {
            Process p2 = pb2.start();
            InputStream is2 = p2.getInputStream();
            int c2;
            while ((c2 = is2.read()) != -1) {
                System.out.print((char) c2);
            }

            Process p = pb.start();

            InputStream is = p.getInputStream();
            int c;
            while ((c = is.read()) != -1) {
                System.out.print((char) c);
            }
        }catch (IOException e){
            e.printStackTrace();
        }



//        final String dir = System.getProperty("user.dir");
//        File directorio = new File(dir + "/src");
//
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Escribe una palabra:");
//        String palabra = scanner.nextLine();
//
//
//        ProcessBuilder pb = new ProcessBuilder("java","Palindromo");
//        pb.directory(directorio);
//        Process p = pb.start();
//
//        OutputStream os = p.getOutputStream();
//        os.write(palabra.getBytes());
//        os.flush();
//
//        try{
//            InputStream is = p.getInputStream();
//            int c;
//            while ((c = is.read()) != -1)
//                System.out.print((char) c);
//            is.close();
//        }catch(Exception e) {
//            e.getMessage();
//        }


    }
}