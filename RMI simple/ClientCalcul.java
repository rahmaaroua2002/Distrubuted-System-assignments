import java.rmi.*;

public class ClientCalcul {
    public static void main(String[] args) {
        try {
            // Récupération de l'objet RMI du serveur
            Calcul calcul = (Calcul) Naming.lookup("//localhost/Calcul");

            // Boucle pour permettre à l'utilisateur de faire plusieurs calculs
            while (true) {
                System.out.println("Choisissez l'opération :");
                System.out.println("1. Addition");
                System.out.println("2. Soustraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Quitter");

                int choix = Integer.parseInt(System.console().readLine());

                if (choix == 5) {
                    break;
                }

                System.out.print("Entrez le premier nombre : ");
                int a = Integer.parseInt(System.console().readLine());
                System.out.print("Entrez le deuxième nombre : ");
                int b = Integer.parseInt(System.console().readLine());

                int resultat = 0;

                switch (choix) {
                    case 1:
                        resultat = calcul.addition(a, b);
                        break;
                    case 2:
                        resultat = calcul.soustraction(a, b);
                        break;
                    case 3:
                        resultat = calcul.multiplication(a, b);
                        break;
                    case 4:
                        resultat = calcul.division(a, b);
                        break;
                    default:
                        System.out.println("Choix invalide !");
                        continue;
                }

                System.out.println("Résultat : " + resultat);
            }
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}
