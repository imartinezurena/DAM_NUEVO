/*
 * Crea un programa cliente que reciba por parámetro
 * una cadena representando la dirección ip,
 * un número representando el puerto y una última cadena
 * representando el texto a enviar.
 * El programa enviará la información usando UDP.
 */

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ClienteEjer1 {

    public static void main(String[] args) {
        // ClienteEjer1 cliente = new ClienteEjer1(args[0], Integer.valueOf(args[1]),
        // args[2]);
        String direccionIP = args[0];
        String texto = args[1];
        int puerto = Integer.valueOf(args[2]);
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName(direccionIP); // Dirección del servidor
            byte[] sendData = new byte[1024];
            // Mensaje a enviar
            sendData = texto.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, puerto);
            socket.send(sendPacket); // Envía el paquete al servidor
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * public ClienteEjer1(String direccionIP, int puerto, String texto) {
     * this.direccionIP = direccionIP;
     * this.puerto = puerto;
     * this.texto = texto;
     * try {
     * DatagramSocket socket = new DatagramSocket(puerto);
     * } catch (SocketException e) {
     * // TODO Auto-generated catch block
     * e.printStackTrace();
     * }
     * }
     */
}