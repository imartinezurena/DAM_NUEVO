package unidad01.entrenamientoC;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Ejer11IpWin {
    public static void main(String[] args) throws IOException {
        try {
            String[] commands = {
                    "ipconfig",
                    "/all"
            };
            // creating the process
            ProcessBuilder pb = new ProcessBuilder(commands);
            Process process;
            process = pb.start();
            // for reading the output from stream
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
