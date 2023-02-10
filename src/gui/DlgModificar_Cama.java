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

public class DlgModificar_Cama extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNumCama;
	private JTextField txtNumCam;
	private JLabel lblCat;
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgModificar_Cama dialog = new DlgModificar_Cama();
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
	public DlgModificar_Cama() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setTitle("Modificar Cama");
		setIconImage(new ImageIcon("imagenes/medicos.png").getImage());
		setBounds(100, 100, 433, 180);
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
		lblCat.setBounds(10, 66, 88, 14);
		getContentPane().add(lblCat);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon("imagenes/ingresar.png"));
		btnModificar.setBounds(262, 14, 126, 23);
		getContentPane().add(btnModificar);

		cboCategoria = new JComboBox<String>();
		cboCategoria.setModel(new DefaultComboBoxModel<String>(lib.tiposdeCategoria));
		cboCategoria.setBounds(108, 65, 86, 20);
		getContentPane().add(cboCategoria);

		lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEstado.setBounds(10, 106, 71, 25);
		getContentPane().add(lblEstado);

		cboEstado = new JComboBox<String>();
		cboEstado.setModel(new DefaultComboBoxModel<String>(lib.tiposdeEstadoCama));
		cboEstado.setBounds(108, 110, 88, 20);
		getContentPane().add(cboEstado);

	}

	private JComboBox<String> cboCategoria;
	private JLabel lblEstado;
	private JComboBox<String> cboEstado;

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
	}

	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		try {
			int numCama = leerNumCama();
			try {

				int Categoria = leerCategoria();
				int estado = leerEstado();
				clases.Cama x = new clases.Cama(numCama, Categoria, estado);
				Principal_Proyecto2017_2.ac.modificar(Principal_Proyecto2017_2.ac.buscarindice(numCama), x);
				DlgCama.listar();
			} catch (Exception e) {
				lib.mensajeError(this, "Ingrese un numero en precio");
			}
		} catch (Exception e) {
			lib.mensajeError(this, "Ingrese un numero de cama");
			txtNumCam.requestFocus();
		}

	}

	public int leerNumCama() {
		return Integer.parseInt(txtNumCam.getText());
	}

	public int leerCategoria() {
		return cboCategoria.getSelectedIndex();
	}

	public int leerEstado() {
		return cboEstado.getSelectedIndex();
	}

}
