package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import clases.Ingreso_Datos_Internamiento;

public class DlgIngreso_Datos_Internamiento extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCodPaciente;
	private JLabel lblCodInternamiento;
	private JButton btnCancelar;
	private JTextField txtPaciente;
	private JButton btnInternar;
	private JTextField txtInternamiento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgIngreso_Datos_Internamiento dialog = new DlgIngreso_Datos_Internamiento();
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
	public DlgIngreso_Datos_Internamiento() {
		setTitle("Ingreso de datos ");
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setIconImage(new ImageIcon("imagenes/medicos.png").getImage());
		getContentPane().setFont(new Font("Cambria", Font.BOLD, 12));
		setResizable(false);
		setBounds(100, 100, 531, 143);
		getContentPane().setLayout(null);

		lblCodPaciente = new JLabel("Cod. Paciente:\r\n");
		lblCodPaciente.setBounds(10, 45, 86, 14);
		getContentPane().add(lblCodPaciente);

		lblCodInternamiento = new JLabel("Cod. Internamiento:");
		lblCodInternamiento.setBounds(10, 14, 117, 16);
		getContentPane().add(lblCodInternamiento);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setIcon(new ImageIcon("imagenes/salir.png"));
		btnCancelar.setFont(new Font("Cambria", Font.BOLD, 12));
		btnCancelar.setBounds(352, 59, 149, 31);
		getContentPane().add(btnCancelar);

		txtPaciente = new JTextField();
		txtPaciente.setBounds(126, 42, 86, 20);
		getContentPane().add(txtPaciente);
		txtPaciente.setColumns(10);

		btnInternar = new JButton("Internar");
		btnInternar.addActionListener(this);
		btnInternar.setBounds(352, 11, 117, 37);
		getContentPane().add(btnInternar);

		txtInternamiento = new JTextField();
		txtInternamiento.setBounds(126, 12, 86, 20);
		getContentPane().add(txtInternamiento);
		txtInternamiento.setColumns(10);

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnInternar) {
			actionPerformedBtnInternar(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
	}

	protected void actionPerformedBtnInternar(ActionEvent arg0) {
		int codigoInternamiento, codigoPaciente, numCama, estado;
		String fechaIngreso, horaIngreso, fechaSalida, horaSalida;
		codigoInternamiento = leerCodInternamiento();
		codigoPaciente = leerCodPaciente();
		numCama = Principal_Proyecto2017_2.ac.PrimeraCamaDisponible();
		fechaIngreso = Principal_Proyecto2017_2.FechaSistema();
		horaIngreso = Principal_Proyecto2017_2.HoraSistema();
		fechaSalida = "";
		horaSalida = "";
		estado = 0;

		Ingreso_Datos_Internamiento nuevo = new Ingreso_Datos_Internamiento(codigoInternamiento, codigoPaciente,
				numCama, fechaIngreso, horaIngreso, fechaSalida, horaSalida, estado);
		Principal_Proyecto2017_2.ai.adicionar(nuevo);
		DlgInternamiento.listar();
		limpieza();
		Principal_Proyecto2017_2.ac.buscar(numCama).setEstado(1);
	}

	int leerCodInternamiento() {
		return Integer.parseInt(txtInternamiento.getText().trim());
	}

	int leerCodPaciente() {
		return Integer.parseInt(txtPaciente.getText().trim());
	}

	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		dispose();

	}

	public void setTipoOperacion(int tipoOperacion) {
		// TODO Auto-generated method stub

	}

	public void configurarFormulario() {
		// TODO Auto-generated method stub

	}

	public void cargarDatosInternamiento(Ingreso_Datos_Internamiento obtener) {
		// TODO Auto-generated method stub

	}

	public void limpieza() {
		txtInternamiento.setText("");
		txtPaciente.setText("");
		txtInternamiento.requestFocus();

	}
}
