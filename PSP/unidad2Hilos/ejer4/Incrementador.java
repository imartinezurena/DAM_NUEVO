package unidad2Hilos.ejer4;

public class Incrementador implements Runnable {
    Cuentas cont;

    public Incrementador(Cuentas c) {
        cont = c;
    }

    public void run() {
        for (int i = 0; i < Ejer04Contador.META; i++) {
            cont.increment();
        }
    }

}
