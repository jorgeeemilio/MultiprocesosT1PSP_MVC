package es.studium.multiproceso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class ControladorFunciones implements WindowListener, ActionListener
{
	VistaInterfaz vint = null;
	ModeloFunciones mfun = null;

	public long pidGestion = 0L;
	public long pidJuego = 0L;
	public long pidNotas = 0L;
	public long pidPaint = 0L;
	public String prog1 ="";
	public String prog2 ="";
	public String prog3 ="";
	public String prog4 ="";
	public String check ="";
	public int nRow=0;

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

			String comando = vint.getTextField().getText().toString();
			String texto =  mfun.lanzarComando(comando);

			vint.getTxtArea().setText(texto);				
		}else if (pulsar.equals(vint.getBtnBloqNotas())) {


			pidNotas = mfun.ejecutarPrograma("notepad.exe", vint.getBtnBloqNotas());

			vint.defTable.addRow(new Object[] {"Bloc de Notas"});

			prog1 = "notepad";

		}else if (pulsar.equals(vint.getBtnPaint())) {


			pidPaint = mfun.ejecutarPrograma("mspaint.exe", vint.getBtnPaint());

			vint.defTable.addRow(new Object[] {"Editor Paint"});		

			prog2 = "mspaint";

		}else if (pulsar.equals(vint.getBtnProgGestin())) {


			pidGestion = mfun.ejecutarJar("gestion", vint.getBtnProgGestin(), vint);


			vint.defTable.addRow(new Object[] {"Programa de Gestión"});


		}else if (pulsar.equals(vint.getBtnJuegAjedrez())) {

			pidJuego = mfun.ejecutarJar("Juego", vint.getBtnJuegAjedrez(),vint);

			vint.defTable.addRow(new Object[] {"Juego de Ajedrez"});


		}else if (pulsar.equals(vint.getBtnTerminar())) {

			nRow =(vint.table.getSelectedRow());
			
			check = vint.table.getValueAt(nRow, 0).toString();
			
			if (check == "Bloc de Notas") {
				try
				{
					mfun.pararProceso(prog1);

				} catch (InterruptedException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				vint.defTable.removeRow(vint.table.getSelectedRow());
				vint.getBtnBloqNotas().setEnabled(true);
			}else if (check=="Editor Paint") {
				try
				{
					mfun.pararProceso(prog2);
				} catch (InterruptedException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				vint.defTable.removeRow(vint.table.getSelectedRow());
				vint.getBtnPaint().setEnabled(true);
			}else if(check=="Programa de Gestión") {

				try
				{
					mfun.pararProcesoJava(pidGestion);
				} catch (InterruptedException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				vint.defTable.removeRow(vint.table.getSelectedRow());
				vint.getBtnProgGestin().setEnabled(true);
			}else if(check=="Juego de Ajedrez") {

				try
				{
					mfun.pararProcesoJava(pidJuego);
				} catch (InterruptedException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				vint.defTable.removeRow(vint.table.getSelectedRow());
				vint.getBtnJuegAjedrez().setEnabled(true);
			}

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
