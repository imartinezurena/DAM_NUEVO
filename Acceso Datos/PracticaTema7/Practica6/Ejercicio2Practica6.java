package Practica6;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.xpath.*;
import java.util.HashMap;
import java.util.Map;

public class Ejercicio2Practica6 {
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

            // Crear un mapa para almacenar la información por departamento
            Map<String, DepartamentoInfo> departamentoInfoMap = new HashMap<>();

            // Obtener información por cada empleado
            NodeList empleadosNodeList = empleadosDoc.getElementsByTagName("EMP_ROW");
            for (int i = 0; i < empleadosNodeList.getLength(); i++) {
                // Obtener información del empleado
                String deptNo = obtenerValorPorTag(empleadosNodeList.item(i), "DEPT_NO");
                double salario = Double.parseDouble(obtenerValorPorTag(empleadosNodeList.item(i), "SALARIO"));

                // Actualizar la información del departamento
                if (!departamentoInfoMap.containsKey(deptNo)) {
                    String nombreDepartamento = obtenerNombreDepartamento(xpath, departamentosDoc, deptNo);
                    departamentoInfoMap.put(deptNo, new DepartamentoInfo(nombreDepartamento));
                }
                departamentoInfoMap.get(deptNo).agregarSalario(salario);
                departamentoInfoMap.get(deptNo).incrementarNumEmpleados();
            }

            // Imprimir la información por cada departamento
            System.out.println("Estadísticas por Departamento:");
            for (String deptNo : departamentoInfoMap.keySet()) {
                DepartamentoInfo departamentoInfo = departamentoInfoMap.get(deptNo);
                System.out.println("Departamento: " + departamentoInfo.getNombreDepartamento());
                System.out.println("Número de Empleados: " + departamentoInfo.getNumEmpleados());
                System.out.println("Media del Salario: " + departamentoInfo.getMediaSalario());
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

    private static String obtenerNombreDepartamento(XPath xpath, Document doc, String deptNo)
            throws XPathExpressionException {
        String expression = String.format("//DEP_ROW[DEPT_NO='%s']/DNOMBRE", deptNo);
        return (String) xpath.compile(expression).evaluate(doc, XPathConstants.STRING);
    }
}

class DepartamentoInfo {
    private String nombreDepartamento;
    private int numEmpleados;
    private double totalSalario;

    public DepartamentoInfo(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
        this.numEmpleados = 0;
        this.totalSalario = 0;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public int getNumEmpleados() {
        return numEmpleados;
    }

    public double getMediaSalario() {
        return numEmpleados > 0 ? totalSalario / numEmpleados : 0;
    }

    public void incrementarNumEmpleados() {
        numEmpleados++;
    }

    public void agregarSalario(double salario) {
        totalSalario += salario;
    }
}
