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

public class DlgModificar_Medicina extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCodMedicina;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JLabel lblPrecio;
	private JTextField txtLaboratorio;
	private JButton btnIngresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgModificar_Medicina dialog = new DlgModificar_Medicina();
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
	public DlgModificar_Medicina() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setTitle("Modificar Medicina");
		setIconImage(new ImageIcon("imagenes/medicos.png").getImage());
		setBounds(100, 100, 440, 270);
		getContentPane().setLayout(null);

		lblCodMedicina = new JLabel("cod. Medicina:");
		lblCodMedicina.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodMedicina.setBounds(10, 11, 114, 25);
		getContentPane().add(lblCodMedicina);

		txtNombre = new JTextField();
		txtNombre.setBounds(134, 46, 86, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(10, 47, 99, 14);
		getContentPane().add(lblNombre);

		lblPrecio = new JLabel("Laboratorio");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecio.setBounds(10, 82, 99, 14);
		getContentPane().add(lblPrecio);

		txtLaboratorio = new JTextField();
		txtLaboratorio.setBounds(134, 81, 86, 20);
		getContentPane().add(txtLaboratorio);
		txtLaboratorio.setColumns(10);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setIcon(new ImageIcon("imagenes/ingresar.png"));
		btnIngresar.setBounds(302, 14, 112, 23);
		getContentPane().add(btnIngresar);

		lblEstado = new JLabel("Precio");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEstado.setBounds(10, 117, 71, 25);
		getContentPane().add(lblEstado);

		txtcod_medicina = new JTextField();
		txtcod_medicina.setColumns(10);
		txtcod_medicina.setBounds(134, 15, 86, 20);
		getContentPane().add(txtcod_medicina);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(134, 157, 86, 20);
		getContentPane().add(txtPrecio);

		Stock = new JLabel("Stock");
		Stock.setFont(new Font("Tahoma", Font.BOLD, 14));
		Stock.setBounds(10, 153, 71, 25);
		getContentPane().add(Stock);

		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(134, 121, 86, 20);
		getContentPane().add(txtStock);

	}

	public int leerCod_medicina() {
		return Integer.parseInt(txtcod_medicina.getText());
	}

	public String leerNombre() {
		return (txtNombre.getText());
	}

	public String leerLaboratorio() {
		return (txtLaboratorio.getText());
	}

	public int leerPrecio() {
		return Integer.parseInt(txtPrecio.getText());
	}

	public int leerStock() {
		return Integer.parseInt(txtStock.getText());
	}

	private JLabel lblEstado;
	private JTextField txtcod_medicina;
	private JTextField txtPrecio;
	private JLabel Stock;
	private JTextField txtStock;

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
	}

	protected void actionPerformedBtnIngresar(ActionEvent arg0) {

		if (leerNombre().length() == 0) {
			lib.mensajeError(this, "Ingrese nombre");
			txtNombre.requestFocus();
		}

		else

		if (leerLaboratorio().length() == 0) {
			lib.mensajeError(this, "Ingrese nombre de laboratorio");
			txtLaboratorio.requestFocus();
		} else

			try {
				int COD = leerCod_medicina();

				try {
					int precio = leerPrecio();
					try {
						int Stock = leerStock();
						clases.Medicina x = new clases.Medicina(COD, leerNombre(), leerLaboratorio(), precio, Stock);

						Principal_Proyecto2017_2.me.modificar(Principal_Proyecto2017_2.ac.buscarindice(COD), x);
						DlgMedicina.listar();
					} catch (Exception e) {
						lib.mensajeError(this, "Ingrese numero de stock");
					}
				} catch (Exception e) {
					lib.mensajeError(this, "Ingrese precio de medicina");
				}

			} catch (Exception e) {
				lib.mensajeError(this, "Ingrese codigo de medicina en numeros");
			}

	}

}
