import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class ServeurCalcul extends UnicastRemoteObject implements Calcul {
    public ServeurCalcul() throws RemoteException {
        super();
    }

    public int addition(int a, int b) throws RemoteException {
        return a + b;
    }

    public int soustraction(int a, int b) throws RemoteException {
        return a - b;
    }

    public int multiplication(int a, int b) throws RemoteException {
        return a * b;
    }

    public int division(int a, int b) throws RemoteException {
        if (b != 0) {
            return a / b;
        } else {
            throw new RemoteException("Division par zéro !");
        }
    }

    public static void main(String[] args) {
        try {
            // Création de l'objet serveur
            ServeurCalcul serveur = new ServeurCalcul();

            // Enregistrement de l'objet serveur dans le registre RMI
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Calcul", serveur);

            System.out.println("Serveur RMI prêt.");
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}
