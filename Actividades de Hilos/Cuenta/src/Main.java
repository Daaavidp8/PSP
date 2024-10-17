//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
            Cuenta cuenta = new Cuenta(40);
            SacarDinero sacar = new SacarDinero(cuenta,"Juan",40);
            sacar.start();
            sacar.join();
        }
}
