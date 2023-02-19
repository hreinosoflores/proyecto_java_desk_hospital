package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import clases.Cama;
import libreria.lib;

public class DlgIngreso_Cama extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNumCama;
	private JTextField txtNumCam;
	private JLabel lblCat;
	private JComboBox<String> cboCategoria;
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
	public DlgIngreso_Cama() {
		getContentPane().setBackground(new Color(0, 128, 128));
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgIngreso_Cama.class.getResource("/Imagenes/cama.png")));
		setTitle("Ingreso Cama");
		setBounds(100, 100, 355, 135);
		getContentPane().setLayout(null);

		lblNumCama = new JLabel(Principal_Proyecto2017_2.listaAc.getColumnName(0));
		lblNumCama.setForeground(new Color(255, 255, 255));
		lblNumCama.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumCama.setBounds(10, 11, 88, 25);
		getContentPane().add(lblNumCama);

		txtNumCam = new JTextField(Principal_Proyecto2017_2.listaAc.generarCodigo() + "");
		txtNumCam.setEditable(false);
		txtNumCam.setBounds(108, 15, 86, 20);
		txtNumCam.setColumns(10);
		getContentPane().add(txtNumCam);

		lblCat = new JLabel(Principal_Proyecto2017_2.listaAc.getColumnName(1));
		lblCat.setForeground(new Color(255, 255, 255));
		lblCat.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCat.setBounds(10, 47, 88, 31);
		getContentPane().add(lblCat);

		cboCategoria = new JComboBox<String>();
		cboCategoria.setModel(new DefaultComboBoxModel<String>(lib.tiposdeCategoria));
		cboCategoria.setBounds(108, 58, 86, 20);
		getContentPane().add(cboCategoria);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setIcon(new ImageIcon(DlgIngreso_Cama.class.getResource("/Imagenes/ingresar.png")));
		btnIngresar.setBounds(214, 14, 116, 39);
		getContentPane().add(btnIngresar);

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
	}

	protected void actionPerformedBtnIngresar(ActionEvent arg0) {
		int ok = lib.mensajeConfirmacion(this, "\u00bfDesea ingresar nueva cama?");
		if (ok == 0) {
			// Validar archivo
			if (!Principal_Proyecto2017_2.listaAc.existeArchivo()) {
				Principal_Proyecto2017_2.listaAc.grabarCama();
			}

			try {
				// Ingresar cama
				Cama nuevo = new Cama(lib.leerEntero(txtNumCam), cboCategoria.getSelectedIndex(), 0);
				Principal_Proyecto2017_2.listaAc.adicionar(nuevo);
				Principal_Proyecto2017_2.listaAc.grabarCama();
				// Cerrar ventanita
				dispose();
				// Refrescar lista
				DlgCama.listar();
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
