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
import javax.swing.table.DefaultTableModel;;

public class DlgMedicina extends JDialog implements ActionListener {
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
					DlgMedicina dialog = new DlgMedicina();
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
	public DlgMedicina() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setTitle("Medicina");
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
		btnGrabar.setBounds(418, 11, 123, 38);
		btnGrabar.setIcon(new ImageIcon("imagenes/grabar.png"));
		getContentPane().add(btnGrabar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 529, 189);
		getContentPane().add(scrollPane);

		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);

		modelo = new DefaultTableModel();
		modelo.addColumn("codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Laboratorio");
		modelo.addColumn("Precio");
		modelo.addColumn("Stock");
		tblTabla.setModel(modelo);
		DlgMedicina.listar();
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
		Dlg_Ingreso_Medicina MnGlobal = new Dlg_Ingreso_Medicina();
		MnGlobal.setLocationRelativeTo(this);
		MnGlobal.setVisible(true);
	}

	public static void listar() {
		DlgMedicina.modelo.setRowCount(0);
		for (int i = 0; i < Principal_Proyecto2017_2.me.tamanio(); i++) {
			Object fila[] = { Principal_Proyecto2017_2.me.obtener(i).getCodigoMedicina(),
					Principal_Proyecto2017_2.me.obtener(i).getNombre(),
					Principal_Proyecto2017_2.me.obtener(i).getLaboratorio(),
					Principal_Proyecto2017_2.me.obtener(i).getPrecio(),
					Principal_Proyecto2017_2.me.obtener(i).getStock(), };
			DlgMedicina.modelo.addRow(fila);
		}
		;
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		Principal_Proyecto2017_2.me.eliminar(Principal_Proyecto2017_2.me.tamanio() - 1);
		DlgMedicina.listar();
	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
		DlgModificar_Medicina MnGlobal = new DlgModificar_Medicina();
		MnGlobal.setLocationRelativeTo(this);
		MnGlobal.setVisible(true);
	}

	protected void actionPerformedBtnGrabar(ActionEvent e) {
		if (Principal_Proyecto2017_2.me.existeArchivo()) {
			int ok = confirmar("� Desea actualizar \"" + Principal_Proyecto2017_2.me.getArchivo() + "\" ?");
			if (ok == 0) {
				Principal_Proyecto2017_2.me.grabarMedicina();
				mensaje("\"" + Principal_Proyecto2017_2.me.getArchivo() + "\" ha sido actualizado");
			} else
				mensaje("No se actualiz�  \"" + Principal_Proyecto2017_2.me.getArchivo() + "\"");
		} else {
			Principal_Proyecto2017_2.me.grabarMedicina();
			mensaje("\"" + Principal_Proyecto2017_2.me.getArchivo() + "\" ha sido creado");
		}
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s);
	}

}
