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

import libreria.lib;

public class DlgModificar_Paciente extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCod_Paciente;
	private JTextField txtPaciente;
	private JLabel lblApellido;
	@SuppressWarnings("unused")
	private JLabel lbltxtApellido;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JButton btnIngresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgModificar_Paciente dialog = new DlgModificar_Paciente();
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
	public DlgModificar_Paciente() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setTitle("Modificar Paciente");
		setIconImage(new ImageIcon("imagenes/medicos.png").getImage());
		setBounds(100, 100, 446, 337);
		getContentPane().setLayout(null);

		lblCod_Paciente = new JLabel("Cod Paciente");
		lblCod_Paciente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCod_Paciente.setBounds(10, 11, 105, 25);
		getContentPane().add(lblCod_Paciente);

		txtPaciente = new JTextField();
		txtPaciente.setBounds(119, 15, 86, 20);
		getContentPane().add(txtPaciente);
		txtPaciente.setColumns(10);

		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido.setBounds(10, 64, 99, 14);
		getContentPane().add(lblApellido);

		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(10, 111, 105, 14);
		getContentPane().add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(119, 110, 86, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setIcon(new ImageIcon("imagenes/ingresar.png"));
		btnIngresar.setBounds(282, 14, 115, 23);
		getContentPane().add(btnIngresar);

		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefono.setBounds(10, 156, 105, 25);
		getContentPane().add(lblTelefono);

		lblDni = new JLabel("Dni");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDni.setBounds(10, 212, 105, 14);
		getContentPane().add(lblDni);

		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(120, 211, 86, 20);
		getContentPane().add(txtDni);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(119, 63, 86, 20);
		getContentPane().add(txtApellido);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(119, 160, 86, 20);
		getContentPane().add(txtTelefono);

	}

	public int leerPaciente() {
		return Integer.parseInt(txtPaciente.getText());
	}

	public String leerApellido() {
		return (txtApellido.getText());
	}

	public String leerNombre() {
		return (txtNombre.getText());
	}

	public String leerTelefono() {
		return (txtTelefono.getText());
	}

	public String leerDni() {
		return (txtDni.getText());
	}

	private JLabel lblDni;
	@SuppressWarnings("unused")
	private JLabel lblPaciente;
	private JTextField txtDni;
	private JTextField txtApellido;

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
	}

	protected void actionPerformedBtnIngresar(ActionEvent arg0) {
		if (leerApellido().length() == 0) {
			lib.mensajeError(this, "Ingrese apellido");
			txtApellido.requestFocus();
		} else if (leerNombre().length() == 0) {
			lib.mensajeError(this, "Ingrese nombre del paciente");
			txtNombre.requestFocus();
		} else

		if (leerTelefono().length() == 0) {
			lib.mensajeError(this, "Ingrese numero de telefono");
			txtTelefono.requestFocus();
		} else if (leerDni().length() == 0) {
			lib.mensajeError(this, "Ingrese numero de DNI");
			txtDni.requestFocus();
		} else
			try {
				int cod_paciente = leerPaciente();

				clases.Paciente x = new clases.Paciente(cod_paciente, leerApellido(), leerNombre(), leerTelefono(),
						leerDni());
				Principal_Proyecto2017_2.ap.modificar(Principal_Proyecto2017_2.ap.buscarindice(cod_paciente), x);
				DlgPaciente.listar();

			} catch (Exception e) {
				lib.mensajeError(this, "Ingrese codigo del paciente");
			}

	}

}
