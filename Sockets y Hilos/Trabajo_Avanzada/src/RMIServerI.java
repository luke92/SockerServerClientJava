
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface RMIServerI extends Remote {
	void imprimir(String s) throws RemoteException;
	public AccionCliente getOrden() throws RemoteException;
	String getDatos() throws RemoteException;
	

}
 