
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClientChat implements Runnable {
    private final String clave = "ñ";
    private static int PORT = 9876;
    private static boolean ESCRITOR = true;
    private static boolean LECTOR = false;
    private static final int MAX_LENGTH = 65535;
    private static Object lock;
    private boolean modo;
    private String ipServer;
    private String usuario;
    private DatagramSocket socket;

    public UDPClientChat(boolean modo, String ip, String usuario) {
        if (lock == null) {
            lock = new Object();
        }
        this.modo = modo;
        this.ipServer = ip;
        this.usuario = usuario;
        try {
            DatagramSocket socket = new DatagramSocket(PORT);
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                String ipServer = args[0];
                Thread th1 = new Thread(new UDPClientChat(LECTOR, ipServer, ""));
                System.out.println("Escriba su nombre de usuario:");
                String usuario = "";
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                usuario = bufferedReader.readLine();
                Thread th2 = new Thread(new UDPClientChat(ESCRITOR, ipServer, usuario));
                th1.start();
                th2.start();
                th2.join();
                th1.interrupt();
            } catch (Exception e) {
                System.err.println("Peto todo");
            }

        }
    }

    @Override
    public void run() {
        while (true) {
            if (modo) {// Soy el que escribe en pantalla
                if (mandar()) {
                    break;
                }
            } else {// soy el que muetsra en pantalla
                recibir();
            }
        }
    }

    private void recibir() {
        try {
            byte[] receivedData = new byte[MAX_LENGTH];
            DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
            socket.receive(receivedPacket); // Espera y recibe el paquete
            String mensaje = new String(receivedData, 0, receivedData.length);
            synchronized (lock) {
                if (mensaje.equals(clave)) {
                    while (socket.isConnected()) {
                        socket.receive(receivedPacket); // Espera y recibe el paquete
                        mensaje = new String(receivedData, 0, receivedData.length);
                        System.out.println(mensaje);
                    }
                } else {
                    System.out.println(mensaje);
                }

            }
            socket.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // Abre el socket en el puerto 9876

    }

    private boolean mandar() {
        boolean res = false;
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress ipAddress = InetAddress.getByName(ipServer); // Dirección del servidor
            byte[] sendData = new byte[MAX_LENGTH];
            synchronized (lock) {
                String sentence = pedirFrase(); // Mensaje a enviar
                if (sentence.equals("q")) {
                    res = true;
                } else {
                    sentence = usuario + ": " + sentence;
                    sendData = sentence.getBytes();
                }
            }
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, 9876);
            socket.send(sendPacket); // Envía el paquete al servidor
            socket.close();
            Thread.sleep(1111);
        } catch (Exception e) {
        }
        return res;
    }

    private String pedirFrase() throws IOException {
        String res = "";
        System.out.println("Escriba su mensaje, escriba solo 'q' para salir");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        res = bufferedReader.readLine();
        return res;
    }
}