package TpAnterior;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Servidor1 implements Runnable 
{
	private ServerSocket ss = null;
	private Socket s = null;
	private int i=0;
	public ArrayList<Socket> logSockets;
	
	
	
	public Servidor1(ArrayList<Socket> sockets)
	
	{
		logSockets = sockets;
	}
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		
		try 
		{
			ss=new ServerSocket(5555);
			System.out.println("Esperando una conexión:");
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(true)
		{	
				try 
				{
					s=ss.accept();
					i += 1;
					logSockets.add(s);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
		}
	}
}
	
