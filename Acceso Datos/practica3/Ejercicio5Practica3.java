package practica3;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Ejercicio5Practica3 {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("sucursales.xml");

            // Crear un objeto XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Consulta XPath 5: Obtener todos los elementos de las sucursales con más de 3
            // cuentas
            String expression5 = "//sucursal[count(cuenta) > 3]";
            XPathExpression xpathExpression5 = xpath.compile(expression5);

            // Ejecutar la consulta y obtener los resultados
            NodeList resultNodes5 = (NodeList) xpathExpression5.evaluate(document, XPathConstants.NODESET);

            System.out.println("Resultados de la consulta 5:");
            for (int i = 0; i < resultNodes5.getLength(); i++) {
                System.out.println("Sucursal " + (i + 1) + ":");
                NodeList sucursalChildren = resultNodes5.item(i).getChildNodes();
                for (int j = 0; j < sucursalChildren.getLength(); j++) {
                    if (sucursalChildren.item(j).getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                        System.out.println("   " + sucursalChildren.item(j).getNodeName() + ": "
                                + sucursalChildren.item(j).getTextContent());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
