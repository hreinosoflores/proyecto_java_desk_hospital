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

import clases.Cama;
import libreria.lib;
import java.awt.Toolkit;

public class DlgModificar_Cama extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNumCama;
	private JTextField txtNumCam;
	private JLabel lblCat;
	private JComboBox<String> cboCategoria;
	private JLabel lblEstado;
	private JComboBox<String> cboEstado;
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (DlgCama.seleccionado != null) {
						DlgModificar_Cama dialog = new DlgModificar_Cama();
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
	public DlgModificar_Cama() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setTitle("Modificar Cama");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(DlgModificar_Cama.class.getResource("/Imagenes/medicos.png")));
		setBounds(100, 100, 433, 180);
		getContentPane().setLayout(null);

		lblNumCama = new JLabel("Nro. Cama");
		lblNumCama.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumCama.setBounds(10, 11, 88, 25);
		getContentPane().add(lblNumCama);

		txtNumCam = new JTextField();
		txtNumCam.setEditable(false);
		txtNumCam.setBounds(108, 15, 86, 20);
		txtNumCam.setColumns(10);
		getContentPane().add(txtNumCam);

		lblCat = new JLabel("Categoria");
		lblCat.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCat.setBounds(10, 66, 88, 14);
		getContentPane().add(lblCat);

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

		btnModificar = new JButton("Guardar Cambios");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(DlgModificar_Cama.class.getResource("/Imagenes/grabar.png")));
		btnModificar.setBounds(226, 14, 162, 38);
		getContentPane().add(btnModificar);

		SetValores();

	}

	private void SetValores() {
		txtNumCam.setText(DlgCama.seleccionado.getNumeroCama() + "");
		cboCategoria.setSelectedIndex(DlgCama.seleccionado.getCategoria());
		cboEstado.setSelectedIndex(DlgCama.seleccionado.getEstado());
	}

	public int leerCategoria() {
		return cboCategoria.getSelectedIndex();
	}

	public int leerEstado() {
		return cboEstado.getSelectedIndex();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
	}

	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		int ok = lib.mensajeConfirmacion(this, "\u00bfDesea actualizar cama?");
		if (ok == 0) {
			try {
				// Guardar cama
				int numCama = lib.leerEntero(txtNumCam);
				Cama mod = new Cama(numCama, leerCategoria(), leerEstado());
				Principal_Proyecto2017_2.listaAc.modificar(Principal_Proyecto2017_2.listaAc.buscarindice(numCama), mod);
				Principal_Proyecto2017_2.listaAc.grabarCama();
				// Cerrar ventanita
				dispose();
				// Refrescar lista
				DlgCama.listar();
			} catch (Exception e) {
				lib.mensajeError(this, "Ingrese un numero de cama");
			}
		} else {
			// Cerrar ventanita
			dispose();
		}
	}

}
