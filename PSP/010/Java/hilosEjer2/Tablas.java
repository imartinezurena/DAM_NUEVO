package hilosEjer2;

public class Tablas {
    
    public static void main(String[] args) {
        
    }
}
class Numeros implements Runnable {
    private static final int MULTIPLICADORES= 10;
    private int numero;

    public Numeros(int numero) {
        this.numero = numero;
    }

    public void run() {
        for (int i = 1; i <= MULTIPLICADORES; i++) {
            int resultado = numero * i;
            System.out.println(numero + "*" + i + "=" + resultado);
        }
        System.out.println(String.format("Tabla del %d terminada.", numero));
    }
}