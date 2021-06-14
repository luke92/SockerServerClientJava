import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Sesion extends Thread{
	
	private ArrayList<Socket> socketList;
	private ServerSocket serverSocket;
	public Sesion(ArrayList<Socket> sockets, ServerSocket sSocket)
	{
		socketList = sockets;
		serverSocket = sSocket;
	}
	
	public void run()
	{
		while(true){
			try{
				Socket socket = serverSocket.accept();
				socketList.add(socket);
				Logger.LogAccionServidor("Cliente conectado");
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
}
