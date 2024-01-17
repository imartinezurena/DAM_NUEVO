package alumnos;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Ejercicio1 {
    public static void main(String[] args) {
        AlumnoBean alumnos = new AlumnoBean();
        // alumnos.getNuevoAlumno("105", "Enriqueta", "ASIR", "3434343", new Date());
        /*
         * AlumnoInterface enriqueta = alumnos.getAlumnoPorNumexpdte("105");
         * enriqueta.setNombre("Blanca");
         * enriqueta.setDni("555555555");
         * enriqueta.setCiclo("DAM");
         */
        // ejecución 2
        /*
         * List resultado = (List) alumnos.getAlumnoPorCiclo("DAM");
         * Iterator it = resultado.iterator();
         * System.out.println("listado de DAM");
         * while (it.hasNext()) {
         * AlumnoBean alumno = (AlumnoBean) it.next();
         * System.out.println(alumno.getNombre());
         * 
         * }
         */
        // ejecucion 3
        /*
         * List resultado = (List) alumnos.getAlumnoPorNombre("juan perez");
         * Iterator it = resultado.iterator();
         * System.out.println("datos de juan");
         * while (it.hasNext()) {
         * AlumnoBean alumno = (AlumnoBean) it.next();
         * String res =
         * String.format("nombre: %s\n ciclo: %s\n dni: %s\n nExpediente: %s\n",
         * alumno.getNombre(),
         * alumno.getCiclo(),
         * alumno.getDni(),
         * alumno.getNumExpdte());
         * System.out.println(res);
         * }
         */
        // ejecucion 4
        /*
         * AlumnoInterface alumno = alumnos.getAlumnoPorNumexpdte("1");
         * String res =
         * String.format("nombre: %s\n ciclo: %s\n dni: %s\n nExpediente: %s\n",
         * alumno.getNombre(),
         * alumno.getCiclo(),
         * alumno.getDni(),
         * alumno.getNumExpdte());
         * System.out.println(res);
         */
        // ejecucion 5
        List resultado = (List) alumnos.getAlumnoPorNombre("Juan Perez");
        Iterator it = resultado.iterator();

        while (it.hasNext()) {
            AlumnoBean alumno = (AlumnoBean) it.next();
            System.out.println(alumno.getNumExpdte());
            alumno.delete();
        }
    }
}