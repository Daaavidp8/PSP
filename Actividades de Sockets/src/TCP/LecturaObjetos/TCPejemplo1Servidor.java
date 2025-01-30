package TCP.LecturaObjetos;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPejemplo1Servidor {
    static final int Puerto = 2000;
    public static void main( String[] arg ) {
        try {
            ServerSocket skServidor = new ServerSocket(Puerto);

            System.out.println("Esperando conexion del Cliente");
            Socket sCliente1 = skServidor.accept();
            System.out.println("Cliente Conectado!");

            InputStream is = sCliente1.getInputStream();
            ObjectInputStream dis = new ObjectInputStream(is);

            Object objeto = dis.readObject();
            System.out.println("Objeto recibido: " + objeto);


            OutputStream salida = sCliente1.getOutputStream();
            DataOutputStream dos = new DataOutputStream(salida);
            dos.writeUTF("Mensaje recibido correctamente en el servidor");

            System.out.println("Servidor Terminado");
            skServidor.close();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
        System.out.println("Servidor cerrado. ");
    }
}
