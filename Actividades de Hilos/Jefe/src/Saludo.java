import java.util.ArrayList;

public class Saludo{
    Boolean jefeDentro = false;

    public synchronized void SaludoJefe() throws InterruptedException {
        jefeDentro = true;
        notifyAll();
        System.out.println("Buenos días mis queridos empleados explotados");
    }

    public synchronized void SaludoEmpleado() throws InterruptedException {
        if (!jefeDentro) {
            wait();
        }
        System.out.println("Buenos días su majestuosidad");
    }
}
