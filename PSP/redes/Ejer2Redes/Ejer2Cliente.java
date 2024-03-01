/*crea un programa que mande algo al servidor y lo reciba de vuelta */

package redes.Ejer2Redes;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Ejer2Cliente {
    public static void main(String[] args) {

        String direccionIP = args[0];
        String texto = args[1];
        int puerto = Integer.valueOf(args[2]);
        // recibe los 3 valores por parametro
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName(direccionIP); // Dirección del servidor
            byte[] sendData = new byte[1024];
            // Mensaje a enviar
            sendData = texto.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, puerto);
            socket.send(sendPacket); // Envía el paquete al servidor
            socket.receive(sendPacket);// lo recibe en el mismo paquete porque es lo mismo
            String message = new String(sendPacket.getData(), 0, sendPacket.getLength());
            System.out.println(message + "llego bien");
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
