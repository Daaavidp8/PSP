import java.util.ArrayList;

public class DatoCompartido {
    ArrayList<Integer> dato;

    public DatoCompartido() {
        dato = new ArrayList<Integer>();
    }

    public synchronized int obtener(int id) {
        try {
            if (!dato.contains(id)) {
                wait();
            }
            int num = dato.get(dato.indexOf(id));
            System.out.println("Obteniendo " + num);
            notifyAll();
            return num;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public synchronized void poner(int nuevoDato) {
        try {
            System.out.println("Añadiendo " + nuevoDato);
            dato.add(nuevoDato);
            System.out.println(dato);
            notifyAll();
            wait();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
