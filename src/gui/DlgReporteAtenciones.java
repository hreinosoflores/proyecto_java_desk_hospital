package gui;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import clases.Atencion;

public class DlgReporteAtenciones extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnListar;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgReporteAtenciones dialog = new DlgReporteAtenciones();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgReporteAtenciones() {
		setTitle("reporte Pago");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(new ImageIcon("imagenes/medicos.png").getImage());
		setBounds(100, 100, 430, 341);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setIcon(new ImageIcon("imagenes/reportar.png"));
		btnListar.setBounds(73, 11, 108, 30);
		contentPane.add(btnListar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 394, 231);
		contentPane.add(scrollPane);

		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);

		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon("imagenes/exit.png"));
		btnSalir.setBounds(234, 11, 108, 30);
		contentPane.add(btnSalir);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnListar) {
			actionPerformedBtnListar(arg0);

		}

	}

	private void actionPerformedBtnListar(ActionEvent arg0) {
		txtS.setText("");
		Atencion x;
		for (int i = 0; i < Principal_Proyecto2017_2.at.tamanio(); i++) {
			x = Principal_Proyecto2017_2.at.obtener(i);
			{
				imprimir("Codigo de Atencion:  " + x.getCodigoAtencion());
				imprimir("Codigo de paciente:  " + x.getCodigoPaciente());
				imprimir("Fecha de Atencion:  " + x.getFechaAtencion());
				imprimir("Total a pagar:  " + x.getTotalPagar());
				imprimir("------------------------------------------------------------------------------");
			}

		}

	}

	void imprimir(String s) {
		txtS.append(s + "\n");
	}

	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}
}