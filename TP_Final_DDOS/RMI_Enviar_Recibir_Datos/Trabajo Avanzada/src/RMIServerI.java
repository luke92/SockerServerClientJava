
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface RMIServerI extends Remote {
	void imprimir(String s) throws RemoteException;
	void imprimirC(String s) throws RemoteException;
	String getDatos() throws RemoteException;
	

}
 