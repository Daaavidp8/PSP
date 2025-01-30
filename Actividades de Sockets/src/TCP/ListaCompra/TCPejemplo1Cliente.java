package TCP.ListaCompra;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPejemplo1Cliente {
    static final String Host = "localhost";
    static final int Puerto=2000;
    public static void main( String[] arg ) {
        Scanner scanner = new Scanner(System.in);
        try{
            Socket sCliente = new Socket( Host, Puerto );
            InetAddress i = sCliente.getInetAddress();
            System.out.println("Host Remoto: "+i.getHostName());
            System.out.println("IP Host Remoto: "+i.getHostAddress());

            String texto = "";
            while (!texto.equalsIgnoreCase("salir")){
                System.out.println("Producto a Añadir:");
                texto = scanner.nextLine();

                OutputStream os = sCliente.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeUTF(texto);
            }
            System.out.println("Cliente Terminado");
            sCliente.close();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
    }
}
