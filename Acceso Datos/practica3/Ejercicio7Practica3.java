package practica3;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Ejercicio7Practica3 {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("sucursales.xml");

            // Crear un objeto XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Consulta XPath 7: Obtener los nodos del director y la población de las
            // sucursales con más de 3 cuentas
            String expression7 = "//sucursal[count(cuenta) > 3]/director | //sucursal[count(cuenta) > 3]/poblacion";
            XPathExpression xpathExpression7 = xpath.compile(expression7);

            // Ejecutar la consulta y obtener los resultados
            NodeList resultNodes7 = (NodeList) xpathExpression7.evaluate(document, XPathConstants.NODESET);

            System.out.println("Resultados de la consulta 7:");
            for (int i = 0; i < resultNodes7.getLength(); i++) {
                System.out.println("Nodo: " + resultNodes7.item(i).getNodeName() + ", Contenido: "
                        + resultNodes7.item(i).getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
