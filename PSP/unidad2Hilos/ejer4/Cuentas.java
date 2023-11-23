package unidad2Hilos.ejer4;

public class Cuentas {
    int c = 0;

    public synchronized void increment() {
        int d;
        for (int i = 0; i < Ejer04Contador.META; i++) {
            // hago cosas
            d = i * i * i;
        }
        synchronized (this) {
            c += 1;
        }
    }

    public synchronized void decrement() {
        int d;
        for (int i = 0; i < Ejer04Contador.META; i++) {
            // hago cosas
            d = i * i * i;
        }
        synchronized (this) {
            c -= 1; 
        }
    }

    public String toString() {
        return String.valueOf(c);
    }

}