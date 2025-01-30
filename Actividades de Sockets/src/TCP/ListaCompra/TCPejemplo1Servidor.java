package TCP.ListaCompra;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPejemplo1Servidor {
    static final int Puerto = 2000;
    public static void main( String[] arg ) {
        try {
            MyFileWriter myFileWriter = new MyFileWriter();
            ServerSocket skServidor = new ServerSocket(Puerto);
            boolean salir = true;
            System.out.println("Escuchando al Cliente 1 ");
            Socket sCliente1 = skServidor.accept();
            InputStream is;
            DataInputStream dis;
            while (salir){
                is = sCliente1.getInputStream();
                dis = new DataInputStream(is);

                String mensaje = dis.readUTF();

                if (!mensaje.equalsIgnoreCase("salir")){
                    System.out.println(mensaje + " Añadido a la cesta");
                    myFileWriter.escribir(mensaje);
                }else {
                    salir = false;
                }
            }
            System.out.println("Servidor Terminado");
            skServidor.close();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
        System.out.println("Servidor cerrado. ");
    }
}
