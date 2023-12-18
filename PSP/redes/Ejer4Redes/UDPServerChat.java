
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class UDPServerChat {
    private static final int MAX_LENGTH = 65535;
    private static final int PORT = 9876;
    private static String ARCHIVO = "./chat.log";
    private static boolean inicio = false;

    public static void main(String[] args) {
        FileWriter fWriter = null;
        ArrayList<InetAddress> usuarios = new ArrayList<>();
        try {
            byte[] receivedData = new byte[MAX_LENGTH];
            byte[] sendData = new byte[MAX_LENGTH];
            InetAddress usuario;
            while (true) {
                DatagramSocket socket = new DatagramSocket(PORT); // Abre el socket en el puerto 9876
                DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
                System.out.println("me bloqueo");
                socket.receive(receivedPacket); // Espera y recibe el paquete
                System.out.println("me desbloqueo");
                // Extrae la información del paquete
                usuario = receivedPacket.getAddress();
                addUser(usuarios, usuario);
                String message = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
                sendData = message.getBytes();
                mandar(usuarios, usuario, message, sendData, socket);
                fWriter = new FileWriter(new File(ARCHIVO), true);
                fWriter.write("El usuario " + " ha escrito " + message + "\n");
                fWriter.close();
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addUser(ArrayList<InetAddress> lista, InetAddress usuario) {
        if (!lista.contains(usuario)) {
            lista.add(usuario);
            inicio = true;
        }
    }

    private static void mandar(ArrayList<InetAddress> lista, InetAddress usuarioQueEnvia, String mensaje, byte[] datos,
            DatagramSocket socket)
            throws IOException {
        Iterator it = lista.iterator();
        if (inicio) {
            inicio = false;
            File archivo = new File(ARCHIVO);
            try (BufferedReader bFArchivo = new BufferedReader(new FileReader(archivo))) {
                String line = "";
                while ((line = bFArchivo.readLine()) != null) {
                    datos = line.getBytes();
                    DatagramPacket senDatagramPacket = new DatagramPacket(datos, datos.length, usuarioQueEnvia, PORT);
                    socket.send(senDatagramPacket);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        while (it.hasNext()) {
            socket = new DatagramSocket();
            InetAddress usuarioAEnviar = (InetAddress) it.next();
            DatagramPacket senDatagramPacket = new DatagramPacket(datos, datos.length, usuarioAEnviar, PORT);
            socket.send(senDatagramPacket);
            socket.close();

        }
    }
}