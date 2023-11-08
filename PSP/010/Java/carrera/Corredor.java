package carrera;

public class Corredor implements Runnable{
    private static final int TIEMPO_DESCANSO = 500;
    private static final int DISTANCIA = 10;
    int KMrecorridos;
    int KMtotales;
    int dorsal;
    public Corredor( int kMtotales, int dorsal) {
        KMrecorridos = 0;
        KMtotales = kMtotales;
        this.dorsal = dorsal;
    }
    
    @Override
    public void run() {
        System.out.printf("soy el dorsal %d" ,dorsal);
        while(KMrecorridos<KMtotales){
            try {
                KMrecorridos+=Math.random()*DISTANCIA;
                System.out.printf("soy el dorsal %d y llevo %d de %d km \n", dorsal,KMrecorridos,KMtotales);
                Thread.sleep((long)((Math.random()*TIEMPO_DESCANSO)+TIEMPO_DESCANSO));
                System.out.printf("soy el dorsal %d y descanso\n",dorsal);
                
            } catch (InterruptedException e) {
               
                e.printStackTrace();
            }
        }

    }
}
