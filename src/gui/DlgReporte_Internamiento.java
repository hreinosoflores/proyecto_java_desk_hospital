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

import arreglos.Arreglo_Reporte_Internamiento;
import clases.Ingreso_Datos_Internamiento;

public class DlgReporte_Internamiento extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JButton btnListar;

	private JScrollPane scrollPaneA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgReporte_Internamiento dialog = new DlgReporte_Internamiento();
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DlgReporte_Internamiento() {
		setTitle("Internamiento Pagados");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 565, 338);
		contentPane = new JPanel();
		setIconImage(new ImageIcon("imagenes/medicos.png").getImage());
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setIcon(new ImageIcon("imagenes/reportar.png"));
		btnListar.setBounds(126, 9, 105, 32);
		contentPane.add(btnListar);

		scrollPaneA = new JScrollPane();
		scrollPaneA.setBounds(10, 48, 529, 240);
		contentPane.add(scrollPaneA);

		txtS = new JTextArea();
		scrollPaneA.setViewportView(txtS);

		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon("imagenes/exit.png"));
		btnSalir.setBounds(313, 9, 105, 32);
		contentPane.add(btnSalir);

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnListar) {
			actionPerformedBtnListar(arg0);
		}
	}

	// declaracion global xs

	Arreglo_Reporte_Internamiento aip = new Arreglo_Reporte_Internamiento();
	private JButton btnSalir;
	private JTextArea txtS;

	private void actionPerformedBtnListar(ActionEvent arg0) {
		txtS.setText("");
		Ingreso_Datos_Internamiento x;
		for (int i = 0; i < Principal_Proyecto2017_2.ai.tamanio(); i++) {
			x = Principal_Proyecto2017_2.ai.obtener(i);
			imprimir("Codigo de internamiento:  " + x.getCodigoInternamiento());
			imprimir("Codigo de paciente:  " + x.getCodigoPaciente());
			imprimir("Numero de Cama:  " + x.getNumCama());
			imprimir("Fecha de ingreso:  " + x.getFechaIngreso());
			imprimir("Fecha de salida:  " + x.getFechaSalida());
			imprimir("------------------------------------------------------------------------------");

		}
	}

	void imprimir(String s) {
		txtS.append(s + "\n");
	}

	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}
}