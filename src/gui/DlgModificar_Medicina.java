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

public class DlgModificar_Medicina extends JDialog implements ActionListener {
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
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (DlgMedicina.seleccionado != null) {
						DlgModificar_Medicina dialog = new DlgModificar_Medicina();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgModificar_Medicina() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setTitle("Modificar Medicina");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(DlgModificar_Medicina.class.getResource("/Imagenes/medicina.png")));
		setBounds(100, 100, 440, 270);
		getContentPane().setLayout(null);

		lblCodMedicina = new JLabel("cod. Medicina:");
		lblCodMedicina.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodMedicina.setBounds(10, 11, 114, 25);
		getContentPane().add(lblCodMedicina);

		txtcod_medicina = new JTextField();
		txtcod_medicina.setEditable(false);
		txtcod_medicina.setColumns(10);
		txtcod_medicina.setBounds(134, 15, 86, 20);
		getContentPane().add(txtcod_medicina);

		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(10, 47, 99, 14);
		getContentPane().add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(134, 46, 86, 20);
		txtNombre.setColumns(10);
		getContentPane().add(txtNombre);

		lblLaboratorio = new JLabel("Laboratorio");
		lblLaboratorio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLaboratorio.setBounds(10, 82, 99, 14);
		getContentPane().add(lblLaboratorio);

		txtLaboratorio = new JTextField();
		txtLaboratorio.setBounds(134, 81, 86, 20);
		txtLaboratorio.setColumns(10);
		getContentPane().add(txtLaboratorio);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecio.setBounds(10, 117, 71, 25);
		getContentPane().add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(134, 121, 86, 20);
		getContentPane().add(txtPrecio);

		lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStock.setBounds(10, 153, 71, 25);
		getContentPane().add(lblStock);

		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(134, 157, 86, 20);
		getContentPane().add(txtStock);

		btnModificar = new JButton("Guardar Cambios");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(DlgModificar_Medicina.class.getResource("/Imagenes/modificar.png")));
		btnModificar.setBounds(285, 14, 129, 47);
		getContentPane().add(btnModificar);

		SetValores();

	}

	private void SetValores() {
		txtcod_medicina.setText(DlgMedicina.seleccionado.getCodigoMedicina() + "");
		txtNombre.setText(DlgMedicina.seleccionado.getNombre() + "");
		txtLaboratorio.setText(DlgMedicina.seleccionado.getLaboratorio() + "");
		txtPrecio.setText(DlgMedicina.seleccionado.getPrecio() + "");
		txtStock.setText(DlgMedicina.seleccionado.getStock() + "");
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
	}

	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		String nom = lib.leerCadena(txtNombre);
		if (nom.length() == 0) {
			lib.mensajeError(this, "Ingrese nombre");
			txtNombre.requestFocus();
		} else {
			String lab = lib.leerCadena(txtLaboratorio);
			if (lab.length() == 0) {
				lib.mensajeError(this, "Ingrese nombre de laboratorio");
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
								int ok = lib.mensajeConfirmacion(this, "\u00bfDesea actualizar medicina?");
								if (ok == 0) {
									try {
										// Guardar medicina
										int codMedicina = lib.leerEntero(txtcod_medicina);
										Medicina mod = new Medicina(codMedicina, nom, lab, precio, stock);
										Principal_Proyecto2017_2.listaMe.modificar(
												Principal_Proyecto2017_2.listaMe.buscarindice(codMedicina), mod);
										Principal_Proyecto2017_2.listaMe.grabarMedicina();
										// Cerrar ventanita
										dispose();
										// Refrescar lista
										DlgMedicina.listar();
									} catch (Exception e) {
										lib.mensajeError(this, "Hubo un error: " + e.getMessage());
									}
								} else {
									// Cerrar ventanita
									dispose();
								}

							}
						} catch (Exception e) {
							lib.mensajeError(this, "Ingrese numero de stock");
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
