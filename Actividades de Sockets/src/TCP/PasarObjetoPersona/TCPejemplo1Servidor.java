package TCP.PasarObjetoPersona;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPejemplo1Servidor {
    static final int Puerto = 2000;
    public static void main( String[] arg ) {
        try {
            Persona persona = new Persona("",0);

            ServerSocket skServidor = new ServerSocket(Puerto);

            System.out.println("Esperando conexion del Cliente");
            Socket sCliente1 = skServidor.accept();
            System.out.println("Cliente Conectado!");

            System.out.println("Pasando la persona al cliente");
            ObjectOutputStream os = new ObjectOutputStream(sCliente1.getOutputStream());
            os.writeObject(persona);


            InputStream is = sCliente1.getInputStream();
            ObjectInputStream dis = new ObjectInputStream(is);
            persona = (Persona)dis.readObject();
            System.out.println("Objeto recibido: " + persona.getNombre() + " con " +persona.getEdad() + " años");


            String mensaje = "Objeto Recibido Correctamente";
            DataOutputStream dos = new DataOutputStream(sCliente1.getOutputStream());
            dos.writeUTF(mensaje);



            System.out.println("Servidor Terminado");
            skServidor.close();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
        System.out.println("Servidor cerrado. ");
    }
}
