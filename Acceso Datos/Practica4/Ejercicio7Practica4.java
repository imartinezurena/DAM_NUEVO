package Practica4;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Ejercicio7Practica4 {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("universidad.xml");

            // Crear un objeto XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Consulta XPath 7: Obtener los nombres de empleados de los departamentos de
            // tipo A, cuyo puesto es profesor
            String expression7 = "//departamento[@tipo='A']/empleado[puesto='Profesor']/nombre";
            XPathExpression xpathExpression7 = xpath.compile(expression7);

            // Ejecutar la consulta y obtener los resultados
            NodeList nombresProfesores = (NodeList) xpathExpression7.evaluate(document, XPathConstants.NODESET);

            // Imprimir los resultados
            System.out.println("Nombres de empleados de los departamentos de tipo A, cuyo puesto es profesor:");
            for (int i = 0; i < nombresProfesores.getLength(); i++) {
                String nombre = nombresProfesores.item(i).getTextContent();
                System.out.println("- " + nombre);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
