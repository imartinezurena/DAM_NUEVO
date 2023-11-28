package unidad2Hilos.ejer4;

public class Decrementador implements Runnable {
    Cuentas cont;

    public Decrementador(Cuentas c) {
        cont = c;
    }

    public void run() {
        for (int i = 0; i < Ejer04Contador.META; i++) {
            cont.decrement();
        }
    }
}
