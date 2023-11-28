package unidad2Hilos.hilosEjer2;
/*Crea una clase que implemente la interfaz Runnable y sobrescriba el método run para imprimir los números del 1 al 10. 
Luego, instancia y ejecuta el hilo en la clase principal.

Modifica el programa anterior para que cree un array de N Threads y los espere. 
A cada thread le dará un nombre (Método setName) y escribirá la tabla de un número.

NOTA: La salida estará desordenada.

Ejecuta el comando en la terminal, y vuelca su salida a un fichero. 
Utiliza las redirecciones de linux y el comando sort para verificar que has escrito todas las tablas. 
Tablas.java > salida.txt
 sort salida.txt
*/

public class Tablas {

    public static void main(String[] args) {

        int nThreads = Integer.parseInt(args[0]);
        Thread arrayThreads[] = new Thread[nThreads];
        for (int i = 0; i < nThreads; i++) {
            arrayThreads[i] = new Thread(new Numeros(i + 1));
            arrayThreads[i].setName("Tabla del " + (i + 1) + ": ");
            arrayThreads[i].start();

        }
        for (int i = 0; i < arrayThreads.length; i++) {// bucle para esperar los threads
            try {
                arrayThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/*
 * String[] commands = {
 * "java", "unidad01.entrenamientoC.ejercicio3.EscribirDatos > "
 * };
 */
class Numeros implements Runnable {
    private static final int MULTIPLICADORES = 10;
    private int numero;

    public Numeros(int numero) {
        this.numero = numero;
    }

    public void run() {
        for (int i = 1; i <= MULTIPLICADORES; i++) {
            int resultado = numero * i;
            System.out.println(numero + "*" + i + "=" + resultado);

        }
        System.out.printf("Tabla del %d terminada.", numero);
    }
}