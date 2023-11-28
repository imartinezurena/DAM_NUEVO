package unidad2Hilos.EjerElefantes;

import java.util.Random;

public class Animales implements Runnable {
    private String nombre;
    private String accion;
    private int maximo;

    public Animales(String nombre, String accion, int maximo) {
        this.nombre = nombre;
        this.accion = accion;
        this.maximo = maximo;
    }

    @Override
    public void run() {
        for (int i = 0; i < maximo; i++) {
            System.out.printf(
                    "un %s se %s sobre la tela de una araña como veian que no se caia fueron a llamar a otro %s \n",
                    nombre, accion, nombre);
            if (esPrimo(numAleatorio())) {
                System.out.println("es primo\n");
            } else {
                System.out.println("no es primo\n");
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
    }

    public int numAleatorio() {
        int min = 100000;
        int max = 300000;

        Random r = new Random();
        int aleatorio = r.nextInt(max - min + 1) + min;
        return aleatorio;
    }

    public boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false; // Los números menores o iguales a 1 no son primos
        }
        for (int i = 2; i * i <= numero; i++) {
            if (numero % i == 0) {
                return false; // El número no es primo
            }
        }
        return true; // El número es primo
    }

}
