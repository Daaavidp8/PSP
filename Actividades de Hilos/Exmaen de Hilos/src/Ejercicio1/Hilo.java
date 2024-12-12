package Ejercicio1;

public class Hilo extends Thread {
    Dato dato;
    String cadena;
    int numero;
    public Hilo(String cadena,Dato dato, int numero) {
        this.cadena = cadena;
        this.dato = dato;
        this.numero = numero;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                dato.imprimirCadena(cadena,numero);
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
