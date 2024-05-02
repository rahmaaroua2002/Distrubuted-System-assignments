import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FabReverseInterface extends Remote {
    FabInterface newFab() throws RemoteException;
}
