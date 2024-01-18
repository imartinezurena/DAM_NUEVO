package alumnos;

public class FactoriaCiclos {

    // metodo estatico que devuelve un obj alumnointerfaz

    public static CicloInterface getCicloDao() {
        return new CicloBean();
    }

}
