package Ejercicio1;

public class Dato {
    int numero;
    public synchronized void imprimirCadena(String s, int numero) throws InterruptedException {
        while (numero == this.numero) {
            wait();
        }
        notifyAll();
        System.out.println(s);
        this.numero = numero;
    }



}
