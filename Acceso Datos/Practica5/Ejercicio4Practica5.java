package Practica5;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.xpath.*;

public class Ejercicio4Practica5 {
    public static void main(String[] args) {
        try {
            // Cargar el XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse("productos.xml");

            // Crear un objeto XPath
            XPath xpath = XPathFactory.newInstance().newXPath();

            // Realizar la consulta para cada categoría
            obtenerDenominacionPorCategoria(xpath, doc, "placa", "Placa Base");
            obtenerDenominacionPorCategoria(xpath, doc, "memoria", "Memoria");
            obtenerDenominacionPorCategoria(xpath, doc, "micro", "Micro");
            obtenerDenominacionPorCategoria(xpath, doc, "otros", "");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void obtenerDenominacionPorCategoria(XPath xpath, Document doc, String etiquetaCategoria,
            String palabraClave) throws XPathExpressionException {
        // Crear la expresión XPath
        String expression = String.format("//produc[contains(denominacion, '%s')]/denominacion", palabraClave);

        // Evaluar la expresión XPath
        NodeList nodeList = (NodeList) xpath.compile(expression).evaluate(doc, XPathConstants.NODESET);

        // Imprimir el resultado con etiquetas
        System.out.println("<" + etiquetaCategoria + ">");
        for (int i = 0; i < nodeList.getLength(); i++) {
            String denominacion = nodeList.item(i).getTextContent();
            System.out.println("  <producto>" + denominacion + "</producto>");
        }
        System.out.println("</" + etiquetaCategoria + ">\n");
    }
}
