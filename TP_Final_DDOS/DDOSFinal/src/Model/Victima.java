package Model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import DAO.AccesoDatosDB;

public class Victima implements IAccesoDatosDB {
	
	private int id;
	private String path;
	private String ip;
	private boolean ataque;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public boolean isAtaque() {
		return ataque;
	}
	public void setAtaque(boolean ataque) {
		this.ataque = ataque;
	}
	
	public Victima(){}
	
	public Victima(int id)
	{
		AccesoDatosDB db = new AccesoDatosDB();
		ArrayList<String[]> datos = db.consultarDatos("SELECT * FROM Victimas WHERE id = " + id);
		for(String[] rs : datos)
		{
			this.setId(Integer.parseInt(rs[0]));
			this.setPath(rs[1]);
			this.setIp(rs[2]);
			if(Integer.parseInt(rs[3]) == 1) this.setAtaque(true);
			else this.setAtaque(false);
		}
	}
	@Override
	public void insertar() {
		int estado;
		if(this.isAtaque()) estado = 1;
		else estado = 0;
		String consulta = "INSERT INTO Victimas VALUES (" +
						  "'" + this.getPath() + "', " +
						  "'" + this.getIp() + "', " + 
						  estado + ")";
		
		AccesoDatosDB db = new AccesoDatosDB();
		db.ejecutarConsulta(consulta);
		
	}
	
	public ArrayList<Victima> getAll()
	{
		ArrayList<Victima> victimas = new ArrayList<Victima>();
		AccesoDatosDB db = new AccesoDatosDB();
		ArrayList<String[]> datos = db.consultarDatos("SELECT * FROM Victimas");
		for(String[] rs : datos)
		{
			Victima x = new Victima();
			x.setId(Integer.parseInt(rs[0]));
			x.setPath(rs[1]);
			x.setIp(rs[2]);
			if(Integer.parseInt(rs[3]) == 1) x.setAtaque(true);
			else x.setAtaque(false);
			victimas.add(x);
		}
		return victimas;
	}

}
