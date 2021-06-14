import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClientTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Socket sock = null;
		try {
			sock = new Socket("192.168.2.81", 5555);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Conectado");
		
		DataInputStream entrada = new DataInputStream(sock.getInputStream());
		String s = entrada.readUTF();
		System.out.println(s);
		if ( s.compareTo("ataque") == 0)
		{
			while(true)
			(new Thread(new HiloCliente("192.168.2.81",9992))).start();
		}

	}

}
