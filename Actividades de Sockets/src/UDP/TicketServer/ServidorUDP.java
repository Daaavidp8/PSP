package UDP.TicketServer;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class ServidorUDP {

    static ArrayList<String> butacas  = new ArrayList<>();
    static DatagramPacket recibo;
    static byte[] buffer = new byte[1024];
    static DatagramSocket socketUDP;

    public static void main(String[] args) throws IOException {

        System.out.println("Iniciado el servidor de Tickets");

        recibo = new DatagramPacket(buffer, buffer.length);
        socketUDP = new DatagramSocket(12345);


        setButacas();


        boolean salir = false;
        while (!salir) {
            int opcion = Integer.parseInt(recibirInfo());
            switch (opcion) {
                case 1: ListarButacas(); break;
                case 2:
                case 3:
                    String nombre = recibirInfo();
                    if (opcion == 2) {
                        AsignarButaca(nombre);
                    } else {
                        if (butacas.contains(nombre)) {
                            System.out.println("Anulando butaca a " + nombre);
                            AnularButaca(nombre);
                        }else {
                            System.out.println("Nombre no encontrado");
                        }
                    }
                    break;
                case 123:
                default: salir = true; break;
            }

        }


        socketUDP.close();
    }

    private static void AnularButaca(String nombre) throws IOException {

        if (butacas.contains(nombre)) {
            if (butacas.indexOf(nombre) < 4) {
                System.out.println(nombre + " ha dejado una butaca libre");
                butacas.set(butacas.indexOf(nombre), null);
                if (butacas.size() > 4){
                    System.out.println("Reasignando butaca...");
                    String firstInQueue = butacas.get(4);
                    butacas.remove(firstInQueue);
                    AsignarButaca(firstInQueue);
                }
            }else {
                System.out.println(nombre + " eliminado de la cola");
                butacas.remove(nombre);
            }
        }
    }


    private static void AsignarButaca(String nombre){
        if (!butacas.contains(nombre)) {
            if (butacas.contains(null)) {
                System.out.println("Asignando butaca a " + nombre);
                int index = butacas.indexOf(null);
                butacas.set(index,nombre);
            }else {
                System.out.println("Añadiendo" + nombre + "a la cola...");
                butacas.add(nombre);
            }
        }else{
            System.out.println("Ya existe una reserva a ese nombre");
        }


    }

    private static String recibirInfo() throws IOException {
        socketUDP.receive(recibo);
        return new String(recibo.getData(), 0, recibo.getLength());
    }

    private static void ListarButacas() {
        for (int i = 0; i < 4; i++) {
            System.out.println((i +1) + ":" + (butacas.get(i) != null ? butacas.get(i) : "Libre!"));
        }
    }

    public static void setButacas(){
        for (int i = 0; i < 4; i++) {
            butacas.add(null);
        }
    }
}
