package UDP.Traductor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;

public class ServidorUDP {
    static DatagramPacket recibo;

    static DatagramPacket envio;
    static InetAddress DESTINO;
    static int PUERTO_SERVIDOR_ESCUCHANDO = 6000;
    static byte[] buffer = new byte[1024];
    static DatagramSocket socketUDP;
    static HashMap<String, String> dictionary = new HashMap<>();

    public static void main(String[] args) throws IOException {

        setHashMap();
        
        System.out.println("Iniciado Traductor");


        // Recibir del cliente
        recibo = new DatagramPacket(buffer, buffer.length);
        socketUDP = new DatagramSocket(PUERTO_SERVIDOR_ESCUCHANDO);
        DESTINO = InetAddress.getByName(socketUDP.getLocalAddress().getHostAddress());

        // Coger palabra,traducirla y enviar la traducción
        String palabra = recibirInfo();
        System.out.println(palabra);
        String translation = traducir(palabra);


        if (translation != null) {
            buffer = translation.getBytes();
            System.out.println(recibo.getPort());

            envio = new DatagramPacket(buffer, buffer.length,
                    DESTINO, recibo.getPort());

            socketUDP.send(envio);
        }


        socketUDP.close();
    }

    private static String traducir(String palabra) {
        return dictionary.getOrDefault(palabra, null);
    }

    private static void setHashMap() {
        dictionary.put("hello", "hola");
        dictionary.put("world", "mundo");
        dictionary.put("dog", "perro");
        dictionary.put("cat", "gato");
        dictionary.put("food", "comida");
    }

    private static String recibirInfo() throws IOException {
        socketUDP.receive(recibo);
        return new String(recibo.getData(), 0, recibo.getLength());
    }

}
