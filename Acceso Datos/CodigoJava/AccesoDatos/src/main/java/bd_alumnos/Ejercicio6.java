package bd_alumnos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio6 {
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

    static ResultSet obtenerTabla(String tabla) throws SQLException {
        Connection connection = getConexion();
        Statement statement = connection.createStatement();
        return statement.executeQuery("SELECT * FROM " + tabla);
    }

    static void mostrarTabla(String tabla) throws SQLException {
        ResultSet resultSet = obtenerTabla(tabla);

        // Imprime los nombres de las columnas
        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
            System.out.print(resultSet.getMetaData().getColumnName(i) + "\t");
        }
        System.out.println();

        // Imprime los datos
        while (resultSet.next()) {
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                System.out.print(resultSet.getString(i) + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try {
            Ejercicio4y5.listarMetadatos();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú:");
            System.out.println("1.alumnos");
            System.out.println("2.alumnos_asignaturas");
            System.out.println("3.asignaturas");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ha seleccionado la Opción 1");
                    try {
                        mostrarTabla("alumnos");
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Ha seleccionado la Opción 2");

                    try {
                        mostrarTabla("alumnos_asignaturas");
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("Ha seleccionado la Opción 3");
                    try {
                        mostrarTabla("asignaturas");
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
