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

import clases.Medicina;
import libreria.lib;
import java.awt.Toolkit;

public class DlgIngreso_Medicina extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCodMedicina;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JLabel lblLaboratorio;
	private JTextField txtLaboratorio;
	private JLabel lblPrecio;
	private JTextField txtcod_medicina;
	private JTextField txtPrecio;
	private JLabel lblStock;
	private JTextField txtStock;
	private JButton btnIngresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgIngreso_Medicina dialog = new DlgIngreso_Medicina();
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
	public DlgIngreso_Medicina() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setTitle("Ingreso Medicina");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(DlgIngreso_Medicina.class.getResource("/Imagenes/medicina.png")));
		setBounds(100, 100, 430, 273);
		getContentPane().setLayout(null);

		lblCodMedicina = new JLabel(Principal_Proyecto2017_2.listaMe.getColumnName(0));
		lblCodMedicina.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodMedicina.setBounds(10, 11, 105, 25);
		getContentPane().add(lblCodMedicina);

		txtcod_medicina = new JTextField(Principal_Proyecto2017_2.listaMe.generarCodigo() + "");
		txtcod_medicina.setEditable(false);
		txtcod_medicina.setColumns(10);
		txtcod_medicina.setBounds(125, 15, 86, 20);
		getContentPane().add(txtcod_medicina);

		lblNombre = new JLabel(Principal_Proyecto2017_2.listaMe.getColumnName(1));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(10, 47, 89, 14);
		getContentPane().add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(125, 46, 154, 20);
		txtNombre.setColumns(10);
		getContentPane().add(txtNombre);

		lblLaboratorio = new JLabel(Principal_Proyecto2017_2.listaMe.getColumnName(2));
		lblLaboratorio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLaboratorio.setBounds(10, 82, 89, 14);
		getContentPane().add(lblLaboratorio);

		txtLaboratorio = new JTextField();
		txtLaboratorio.setBounds(125, 81, 154, 20);
		txtLaboratorio.setColumns(10);
		getContentPane().add(txtLaboratorio);

		lblPrecio = new JLabel(Principal_Proyecto2017_2.listaMe.getColumnName(3));
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecio.setBounds(10, 117, 71, 25);
		getContentPane().add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(125, 121, 86, 20);
		getContentPane().add(txtPrecio);

		lblStock = new JLabel(Principal_Proyecto2017_2.listaMe.getColumnName(4));
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStock.setBounds(10, 153, 71, 25);
		getContentPane().add(lblStock);

		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(125, 152, 86, 20);
		getContentPane().add(txtStock);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setIcon(new ImageIcon(DlgIngreso_Medicina.class.getResource("/Imagenes/ingresar.png")));
		btnIngresar.setBounds(289, 14, 115, 47);
		getContentPane().add(btnIngresar);

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
	}

	protected void actionPerformedBtnIngresar(ActionEvent arg0) {

		String nom = lib.leerCadena(txtNombre);
		if (nom.length() == 0) {
			lib.mensajeError(this, "Ingrese nombre");
			txtNombre.requestFocus();
		} else {
			String lab = lib.leerCadena(txtLaboratorio);
			if (lab.length() == 0) {
				lib.mensajeError(this, "Ingrese laboratorio");
				txtLaboratorio.requestFocus();
			} else {
				try {
					double precio = lib.leerDouble(txtPrecio);
					if (precio <= 0) {
						lib.mensajeError(this, "Ingrese precio positivo");
						txtPrecio.requestFocus();
					} else {
						try {
							int stock = lib.leerEntero(txtStock);
							if (stock <= 0) {
								lib.mensajeError(this, "Ingrese stock positivo");
								txtStock.requestFocus();
							} else {
								int ok = lib.mensajeConfirmacion(this, "\u00bfDesea ingresar nueva medicina?");
								if (ok == 0) {
									// Validar archivo
									if (!Principal_Proyecto2017_2.listaMe.existeArchivo()) {
										Principal_Proyecto2017_2.listaMe.grabarMedicina();
									}

									try {
										// Ingresar medicina
										Medicina nuevo = new Medicina(lib.leerEntero(txtcod_medicina), nom, lab, precio,
												stock);
										Principal_Proyecto2017_2.listaMe.adicionar(nuevo);
										Principal_Proyecto2017_2.listaMe.grabarMedicina();
										// Cerrar ventanita
										dispose();
										// Refrescar lista
										DlgMedicina.listar();
									} catch (Exception e) {
										// TODO: handle exception
										lib.mensajeError(this, "Hubo un error: " + e.getMessage());
									}

								} else {
									// Cerrar ventanita
									dispose();
								}

							}
						} catch (Exception e) {
							lib.mensajeError(this, "Ingrese numero en stock");
							txtStock.requestFocus();
						}
					}
				} catch (Exception e) {
					lib.mensajeError(this, "Ingrese numero en precio");
					txtPrecio.requestFocus();
				}
			}
		}
	}

}
