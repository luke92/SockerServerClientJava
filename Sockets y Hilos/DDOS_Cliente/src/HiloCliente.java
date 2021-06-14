import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class HiloCliente implements Runnable
{
	
		String ip;
		int puerto;
	// En el constructor recibe y guarda los par�metros que sean necesarios.
	   // En este caso una lista con toda la conversaci�n y el socket que debe
	   // atender.
	
	  public HiloCliente(String ip, int puerto)
	   {
	      this.ip = ip;
	      this.puerto = puerto;
	   }

	   public void run ()
	   {		   
	    	  Socket sock = null;
	    	  try 
	    	  {
				sock = new Socket(ip, puerto);
				System.out.println("Conectado");
				
				sock.close();
	    	  } 
	    	  catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 
	   }
	
	   
	   
}
