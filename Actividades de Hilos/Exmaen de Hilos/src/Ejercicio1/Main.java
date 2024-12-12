package Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Dato dato = new Dato();

        new Hilo("A",dato,1).start();
        new Hilo("B",dato,2).start();
    }
}
