public class Contador{
    int valor;
    public Contador(int valor){
        this.valor = valor;
    }
    public synchronized void incrementar(){
        valor++;
        System.out.println(this.getValor());
    }
    public synchronized void decrementar(){
        valor--;
        System.out.println(this.getValor());
    }
    public int getValor(){
        return valor;
    }
}