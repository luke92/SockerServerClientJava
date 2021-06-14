import java.net.Socket;
import java.util.ArrayList;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String opcion = "";
		ArrayList<Socket> sockets = new ArrayList<Socket>();
		(new Thread(new Servidor1(sockets))).start();
		
		while(true)
		{
			System.out.println("iniciar DDOS (1)");
			System.out.println("Estados (2)");
			
			System.out.println("Ingresar opcion: ");
			opcion = Entrada.readLine();
			
			
			switch(opcion)
			{
				case "1": (new Thread(new ServidorAtack(sockets))).start();
					
					break;
			}
		}
		
	}

}
