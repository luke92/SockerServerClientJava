import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class ServidorAtack implements Runnable {
	private ServerSocket ss = null;
	private int i=0;
	DataOutputStream salida;	
	public ArrayList<Socket> logSockets;
	
	public ServidorAtack(ArrayList<Socket> sockets)
	{
		logSockets = sockets;
	}
	
	@Override
	public void run() 
	{	
					
		for (Socket socket : logSockets) 
		{
			System.out.println(socket.toString());
			try 
			{
				salida = new DataOutputStream(socket.getOutputStream());
				salida.writeUTF("ataque");
				salida.flush();
			} 
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
				
				
				
			
		 
		
		
	}
}
