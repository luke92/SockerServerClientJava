import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;


public class RMIServer2 extends UnicastRemoteObject {
	
	private static final RMIClient RMIClienteI = null;
	private static String Mensaje;
	
	static RMIServer serv ;
	

	public static String getMensaje() {
		return Mensaje;
	}
	public static void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}
	protected RMIServer2() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
 
	
	
public static void main(String[] args) throws RemoteException, AlreadyBoundException, NotBoundException, InterruptedException, ServerNotActiveException {
	
		
		
		
		
		
		Registry reg = LocateRegistry.createRegistry(5556);
		serv = new RMIServer();
		reg.rebind("Tomas2", serv);
		
	
		Thread.sleep(30000);
	}

}
