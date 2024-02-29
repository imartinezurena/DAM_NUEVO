
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Ejercicio7Practica2 {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("productos.xml");

            // Crear un objeto XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Consulta XPath 7: Obtener el nombre de producto y el precio de aquellos cuyo
            // stock mínimo sea mayor que su stock actual y sean de la zona 40
            String expression7 = "/productos/produc[stock_minimo > stock_actual and cod_zona = 40]/denominacion | /productos/produc[stock_minimo > stock_actual and cod_zona = 40]/precio";
            XPathExpression xpathExpression7 = xpath.compile(expression7);

            // Ejecutar la consulta y obtener los resultados
            NodeList resultNodes7 = (NodeList) xpathExpression7.evaluate(document, XPathConstants.NODESET);

            System.out.println("\nResultados de la consulta 7:");
            for (int i = 0; i < resultNodes7.getLength(); i++) {
                System.out.println("Nodo: " + resultNodes7.item(i).getNodeName() + ", Contenido: "
                        + resultNodes7.item(i).getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
