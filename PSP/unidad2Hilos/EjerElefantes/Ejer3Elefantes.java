package unidad2Hilos.EjerElefantes;

public class Ejer3Elefantes {
    public static void main(String[] args) {

        Animales gato = new Animales("gato", "maullaba", 4);
        Animales raton = new Animales("raton", "mordisqueaba", 5);

        Thread threadPerro = new Thread(new Animales("perro", "ladraba", 8));
        Thread threadGato = new Thread(gato);
        Thread threadRaton = new Thread(raton);

        threadPerro.setPriority(Thread.NORM_PRIORITY);
        threadGato.setPriority(Thread.MAX_PRIORITY);
        threadRaton.setPriority(Thread.MIN_PRIORITY);

        threadPerro.start();
        threadGato.start();
        threadRaton.start();
    }
}
