
public class AccionCliente 
{
	private String Mensaje;
	public String getMensaje() {
		return Mensaje;
	}
	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}
	public String getIpVictima() {
		return ipVictima;
	}
	public void setIpVictima(String ipVictima) {
		this.ipVictima = ipVictima;
	}
	public String getStrArbitrario() {
		return strArbitrario;
	}
	public void setStrArbitrario(String strArbitrario) {
		this.strArbitrario = strArbitrario;
	}
	private String ipVictima;
	private String strArbitrario;
}
