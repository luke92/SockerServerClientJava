import java.io.BufferedReader;
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
			sock = new Socket("localhost", 5555);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Conectado");
		BufferedReader in = new BufferedReader(new InputStreamReader( sock.getInputStream()));
		PrintWriter out = new PrintWriter(sock.getOutputStream());
		out.flush();
		String s = "";
		while((s =  in.readLine() )!= null){
			System.out.println(s);
		}

	}

}
