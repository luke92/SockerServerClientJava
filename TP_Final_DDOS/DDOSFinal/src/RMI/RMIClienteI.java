package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface RMIClienteI extends Remote {
	
	void imprimirC(String s) throws RemoteException;

}