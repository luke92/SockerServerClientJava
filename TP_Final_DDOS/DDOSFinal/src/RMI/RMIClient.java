package RMI;


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
		 System.setProperty("java.security.policy", "file:/C:/workspace/DDOSFinal/java.policy" );

		if (System.getSecurityManager() == null) { 
			System.setSecurityManager(new SecurityManager()); 
		} 

		Registry reg = LocateRegistry.getRegistry("localhost", 1099);
		RMIServerI server = (RMIServerI) reg.lookup("ElServidor"); 
		server.imprimir("Hola soy el cliente Como te va");
		for (Integer i = 0 ; i<10; i++){
			server.imprimir("Prueba " + i.toString());
			Thread.sleep(1000);
		}
		
		System.out.println(server.getDatos());

	}
	

}
