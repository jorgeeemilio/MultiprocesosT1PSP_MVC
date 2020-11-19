package es.studium.multiproceso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class ControladorFunciones implements WindowListener, ActionListener
{
	VistaInterfaz vint = null;
	ModeloFunciones mfun = null;

	public ControladorFunciones(VistaInterfaz vint, ModeloFunciones mfun)
	{
		this.vint = vint;
		this.mfun = mfun;
		
		//Escuchador de la ventana VistaInterfaz
		vint.addWindowListener(this);
		
		
	
		//Listeners de los objetos del interfaz
		
		vint.getBtnBloqNotas().addActionListener(this);
		vint.getBtnPaint().addActionListener(this);
		vint.getBtnProgGestin().addActionListener(this);
		vint.getBtnJuegAjedrez().addActionListener(this);
		vint.getBtnTerminar().addActionListener(this);
		vint.getBtnEjecutar().addActionListener(this);
		vint.getTextField().addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		Object pulsar = e.getSource();
		
		if (pulsar.equals(vint.getBtnEjecutar())) {
			
			System.out.println("hola");
			System.out.println(vint.getTextField().getText().toString());
			
			String comando = vint.getTextField().getText().toString();
			String texto =  mfun.lanzarComando(comando);
			
			vint.getTxtArea().setText(texto);				
		}else if (pulsar.equals(vint.getBtnBloqNotas())) {
			
			mfun.ejecutarPrograma("notepad.exe", vint.getBtnBloqNotas());
		}else if (pulsar.equals(vint.getBtnPaint())) {
			
			mfun.ejecutarPrograma("mspaint.exe", vint.getBtnPaint());
			
		}else if (pulsar.equals(vint.getBtnProgGestin())) {
			long pid = 0L;	
					pid = mfun.ejecutarJar("gestion", vint.getBtnProgGestin());
					
					System.out.println(pid);
			
		}else if (pulsar.equals(vint.getBtnJuegAjedrez())) {
			long pid = 0L;	
			pid = mfun.ejecutarJar("ajedrez", vint.getBtnJuegAjedrez());
			
			System.out.println(pid);
	
}

	}

	@Override
	public void windowOpened(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	

}
