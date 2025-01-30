package UDP.Traductor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUDP {


    static DatagramPacket recibo;
    static byte[] buffer = new byte[1024];
    static DatagramSocket socketUDP;
    static DatagramPacket envio;
    static Scanner entrada;
    static InetAddress DESTINO;
    static final int PUERTO_PROPIO = 12345;
    static final int SERVIDOR_PUERTO = 6000;


    public static void main(String[] args) throws IOException {
        entrada = new Scanner(System.in);
        DESTINO = InetAddress.getByName("localhost");




        socketUDP = new DatagramSocket(PUERTO_PROPIO);


        //Enviar Al servidor
        String palabra = entrada.nextLine();
        buffer = palabra.getBytes();
        envio = new DatagramPacket(buffer, buffer.length,
                DESTINO, SERVIDOR_PUERTO);

        socketUDP.send(envio);




        // Recibir del Servidor
        recibo = new DatagramPacket(buffer, buffer.length);

        socketUDP.setSoTimeout(5000);


        String traduccion = recibirInfo();
        System.out.println("->" + traduccion);



        socketUDP.close();
    }

    private static String recibirInfo() throws IOException {
        socketUDP.receive(recibo);
        return new String(recibo.getData(), 0, recibo.getLength());
    }
}
