public class Corredor {
    String nombre;
    int m=0;
    public Corredor(String nombre) {
        this.nombre = nombre;
    }
    public void sumarMetro(){
        m+=1;
    }

    public boolean finalizado(){
        return m>1500;
    }
}
