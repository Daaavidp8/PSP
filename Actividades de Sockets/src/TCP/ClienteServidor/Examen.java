package TCP.ClienteServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Examen {
        static final String Host = "192.168.74.205";
        static final int Puerto = 2000;

        public static void main(String[] args) {
            try (Socket sCliente = new Socket(Host, Puerto);
                 DataOutputStream dos = new DataOutputStream(sCliente.getOutputStream())) {
                Scanner sc = new Scanner(System.in);

                new Thread(() -> escucharServidor(sCliente)).start();

                while (true) {
                    System.out.println("Introduce una cadena de texto: ");
                    String mensaje = sc.nextLine();
                    dos.writeUTF("LHDPEUG: " + mensaje);

                    if (mensaje.equalsIgnoreCase("Salir")) {
                        System.out.println("Cerrando conexión...");
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Error en el cliente: " + e.getMessage());
            }
        }

        private static void escucharServidor(Socket socket) {
            try (DataInputStream dis = new DataInputStream(socket.getInputStream())) {
                while (true) {
                    String mensaje = dis.readUTF();
                    System.out.println(mensaje);
                }
            } catch (IOException e) {
                System.out.println("Conexión cerrada por el servidor.");
            }
        }
}
