import java.lang.reflect.Array;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static ArrayList<ArrayList<String>> tablero = new ArrayList<ArrayList<String>>();
    public static ArrayList<String> movimientos = new ArrayList<>();

    public static void main(String[] args) {

        boolean jugar = true;


        generarTablero();

        while (jugar) {
            movimientos.clear();

            // Mostrar Tablero
            for(ArrayList<String> fila:tablero) {
                for(String posicion:fila) {
                    System.out.print(posicion + " ");
                }
                System.out.println();
            }

            String casilla = "";
            Scanner myObj = new Scanner(System.in);
            System.out.println("Que posicion eliges?");
            casilla = myObj.nextLine();
            movimientos.add(casilla);


            int fila = 0;
            int columna = 0;
            boolean existe = false;

            // Cogemos las coordenadas del alfil
            for(int i = 0; i < tablero.size(); i++) {
                for(int j = 0; j < tablero.get(i).size(); j++) {
                    if (casilla.equals(tablero.get(j).get(i))) {
                        fila = j;
                        columna = i;
                        existe = true;
                    }
                }
            }

            if (existe) {
                Movimientos(fila,columna);


                // Dibujar movimientos
                for(ArrayList<String> row:tablero) {
                    for(String posicion:row) {
                        if (movimientos.contains(posicion)) {
                            if (casilla.equals(posicion)) {
                                System.out.print(" \u265D");
                            }else{
                                System.out.print(posicion + " ");
                            }
                        }else {
                            System.out.print(" - ");
                        }
                    }
                    System.out.println();
                }
            }



            System.out.println("Desea elegir otra posición? (S/n)");
            String respuesta = myObj.nextLine();

            if (respuesta.equalsIgnoreCase("n")) {
                jugar = false;
            }
        }



    }

    public static void generarTablero() {
        String[] numeros = new String[]{"8","7","6","5","4","3","2","1"};
        String[] letras = new String[]{"a","b","c","d","e","f","g","h"};
        for(String numero:numeros) {
            ArrayList<String> fila = new ArrayList<>();
            for(String letra:letras) {
                fila.add(letra + numero);
            }
            tablero.add(fila);
        }
    }

    public static void Movimientos(int fila, int columna) {



        ArrayList<ArrayList<Integer>> direcciones = new ArrayList<>();
        int[] numeros = new int[]{1,-1};
        for (int i = 0; i < 2; i++) {
            for (int numero:numeros){
                ArrayList<Integer> direccion = new ArrayList<>();
                direccion.add(numero);
                direccion.add(numeros[i]);
                direcciones.add(direccion);
            }
        }




        for (ArrayList<Integer> direccion : direcciones) {
            boolean limite = false;
            while (!limite) {
                if (fila + direccion.getFirst() < 0 || columna + direccion.get(1) < 0 || fila + direccion.getFirst() >= tablero.size() || columna + direccion.get(1) >= tablero.size()) {
                    break;
                }
                if (tablero.get(fila + direccion.getFirst()).get(columna + direccion.get(1)) != null ) {
                    movimientos.add(tablero.get(fila + direccion.getFirst()).get(columna + direccion.get(1)));
                }else {
                    limite = true;
                }
                if (direccion.getFirst() < 0){
                    direccion.set(0, direccion.getFirst() - 1);
                }else {
                    direccion.set(0, direccion.getFirst() + 1);
                }
                if (direccion.get(1) < 0){
                    direccion.set(1, direccion.get(1) - 1);
                }else {
                    direccion.set(1, direccion.get(1) + 1);
                }
            }
        }

    }


}