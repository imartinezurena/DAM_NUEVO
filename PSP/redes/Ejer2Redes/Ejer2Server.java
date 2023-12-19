//El cliente envía información, y espera una respuesta en el mismo puerto.

package redes.Ejer2Redes;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Ejer2Server {
    public static void main(String[] args) {
        InetAddress direccion;
        try {
            DatagramSocket socket = new DatagramSocket(9879); // Abre el socket en el puerto 9877
            byte[] receivedData = new byte[1024];

            while (true) {
                DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
                socket.receive(receivedPacket); // Espera y recibe el paquete
                direccion = receivedPacket.getAddress();
                // Extrae la información del paquete
                String message = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
                socket.send(receivedPacket);// como no cambia se puede usar el mismo packet
                System.out.println("Mensaje recibido: " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
