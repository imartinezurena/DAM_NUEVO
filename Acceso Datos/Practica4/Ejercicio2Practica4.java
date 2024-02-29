package Practica4;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.HashSet;
import java.util.Set;

public class Ejercicio2Practica4 {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("empleados.xml");

            // Crear un objeto XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Consulta XPath 2: Obtener los nombres de oficio y los empleados de cada
            // oficio
            String expression2 = "//OFICIO";
            XPathExpression xpathExpression2 = xpath.compile(expression2);

            // Almacenar los oficios en un conjunto para evitar repeticiones
            Set<String> oficiosSet = new HashSet<>();

            // Ejecutar la consulta y obtener los resultados
            NodeList oficios = (NodeList) xpathExpression2.evaluate(document, XPathConstants.NODESET);

            // Almacenar los oficios en el conjunto
            for (int i = 0; i < oficios.getLength(); i++) {
                oficiosSet.add(oficios.item(i).getTextContent());
            }

            // Imprimir los resultados únicos
            System.out.println("Nombres de oficio y empleados de cada oficio:");
            for (String oficio : oficiosSet) {
                NodeList empleados = (NodeList) xpath.evaluate("//EMP_ROW[OFICIO='" + oficio + "']/APELLIDO", document,
                        XPathConstants.NODESET);

                System.out.println("Oficio: " + oficio);
                System.out.println("Empleados:");
                for (int j = 0; j < empleados.getLength(); j++) {
                    System.out.println("- " + empleados.item(j).getTextContent());
                }
                System.out.println("------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
