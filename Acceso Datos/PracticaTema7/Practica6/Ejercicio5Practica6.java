package Practica6;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class Ejercicio5Practica6 {
    public static void main(String[] args) {
        try {
            // Ejercicio a)
            System.out.println("Ejercicio a):");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document universidadDoc = builder.parse(new File("universidad.xml"));
            NodeList departamentosList = universidadDoc.getElementsByTagName("departamento");

            for (int i = 0; i < departamentosList.getLength(); i++) {
                Element departamento = (Element) departamentosList.item(i);
                String nombreDepartamento = departamento.getElementsByTagName("nombre").item(0).getTextContent();
                NodeList empleadosList = departamento.getElementsByTagName("empleado");

                System.out.println("Departamento: " + nombreDepartamento);
                for (int j = 0; j < empleadosList.getLength(); j++) {
                    Element empleado = (Element) empleadosList.item(j);
                    String puesto = empleado.getElementsByTagName("puesto").item(0).getTextContent();
                    System.out.println("Puesto: " + puesto);
                }
                System.out.println("--------------------");
            }

            // Ejercicio b)
            System.out.println("\nEjercicio b):");
            NodeList departamentosList2 = universidadDoc.getElementsByTagName("departamento");

            for (int i = 0; i < departamentosList2.getLength(); i++) {
                Element departamento = (Element) departamentosList2.item(i);
                String nombreDepartamento = departamento.getElementsByTagName("nombre").item(0).getTextContent();
                NodeList empleadosList = departamento.getElementsByTagName("empleado");
                double salarioMaximo = 0;
                String empleadoSalarioMaximo = "";

                for (int j = 0; j < empleadosList.getLength(); j++) {
                    Element empleado = (Element) empleadosList.item(j);
                    double salario = Double.parseDouble(empleado.getAttribute("salario"));
                    if (salario > salarioMaximo) {
                        salarioMaximo = salario;
                        empleadoSalarioMaximo = empleado.getElementsByTagName("nombre").item(0).getTextContent();
                    }
                }
                System.out.println("Departamento: " + nombreDepartamento + ". Empleado con salario máximo: "
                        + empleadoSalarioMaximo + ", Salario máximo: " + salarioMaximo);
            }

            // Ejercicio c)
            System.out.println("\nEjercicio c):");
            NodeList oficios = universidadDoc.getElementsByTagName("puesto");

            for (int i = 0; i < oficios.getLength(); i++) {
                Element oficio = (Element) oficios.item(i);
                String nombreOficio = oficio.getTextContent();
                NodeList empleadosList = universidadDoc.getElementsByTagName("empleado");
                double salarioMaximo = 0;
                String empleadoSalarioMaximo = "";

                for (int j = 0; j < empleadosList.getLength(); j++) {
                    Element empleado = (Element) empleadosList.item(j);
                    if (empleado.getElementsByTagName("puesto").item(0).getTextContent().equals(nombreOficio)) {
                        double salario = Double.parseDouble(empleado.getAttribute("salario"));
                        if (salario > salarioMaximo) {
                            salarioMaximo = salario;
                            empleadoSalarioMaximo = empleado.getElementsByTagName("nombre").item(0).getTextContent();
                        }
                    }
                }
                System.out.println("Oficio: " + nombreOficio + ". Empleado con salario máximo: " + empleadoSalarioMaximo
                        + ", Salario máximo: " + salarioMaximo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}