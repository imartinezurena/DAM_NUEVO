package unidad2Hilos.EjerElefantes;

/*Un elefante se balanceaba sobre la tela de una araña
Como veía que resistía, fue a llamar otro elefante
Dos elefantes se balanceaban sobre la tela de una araña
Como veían que resistía, fueron a llamar otro elefante

Basándote en esa canción, crea un Thread que reciba el tipo de animal, la acción y el número máximo. 
Cada vez que escriba una estrofa, el thread generará un número aleatorio entre 100000 y 300000 y verificará si es primo.

Crea un programa principal que gestion 3 canciones infantiles de forma concurrente con distintas prioridades (setPriority) */
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
