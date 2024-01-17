package alumnos;

/**
 * CicloInterface
 */
public interface CicloInterface {

    public String getNumExpdte();

    public String getNombre();

    public String getCiclo();

    public String getDni();

    public java.util.Date getFecha();

    // metodos set
    public void setNombre(String nombre);

    public void setCiclo(String ciclo);

    public void setDni(String dni);

    public void setFecha(java.util.Date fecha);

    // metodos find
    public AlumnoInterface getAlumnoPorNumexpdte(String numExpdte);

    public java.util.Collection getAlumnoPorCiclo(String ciclo);

    public java.util.Collection getAlumnoPorNombre(String nombre);

    // metodo borrado
    public void delete();

    // metodo par acrear un numero alumno

    public AlumnoInterface getNuevoAlumno(String numExpdte, String nombre, String ciclo, String dni,
            java.util.Date fecha);
}
