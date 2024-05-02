package TCP;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SocketServeur {
    public static void main(String argv[]) {
        int port = 0;
        Scanner keyb = new Scanner(System.in);

        // Demande à l'utilisateur de saisir le port d'écoute du serveur
        System.out.print("Port d'écoute : ");
        try {
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            // En cas d'erreur de saisie du port
            System.err.println("Le paramètre n'est pas un entier.");
            System.err.println("Usage : java ServeurUDP port-serveur");
            System.exit(-1);
        }

        try {
            // Création d'un serveur socket écoutant sur le port spécifié
            ServerSocket serverSocket = new ServerSocket(port);

            // Accepte la connexion d'un client et crée un socket pour cette connexion
            Socket socket = serverSocket.accept();

            // Crée un flux de sortie pour envoyer des objets au client
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            // Crée un flux d'entrée pour recevoir des objets du client
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            // Lit la chaîne envoyée par le client
            String chaine = (String) input.readObject();
            System.out.println(" recu : " + chaine);

            // Affiche l'adresse IP et le port du client
            System.out.println(" ca vient de : " + socket.getInetAddress() + ":" + socket.getPort());

            // Envoie une réponse au client
            output.writeObject(new String("bien recu"));
        } catch (Exception e) {
            // En cas d'erreur lors de la création du serveur ou de la communication avec le client
            System.err.println("Erreur : " + e);
        }
    }
}
