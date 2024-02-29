package Practica6;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.xpath.*;

public class Ejercicio3Practica6 {
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

            // Realizar la consulta para cada departamento
            NodeList departamentosNodeList = departamentosDoc.getElementsByTagName("DEP_ROW");
            for (int i = 0; i < departamentosNodeList.getLength(); i++) {
                // Obtener información del departamento
                String deptNo = obtenerValorPorTag(departamentosNodeList.item(i), "DEPT_NO");
                String nombreDepartamento = obtenerValorPorTag(departamentosNodeList.item(i), "DNOMBRE");

                // Realizar la consulta XPath para obtener el empleado que más gana en el
                // departamento
                String expression = String.format(
                        "//EMP_ROW[DEPT_NO='%s'][SALARIO = (//EMP_ROW[DEPT_NO='%s']/SALARIO)[last()]]/APELLIDO", deptNo,
                        deptNo);
                String empleadoMasGanador = (String) xpath.compile(expression).evaluate(empleadosDoc,
                        XPathConstants.STRING);

                // Imprimir el resultado
                System.out.println("Departamento: " + nombreDepartamento);
                System.out.println("Empleado que más gana: " + empleadoMasGanador);
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
