package Practica4;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Ejercicio9Practica4 {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("universidad.xml");

            // Crear un objeto XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Consulta XPath 9: Obtener nombres de departamentos y empleados de cada
            // departamento
            String expression9 = "//departamento/nombre";
            XPathExpression xpathExpression9 = xpath.compile(expression9);

            // Ejecutar la consulta y obtener los resultados
            NodeList nombresDepartamentos = (NodeList) xpathExpression9.evaluate(document, XPathConstants.NODESET);

            // Imprimir los resultados
            System.out.println("Nombres de departamentos y empleados que tiene cada departamento:");
            for (int i = 0; i < nombresDepartamentos.getLength(); i++) {
                String nombreDepartamento = nombresDepartamentos.item(i).getTextContent();
                System.out.println("Departamento: " + nombreDepartamento);

                // Consulta XPath para obtener empleados de cada departamento
                String expressionEmpleados = "//departamento[nombre='" + nombreDepartamento + "']/empleado/nombre";
                XPathExpression xpathExpressionEmpleados = xpath.compile(expressionEmpleados);

                // Ejecutar la consulta y obtener los empleados
                NodeList nombresEmpleados = (NodeList) xpathExpressionEmpleados.evaluate(document,
                        XPathConstants.NODESET);

                // Imprimir los nombres de los empleados
                for (int j = 0; j < nombresEmpleados.getLength(); j++) {
                    String nombreEmpleado = nombresEmpleados.item(j).getTextContent();
                    System.out.println("  - " + nombreEmpleado);
                }
                System.out.println(); // Separador entre departamentos
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
