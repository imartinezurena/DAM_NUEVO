/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pcundo
 */
public class Ejercicio0 {

    public static void main(String args[]) {
        try {
            String url = "jdbc:mysql://localhost:3306/employee";
            Connection con = (Connection) DriverManager.getConnection(url, "root", "");
            PreparedStatement pst;
            ResultSet rs;
            pst = con.prepareStatement("select * from EMPLOYEE, JOB where EMPLOYEE.job_id= JOB.job_id and department_id=?");
            pst.setString(1, "30");
            rs = pst.executeQuery();
            System.out.println("Los empleados del departamento 30 son los siguientes:");
            int empid;
            String nombre;
            String job;
            while (rs.next()) {
                empid = Integer.parseInt(rs.getString("employee_id"));
                nombre = rs.getString("first_name");
                job = rs.getString("function");
                System.out.println("empno: " + empid + " ename: " + nombre + " job: " + job);
            }
        } catch (SQLException e) {
            Logger.getLogger(Ejercicio0.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
