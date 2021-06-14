import java.io.*;
import java.util.*;

public class AccesoDatosArchivo {
	
	
	
	public static ArrayList<String> tomarIPS(String nombreArchivo)
	{
		ArrayList<String> cadenas = new ArrayList<String>();
        File f = new File( nombreArchivo );
		BufferedReader entrada;
		try 
		{
			entrada = new BufferedReader( new FileReader( f ) );
			String linea;
			while(entrada.ready())
			{
				linea = entrada.readLine();
				cadenas.add(linea);
			}
			entrada.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return cadenas;
	}
	

}
