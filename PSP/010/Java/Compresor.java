import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Compresor {

    public static void main(String[] args) {
        int i = 0;
        try {
            while (i < args.length) {

                String directorio = args[i];
                String nombre = directorio.replace("/", "_");
                LocalDate fecha=LocalDate.now();
                nombre=nombre+"_"+fecha.getYear()+"_"+fecha.getMonth()+"_"+fecha.getDayOfMonth();
                String[] comando = { "tar", "cvfz", nombre, directorio };
                ProcessBuilder pb = new ProcessBuilder(comando);
                Process comprimir = pb.start();
                i++;
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}