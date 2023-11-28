package unidad2Hilos.ejer4;
/*Crea una clase Counter con un método sincronizado increment que incremente una variable count. 
Crea dos hilos que incrementen el contador y observa el resultado. 
Modifica la clase Counter anterior para usar un bloque sincronizado en lugar de un método sincronizado.

Modificación 04a
Modifica el ejercicio para poder incrementar y decrementar, crea 5 hilos que incrementen 1000 veces y 5 que decrementen 1000 veces.
Muestra el resultado de hacer esta operación con sincronización y sin sincornización. */

public class Cuentas {
    int c = 0;

    public Cuentas(int c) {
        this.c = c;
    }

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