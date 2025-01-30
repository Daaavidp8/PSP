package UDP.ContarLetras;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUDP {
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);

        final int puerto = 12345;

        byte[] buffer = new byte[1024];
        InetAddress destino = InetAddress.getByName("localhost");
        DatagramSocket socketUDP = new DatagramSocket(6000);

        System.out.println("Texto:");
        String message = entrada.nextLine();
        buffer = message.getBytes();
        DatagramPacket envioTexto = new DatagramPacket(buffer, buffer.length,
                destino, puerto);
        socketUDP.send(envioTexto);


        System.out.println("Letra:");
        String letra = entrada.nextLine();
        buffer = letra.getBytes();
        DatagramPacket envioLetra = new DatagramPacket(buffer, buffer.length,
                destino, puerto);
        socketUDP.send(envioLetra);


        DatagramPacket recibo = new DatagramPacket(buffer, buffer.
                length);
        socketUDP.receive(recibo);
        String respuesta = new String(recibo.getData(), 0, recibo.getLength());

        System.out.println(respuesta + "---");

        socketUDP.close();
    }
}
