package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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

public class DlgIngreso_Paciente extends JDialog implements ActionListener {
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
	private JButton btnIngresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgIngreso_Paciente dialog = new DlgIngreso_Paciente();
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
	public DlgIngreso_Paciente() {
		getContentPane().setBackground(new Color(218, 165, 32));
		setTitle("Ingreso Paciente");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(DlgIngreso_Paciente.class.getResource("/Imagenes/paciente.png")));
		setBounds(100, 100, 432, 262);
		getContentPane().setLayout(null);

		lblCod_Paciente = new JLabel(Principal_Proyecto2017_2.listaPa.getColumnName(0));
		lblCod_Paciente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCod_Paciente.setBounds(10, 11, 120, 25);
		getContentPane().add(lblCod_Paciente);

		txtPaciente = new JTextField(Principal_Proyecto2017_2.listaPa.generarCodigo() + "");
		txtPaciente.setEditable(false);
		txtPaciente.setBounds(140, 15, 86, 20);
		txtPaciente.setColumns(10);
		getContentPane().add(txtPaciente);

		lblDni = new JLabel(Principal_Proyecto2017_2.listaPa.getColumnName(1));
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDni.setBounds(10, 58, 61, 14);
		getContentPane().add(lblDni);

		txtDni = new JTextField();
		txtDni.setBounds(140, 57, 86, 20);
		txtDni.setColumns(10);
		getContentPane().add(txtDni);

		lblNombre = new JLabel(Principal_Proyecto2017_2.listaPa.getColumnName(3));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(10, 89, 120, 14);
		getContentPane().add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(140, 88, 266, 20);
		txtNombre.setColumns(10);
		getContentPane().add(txtNombre);

		lblApellido = new JLabel(Principal_Proyecto2017_2.listaPa.getColumnName(2));
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido.setBounds(10, 114, 120, 20);
		getContentPane().add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.setBounds(140, 116, 266, 20);
		txtApellido.setColumns(10);
		getContentPane().add(txtApellido);

		lblTelefono = new JLabel(Principal_Proyecto2017_2.listaPa.getColumnName(4));
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefono.setBounds(10, 145, 103, 25);
		getContentPane().add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(140, 149, 115, 20);
		txtTelefono.setColumns(10);
		getContentPane().add(txtTelefono);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setIcon(new ImageIcon(DlgIngreso_Paciente.class.getResource("/Imagenes/ingresar.png")));
		btnIngresar.setBounds(291, 26, 115, 46);
		getContentPane().add(btnIngresar);

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnIngresar) {
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
						int ok = lib.mensajeConfirmacion(this, "\u00bfDesea ingresar nuevo paciente?");
						if (ok == 0) {
							// Validar archivo
							if (!Principal_Proyecto2017_2.listaPa.existeArchivo()) {
								Principal_Proyecto2017_2.listaPa.grabarPaciente();
							}

							try {
								// Ingresar paciente
								Paciente nuevo = new Paciente(lib.leerEntero(txtPaciente), apellidos, nombres,
										lib.leerCadena(txtTelefono), dni);
								Principal_Proyecto2017_2.listaPa.adicionar(nuevo);
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
