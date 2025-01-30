package UDP.TicketServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUDP {

    static DatagramPacket envio;
    static Scanner entrada;
    static InetAddress DESTINO;
    static final int PUERTO = 12345;
    static DatagramSocket socketUDP;
    static byte[] buffer = new byte[1024];


    public static void main(String[] args) throws IOException {
        entrada = new Scanner(System.in);
        DESTINO = InetAddress.getByName("localhost");




        socketUDP = new DatagramSocket(34567);



        boolean salir = false;
        int opcion;
        while (!salir) {
            try{
                menuOpciones();
                opcion = entrada.nextInt();
                entrada.nextLine();
                buffer = Integer.toString(opcion).getBytes();
                envio = new DatagramPacket(buffer, buffer.length,
                        DESTINO, PUERTO);
                socketUDP.send(envio);

                if (opcion == 2 || opcion == 3) {
                    enviarNombre(socketUDP, opcion);
                } else if (opcion == 5 || opcion == 123) {
                    salir = true;
                }
            }catch (Exception e) {
                System.out.println("Cerrando server");
                buffer = Integer.toString(4).getBytes();
                envio = new DatagramPacket(buffer, buffer.length,
                        DESTINO, PUERTO);
                socketUDP.send(envio);
                salir = true;
            }

        }

        socketUDP.close();
    }

    private static void enviarNombre(DatagramSocket socketUDP, int opcion) throws IOException {
        System.out.println(opcion == 2 ? "Nombre de butaca a reservar:" : "Nombre de butaca a anular:");
        String nombre = entrada.nextLine();
        buffer = nombre.getBytes();
        envio = new DatagramPacket(buffer, buffer.length,
                DESTINO, PUERTO);
        socketUDP.send(envio);
    }

    public static void menuOpciones(){
        String[] opciones = new String[]{
                "Listar Butacas",
                "Reservar Butacas",
                "Anular Butacas",
                "Superusuario",
                "Salir"
        };
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i == 3 ? 123 : (i+1)) + "-" + opciones[i]);
        }
        System.out.println("-------------------------");
    }
}
