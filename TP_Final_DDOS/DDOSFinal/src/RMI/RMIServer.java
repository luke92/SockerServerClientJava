package RMI;
import java.lang.invoke.MethodHandles.Lookup;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;



public class RMIServer extends UnicastRemoteObject implements RMIServerI {

	private static final RMIClient RMIClienteI = null;
	private static String Mensaje;
	
	
	public static String getMensaje() {
		return Mensaje;
	}
	public static void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}

	static RMIServer serv;
	protected RMIServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param args
	 * @throws RemoteException 
	 * @throws AlreadyBoundException 
	 * @throws NotBoundException 
	 * @throws InterruptedException 
	 * @throws ServerNotActiveException 
	 */
	public static void main(String[] args) throws RemoteException, AlreadyBoundException, NotBoundException, InterruptedException, ServerNotActiveException {
		 System.setProperty("java.security.policy", "file:/C:/workspace/DDOSFinal/java.policy" );
		 
		System.setProperty("java.rmi.server.codebase", "file:/C:/workspace/DDOSFinal/bin/" );
		
		Registry reg = LocateRegistry.createRegistry(1099);
		serv = new RMIServer();
		reg.rebind("ElServidor", serv);
		
	
		Thread.sleep(30000);
		
		
		
	}
	public void imprimir(String s){
		try {
			this.setMensaje("Se conecto el " + serv.getClientHost());
			System.out.println(this.getMensaje());
			
			
		} catch (ServerNotActiveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s);
	}
	
	
	@Override
	public String getDatos() throws RemoteException {
		// TODO Auto-generated method stub
		 return this.getMensaje();
	}
	@Override
	public void imprimirC(String s) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
