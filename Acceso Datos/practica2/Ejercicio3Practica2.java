
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Ejercicio3Practica2 {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("productos.xml");

            // Crear un objeto XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Consulta XPath 3: Obtener los nodos de los productos con precio mayor de 60 €
            // y de la zona 20
            String expression3 = "/productos/produc[precio > 60 and cod_zona = 20]";
            XPathExpression xpathExpression3 = xpath.compile(expression3);

            // Ejecutar la consulta y obtener los resultados
            NodeList resultNodes3 = (NodeList) xpathExpression3.evaluate(document, XPathConstants.NODESET);

            System.out.println("\nResultados de la consulta 3:");
            for (int i = 0; i < resultNodes3.getLength(); i++) {
                System.out.println("Nodo: " + resultNodes3.item(i).getNodeName() + ", Contenido: "
                        + resultNodes3.item(i).getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
