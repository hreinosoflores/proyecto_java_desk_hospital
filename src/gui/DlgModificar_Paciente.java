package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import clases.Paciente;
import libreria.lib;

public class DlgModificar_Paciente extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCod_Paciente;
	private JTextField txtPaciente;
	private JLabel lblApellido;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JLabel lblDni;
	private JTextField txtDni;
	private JTextField txtApellido;
	private JButton btnModificar;

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
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(DlgModificar_Paciente.class.getResource("/Imagenes/paciente.png")));
		setBounds(100, 100, 446, 337);
		getContentPane().setLayout(null);

		lblCod_Paciente = new JLabel(Principal_Proyecto2017_2.listaPa.getColumnName(0));
		lblCod_Paciente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCod_Paciente.setBounds(10, 28, 105, 25);
		getContentPane().add(lblCod_Paciente);

		txtPaciente = new JTextField();
		txtPaciente.setEditable(false);
		txtPaciente.setBounds(119, 32, 86, 20);
		txtPaciente.setColumns(10);
		getContentPane().add(txtPaciente);

		lblDni = new JLabel(Principal_Proyecto2017_2.listaPa.getColumnName(1));
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDni.setBounds(10, 76, 105, 14);
		getContentPane().add(lblDni);

		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(120, 75, 86, 20);
		getContentPane().add(txtDni);

		lblNombre = new JLabel(Principal_Proyecto2017_2.listaPa.getColumnName(3));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(10, 117, 105, 14);
		getContentPane().add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(119, 116, 278, 20);
		txtNombre.setColumns(10);
		getContentPane().add(txtNombre);

		lblApellido = new JLabel(Principal_Proyecto2017_2.listaPa.getColumnName(2));
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido.setBounds(10, 147, 99, 20);
		getContentPane().add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(119, 149, 278, 20);
		getContentPane().add(txtApellido);

		lblTelefono = new JLabel(Principal_Proyecto2017_2.listaPa.getColumnName(4));
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefono.setBounds(10, 180, 105, 25);
		getContentPane().add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(119, 184, 86, 20);
		getContentPane().add(txtTelefono);

		btnModificar = new JButton("Guardar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(DlgModificar_Paciente.class.getResource("/Imagenes/modificar.png")));
		btnModificar.setBounds(263, 51, 134, 39);
		getContentPane().add(btnModificar);

		SetValores();
	}

	private void SetValores() {
		txtPaciente.setText(DlgPaciente.seleccionado.getCodigoPaciente() + "");
		txtDni.setText(DlgPaciente.seleccionado.getDni() + "");
		txtNombre.setText(DlgPaciente.seleccionado.getNombres() + "");
		txtApellido.setText(DlgPaciente.seleccionado.getApellidos() + "");
		txtTelefono.setText(DlgPaciente.seleccionado.getTelefono() + "");
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnIngresar(arg0);
		}
	}

	protected void actionPerformedBtnIngresar(ActionEvent arg0) {
		String dni = lib.leerCadena(txtDni);
		if (dni.length() == 0 || !Pattern.matches("[0-9]{7,8}", dni)) {
			lib.mensajeError(this, "Ingrese dni con el formato correcto");
			txtDni.requestFocus();
		} else {
			Paciente buscadoDni = Principal_Proyecto2017_2.listaPa.buscarDNI(dni);
			if (buscadoDni != null) {
				lib.mensajeError(this, "El Dni ya está registrado");
			} else {

				String nombres = lib.leerCadena(txtNombre);
				if (nombres.length() == 0) {
					lib.mensajeError(this, "Ingrese nombre");
					txtNombre.requestFocus();
				} else {
					String apellidos = lib.leerCadena(txtApellido);
					if (apellidos.length() == 0) {
						lib.mensajeError(this, "Ingrese apellido");
						txtApellido.requestFocus();
					} else {
						int ok = lib.mensajeConfirmacion(this, "\u00bfDesea actualizar paciente?");
						if (ok == 0) {
							try {
								// Guardar paciente
								int codPaciente = lib.leerEntero(txtPaciente);
								Paciente mod = new Paciente(codPaciente, apellidos, nombres,
										lib.leerCadena(txtTelefono), dni);
								Principal_Proyecto2017_2.listaPa
										.modificar(Principal_Proyecto2017_2.listaPa.buscarindice(codPaciente), mod);
								Principal_Proyecto2017_2.listaPa.grabarPaciente();
								// Cerrar ventanita
								dispose();
								// Refrescar lista
								DlgPaciente.listar();
							} catch (Exception e) {
								// TODO: handle exception
								lib.mensajeError(this, "Hubo un error: " + e.getMessage());
							}

						} else {
							// Cerrar ventanita
							dispose();
						}
					}
				}

			}

		}

	}

}
