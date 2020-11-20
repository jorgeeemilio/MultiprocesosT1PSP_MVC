package es.studium.multiproceso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;




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


//			System.out.println(vint.getTextField().getText().toString());

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

			prog3 = "Programa de Gestión";

//			System.out.println(pidGestion);


		}else if (pulsar.equals(vint.getBtnJuegAjedrez())) {

			pidJuego = mfun.ejecutarJar("Juego", vint.getBtnJuegAjedrez(),vint);

			vint.defTable.addRow(new Object[] {"Juego de Ajedrez"});

//			int numProg4 = vint.defTable.getColumnCount();
			prog4 = "Juego de Ajedrez";

//			System.out.println(pidJuego+"--> "+numProg4);



		}else if (pulsar.equals(vint.getBtnTerminar())) {

			nRow =(vint.table.getSelectedRow());
			System.out.println(nRow);
			check = vint.table.getValueAt(nRow, 0).toString();
			System.out.println(check);
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
				vint.getBtnBloqNotas().setEnabled(true);
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
			
//			if (vint.table.getSelectedRow() == 0 ) {
//
//				if (prog1.equals(prog1)) {
//					try
//					{
//						mfun.pararProceso(prog1);
//					} catch (InterruptedException e1)
//					{
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					vint.getBtnBloqNotas().setEnabled(true);
//				}else if (prog2.equals(prog2)){
//					try
//					{
//						mfun.pararProceso(prog2);
//					} catch (InterruptedException e1)
//					{
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					vint.getBtnBloqNotas().setEnabled(true);
//				}else if (prog3.equals(prog3)) {
//					try
//					{
//						mfun.pararProcesoJava(pidGestion);
//					} catch (InterruptedException e1)
//					{
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}else if (prog4.equals(prog4)) {
//					try
//					{
//						mfun.pararProcesoJava(pidJuego);
//					} catch (InterruptedException e1)
//					{
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
//				vint.defTable.removeRow(vint.table.getSelectedRow());
//
//			}else if (vint.table.getSelectedRow() == 1) {
//
//				try
//				{
//					mfun.pararProceso(prog2);
//				} catch (InterruptedException e1)
//				{
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				vint.getBtnBloqNotas().setEnabled(true);
//				vint.defTable.removeRow(vint.table.getSelectedRow());
//			}else if (vint.table.getSelectedRow() == 2) {
//
//				try
//				{
//					mfun.pararProcesoJava(pidGestion);
//				} catch (InterruptedException e1)
//				{
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				vint.defTable.removeRow(vint.table.getSelectedRow());
//			}else if (vint.table.getSelectedRow() == 3) {
//
//				try
//				{
//					mfun.pararProcesoJava(pidJuego);
//				} catch (InterruptedException e1)
//				{
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				vint.defTable.removeRow(vint.table.getSelectedRow());
//			}
//			vint.getBtnPaint().setEnabled(true);
//			vint.getBtnProgGestin().setEnabled(true);
//			vint.getBtnJuegAjedrez().setEnabled(true);
//			
//			
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
