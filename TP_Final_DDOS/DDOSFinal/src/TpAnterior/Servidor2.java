package TpAnterior;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Servidor2
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ServerSocket ss = null;
		Socket s = null;
		int i=0;
		try 
		{
			ss=new ServerSocket(9992);
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
					System.out.println("BIEN WACHO TE CONECTASTE!!!!");
					i += 1;
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
		}
	}
	
}
	