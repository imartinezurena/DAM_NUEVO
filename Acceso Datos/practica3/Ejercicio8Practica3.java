package practica3;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Ejercicio8Practica3 {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("sucursales.xml");

            // Crear un objeto XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Consulta XPath 8: Obtener el número de sucursales cuya población sea Madrid
            String expression8 = "count(//sucursal[poblacion='Madrid'])";
            XPathExpression xpathExpression8 = xpath.compile(expression8);

            // Ejecutar la consulta y obtener el resultado
            Double resultCount8 = (Double) xpathExpression8.evaluate(document, XPathConstants.NUMBER);

            System.out.println("Número de sucursales en Madrid: " + resultCount8.intValue());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
