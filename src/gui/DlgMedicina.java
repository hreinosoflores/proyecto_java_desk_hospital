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

import clases.Medicina;
import libreria.lib;

import java.awt.Toolkit;;

public class DlgMedicina extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private static DefaultTableModel modelo;
	public static Medicina seleccionado;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgMedicina.class.getResource("/Imagenes/medicina.png")));
		setBounds(100, 100, 568, 300);
		getContentPane().setLayout(null);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setIcon(new ImageIcon(DlgMedicina.class.getResource("/Imagenes/ingresar.png")));
		btnIngresar.setBounds(10, 11, 123, 38);
		getContentPane().add(btnIngresar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(DlgMedicina.class.getResource("/Imagenes/modificar.png")));
		btnModificar.setBounds(148, 11, 123, 38);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(DlgMedicina.class.getResource("/Imagenes/eliminar.png")));
		btnEliminar.setBounds(285, 11, 123, 38);
		getContentPane().add(btnEliminar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 529, 189);
		getContentPane().add(scrollPane);

		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);

		modelo = new DefaultTableModel();
		for (int i = 0; i < Principal_Proyecto2017_2.listaMe.getColumnCount(); i++) {
			modelo.addColumn(Principal_Proyecto2017_2.listaMe.getColumnName(i));
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
		DlgIngreso_Medicina dlg = new DlgIngreso_Medicina();
		dlg.setLocationRelativeTo(this);
		dlg.setVisible(true);
	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
		int seleccionadoIdx = tblTabla.getSelectedRow();
		if (seleccionadoIdx != -1) {
			seleccionado = Principal_Proyecto2017_2.listaMe.obtener(seleccionadoIdx);
			DlgModificar_Medicina dlg = new DlgModificar_Medicina();
			dlg.setLocationRelativeTo(this);
			dlg.setVisible(true);
		} else {
			lib.mensajeAdvertencia(this, "Debe seleccionar una medicina");
		}
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int seleccionadoIdx = tblTabla.getSelectedRow();
		if (seleccionadoIdx != -1) {
			seleccionado = Principal_Proyecto2017_2.listaMe.obtener(seleccionadoIdx);
			Principal_Proyecto2017_2.listaMe.eliminar(seleccionadoIdx);
			listar();
		} else {
			lib.mensajeAdvertencia(this, "Debe seleccionar una medicina");
		}

	}

	public static void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < Principal_Proyecto2017_2.listaMe.tamanio(); i++) {
			Object fila[] = { Principal_Proyecto2017_2.listaMe.obtener(i).getCodigoMedicina(),
					Principal_Proyecto2017_2.listaMe.obtener(i).getNombre(),
					Principal_Proyecto2017_2.listaMe.obtener(i).getLaboratorio(),
					lib.formatSoles(Principal_Proyecto2017_2.listaMe.obtener(i).getPrecio()),
					Principal_Proyecto2017_2.listaMe.obtener(i).getStock() + " unds", };
			modelo.addRow(fila);
		}
	}

}
