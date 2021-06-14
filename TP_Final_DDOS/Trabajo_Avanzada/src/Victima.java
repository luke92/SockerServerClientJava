import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;


public class Victima {
	
	private int id;
	private String path;
	private String ipServidor;
	private boolean ataqueRealizado;
	
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
	public String getIpServidor() {
		return ipServidor;
	}
	public void setIpServidor(String ipServidor) {
		this.ipServidor = ipServidor;
	}
	public boolean isAtaqueRealizado() {
		return ataqueRealizado;
	}
	public void setAtaqueRealizado(boolean ataqueRealizado) {
		this.ataqueRealizado = ataqueRealizado;
	}
	

	public void agregar()
	{	
		int estado ;
		if(this.isAtaqueRealizado()) estado = 1 ;
		else estado  = 0 ;
		String Consulta = "INSERT into victimas (NombreArchivo,IPservidor,Ataque) values('"  
				+ this.getPath() + "', '" 
				+ this.getIpServidor() + "' , " 
				+  estado   + " )" ;

AccesoDatos db = new AccesoDatos();
db.ejecutarConsulta(Consulta);
			
	}
	
	public  ArrayList<Victima> leerTodos( )
	{
		ArrayList<Victima> victimas = new ArrayList<Victima>();
		AccesoDatos db = new AccesoDatos();
		ArrayList<String[]> archivos = db.consultarDatos("SELECT * FROM clientes");
			for(String[] rs : archivos )
			{
				
				Victima v = new Victima();
				
				v.setId(Integer.parseInt(rs[0]));
				v.setPath(rs[1]);
				v.setIpServidor(rs[2]);
				if(Integer.parseInt(rs[3])==1) v.setAtaqueRealizado(true);
				else v.setAtaqueRealizado(false);				
			
				victimas.add(v);
			}
		 
		return victimas ;
	}
	
	
	
}
