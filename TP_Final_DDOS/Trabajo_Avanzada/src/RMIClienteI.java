
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface RMIClienteI extends Remote {
	
	void Attack (String ip)throws RemoteException ;
	void AttackString (String ip , String Mensaje) throws RemoteException ;
	String  Estado () throws RemoteException ;

}