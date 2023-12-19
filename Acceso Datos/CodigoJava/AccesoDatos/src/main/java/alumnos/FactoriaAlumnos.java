/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alumnos;

/**
 *
 * @author pcundo
 */
public class FactoriaAlumnos {
    
    //metodo estatico que devuelve un obj alumnointerfaz
    
    public static AlumnoInterface getAlumnoDao(){
    return new AlumnoBean();
    }
    
}
