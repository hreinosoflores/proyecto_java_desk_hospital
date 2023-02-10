package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import libreria.lib;

public class DlgIngreso_Cama extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNumCama;
	private JTextField txtNumCam;
	private JLabel lblCat;
	private JButton btnIngresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgIngreso_Cama dialog = new DlgIngreso_Cama();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DlgIngreso_Cama() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setIconImage(new ImageIcon("imagenes/medicos.png").getImage());
		setTitle("Ingreso Cama");
		setBounds(100, 100, 355, 135);

		getContentPane().setLayout(null);

		lblNumCama = new JLabel("Nro. Cama");
		lblNumCama.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumCama.setBounds(10, 11, 88, 25);
		getContentPane().add(lblNumCama);

		txtNumCam = new JTextField();
		txtNumCam.setBounds(108, 15, 86, 20);
		getContentPane().add(txtNumCam);
		txtNumCam.setColumns(10);

		lblCat = new JLabel("Categoria");
		lblCat.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCat.setBounds(10, 47, 88, 31);
		getContentPane().add(lblCat);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setIcon(new ImageIcon("imagenes/ingresar.png"));
		btnIngresar.setBounds(214, 14, 116, 23);
		getContentPane().add(btnIngresar);

		cboCategoria = new JComboBox();
		cboCategoria.setModel(new DefaultComboBoxModel<String>(lib.tiposdeCategoria));
		cboCategoria.setBounds(108, 58, 86, 20);
		getContentPane().add(cboCategoria);

	}

	public int leerNumCama() {
		return Integer.parseInt(txtNumCam.getText());
	}

	public int leerCategoria() {
		return cboCategoria.getSelectedIndex();
	}

	private JComboBox<String> cboCategoria;

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
	}

	protected void actionPerformedBtnIngresar(ActionEvent arg0) {
		try {
			int numCama = leerNumCama();
			try {
				int cat = leerCategoria();
				clases.Cama x = new clases.Cama(numCama, cat, 0);

				Principal_Proyecto2017_2.ac.adicionar(x);
				DlgCama.listar();
			} catch (Exception e) {
				lib.mensajeError(this, "Ingrese un numero en precio");
			}
		} catch (Exception e) {
			lib.mensajeError(this, "Ingrese un numero de cama");
			txtNumCam.requestFocus();
		}

	}

}
