package Practica4;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Ejercicio5Practica4 {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("empleados.xml");

            // Crear un objeto XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Consulta XPath 5: Obtener los nombres de los empleados etiquetados como
            // DIRECTOR o EMPLE
            String expression5 = "//APELLIDO";
            XPathExpression xpathExpression5 = xpath.compile(expression5);

            // Ejecutar la consulta y obtener los resultados
            NodeList empleados = (NodeList) xpathExpression5.evaluate(document, XPathConstants.NODESET);

            // Imprimir los resultados
            System.out.println("<resultados>");
            for (int i = 0; i < empleados.getLength(); i++) {
                String apellido = empleados.item(i).getTextContent();

                // Verificar si el empleado es director
                boolean esDirector = xpath.evaluate("//EMP_ROW[APELLIDO='" + apellido + "' and OFICIO='DIRECTOR']",
                        document, XPathConstants.NODE) != null;

                // Etiquetar como DIRECTOR o EMPLE
                String etiqueta = esDirector ? "DIRECTOR" : "EMPLE";

                // Imprimir el resultado con la etiqueta correspondiente
                System.out.println("  <" + etiqueta + ">" + apellido + "</" + etiqueta + ">");
            }
            System.out.println("</resultados>");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
