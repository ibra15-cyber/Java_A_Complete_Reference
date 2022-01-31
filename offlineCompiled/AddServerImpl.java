import java.rmi.*;
import java.rmi.server.*;

public class AddServerImp extends UnicastRemoteObject implements AddServerIntf{
	public AddServerImp() throws RemoteException{
	}
	public double add(double d1, double d2) throws RemoteException{
		return d1 + d2;
	}
}