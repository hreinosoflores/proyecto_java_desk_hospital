package gui;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DlgCama extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGrabar;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private static DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgCama dialog = new DlgCama();
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
	public DlgCama() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setTitle("Cama");
		setIconImage(new ImageIcon("imagenes/medicos.png").getImage());
		setBounds(100, 100, 568, 300);
		getContentPane().setLayout(null);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setIcon(new ImageIcon("imagenes/ingresar.png"));
		btnIngresar.setBounds(10, 11, 123, 38);
		getContentPane().add(btnIngresar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon("imagenes/modificar.png"));
		btnModificar.setBounds(148, 11, 123, 38);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon("imagenes/eliminar.png"));
		btnEliminar.setBounds(285, 11, 123, 38);
		getContentPane().add(btnEliminar);

		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setIcon(new ImageIcon("imagenes/grabar.png"));
		btnGrabar.setBounds(418, 11, 123, 38);
		getContentPane().add(btnGrabar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 529, 189);
		getContentPane().add(scrollPane);

		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);

		modelo = new DefaultTableModel();
		modelo.addColumn("N� Cama");
		modelo.addColumn("Categoria");
		modelo.addColumn("Precio");
		modelo.addColumn("Estado");
		tblTabla.setModel(modelo);
		DlgCama.listar();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}

	protected void actionPerformedBtnIngresar(ActionEvent e) {
		DlgIngreso_Cama MnGlobal = new DlgIngreso_Cama();

		MnGlobal.setLocationRelativeTo(this);
		MnGlobal.setVisible(true);
	}

	public static void listar() {
		DlgCama.modelo.setRowCount(0);
		for (int i = 0; i < Principal_Proyecto2017_2.ac.tamanio(); i++) {
			Object fila[] = { Principal_Proyecto2017_2.ac.obtener(i).getNumeroCama(),
					Principal_Proyecto2017_2.ac.obtener(i).detalleCategoria(),
					Principal_Proyecto2017_2.ac.obtener(i).Precio(),
					Principal_Proyecto2017_2.ac.obtener(i).detalleEstado() };
			DlgCama.modelo.addRow(fila);
		}
		;
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		Principal_Proyecto2017_2.ac.eliminar(Principal_Proyecto2017_2.ac.tamanio() - 1);
		DlgCama.listar();
	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
		DlgModificar_Cama MnGlobal = new DlgModificar_Cama();
		MnGlobal.setLocationRelativeTo(this);
		MnGlobal.setVisible(true);
	}

	protected void actionPerformedBtnGrabar(ActionEvent e) {
		if (Principal_Proyecto2017_2.ac.existeArchivo()) {
			int ok = confirmar("� Desea actualizar \"" + Principal_Proyecto2017_2.ac.getArchivo() + "\" ?");
			if (ok == 0) {
				Principal_Proyecto2017_2.ac.grabarCama();
				mensaje("\"" + Principal_Proyecto2017_2.ac.getArchivo() + "\" ha sido actualizado");
			} else
				mensaje("No se actualiz�  \"" + Principal_Proyecto2017_2.ac.getArchivo() + "\"");
		} else {
			Principal_Proyecto2017_2.ac.grabarCama();
			mensaje("\"" + Principal_Proyecto2017_2.ac.getArchivo() + "\" ha sido creado");
		}
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s);
	}

}
