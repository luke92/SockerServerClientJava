
import java.rmi.*;

public interface RMIServerI extends Remote {
	public void registrarCliente(RMIClienteI cli) throws RemoteException  ;
	public void registrarLog (String ipVictima, String tipoAtaque, String strArbitrario) throws RemoteException;
	
	

}
 