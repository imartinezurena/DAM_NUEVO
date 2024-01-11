/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author pcundo
 */
public class AlumnoBean implements AlumnoInterface {

    private String numExpdte;
    private String nombre;
    private String ciclo;
    private String dni;
    private java.util.Date fecha;
    private java.sql.Connection conexcion;

    public AlumnoBean() {
    }

    @Override
    public String getNumExpdte() {
        return numExpdte;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getCiclo() {
        return ciclo;
    }

    @Override
    public String getDni() {
        return dni;
    }

    @Override
    public Date getFecha() {
        return fecha;
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
            String url = "jdbc:mysql://localhost:3306/alumno";
            con = (Connection) DriverManager.getConnection(url, "root", "");
        } catch (SQLException e) {
            System.err.println("No se puede obtener la conexcion");
            return null;
        }
        return con;
    }

    private boolean setCosas(String cosa, Object valor) {
        boolean res = false;
        try {
            conexcion = getConexion();
            PreparedStatement pst;
            String sentencia = String.format("update ALUMNO set %s=? where numexpdte=? ", cosa);
            pst = conexcion.prepareCall(sentencia);
            if (cosa.equals("fecnac")) {
                Date dia = (Date) valor;
                pst.setDate(1, new java.sql.Date(dia.getTime()));
            } else {
                String dato = (String) valor;
                pst.setString(1, dato);
            }
            pst.setString(2, this.numExpdte);
            pst.executeUpdate();
            conexcion.close();
            res = true;
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el alumno");
            res = false;
        }
        return res;
    }

    @Override
    public void setNombre(String nombre) {
        /*try {
            conexcion = getConexion();
            PreparedStatement pst;
            pst = conexcion.prepareCall("update ALUMNO set nombre=? where numexpdte=? ");
            pst.setString(1, nombre);
            pst.setString(2, this.numExpdte);
            pst.executeUpdate();
            conexcion.close();
            this.nombre=nombre;
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el alumno");
        }*/
        if (setCosas("nombre", nombre)) {
            this.nombre = nombre;
        }
    }

    @Override
    public void setCiclo(String ciclo) {
        if (setCosas("ciclo", ciclo)) {
            this.ciclo = ciclo;
        }
    }

    @Override
    public void setDni(String dni) {
        if (setCosas("dni", dni)) {
            this.dni = dni;
        }
    }

    @Override
    public void setFecha(Date fecha) {
        if (setCosas("fecnac", fecha)) {
            this.fecha = fecha;
        }

    }

    @Override
    public AlumnoInterface getAlumnoPorNumexpdte(String numExpdte) {

        AlumnoBean alumno = null;
        try {
            conexcion = getConexion();
            PreparedStatement pst;
            ResultSet rs;
            pst = conexcion.prepareStatement("select * from ALUMNO where numexpdte=?");
            pst.setString(1, numExpdte);
            rs = pst.executeQuery();
            while (rs.next()) {
                alumno.ciclo = rs.getString("ciclo");
                alumno.dni = rs.getString("dni");
                alumno.fecha = rs.getDate("fecnac");
                alumno.nombre = rs.getString("nombre");
                alumno.numExpdte = rs.getString("numexpdte");
            }
            conexcion.close();
        } catch (SQLException ex) {
            System.out.println("Error en SELECT de Alumno por NUMEXPDTE sobre ALUMNO");
        }
        return alumno;
    }

    @Override
    public Collection getAlumnoPorCiclo(String ciclo) {
        List lista = new ArrayList();
        try {
            conexcion = getConexion();
            PreparedStatement pst;
            ResultSet rs;
            pst = conexcion.prepareStatement("select * from ALUMNO where ciclo=?");
            pst.setString(1, ciclo);
            rs = pst.executeQuery();
            while (rs.next()) {
                AlumnoBean alumno = new AlumnoBean();
                alumno.ciclo = rs.getString("ciclo");
                alumno.dni = rs.getString("dni");
                alumno.fecha = rs.getDate("fecnac");
                alumno.nombre = rs.getString("nombre");
                alumno.numExpdte = rs.getString("numexpdte");
                lista.add(alumno);
            }
        } catch (SQLException ex) {
            System.out.println("Error en SELECT de alumno por ciclo sobre alumno");
        }
        return lista;
    }

    @Override
    public Collection getAlumnoPorNombre(String nombre) {
        List lista = new ArrayList();
        try {
            conexcion = getConexion();
            PreparedStatement pst;
            ResultSet rs;
            pst = conexcion.prepareStatement("select * from alumno where nombre=?");
            pst.setString(1, nombre);
            rs = pst.executeQuery();
            while (rs.next()) {
                AlumnoBean alumno = new AlumnoBean();
                alumno.ciclo = rs.getString("ciclo");
                alumno.dni = rs.getString("dni");
                alumno.fecha = rs.getDate("fecnac");
                alumno.nombre = rs.getString("nombre");
                alumno.numExpdte = rs.getString("numexpdte");
                lista.add(alumno);
            }
        } catch (SQLException ex) {
            System.out.println("Error en SELECT de alumno por nombre sobre alumno");
        }
        return lista;
    }

    @Override
    public void delete() {
        try {
            conexcion = getConexion();
            PreparedStatement pst;
            pst = conexcion.prepareCall("delete from ALUMNO where numexpdt=?");
            pst.setString(1, this.numExpdte);
            pst.executeUpdate();
            conexcion.close();
            this.ciclo = null;
            this.dni = null;
            this.fecha = null;
            this.nombre = null;
            this.numExpdte = null;
            this.conexcion = null;
        } catch (SQLException ex) {
            System.out.println("Error al borrar el alumno");
        }
    }

    @Override
    public AlumnoInterface getNuevoAlumno(String numExpdte, String nombre, String ciclo, String dni, Date fecha) {
        AlumnoBean alumno = null;
        try {
            conexcion = getConexion();
            PreparedStatement pst;
            pst = conexcion.prepareCall("insert into alumno(numexpdte,nombre,dni,fecnac,ciclo) values (?,?,?,?,?)");
            pst.setString(1, numExpdte);
            pst.setString(2, nombre);
            pst.setString(3, dni);
            pst.setDate(4, new java.sql.Date(fecha.getTime()));
            pst.setString(5, ciclo);
            pst.executeUpdate();
            conexcion.close();
            this.ciclo=ciclo;
            this.dni=dni;
            this.nombre=nombre;
            this.numExpdte=numExpdte;
            this.fecha=fecha;
        } catch (SQLException ex) {
            System.out.println("Error SQL al insertar Alumno" + ex.getMessage());
        }
        return alumno;
    }

}
