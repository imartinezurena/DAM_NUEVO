package bd_alumnos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio4y5 {

    static java.sql.Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("No se encuentra la clase del driver");
            return null;
        }
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/bd_alumnos";
            con = (Connection) DriverManager.getConnection(url, "root", "");
        } catch (SQLException e) {
            System.err.println("No se puede obtener la conexion");
            return null;
        }
        return con;
    }

    static void listarMetadatos() throws SQLException {
        try (Connection connection = getConexion()) {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getTables(connection.getCatalog(), null, "%", new String[] { "TABLE" });

            System.out.println("Tablas en la base de METAdatos BD_Alumnos:");

            while (resultSet.next()) {
                String nombreTabla = resultSet.getString("TABLE_NAME");
                System.out.println(nombreTabla);
            }
        }
    }

    static void listarTablas() throws SQLException {
        try (Connection connection = getConexion()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SHOW TABLES");

            System.out.println("Tablas en la base de datos BD_Alumnos:");

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        }
    }

    public static void main(String[] args) {
        try {
            Ejercicio4y5.listarTablas();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Ejercicio4y5.listarMetadatos();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
