package unidad01.entrenamientoC.ejercicio3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

public class EscribirDatos {
    public static final char[] LETRAS = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    public static void main(String[] args) {
        int longitud_combinacion = Integer.parseInt(args[0]);
        String n_archivo = "datos" + longitud_combinacion + ".txt";
        ArrayList<String> listaCombinaciones = new ArrayList<>();
        int contador = 1;
        while (contador <= longitud_combinacion) {
            rellenarLista(listaCombinaciones);
            contador++;
        }
        listaCombinaciones.sort((arg0, arg1) -> arg0.compareTo(arg1));
        FileWriter escritor = null;
        try {
            escritor = new FileWriter(n_archivo);
            for (String combinacion : listaCombinaciones) {
                escritor.append(combinacion + "\n");
                // System.out.println(combinacion);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        if (escritor != null) {
            try {
                escritor.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private static void rellenarLista(ArrayList<String> listaCombinaciones) {
        if (listaCombinaciones.isEmpty()) {
            for (int i = 0; i < LETRAS.length; i++) {
                listaCombinaciones.add("" + LETRAS[i]);
            }
        } else {
            ArrayList<String> intermedia = new ArrayList<>(listaCombinaciones);
            for (String combinacion : intermedia) {
                listaCombinaciones.remove(combinacion);
                for (int i = 0; i < LETRAS.length; i++) {
                    listaCombinaciones.add(combinacion + LETRAS[i]);
                }
            }
        }
    }
}
/*
 * /usr/bin/env /usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp
 * /home/goku/.config/Code/User/workspaceStorage/
 * be7bcf7b356e255848cdffb53811f9da/redhat.java/jdt_ws/PSP_62cdc44a/bin
 * unidad01.entrenamientoC.ejercicio3.EscribirDatos
 */
