package TCP.TCPejemplo;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPejemplo1Servidor {
    static final int Puerto = 2000;
    public static void main( String[] arg ) {
        try {
            ServerSocket skServidor = new ServerSocket(Puerto);
            System.out.println("Escuchando en el puerto "+Puerto);
            System.out.println("Escuchando al Cliente 1 ");
            Socket sCliente1 = skServidor.accept();

            InputStream is = sCliente1.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            System.out.println(dis.readUTF());

            skServidor.close();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
        System.out.println("Servidor cerrado. ");
    }
}
