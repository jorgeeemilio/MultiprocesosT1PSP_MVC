package es.studium.multiproceso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ModeloFunciones
{
	private String comand;
	
	public ModeloFunciones() {
			
			setDir("");
				}
		public ModeloFunciones(String dr) {
			
			this.setDir(dr);
			
				}
		public String lanzarComando(String comando) {
			
			
			String cmd = "cmd /c "+ comand + comando;
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
				
				is.close();
			}
			catch (IOException e)
			{
				System.err.println("Excepción de E/S!!");
				System.exit(-1);
			}
			return comand;
			}
		
		public String getDir()
		{
			return comand;
		}
		public void setDir(String dir)
		{
			this.comand = dir;
		}
}
