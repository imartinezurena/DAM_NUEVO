
package escalera.java;

import java.util.ArrayList;

public class Escalera {
    public interface ObservadorDeMirilla{
        void aviso(String info);
    }
    private ArrayList<ObservadorDeMirilla>misCotillas;
    
    public Escalera(){
        misCotillas = new ArrayList<ObservadorDeMirilla>();
        }   
    public void addCotilla(ObservadorDeMirilla cotilla){
        misCotillas.add(cotilla);
    }
    public void dispararEvento(String info){
        for(ObservadorDeMirilla om:misCotillas){
            om.aviso(info);
        }
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
