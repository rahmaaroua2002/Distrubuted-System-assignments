import java.rmi.*;
import java.rmi.registry.*;

public class ReverseClient {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Utilisation : java ReverseClient ch1 ch2");
            System.exit(0);
        }
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1099);
            FabReverseInterface fabrique = (FabReverseInterface) reg.lookup("Fabrique");
            FabInterface fab = fabrique.newFab();
            ReverseInterface reverseObj1 = fab.newReverse();
            ReverseInterface reverseObj2 = fab.newReverse();
            String result1 = reverseObj1.reverseString(args[0]);
            System.out.println("L'inverse de " + args[0] + " est " + result1);
            String result2 = reverseObj2.reverseString(args[1]);
            System.out.println("L'inverse de " + args[1] + " est " + result2);
        } catch (Exception e) {
            System.out.println("Erreur d'accès à l'objet distant.");
            System.out.println(e.toString());
        }
    }
}
