package alumnos;

public class Ejercicio2 {
    public static void main(String[] args) {
        CicloInterface ciclo = FactoriaCiclos.getCicloDao();
        ciclo.getNuevoCiclo("DPI", "Desarrollo de producto informaticos", "medio");
    }

}
