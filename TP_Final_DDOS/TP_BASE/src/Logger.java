import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {
	public static void LogAccionServidor(String accion) throws IOException {
		File file = new File("logServidor.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		BufferedWriter bw = new BufferedWriter(fw);
		fw.append("Log " + new Date().toString() + " " + accion + System.getProperty("line.separator"));
		bw.close();
		fw.close();
	}
	
	public static void LogAccionCliente(String accion) throws IOException {
		File file = new File("logCliente.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		BufferedWriter bw = new BufferedWriter(fw);
		fw.append("Log " + new Date().toString() + " " + accion  + System.getProperty("line.separator"));
		bw.close();
		fw.close();
	}
}
