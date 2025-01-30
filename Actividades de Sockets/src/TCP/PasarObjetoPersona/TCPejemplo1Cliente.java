package TCP.PasarObjetoPersona;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPejemplo1Cliente {
    static final String Host = "localhost";
    static final int Puerto=2000;
    public static void main( String[] arg ) {

        try{
            System.out.println("Iniciando conexion al servidor...");
            Socket sCliente = new Socket( Host, Puerto );


            InputStream is = sCliente.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            Persona persona = (Persona)ois.readObject();

            persona.setNombre("Paco");
            persona.setEdad(18);


            System.out.println("Persona devuelta al servidor");
            ObjectOutputStream os = new ObjectOutputStream(sCliente.getOutputStream());
            os.writeObject(persona);


            // Leer el mensaje enviado desde el servidor
            DataInputStream dis = new DataInputStream(is);

            String mensajeRecibido = dis.readUTF();
            System.out.println("Mensaje del servidor: " + mensajeRecibido);



            System.out.println("Cliente Terminado");
            sCliente.close();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }

    }
}
