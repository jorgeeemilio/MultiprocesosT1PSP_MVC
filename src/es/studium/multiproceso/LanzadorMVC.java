package es.studium.multiproceso;

public class LanzadorMVC
{

	public static void main(String[] args)
	{
		
		VistaInterfaz vint = new VistaInterfaz();
		ModeloFunciones mfun = new ModeloFunciones();
		//vint.main(null);
		new ControladorFunciones(vint, mfun);
		
	}

}
