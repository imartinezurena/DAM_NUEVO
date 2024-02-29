package practica3;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Ejercicio10Practica3 {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("sucursales.xml");

            // Crear un objeto XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Consulta XPath 10: Obtener los nodos de número de cuenta, nombre de cuenta y
            // saldo haber de las cuentas con saldo haber mayor de 10000
            String expression10 = "//cuenta[saldohaber > 10000]/numero | //cuenta[saldohaber > 10000]/nombre | //cuenta[saldohaber > 10000]/saldohaber";
            XPathExpression xpathExpression10 = xpath.compile(expression10);

            // Ejecutar la consulta y obtener los resultados
            NodeList resultNodes10 = (NodeList) xpathExpression10.evaluate(document, XPathConstants.NODESET);

            System.out.println("Resultados de la consulta 10:");
            for (int i = 0; i < resultNodes10.getLength(); i++) {
                System.out.println("Nodo: " + resultNodes10.item(i).getNodeName() + ", Contenido: "
                        + resultNodes10.item(i).getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
