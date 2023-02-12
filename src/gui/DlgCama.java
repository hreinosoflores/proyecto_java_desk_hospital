package gui;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clases.Cama;
import libreria.lib;

public class DlgCama extends JDialog implements ActionListener {
	/**
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private static DefaultTableModel modelo;
	public static Cama seleccionado;

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

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 529, 189);
		getContentPane().add(scrollPane);

		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);

		modelo = new DefaultTableModel();
		for (int i = 0; i < Principal_Proyecto2017_2.listaAc.getColumnCount(); i++) {
			modelo.addColumn(Principal_Proyecto2017_2.listaAc.getColumnName(i));
		}
		tblTabla.setModel(modelo);
		listar();
	}

	public void actionPerformed(ActionEvent e) {
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

	protected void actionPerformedBtnModificar(ActionEvent e) {
		int seleccionadoIdx = tblTabla.getSelectedRow();
		if (seleccionadoIdx != -1) {
			seleccionado = Principal_Proyecto2017_2.listaAc.obtener(seleccionadoIdx);
			DlgModificar_Cama dlg = new DlgModificar_Cama();
			dlg.setLocationRelativeTo(this);
			dlg.setVisible(true);
		} else {
			lib.mensajeAdvertencia(this, "Debe seleccionar una cama");
		}
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int seleccionadoIdx = tblTabla.getSelectedRow();
		if (seleccionadoIdx != -1) {
			seleccionado = Principal_Proyecto2017_2.listaAc.obtener(seleccionadoIdx);
			Principal_Proyecto2017_2.listaAc.eliminar(seleccionadoIdx);
			listar();
		} else {
			lib.mensajeAdvertencia(this, "Debe seleccionar una cama");
		}
	}

	public static void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < Principal_Proyecto2017_2.listaAc.tamanio(); i++) {
			Object fila[] = { Principal_Proyecto2017_2.listaAc.obtener(i).getNumeroCama(),
					Principal_Proyecto2017_2.listaAc.obtener(i).CategoriaDescr(),
					lib.formatSoles(Principal_Proyecto2017_2.listaAc.obtener(i).Precio()),
					Principal_Proyecto2017_2.listaAc.obtener(i).EstadoDescr() };
			modelo.addRow(fila);
		}
	}

}
