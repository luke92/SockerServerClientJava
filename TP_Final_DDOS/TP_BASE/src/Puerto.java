
public class Puerto {
	private String NumeroDePuerto;
	private int ContadorConexiones;
	
	public String getPuerto() {
		return NumeroDePuerto;
	}
	public void setPuerto(String puerto) {
		this.NumeroDePuerto = puerto;
	}
	public int getContadorIntentos() {
		return ContadorConexiones;
	}
	public void setContadorIntentos(int contadorIntentos) {
		this.ContadorConexiones = contadorIntentos;
	}
}
