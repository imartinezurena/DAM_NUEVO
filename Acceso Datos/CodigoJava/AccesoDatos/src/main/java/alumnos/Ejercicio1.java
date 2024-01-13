package alumnos;

import java.util.Date;

public class Ejercicio1 {
    public static void main(String[] args) {
        AlumnoBean alumnos = new AlumnoBean();
        alumnos.getNuevoAlumno("105", "Enriqueta", "ASIR", "3434343", new Date());
    }
}