package es.studium.multiproceso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class ModeloFunciones
{
	
		//String path = "c:\\users\\david.info\\";
		public String lanzarComando(String comando) {
			
			String comand="";
			//String cmdExe = "cmd /c "+comando;
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
		
		public long ejecutarPrograma(String prog, JButton btn ) {
			
			long pid = 0L;
			String cmd = "cmd /c start "+ prog;
			try {
				
				Process proceso= Runtime.getRuntime().exec(cmd);
				pid = proceso.pid();
				while(proceso.isAlive()) {
					System.out.println("El proceso està activo");
					
				}
				btn.setEnabled(false);
				System.out.println("Se cerró el "+prog+" correctamente");
				
			}catch(IOException e) {
				
				e.printStackTrace();
				System.out.println("Error al intentar abrir el "+prog);
			}
			return pid;
		}
		public long ejecutarJar(String programa, JButton btn , VistaInterfaz vista) {
			long pid = 0;
			
			String arg1 = "java";
			String arg2 = "-jar";
			String arg3 = "C:\\Users\\David.Info\\Documents\\GrupoStudium\\"+programa+".jar";
			
			//Creación de una array de cadenas texto
			
			String[] param = {arg1, arg2, arg3};
			
			//Instanciamos un proceso
			
			try
			{
				Process process = Runtime.getRuntime().exec(param);
				
				pid = process.pid();
				
				btn.setEnabled(false);
			
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return pid;
		}
		public void pararProcesoJava(long pid) throws InterruptedException {
			
			try
			{
				
				Runtime.getRuntime().exec("cmd /c taskkill /f /pid "+pid );
				Thread.sleep(90);
				
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public void pararProceso(String proceso) {
			
			try
			{
				Runtime.getRuntime().exec("cmd /c taskkill /f /im "+proceso+".exe");
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
