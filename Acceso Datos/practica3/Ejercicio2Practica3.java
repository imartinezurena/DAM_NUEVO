package practica3;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Ejercicio2Practica3 {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("sucursales.xml");

            // Crear un objeto XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Consulta XPath 2: Obtener por cada sucursal la concatenación de su código y
            // el número de cuentas del tipo AHORRO
            String expression2 = "//sucursal";
            XPathExpression xpathExpression2 = xpath.compile(expression2);

            // Ejecutar la consulta y obtener los resultados
            NodeList resultNodes2 = (NodeList) xpathExpression2.evaluate(document, XPathConstants.NODESET);

            System.out.println("Resultados de la consulta 2:");
            for (int i = 0; i < resultNodes2.getLength(); i++) {
                String codigoSucursal = resultNodes2.item(i).getAttributes().getNamedItem("codigo").getTextContent();
                NodeList cuentasAhorro = (NodeList) xpath.evaluate(".//cuenta[@tipo='AHORRO']", resultNodes2.item(i),
                        XPathConstants.NODESET);
                int numeroCuentasAhorrro = cuentasAhorro.getLength();
                System.out
                        .println("Sucursal: " + codigoSucursal + ", Número de cuentas AHORRO: " + numeroCuentasAhorrro);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
