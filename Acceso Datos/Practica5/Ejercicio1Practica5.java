package Practica5;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Ejercicio1Practica5 {
    public static void main(String[] args) {
        try {
            // Cargar el XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse("productos.xml");

            // Normalizar el documento
            doc.getDocumentElement().normalize();

            // Obtener la lista de nodos 'produc'
            NodeList nodeList = doc.getElementsByTagName("produc");

            // Crear un mapa para almacenar el recuento por zona
            // La clave es el código de zona y el valor es el recuento de productos
            java.util.Map<String, Integer> countByZona = new java.util.HashMap<>();

            // Iterar sobre los nodos 'produc'
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Element producElement = (Element) nodeList.item(temp);
                String codZona = producElement.getElementsByTagName("cod_zona").item(0).getTextContent();

                // Actualizar el recuento para la zona actual
                countByZona.put(codZona, countByZona.getOrDefault(codZona, 0) + 1);
            }

            // Imprimir el resultado
            System.out.println("Número de productos por zona:");
            for (String codZona : countByZona.keySet()) {
                int count = countByZona.get(codZona);
                System.out.println("Zona " + codZona + ": " + count + " productos");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
