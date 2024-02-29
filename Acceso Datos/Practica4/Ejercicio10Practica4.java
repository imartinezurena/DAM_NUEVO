package Practica4;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Ejercicio10Practica4 {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("universidad.xml");

            // Crear un objeto XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Consulta XPath 10: Obtener nombres de departamentos, empleados y media del
            // salario
            String expression10 = "//departamento";
            XPathExpression xpathExpression10 = xpath.compile(expression10);

            // Ejecutar la consulta y obtener los resultados
            NodeList departamentos = (NodeList) xpathExpression10.evaluate(document, XPathConstants.NODESET);

            // Imprimir los resultados
            System.out
                    .println("Nombres de departamentos, empleados que tiene cada departamento y la media del salario:");
            for (int i = 0; i < departamentos.getLength(); i++) {
                String nombreDepartamento = xpath.evaluate("nombre", departamentos.item(i));
                System.out.println("<departamento>");
                System.out.println("  <nombre>" + nombreDepartamento + "</nombre>");

                // Consulta XPath para obtener empleados y salarios de cada departamento
                String expressionEmpleados = "empleado";
                XPathExpression xpathExpressionEmpleados = xpath.compile(expressionEmpleados);

                // Ejecutar la consulta y obtener los empleados y salarios
                NodeList empleados = (NodeList) xpathExpressionEmpleados.evaluate(departamentos.item(i),
                        XPathConstants.NODESET);

                // Imprimir los nombres de los empleados y calcular la media del salario
                double sumaSalarios = 0;
                for (int j = 0; j < empleados.getLength(); j++) {
                    String nombreEmpleado = xpath.evaluate("nombre", empleados.item(j));
                    String salario = xpath.evaluate("@salario", empleados.item(j));
                    System.out.println("  <empleado>");
                    System.out.println("    <nombre>" + nombreEmpleado + "</nombre>");
                    System.out.println("    <salario>" + salario + "</salario>");
                    System.out.println("  </empleado>");

                    sumaSalarios += Double.parseDouble(salario);
                }

                // Calcular la media del salario y mostrarla
                double mediaSalarios = sumaSalarios / empleados.getLength();
                System.out.println("  <mediaSalarios>" + mediaSalarios + "</mediaSalarios>");

                System.out.println("</departamento>");
                System.out.println(); // Separador entre departamentos
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
