import java.util.Random;

public class Coche {
    String marca;
    int km = 0;
    int numero;
    Random rand = new Random();

    public Coche(String marca, int numero) {
        this.marca = marca;
        this.numero = numero;
    }

    public String getKm() {
        return this.marca + "(" + this.numero + ") lleva recorrido " + this.km + "Km!";
    }

    public void sumarKm(){
        km += rand.nextInt(100);
    }


    public boolean finalizado(){
        return km > 500;
    }
}
