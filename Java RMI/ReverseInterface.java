import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ReverseInterface extends Remote {
    String reverseString(String input) throws RemoteException;
}
