import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FabInterface extends Remote {
    ReverseInterface newReverse() throws RemoteException;
}
