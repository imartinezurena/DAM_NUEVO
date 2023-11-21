/*Crea un programa que reciba por parámetro un número entero positivo n.
 Este número indicará el número de hijos. 
 Cada hijo generará un fichero con la posibles combinación de caracteres de esa longitud. El hijo 1 una letra, 
el hijo 2 dos letras 'aa' a la 'zz', etc. Los nombres serán datos1.txt, datos2.txt, etc.*/
package unidad01.entrenamientoC;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GenerarDatos {
    public static final char[] LETRAS = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    public static void main(String[] args) {
        int numeroDatos = Integer.parseInt(args[0]);
        for (int i = 0; i < numeroDatos; i++) {
            String n_archivo = "datos" + i + ".txt";
            String[] commands = {
                    "echo",
                    ">",
                    n_archivo };

            ProcessBuilder pb = new ProcessBuilder(commands);
            try {
                Process proceso = pb.start();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(n_archivo)) {

            }) {
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}