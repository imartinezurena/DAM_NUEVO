
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class Ejercicio1Practica2 {

    public static void main(String[] args) {
        try {
            // Crear un documento DOM a partir del archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("productos.xml"); // Reemplaza con la ruta de tu archivo XML

            // Crear un XPath expression para obtener los nodos de denominación y precio de
            // todos los productos
            String xpathExpresion = "//produc/*[self::denominacion or self::precio]";

            // Ejecutar la consulta XPath
            NodeList nodeList = (NodeList) javax.xml.xpath.XPathFactory.newInstance()
                    .newXPath().compile(xpathExpresion)
                    .evaluate(document, javax.xml.xpath.XPathConstants.NODESET);

            // Iterar sobre los resultados y mostrar la denominación y el precio
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                String nodeName = node.getNodeName();
                String nodeValue = node.getTextContent();
                System.out.println(nodeName + ": " + nodeValue);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
