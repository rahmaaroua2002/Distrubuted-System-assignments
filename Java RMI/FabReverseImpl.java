import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FabReverseImpl extends UnicastRemoteObject implements FabReverseInterface {
    public FabReverseImpl() throws RemoteException {
        super();
    }

    public FabInterface newFab() throws RemoteException {
        return new FabImpl();
    }
}
