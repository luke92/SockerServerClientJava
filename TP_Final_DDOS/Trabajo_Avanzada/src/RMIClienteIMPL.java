import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class RMIClienteIMPL extends UnicastRemoteObject implements RMIClienteI {

	Thread hilo;
	
	public RMIClienteIMPL() throws RemoteException {
		super();
		hilo = null;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Attack(String ip) {
		// TODO Auto-generated method stub
		hilo = (new Thread(new Atack(ip,9992))); 
		hilo.start();
		
	}

	@Override
	public void AttackString(String ip, String Mensaje) {
		// TODO Auto-generated method stub
		hilo = (new Thread(new Atack(ip,9992,Mensaje))); 
		hilo.start();
	}

	@Override
	public String Estado() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
}
