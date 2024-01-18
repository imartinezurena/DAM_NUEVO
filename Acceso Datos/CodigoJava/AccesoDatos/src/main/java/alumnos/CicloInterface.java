package alumnos;

/**
 * CicloInterface
 */
public interface CicloInterface {
    // metodos get
    public String getCodCiclo();

    public String getDenCiclo();

    public String getGrado();

    // metodos set
    public void setCodCiclo(String nombre);

    public void setDenCiclo(String ciclo);

    public void setGrado(String dni);

    // metodo par acrear un ciclo

    public CicloInterface getNuevoCiclo(String Cod, String Den, String grado);
}
