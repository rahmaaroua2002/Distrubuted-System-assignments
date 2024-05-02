package TCP;

import java.io.*;
import java.net.*;
import java.util.Scanner;

class SocketClient {
    public static void main(String argv[]) {
        int port = 0;
        String host = "";
        Scanner keyb = new Scanner(System.in);

        // Demande à l'utilisateur de saisir l'adresse IP du serveur
        System.out.print("Nom du serveur : ");
        host = keyb.next();

        // Demande à l'utilisateur de saisir le port du serveur
        System.out.print("Port du serveur : ");
        try {
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            // En cas d'erreur de saisie du port
            System.err.println("Le second paramètre n'est pas un entier.");
            System.exit(-1);
        }

        try {
            // Résolution du nom d'hôte en adresse IP
            InetAddress adr = InetAddress.getByName(host);

            // Création d'un socket client pour se connecter au serveur spécifié
            Socket socket = new Socket(adr, port);

            // Création d'un flux de sortie pour envoyer des objets au serveur
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            // Création d'un flux d'entrée pour recevoir des objets du serveur
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            // Envoie une chaîne au serveur
            output.writeObject(new String("ma première socket"));

            // Lit la réponse du serveur
            String chaine = (String) input.readObject();
            System.out.println(" recu du serveur : " + chaine);
        } catch (Exception e) {
            // En cas d'erreur lors de la connexion au serveur ou de la communication avec celui-ci
            System.err.println("Erreur : " + e);
        }
    }
}
