
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Ejercicio6Practica2 {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("productos.xml");

            // Crear un objeto XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Consulta XPath 6: Obtener los datos de los productos cuyo stock mínimo sea
            // mayor que su stock actual
            String expression6 = "/productos/produc[stock_minimo > stock_actual]";
            XPathExpression xpathExpression6 = xpath.compile(expression6);

            // Ejecutar la consulta y obtener los resultados
            NodeList resultNodes6 = (NodeList) xpathExpression6.evaluate(document, XPathConstants.NODESET);

            System.out.println("\nResultados de la consulta 6:");
            for (int i = 0; i < resultNodes6.getLength(); i++) {
                System.out.println("Nodo: " + resultNodes6.item(i).getNodeName() + ", Contenido: "
                        + resultNodes6.item(i).getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
