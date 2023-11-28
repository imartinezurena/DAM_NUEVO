package unidad2Hilos.Ejer1;

/*Hilos:
Crea una clase que extienda de Thread y sobrescriba el método run para imprimir "Hola Mundo" en la consola. 
Luego, instancia y ejecuta el hilo en la clase principal.
Crea un versión de forma que implementes Runnable.
Crea una versión con un Lambda.*/
public class Ejer1HolaMundo {

    public static void main(String[] args) {
        HiloThread hiloThread = new HiloThread();
        hiloThread.start();

        Thread hiloRunnable = new Thread(new HiloRunnable());
        hiloRunnable.start();
        /*
         * HiloRunnable ho = new HiloRunnable();
         * Thread hiloRunnable = new Thread(ho);
         */
        Runnable runnable = () -> {
            System.out.println("Hola mundo desde Lambda runnable");
        };
        runnable.run();
    }
}