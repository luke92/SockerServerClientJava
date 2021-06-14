import java.io.*;


public class Entrada 
{
	public static String readLine()
	{
		StringBuffer s = null;
		try {
			InputStreamReader converter = new InputStreamReader(System.in);
			BufferedReader in = new BufferedReader(converter);
			s = new StringBuffer(in.readLine());
		} catch (Exception e) {
			System.out.println("Error! Exception: "+e); 
		}
		return s.toString() ;
	}
}
