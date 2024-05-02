package TCP;

import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        // Définition du port à utiliser
        int port = 10000;

        // Partie Serveur
        try {
            // Création d'un serveur socket écoutant sur le port spécifié
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Serveur en attente sur le port " + port + "...");

            // Attente de la connexion d'un client
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connecté : " + clientSocket.getInetAddress().getHostName());

            // Flux de sortie vers le client
            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);

            // Envoi d'un message au client
            writer.println("Bonjour, client !");

            // Fermeture des flux et du socket
            writer.close();
            outputStream.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Partie Client
        try {
            // Connexion au serveur sur la machine locale (localhost) et sur le port spécifié
            Socket socket = new Socket("localhost", port);

            // Flux d'entrée depuis le serveur
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Lecture du message envoyé par le serveur
            String message = reader.readLine();
            System.out.println("Message du serveur : " + message);

            // Fermeture des flux et du socket
            reader.close();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
