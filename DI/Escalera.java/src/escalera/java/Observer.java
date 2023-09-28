
package escalera.java;


public class Observer {
    public static void main(String[] args) {
        Escalera escalera = new Escalera();
        Persona ana = new Persona("Ana");
        Persona pepe = new Persona("Pepe");
        
        //gente se subscriba
        escalera.addCotilla(ana);
        escalera.addCotilla(pepe);
        Escalera.ObservadorDeMirilla o =
            new Escalera.ObservadorDeMirilla() {
                @Override
                public void aviso(String info) {
                    System.out.println("arghhhh!!!"+info);
                }
            }
        ;       
        escalera.addCotilla(o);
        escalera.addCotilla((String i)->{System.out.println("WTF!!!"+i);});
        //lanzar evento
        escalera.dispararEvento("Ha pasado Juan");
        escalera.dispararEvento("El del 2 ha llegado a las 3");
        
        
        
    }
    
}
