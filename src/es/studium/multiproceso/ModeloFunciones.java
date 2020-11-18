package es.studium.multiproceso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ModeloFunciones
{
	
	
	public ModeloFunciones() {}
	
		public String lanzarComando(String comando) {
			
			String comand="";
			String cmd = "cmd /c " + comando;
			try
			{
				
				Process process = Runtime.getRuntime().exec(cmd);
				// Flujo de entrada(padre) para la salida estándar (hijo)
				InputStream is = process.getInputStream();
				// Flujo de lectura para esa entrada
				InputStreamReader isr = new InputStreamReader(is);
				// Buffer para leer línea a línea
				BufferedReader br = new BufferedReader(isr);
				String line;
				System.out.println("Proceso en ejecución... ");
				while ((line = br.readLine()) != null)
				{
					comand=comand+line+"\n";
				}
//				long pidEjecutar =  process.pid();
				is.close();
			}
			catch (IOException e)
			{
				System.err.println("Excepción de E/S!!");
				System.exit(-1);
			}
			return comand;
			}
		
		
}
