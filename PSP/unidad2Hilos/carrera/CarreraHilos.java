package unidad2Hilos.carrera;

public class CarreraHilos {

    private static final int CANTIDAD_CORREDORES = 10;
    private static final int KILOMETROS = 100;

    public static void main(String[] args) throws InterruptedException {
        Thread threadArray[] = new Thread[CANTIDAD_CORREDORES];
        Object salida = new Object();
        for (int i = 0; i < CANTIDAD_CORREDORES; i++) {
            threadArray[i] = new Thread(new Corredor(KILOMETROS, i));
        }
        /*
         * Thread facu = new Thread(new Corredor(100, 0));
         * Thread fausto = new Thread(new Corredor(100, 1));
         * fausto.start();
         * facu.start();
         * facu.join();
         * fausto.join();
         */
        for (int i = 0; i < CANTIDAD_CORREDORES; i++) {
            threadArray[i].start();
        }
        Thread.sleep(1000);
        synchronized (Corredor.salida) {
            Corredor.salida.notifyAll();
        }
        try {
            for (int i = 0; i < CANTIDAD_CORREDORES; i++) {
                threadArray[i].join();
            }

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        System.out.println("la carrera ha terminado");

    }
}