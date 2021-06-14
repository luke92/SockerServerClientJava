package DAO;
import java.io.*;
import java.util.*;

public class AccesoDatosArchivo {
	/*
	public static void grabar(String nombreArchivo, ArrayList<String> cadenas)
	{
		try 
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(nombreArchivo));
            for(String x : cadenas)
            {
            	out.write(x + ";");
            }
            out.newLine();
			out.close();
		} 
		catch (IOException e) 
		{
			// 
			e.printStackTrace();
		}
	}
	
	public static void limpiarDatos(String nombreArchivo)
	{
		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(nombreArchivo));
			out.write("");
			out.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	*/
	public static ArrayList<String> getIPS(String nombreArchivo)
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
