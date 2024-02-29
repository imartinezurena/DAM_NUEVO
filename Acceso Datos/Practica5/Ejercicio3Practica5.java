package Practica5;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.xpath.*;

public class Ejercicio3Practica5 {
    public static void main(String[] args) {
        try {
            // Cargar el XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse("productos.xml");

            // Crear un objeto XPath
            XPath xpath = XPathFactory.newInstance().newXPath();

            // Realizar la consulta para cada zona
            obtenerProductosMasCarosPorZona(xpath, doc, "zona10", "10");
            obtenerProductosMasCarosPorZona(xpath, doc, "zona20", "20");
            obtenerProductosMasCarosPorZona(xpath, doc, "zona30", "30");
            obtenerProductosMasCarosPorZona(xpath, doc, "zona40", "40");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void obtenerProductosMasCarosPorZona(XPath xpath, Document doc, String etiquetaZona, String codZona)
            throws XPathExpressionException {
        // Crear la expresión XPath
        String expression = String.format(
                "//produc[cod_zona='%s'][precio = (//produc[cod_zona='%s']/precio)[last()]]/denominacion", codZona,
                codZona);

        // Evaluar la expresión XPath
        NodeList nodeList = (NodeList) xpath.compile(expression).evaluate(doc, XPathConstants.NODESET);

        // Imprimir el resultado con etiquetas
        System.out.println("<" + etiquetaZona + ">");
        for (int i = 0; i < nodeList.getLength(); i++) {
            String denominacion = nodeList.item(i).getTextContent();
            System.out.println("  <producto>" + denominacion + "</producto>");
        }
        System.out.println("</" + etiquetaZona + ">\n");
    }
}
