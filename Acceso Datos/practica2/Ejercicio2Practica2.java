
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Ejercicio2Practica2 {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("productos.xml");

            // Crear un objeto XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Consulta XPath 1: Obtener los nodos denominación y precio de todos los
            // productos
            String expression1 = "/productos/produc/denominacion | /productos/produc/precio";
            XPathExpression xpathExpression1 = xpath.compile(expression1);

            // Ejecutar la consulta y obtener los resultados
            NodeList resultNodes1 = (NodeList) xpathExpression1.evaluate(document, XPathConstants.NODESET);

            System.out.println("Resultados de la consulta 1:");
            for (int i = 0; i < resultNodes1.getLength(); i++) {
                System.out.println("Nodo: " + resultNodes1.item(i).getNodeName() + ", Valor: "
                        + resultNodes1.item(i).getTextContent());
            }

            // Consulta XPath 2: Obtener los nodos de los productos que sean placas base
            String expression2 = "/productos/produc[denominacion[contains(., 'Placa Base')]]";
            XPathExpression xpathExpression2 = xpath.compile(expression2);

            // Ejecutar la consulta y obtener los resultados
            NodeList resultNodes2 = (NodeList) xpathExpression2.evaluate(document, XPathConstants.NODESET);

            System.out.println("\nResultados de la consulta 2:");
            for (int i = 0; i < resultNodes2.getLength(); i++) {
                System.out.println("Nodo: " + resultNodes2.item(i).getNodeName() + ", Contenido: "
                        + resultNodes2.item(i).getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
