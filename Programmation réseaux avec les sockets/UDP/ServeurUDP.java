package UDP;

import java.io.*;
import java.net.*;
import java.util.Date;

public class ServeurUDP {

    private static final int PORT = 1250;

    public static void main(String[] args) throws IOException {
        // Création d'un socket UDP
        DatagramSocket socket = new DatagramSocket(PORT);

        // Boucle d'écoute des datagrammes
        while (true) {
            // Réception d'un datagramme
            byte[] data = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
            socket.receive(datagramPacket);

            // Conversion de la date et l'heure en chaîne de caractères
            String dateHeure = new Date().toString();

            // Envoi d'un datagramme de réponse avec la date et l'heure
            byte[] response = dateHeure.getBytes();
            DatagramPacket responsePacket = new DatagramPacket(response, response.length, datagramPacket.getAddress(), datagramPacket.getPort());
            socket.send(responsePacket);
        }

        // Fermeture du socket
        socket.close();
    }
}