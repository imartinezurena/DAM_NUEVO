package redes;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * ServerRespuesta
 */
public class ServerRespuesta {

    public static void main(String[] args) {
        InetAddress direccion;
        try {
            DatagramSocket socket = new DatagramSocket(9876); // Abre el socket en el puerto 9876
            byte[] receivedData = new byte[1024];

            while (true) {
                DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
                socket.receive(receivedPacket); // Espera y recibe el paquete
                direccion = receivedPacket.getAddress();
                // Extrae la información del paquete
                String message = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
                System.out.println("Mensaje recibido: " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}