package practica3;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Ejercicio4Practica3 {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("sucursales.xml");

            // Crear un objeto XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Consulta XPath 4: Obtener por cada sucursal la concatenación de los datos
            String expression4 = "//sucursal";
            XPathExpression xpathExpression4 = xpath.compile(expression4);

            // Ejecutar la consulta y obtener los resultados
            NodeList resultNodes4 = (NodeList) xpathExpression4.evaluate(document, XPathConstants.NODESET);

            System.out.println("Resultados de la consulta 4:");
            for (int i = 0; i < resultNodes4.getLength(); i++) {
                String codigoSucursal = resultNodes4.item(i).getAttributes().getNamedItem("codigo").getTextContent();
                String director = xpath.evaluate("director", resultNodes4.item(i));
                NodeList cuentasHaber = (NodeList) xpath.evaluate(".//cuenta/saldohaber", resultNodes4.item(i),
                        XPathConstants.NODESET);

                double totalSaldoHaber = 0;
                for (int j = 0; j < cuentasHaber.getLength(); j++) {
                    totalSaldoHaber += Double.parseDouble(cuentasHaber.item(j).getTextContent());
                }

                System.out.println("Sucursal: " + codigoSucursal + ", Director: " + director + ", Total Saldo Haber: "
                        + totalSaldoHaber);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
