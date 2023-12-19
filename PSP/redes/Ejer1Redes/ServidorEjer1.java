//Crea un programa servidor que reciba por parámetro
//un número que representa el puerto en el que escuchará,
//cuando reciba un mensaje lo escribirá por pantalla.

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;

public class ServidorEjer1 {
    // poner e ip como inet adress y ejecutar cliente con esa
    public static void main(String[] args) {
        InetAddress direccion;
        try {
            DatagramSocket socket = new DatagramSocket(9877); // Abre el socket en el puerto 9877
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