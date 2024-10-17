import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class ValidaMail {
    public static void main(String[] args) {
        String email = args[0];


        int contador = 0;
        boolean arroba = false;
        boolean segundoIdentificador = false;
        ArrayList<String> dominiosValido = new ArrayList<>(Arrays.asList("com","es","org"));
        StringBuilder dominio = new StringBuilder();

        for (char c : email.toCharArray()) {
            if (c == '@') {
                if (!arroba) {
                    arroba = true;
                }else {
                    System.out.println("ERROR: El correo no puede tener mas de un \'@\' ");
                    System.exit(1);
                }
                if (contador < 2){
                    System.out.println("ERROR: El primer " +
                            "identificador ha de tener una longitud mínima de 3 caracteres");
                    System.exit(1);
                }
                contador = 0;
            }

            if (arroba && c == '.' && contador > 1) {
                segundoIdentificador = true;
            } else if (segundoIdentificador) {
                dominio.append(c);
            }
            contador++;
        }

        if (!email.contains("@")) {
            System.out.println("ERROR: El email no contiene una @!");
            System.exit(1);
        } else if (!segundoIdentificador) {
            System.out.println("ERROR: El email no contiene segundo identificador");
            System.exit(1);
        } else if (!dominiosValido.contains(dominio.toString())) {
            System.out.println(dominiosValido);
            System.out.println(dominio.toString());
            System.out.println("ERROR: El dominio no es ni com/es/org!");
            System.exit(1);
        }

    }
}
