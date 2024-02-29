package Practica6;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.xpath.*;

public class Ejercicio1Practica6 {
    public static void main(String[] args) {
        try {
            // Cargar el documento de empleados.xml
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document empleadosDoc = dBuilder.parse("empleados.xml");

            // Cargar el documento de departamentos.xml
            Document departamentosDoc = dBuilder.parse("departamentos.xml");

            // Crear un objeto XPath
            XPath xpath = XPathFactory.newInstance().newXPath();

            // Realizar la consulta para cada empleado
            NodeList empleadosNodeList = empleadosDoc.getElementsByTagName("EMP_ROW");
            for (int i = 0; i < empleadosNodeList.getLength(); i++) {
                // Obtener información del empleado
                String apellido = obtenerValorPorTag(empleadosNodeList.item(i), "APELLIDO");
                String deptNo = obtenerValorPorTag(empleadosNodeList.item(i), "DEPT_NO");

                // Realizar la consulta XPath para obtener el nombre del departamento
                String expression = String.format("//DEP_ROW[DEPT_NO='%s']/DNOMBRE", deptNo);
                String nombreDepartamento = (String) xpath.compile(expression).evaluate(departamentosDoc,
                        XPathConstants.STRING);

                // Imprimir el resultado
                System.out.println("Apellido: " + apellido);
                System.out.println("Número de Departamento: " + deptNo);
                System.out.println("Nombre del Departamento: " + nombreDepartamento);
                System.out.println();
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
