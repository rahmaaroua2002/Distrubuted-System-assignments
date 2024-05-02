import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.rmi.server.RMIClassLoader;
import java.util.Properties;

public class DynamicReverseClient {
    public static void main(String[] args) {
        try {
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new RMISecurityManager());
            }

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Properties p = System.getProperties();
            String url = p.getProperty("java.rmi.server.codebase");

            Class<?> ClasseClient = RMIClassLoader.loadClass(url, "ReverseImpl");
            ReverseInterface reverse = (ReverseInterface) ClasseClient.newInstance();

            String input = "Hello";
            String result = reverse.reverseString(input);
            System.out.println("Reverse of " + input + " is " + result);
        } catch (Exception e) {
            System.err.println("Error: " + e.toString());
        }
    }
}