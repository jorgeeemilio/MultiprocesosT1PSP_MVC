package es.studium.multiproceso;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.SystemColor;

public class VistaInterfaz extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnBloqNotas;
	private JButton btnPaint;
	private JButton btnProgGestin;
	private JButton btnJuegAjedrez;
	private JScrollPane scrollPane_1;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextArea txtArea;
	private JButton btnTerminar;
	private JButton btnEjecutar;
	
//	private static VistaInterfaz frame=null;

	/**
	 * Launch the application.
	 */
//	public void main(String[] args)
//	{
//		EventQueue.invokeLater(new Runnable()
//		{
//			public void run()
//			{
//				try
//				{
//					frame = new VistaInterfaz();
//					frame.setVisible(true);
//				} catch (Exception e)
//				{
//					
//					e.printStackTrace();
//					System.err.println("entra en el catch de la excepcion :(");
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public VistaInterfaz()
	{
		setTitle("Pr\u00E1ctica PSP Tema 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnEjecutar = new JButton("Ejecutar");
		
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setBackground(SystemColor.desktop);
		textField.setColumns(10);
		
		//Instanciar los botones
		
		btnBloqNotas = new JButton("Bloc de Notas");
		
		btnPaint = new JButton("Paint");
				
		btnProgGestin = new JButton("Prog. Gesti\u00F3n");
		
		btnJuegAjedrez = new JButton("Jueg. Ajedrez");
		
		btnTerminar = new JButton("Terminar");
		
		scrollPane_1 = new JScrollPane();
		
		scrollPane = new JScrollPane();
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnTerminar)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(btnBloqNotas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnPaint, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnProgGestin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnJuegAjedrez, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnEjecutar))
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(14)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnBloqNotas)
										.addComponent(btnEjecutar)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(35)
									.addComponent(btnProgGestin)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnJuegAjedrez))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(43)
									.addComponent(btnPaint)))
							.addGap(18)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnTerminar)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		txtArea = new JTextArea();
		txtArea.setForeground(Color.WHITE);
		txtArea.setBackground(new Color(0, 0, 205));
		txtArea.setText("");
		scrollPane.setViewportView(txtArea);
		
		table = new JTable();
		table.setBackground(Color.ORANGE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"PID ", "Procesos Activos"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(44);
		table.getColumnModel().getColumn(1).setPreferredWidth(167);
		scrollPane_1.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
	

	public JButton getBtnBloqNotas()
	{
		return btnBloqNotas;
	}


	public void setBtnBloqNotas(JButton btnBloqNotas)
	{
		this.btnBloqNotas = btnBloqNotas;
	}


	public JButton getBtnPaint()
	{
		return btnPaint;
	}

	public void setBtnPaint(JButton btnPaint)
	{
		this.btnPaint = btnPaint;
	}

	public JButton getBtnProgGestin()
	{
		return btnProgGestin;
	}

	public void setBtnProgGestin(JButton btnProgGestin)
	{
		this.btnProgGestin = btnProgGestin;
	}

	public JButton getBtnJuegAjedrez()
	{
		return btnJuegAjedrez;
	}

	public void setBtnJuegAjedrez(JButton btnJuegAjedrez)
	{
		this.btnJuegAjedrez = btnJuegAjedrez;
	}

	public JButton getBtnTerminar()
	{
		return btnTerminar;
	}

	public void setBtnTerminar(JButton btnTerminar)
	{
		this.btnTerminar = btnTerminar;
	}

	public JButton getBtnEjecutar()
	{
		return btnEjecutar;
	}

	public void setBtnEjecutar(JButton btnEjecutar)
	{
		this.btnEjecutar = btnEjecutar;
	}

	public JTextField getTextField()
	{
		return textField;
	}

	public void setTextField(JTextField textField)
	{
		this.textField = textField;
	}

	public JTextArea getTxtArea()
	{
		return txtArea;
	}

	public void setTxtArea(JTextArea txtArea)
	{
		this.txtArea = txtArea;
	}

	public JTable getTable()
	{
		return table;
	}

	public void setTable(JTable table)
	{
		this.table = table;
	}

	public JScrollPane getScrollPane_1()
	{
		return scrollPane_1;
	}

	public void setScrollPane_1(JScrollPane scrollPane_1)
	{
		this.scrollPane_1 = scrollPane_1;
	}

	public JScrollPane getScrollPane()
	{
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane)
	{
		this.scrollPane = scrollPane;
	}
	

	
}
