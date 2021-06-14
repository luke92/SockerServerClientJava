import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;


public class Log {
	
	private int id;
	private Date fecha  ;
	private Time hora;
	private String ipServidor;
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
	public String getIpServidor() {
		return ipServidor;
	}
	public void setIpServidor(String ipServidor) {
		this.ipServidor = ipServidor;
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
	
	public void logging()
	{	
		String Consulta = "INSERT into logs values(" +  " "
				+ " , '" +this.getFecha() + "' , '"
				+ this.getHora() + "', '" 
				+ this.getIpServidor() + "' , '" 
				+ this.getKeyword() + "' , ' "
				+ this.getDescripcion() + "' )" ;

AccesoDatos db = new AccesoDatos();
db.ejecutarConsulta(Consulta);
			
	}
	
	public  ArrayList<Log> getAll( )
	{
		ArrayList<Log> logs = new ArrayList<Log>();
		AccesoDatos db = new AccesoDatos();
		ArrayList<String[]> datos = db.consultarDatos("SELECT * FROM clientes");
			for(String[] rs : datos )
			{
				
				Log l = new Log();
				
				l.setId(Integer.parseInt(rs[0]));
				l.setFecha(new Date (rs[1]));				
				l.setHora(Time.valueOf(rs[2])) ;
				l.setIpServidor(rs[3]);
				l.setKeyword(rs[4]);
				l.setDescripcion(rs[5]);
			
				logs.add(l);
			}
		 
		return logs;
	}
	
	
	

}
