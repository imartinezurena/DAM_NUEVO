package unidad2Hilos.ejer4;

public class Ejer04Contador{
public static int counter;
public static final int META=1000;

public static void main(String[] args) {
    Cuentas c = new Cuentas();
    Thread hilo1= new Thread(new Incrementador(c));
    Thread hilo2= new Thread(new Decrementador(c));

}
}