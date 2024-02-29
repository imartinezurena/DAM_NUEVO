package Practica6;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.xpath.*;

public class Ejercicio5Practica6 {
    public static void main(String[] args) {
        try {
            // Cargar el documento de universidad.xml
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse("universidad.xml");

            // Crear un objeto XPath
            XPath xpath = XPathFactory.newInstance().newXPath();

            // Obtener nodos de departamento
            NodeList departamentosNodeList = doc.getElementsByTagName("departamento");

            // Iterar sobre los nodos de departamento
            for (int i = 0; i < departamentosNodeList.getLength(); i++) {
                org.w3c.dom.Node departamentoNode = departamentosNodeList.item(i);
                String nombreDepartamento = obtenerValorPorTag(departamentoNode, "nombre");

                // Imprimir el nombre del departamento
                System.out.println("Departamento: " + nombreDepartamento);

                // Obtener nodos de empleado para el departamento actual
                NodeList empleadosNodeList = ((org.w3c.dom.Element) departamentoNode).getElementsByTagName("empleado");

                // Variables para almacenar el salario máximo y el empleado correspondiente
                double salarioMaximo = 0;
                String empleadoSalarioMaximo = "";

                // Iterar sobre los nodos de empleado
                for (int j = 0; j < empleadosNodeList.getLength(); j++) {
                    org.w3c.dom.Node empleadoNode = empleadosNodeList.item(j);
                    double salario = Double.parseDouble(obtenerValorPorTag(empleadoNode, "salario"));

                    // Verificar si el salario actual es el máximo
                    if (salario > salarioMaximo) {
                        salarioMaximo = salario;
                        empleadoSalarioMaximo = obtenerValorPorTag(empleadoNode, "nombre");
                    }
                }

                // Imprimir el salario máximo y el empleado correspondiente
                System.out.println("  Salario Máximo: " + salarioMaximo);
                System.out.println("  Empleado con Salario Máximo: " + empleadoSalarioMaximo);
                System.out.println(); // Separador entre departamentos
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String obtenerValorPorTag(org.w3c.dom.Node node, String tagName) {
        NodeList nodeList = ((org.w3c.dom.Element) node).getElementsByTagName(tagName);
        return nodeList.item(0).getTextContent();
    }
}
