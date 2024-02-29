package Practica4;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Ejercicio1Practica4 {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("empleados.xml");

            // Crear un objeto XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Consulta XPath 1: Obtener los nombres de oficio que empiezan por "P"
            String expression1 = "//OFICIO[starts-with(., 'P')]";
            XPathExpression xpathExpression1 = xpath.compile(expression1);

            // Ejecutar la consulta y obtener los resultados
            NodeList resultNodes1 = (NodeList) xpathExpression1.evaluate(document, XPathConstants.NODESET);

            System.out.println("Nombres de oficio que empiezan por 'P':");
            for (int i = 0; i < resultNodes1.getLength(); i++) {
                System.out.println("Oficio: " + resultNodes1.item(i).getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
