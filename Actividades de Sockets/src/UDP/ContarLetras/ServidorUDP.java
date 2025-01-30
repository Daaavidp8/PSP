package UDP.ContarLetras;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorUDP {
    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[1024];
        System.out.println("Iniciado el servidor UDP");
        DatagramPacket recibo = new DatagramPacket(buffer, buffer.
                length);
        DatagramSocket socketUDP = new DatagramSocket(12345);

        InetAddress destino = InetAddress.getByName(socketUDP.getLocalAddress().getHostAddress());


        // Recogida de Información
        socketUDP.receive(recibo);
        String mensaje = new String(recibo.getData(), 0, recibo.getLength());

        socketUDP.receive(recibo);
        String letra = new String(recibo.getData(), 0, recibo.getLength());


        System.out.println(letra);
        System.out.println(mensaje);

        int contador = 0;
        for(Character c : mensaje.toCharArray()) {
            if(c == letra.charAt(0)) {
                contador++;
            }
        }


        buffer = Integer.toString(contador).getBytes();
        DatagramPacket sendBack = new DatagramPacket(buffer, buffer.length,
                destino, recibo.getPort());
        socketUDP.send(sendBack);







        socketUDP.close();
    }
}
