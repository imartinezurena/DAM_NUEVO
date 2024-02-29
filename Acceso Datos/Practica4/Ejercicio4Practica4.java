package Practica4;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.HashMap;
import java.util.Map;

public class Ejercicio4Practica4 {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("empleados.xml");

            // Crear un objeto XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Consulta XPath 3: Obtener el número de empleados y la media de salario
            // redondeada por departamento
            String expression3 = "//DEPT_NO";
            XPathExpression xpathExpression3 = xpath.compile(expression3);

            // Almacenar el número de empleados y la suma de salarios por departamento
            Map<String, Integer> empleadosPorDepartamento = new HashMap<>();
            Map<String, Double> sumaSalariosPorDepartamento = new HashMap<>();

            // Ejecutar la consulta y obtener los resultados
            NodeList departamentos = (NodeList) xpathExpression3.evaluate(document, XPathConstants.NODESET);

            for (int i = 0; i < departamentos.getLength(); i++) {
                String deptNo = departamentos.item(i).getTextContent();

                // Obtener el número de empleados en el departamento
                int numEmpleados = ((Number) xpath.evaluate("count(//EMP_ROW[DEPT_NO='" + deptNo + "'])", document,
                        XPathConstants.NUMBER)).intValue();

                // Obtener la suma de salarios en el departamento
                double sumaSalarios = ((Number) xpath.evaluate("sum(//EMP_ROW[DEPT_NO='" + deptNo + "']/SALARIO)",
                        document, XPathConstants.NUMBER)).doubleValue();

                // Almacenar el número de empleados y la suma de salarios por departamento
                empleadosPorDepartamento.put(deptNo, numEmpleados);
                sumaSalariosPorDepartamento.put(deptNo, sumaSalarios);
            }

            // Imprimir los resultados como XML
            System.out.println("<resultados>");
            for (String deptNo : empleadosPorDepartamento.keySet()) {
                int numEmpleados = empleadosPorDepartamento.get(deptNo);
                double sumaSalarios = sumaSalariosPorDepartamento.get(deptNo);
                double mediaSalarios = sumaSalarios / numEmpleados;

                System.out.println("  <departamento>");
                System.out.println("    <numero>" + deptNo + "</numero>");
                System.out.println("    <numEmpleados>" + numEmpleados + "</numEmpleados>");
                System.out.println("    <mediaSalarios>" + Math.round(mediaSalarios) + "</mediaSalarios>");
                System.out.println("  </departamento>");
            }
            System.out.println("</resultados>");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
