import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Estado {
	private String Descripcion;
	private Date fechaInicio;
	private String Ip;
	private ArrayList<Puerto> puertos;
	
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicioParametro) {
		fechaInicio = fechaInicioParametro;
	}
	public ArrayList<Puerto> getPuertos() {
		return puertos;
	}
	public void setPuertos(ArrayList<Puerto> puertosList) {
		this.puertos = puertosList;
	}
	public String getIp() {
		return Ip;
	}
	public void setIp(String ip) {
		Ip = ip;
	}
	
}
