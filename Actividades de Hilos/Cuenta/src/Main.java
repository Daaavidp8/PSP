//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
            Cuenta cuenta = new Cuenta(1200);
            new SacarDinero(cuenta,"Juan",200).start();
            new SacarDinero(cuenta,"Pepe",200).start();
            new SacarDinero(cuenta,"Maria",200).start();
            new SacarDinero(cuenta,"Alberto",200).start();
        }
}
