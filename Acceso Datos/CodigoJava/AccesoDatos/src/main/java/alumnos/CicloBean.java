package alumnos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class CicloBean implements CicloInterface {

    private String denciclo;
    private String codciclo;
    private String grado;
    private java.sql.Connection conexcion;

    public CicloBean() {
    }

    public String getDenCiclo() {
        return denciclo;
    }

    public String getCodCiclo() {
        return codciclo;
    }

    public String getGrado() {
        return grado;
    }

    private java.sql.Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("No se encuentra la clase del driver");
            return null;
        }
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/alumnos";
            con = (Connection) DriverManager.getConnection(url, "root", "");
        } catch (SQLException e) {
            System.err.println("No se puede obtener la conexion");
            return null;
        }
        return con;
    }

    @Override
    public void setCodCiclo(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCodCiclo'");
    }

    public void setDenCiclo(String denCiclo) {
        denciclo = denciclo;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    @Override
    public CicloInterface getNuevoCiclo(String codciclo, String denciclo, String grado) {
        CicloBean Ciclo = null;
        try {
            conexcion = getConexion();
            PreparedStatement pst;
            pst = conexcion.prepareCall("insert into ciclo(codciclo,denciclo,grado) values (?,?,?)");
            pst.setString(1, codciclo);
            pst.setString(2, denciclo);
            pst.setString(3, grado);

            pst.executeUpdate();
            conexcion.close();
            this.codciclo = codciclo;
            this.denciclo = denciclo;
            this.grado = grado;

        } catch (SQLException ex) {
            System.out.println("Error SQL al insertar Ciclo" + ex.getMessage());
        }
        return Ciclo;
    }

}
