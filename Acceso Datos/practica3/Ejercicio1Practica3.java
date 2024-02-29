package practica3;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Ejercicio1Practica3 {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("sucursales.xml");

            // Crear un objeto XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Consulta XPath 1: Obtener los datos de las cuentas bancarias cuyo tipo sea
            // AHORRO
            String expression1 = "//cuenta[@tipo='AHORRO']";
            XPathExpression xpathExpression1 = xpath.compile(expression1);

            // Ejecutar la consulta y obtener los resultados
            NodeList resultNodes1 = (NodeList) xpathExpression1.evaluate(document, XPathConstants.NODESET);

            System.out.println("Resultados de la consulta 1:");
            for (int i = 0; i < resultNodes1.getLength(); i++) {
                System.out.println("Cuenta " + (i + 1) + ":");
                NodeList cuentaChildren = resultNodes1.item(i).getChildNodes();
                for (int j = 0; j < cuentaChildren.getLength(); j++) {
                    if (cuentaChildren.item(j).getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                        System.out.println("   " + cuentaChildren.item(j).getNodeName() + ": "
                                + cuentaChildren.item(j).getTextContent());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
