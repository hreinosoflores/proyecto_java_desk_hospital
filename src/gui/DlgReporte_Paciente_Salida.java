package gui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clases.Internamiento;
import clases.Paciente;

public class DlgReporte_Paciente_Salida extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JButton btnGenerar;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JTextField txtFecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgReporte_Paciente_Salida dialog = new DlgReporte_Paciente_Salida();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgReporte_Paciente_Salida() {
		setTitle("Reporte paciente Salida");
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setBounds(100, 100, 467, 313);
		setIconImage(new ImageIcon("imagenes/medicos.png").getImage());
		getContentPane().setLayout(null);

		label = new JLabel("Fecha Salida:");
		label.setBounds(10, 11, 86, 14);
		getContentPane().add(label);

		btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(this);
		btnGenerar.setIcon(new ImageIcon("imagenes/generar.png"));
		btnGenerar.setBounds(307, 3, 118, 30);
		getContentPane().add(btnGenerar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 414, 214);
		getContentPane().add(scrollPane);

		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);

		txtFecha = new JTextField();
		txtFecha.setBounds(96, 8, 107, 20);
		getContentPane().add(txtFecha);
		txtFecha.setColumns(10);
	}

	private String leerFecha() {
		return txtFecha.getText();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGenerar) {
			actionPerformedBtnGenerar(arg0);
		}
	}

	protected void actionPerformedBtnGenerar(ActionEvent arg0) {
		txtS.setText("");
		Internamiento x;
		Paciente y;
		for (int i = 0; i < Principal_Proyecto2017_2.ai.tamanio(); i++) {
			x = Principal_Proyecto2017_2.ai.obtener(i);
			for (int j = 0; j < Principal_Proyecto2017_2.ap.tamanio(); j++) {
				y = Principal_Proyecto2017_2.ap.obtener(j);
				if (x.getCodigoPaciente() == y.getCodigoPaciente() && x.getFechaSalida() == leerFecha()) {
					imprimir("Codigo de paciente:  " + y.getCodigoPaciente());
					imprimir("Nombre del paciente:  " + y.getNombres());
					imprimir("Apellidos del paciente:  " + y.getApellidos());
					imprimir("Fecha de ingreso:  " + x.getFechaIngreso());
					imprimir("Numero de cama:  " + x.getNumCama());
					imprimir("------------------------------------------------------------------------------");
				}

			}

		}
		if (txtS.getText().length() == 0)
			imprimir("No hay pacientes que salgan ese dia");
	}

	void imprimir(String s) {
		txtS.append(s + "\n");
	}
}
