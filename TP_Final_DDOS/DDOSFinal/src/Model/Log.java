package Model;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import DAO.AccesoDatosDB;


public class Log implements IAccesoDatosDB {
	
	private int id;
	private Date fecha;
	private Time hora;
	private String ip;
	private String keyword;
	private String descripcion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Log(){}
	
	public Log(int id)
	{
		AccesoDatosDB db = new AccesoDatosDB();
		ArrayList<String[]> datos = db.consultarDatos("SELECT * FROM Logs WHERE id = " + id);
		for(String[] rs : datos)
		{
			this.setId(Integer.parseInt(rs[0]));
			this.setFecha(new Date(rs[1]));
			this.setHora(Time.valueOf(rs[2]));
			this.setIp(rs[3]);
			this.setKeyword(rs[4]);
			this.setDescripcion(rs[5]);
		}
	}
	@Override
	public void insertar() {
		String consulta = "INSERT INTO Logs VALUES (" +
						  "'" + this.getFecha() + "', " +
						  "'" + this.getHora() + "', " + 
						  "'" + this.getIp() + "', " + 
						  "'" + this.getKeyword() + "', " + 
						  "'" + this.getDescripcion() + "')";
		
		AccesoDatosDB db = new AccesoDatosDB();
		db.ejecutarConsulta(consulta);
		
	}
	
	public ArrayList<Log> getAll()
	{
		ArrayList<Log> logs = new ArrayList<Log>();
		AccesoDatosDB db = new AccesoDatosDB();
		ArrayList<String[]> datos = db.consultarDatos("SELECT * FROM Logs");
		for(String[] rs : datos)
		{
			Log x = new Log();
			x.setId(Integer.parseInt(rs[0]));
			x.setFecha(new Date(rs[1]));
			x.setHora(Time.valueOf(rs[2]));
			x.setIp(rs[3]);
			x.setKeyword(rs[4]);
			x.setDescripcion(rs[5]);
			logs.add(x);
		}
		return logs;
	}
	

}
