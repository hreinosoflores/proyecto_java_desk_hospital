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

import arreglos.Arreglo_Reporte_Pacientes;
import clases.Internamiento;
import clases.Paciente;

public class DlgReporte_Pacientes_Internados extends JDialog implements ActionListener {

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
					DlgReporte_Pacientes_Internados dialog = new DlgReporte_Pacientes_Internados();
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
	public DlgReporte_Pacientes_Internados() {
		setTitle("Reporte Paciente");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(new ImageIcon("imagenes/medicos.png").getImage());
		setBounds(100, 100, 564, 352);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		btnListar = new JButton("Listar");
		btnListar.setBounds(106, 11, 105, 33);

		btnListar.addActionListener(this);
		btnListar.setIcon(new ImageIcon("imagenes/reportar.png"));
		contentPane.setLayout(null);
		contentPane.add(btnListar);

		scrollPaneA = new JScrollPane();
		scrollPaneA.setBounds(10, 48, 528, 254);
		contentPane.add(scrollPaneA);

		txtS = new JTextArea();
		scrollPaneA.setViewportView(txtS);

		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon("imagenes/exit.png"));
		btnSalir.setBounds(327, 11, 105, 33);
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

	Arreglo_Reporte_Pacientes arp = new Arreglo_Reporte_Pacientes();
	private JTextArea txtS;
	private JButton btnSalir;

	private void actionPerformedBtnListar(ActionEvent arg0) {
		txtS.setText("");
		Internamiento x;
		Paciente y;
		for (int i = 0; i < Principal_Proyecto2017_2.ai.tamanio(); i++) {
			x = Principal_Proyecto2017_2.ai.obtener(i);
			for (int j = 0; j < Principal_Proyecto2017_2.ap.tamanio(); j++) {
				y = Principal_Proyecto2017_2.ap.obtener(j);
				if (x.getCodigoPaciente() == y.getCodigoPaciente()) {
					imprimir("Codigo de paciente:  " + y.getCodigoPaciente());
					imprimir("Nombre del paciente:  " + y.getNombres());
					imprimir("Apellidos del paciente:  " + y.getApellidos());
					imprimir("Fecha de ingreso:  " + x.getFechaIngreso());
					imprimir("Numero de cama:  " + x.getNumCama());
					imprimir("------------------------------------------------------------------------------");
				}

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
