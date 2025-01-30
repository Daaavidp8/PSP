package TCP.LecturaObjetos;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class TCPejemplo1Cliente {
    static final String Host = "localhost";
    static final int Puerto=2000;
    public static void main( String[] arg ) {

        ArrayList<String> clientes = new ArrayList<>();
        clientes.add("Juan Pérez");
        clientes.add("María López");
        clientes.add("Carlos García");
        clientes.add("Ana Martínez");

        try{
            System.out.println("Iniciando conexion al servidor...");
            Socket sCliente = new Socket( Host, Puerto );

            System.out.println("Objeto enviado al servidor:" + clientes);
            ObjectOutputStream os = new ObjectOutputStream(sCliente.getOutputStream());
            os.writeObject(clientes);

            InputStream is = sCliente.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            // Leer el mensaje enviado desde el servidor
            String mensajeRecibido = dis.readUTF();
            System.out.println("Mensaje del servidor: " + mensajeRecibido);


            System.out.println("Cliente Terminado");
            sCliente.close();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }

    }
}
