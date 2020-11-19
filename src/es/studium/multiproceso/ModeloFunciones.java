package es.studium.multiproceso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ModeloFunciones
{
		String path = "c:\\users\\david.info\\";
		public String lanzarComando(String comando) {
			
			String comand="";
			String cmdExe = "cmd /c "+comando;
			//String cmd = "cmd /c " + comando;
			try
			{
				
				Process process = Runtime.getRuntime().exec(cmdExe);
				// Flujo de entrada(padre) para la salida est�ndar (hijo)
				InputStream is = process.getInputStream();
				// Flujo de lectura para esa entrada
				InputStreamReader isr = new InputStreamReader(is);
				// Buffer para leer l�nea a l�nea
				BufferedReader br = new BufferedReader(isr);
				String line;
				System.out.println("Proceso en ejecuci�n... ");
				while ((line = br.readLine()) != null)
				{
					comand=comand+line+"\n";
				}
//				long pidEjecutar =  process.pid();
				is.close();
			}
			catch (IOException e)
			{
				System.err.println("Excepci�n de E/S!!");
				System.exit(-1);
			}
			return comand;
			}
		
		public void ejecutarPrograma(String prog) {
			try {
				
				Process proceso= Runtime.getRuntime().exec(prog);
				
				while(proceso.isAlive()) {
					System.out.println("El proceso est� activo");
				}
				System.out.println("Se cerr� el "+prog+" correctamente");
				
			}catch(IOException e) {
				
				e.printStackTrace();
				System.out.println("Error al intentar abrir el "+prog);
			}
		}
		
}
