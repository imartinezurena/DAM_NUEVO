package practica3;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Ejercicio6Practica3 {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("sucursales.xml");

            // Crear un objeto XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Consulta XPath 6: Obtener todos los elementos de las sucursales con más de 3
            // cuentas del tipo AHORRO
            String expression6 = "//sucursal[count(cuenta[@tipo='AHORRO']) > 3]";
            XPathExpression xpathExpression6 = xpath.compile(expression6);

            // Ejecutar la consulta y obtener los resultados
            NodeList resultNodes6 = (NodeList) xpathExpression6.evaluate(document, XPathConstants.NODESET);

            System.out.println("Resultados de la consulta 6:");
            for (int i = 0; i < resultNodes6.getLength(); i++) {
                System.out.println("Sucursal " + (i + 1) + ":");
                NodeList sucursalChildren = resultNodes6.item(i).getChildNodes();
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
