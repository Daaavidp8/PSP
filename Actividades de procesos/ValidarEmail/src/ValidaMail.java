import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class ValidaMail {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String email = br.readLine();


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
                }
                if (contador < 2){
                    System.out.println("ERROR: El primer " +
                            "identificador ha de tener una longitud mínima de 3 caracteres");
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
        } else if (!segundoIdentificador) {
            System.out.println("ERROR: El email no contiene segundo identificador");
        } else if (!dominiosValido.contains(dominio.toString())) {
            System.out.println("ERROR: El dominio no es ni com/es/org!");
        }else {
            System.out.println("true");
        }



    }
}
