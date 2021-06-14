import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class AttackThread extends Thread {
	private String ip;
	private String[] puertos;
	private String stringArbitrario;
	private Estado estado;
	private Socket socketAttack;

	public AttackThread(String ipParameter, String[] puertosParameter,
			Estado estadoParameter) throws IOException, InterruptedException {
		ip = ipParameter;
		puertos = puertosParameter;
		estado = estadoParameter;
	}

	public AttackThread(String ipParameter, String[] puertosParameter,
			Estado estadoParameter, String stringArbitrarioParameter)
			throws InterruptedException, IOException {
		ip = ipParameter;
		puertos = puertosParameter;
		stringArbitrario = stringArbitrarioParameter;
		estado = estadoParameter;
	}

	private void IniciarAtaque() throws IOException, InterruptedException {
		int y = 0;
		String puertosAsString = "";
		for (y = 0; y < puertos.length; y++) {
			puertosAsString = puertosAsString + puertos[y] + ", ";
		}

		while (true) {
			for (int x = 0; x < puertos.length; x++) {
				Thread.sleep(2000);
				socketAttack = new Socket(ip, Integer.parseInt(puertos[x]));

				ArrayList<Puerto> puertoList = estado.getPuertos();
				Puerto puerto = puertoList.get(x);
				puerto.setContadorIntentos(puerto.getContadorIntentos() + 1);
				puertoList.set(x, puerto);
				estado.setPuertos(puertoList);
				Logger.LogAccionCliente("Ataque de conexion a IP: "
						+ ip.toString() + ", Puertos: " + puertosAsString);
				socketAttack.close();
			}
		}
	}

	private void IniciarAtaqueStringArbitrario() throws InterruptedException,
			IOException {
		int y = 0;
		String puertosAsString = "";
		for (y = 0; y < puertos.length; y++) {
			puertosAsString = puertosAsString + puertos[y] + ", ";
		}

		while (true) {
			for (int x = 0; x < puertos.length; x++) {
				Thread.sleep(2000);
				socketAttack = new Socket(ip, Integer.parseInt(puertos[x]));

				DataOutputStream dos = new DataOutputStream(
						socketAttack.getOutputStream());
				dos.writeUTF(stringArbitrario);

				ArrayList<Puerto> puertoList = estado.getPuertos();
				Puerto puerto = puertoList.get(x);
				puerto.setContadorIntentos(puerto.getContadorIntentos() + 1);
				puertoList.set(x, puerto);
				estado.setPuertos(puertoList);
				Logger.LogAccionCliente("Ataque de String Arbitrario a IP: "
						+ ip.toString() + ", Puertos: " + puertosAsString
						+ ", String arbitrario: " + stringArbitrario);

				DataInputStream dis = new DataInputStream(
						socketAttack.getInputStream());
				System.out.println(dis.readUTF());
				socketAttack.close();
			}
		}
	}

	public void run() {
		try {
			IniciarAtaque();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Socket getSocketAttack() {
		return socketAttack;
	}

	public void setSocketAttack(Socket socketAttack) {
		this.socketAttack = socketAttack;
	}
}
