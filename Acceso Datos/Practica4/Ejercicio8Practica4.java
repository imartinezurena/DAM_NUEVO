package Practica4;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Ejercicio8Practica4 {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("universidad.xml");

            // Crear un objeto XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Consulta XPath 8: Obtener el nombre de departamento encerrado entre las
            // etiquetas <tipo=A></tipo=A> si es de tipo A, y <tipo=B></tipo=B> si no lo es
            String expression8 = "//departamento";
            XPathExpression xpathExpression8 = xpath.compile(expression8);

            // Ejecutar la consulta y obtener los resultados
            NodeList departamentos = (NodeList) xpathExpression8.evaluate(document, XPathConstants.NODESET);

            // Imprimir los resultados
            System.out.println(
                    "Nombre de departamento encerrado entre las etiquetas <tipo=A></tipo=A> si es de tipo A, y <tipo=B></tipo=B>, si no lo es:");
            for (int i = 0; i < departamentos.getLength(); i++) {
                String tipoDepartamento = xpath.evaluate("@tipo", departamentos.item(i));
                String nombre = xpath.evaluate("nombre", departamentos.item(i));

                // Imprimir el resultado con las etiquetas correspondientes
                System.out.println("<tipo=" + tipoDepartamento + ">" + nombre + "</tipo=" + tipoDepartamento + ">");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
