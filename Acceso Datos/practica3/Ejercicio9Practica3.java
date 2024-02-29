package practica3;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Ejercicio9Practica3 {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("sucursales.xml");

            // Crear un objeto XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Consulta XPath 9: Obtener por cada sucursal su código y la suma de las
            // aportaciones de las cuentas del tipo PENSIONES
            String expression9 = "//sucursal";
            XPathExpression xpathExpression9 = xpath.compile(expression9);

            // Ejecutar la consulta y obtener los resultados
            NodeList resultNodes9 = (NodeList) xpathExpression9.evaluate(document, XPathConstants.NODESET);

            System.out.println("Resultados de la consulta 9:");
            for (int i = 0; i < resultNodes9.getLength(); i++) {
                String codigoSucursal = resultNodes9.item(i).getAttributes().getNamedItem("codigo").getTextContent();
                NodeList cuentasPensiones = (NodeList) xpath.evaluate(".//cuenta[@tipo='PENSIONES']/aportacion",
                        resultNodes9.item(i), XPathConstants.NODESET);

                double sumaAportaciones = 0;
                for (int j = 0; j < cuentasPensiones.getLength(); j++) {
                    sumaAportaciones += Double.parseDouble(cuentasPensiones.item(j).getTextContent());
                }

                System.out.println(
                        "Sucursal: " + codigoSucursal + ", Suma de Aportaciones PENSIONES: " + sumaAportaciones);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
