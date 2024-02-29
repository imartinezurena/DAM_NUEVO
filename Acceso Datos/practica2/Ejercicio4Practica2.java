
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Ejercicio4Practica2 {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("productos.xml");

            // Crear un objeto XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Consulta XPath 4: Obtener el número de productos que sean memorias y de la
            // zona 10
            String expression4 = "count(/productos/produc[contains(denominacion, 'Memoria') and cod_zona = 10])";
            XPathExpression xpathExpression4 = xpath.compile(expression4);

            // Ejecutar la consulta y obtener el resultado
            Double resultCount = (Double) xpathExpression4.evaluate(document, XPathConstants.NUMBER);

            System.out.println("\nNúmero de productos que son memorias y de la zona 10: " + resultCount.intValue());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
