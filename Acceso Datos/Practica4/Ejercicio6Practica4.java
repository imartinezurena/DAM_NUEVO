package Practica4;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Ejercicio6Practica4 {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("empleados.xml");

            // Crear un objeto XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Consulta XPath 6: Obtener el nombre y el oficio concatenado entre las
            // etiquetas <APE_OFI></APE_OFI>
            String expression6 = "//EMP_ROW";
            XPathExpression xpathExpression6 = xpath.compile(expression6);

            // Ejecutar la consulta y obtener los resultados
            NodeList empleados = (NodeList) xpathExpression6.evaluate(document, XPathConstants.NODESET);

            // Imprimir los resultados
            System.out.println("<resultados>");
            for (int i = 0; i < empleados.getLength(); i++) {
                String apellido = xpath.evaluate("APELLIDO", empleados.item(i));
                String oficio = xpath.evaluate("OFICIO", empleados.item(i));

                // Concatenar nombre y oficio entre las etiquetas <APE_OFI></APE_OFI>
                String concatenado = apellido + " " + oficio;

                // Imprimir el resultado entre las etiquetas correspondientes
                System.out.println("  <APE_OFI>" + concatenado + "</APE_OFI>");
            }
            System.out.println("</resultados>");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
