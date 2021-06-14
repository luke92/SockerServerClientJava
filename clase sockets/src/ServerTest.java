import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerTest {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ServerSocket server= null;
		try {
			 server = new ServerSocket(5555);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}
		Socket sock = server.accept();
		System.out.println("Conectado");
		PrintWriter writer = null; 
		try {
			writer = new PrintWriter(sock.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error");

			e.printStackTrace();
		}
		for (Integer i = 0; i<10; i++){
			writer.write("Holaaaaaaaaaaaaaaa\n\r");
			writer.write(i.toString());
			writer.flush();
			Thread.sleep(1000);
		}
		System.out.println("Fin");
		writer.flush();
	}
	

}
