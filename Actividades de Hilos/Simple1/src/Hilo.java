public class Hilo extends Thread {
    static int contador = 0;
    public void run(){
        contador += 1000;
    }
}
