package es.studium.multiproceso;

public class LanzadorMVC
{

	public static void main(String[] args)
	{
		VistaInterfaz.main(null);
		
		VistaInterfaz vint = new VistaInterfaz();
		ModeloFunciones mfun = new ModeloFunciones();
		
		new ControladorFunciones(vint, mfun);

	}

}
