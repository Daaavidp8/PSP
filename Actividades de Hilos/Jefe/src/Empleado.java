public class Empleado extends Thread{
    String nombre;
    boolean esJefe;
    Saludo saludo;

    @Override
    public void run() {
        try {
            if (esJefe){
                saludo.SaludoJefe();
            }else {
                saludo.SaludoEmpleado();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Empleado(String nombre, boolean esJefe, Saludo saludo) {
        this.nombre = nombre;
        this.esJefe = esJefe;
        this.saludo = saludo;
    }
}
