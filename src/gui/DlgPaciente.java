package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import clases.Paciente;
import libreria.lib;

import java.awt.Toolkit;
import java.awt.Color;

public class DlgPaciente extends JDialog implements ActionListener {
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
	public static Paciente seleccionado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgPaciente dialog = new DlgPaciente();
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
	public DlgPaciente() {
		getContentPane().setBackground(new Color(218, 165, 32));
		setTitle("Paciente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgPaciente.class.getResource("/Imagenes/paciente.png")));
		setBounds(100, 100, 568, 300);
		getContentPane().setLayout(null);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/Imagenes/ingresar.png")));
		btnIngresar.setBounds(10, 11, 123, 38);
		getContentPane().add(btnIngresar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(148, 11, 123, 38);
		btnModificar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/Imagenes/modificar.png")));
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/Imagenes/eliminar.png")));
		btnEliminar.setBounds(285, 11, 123, 38);
		getContentPane().add(btnEliminar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 529, 189);
		getContentPane().add(scrollPane);

		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		tblTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblTabla);

		modelo = new DefaultTableModel();
		for (int i = 0; i < Principal_Proyecto2017_2.listaPa.getColumnCount(); i++) {
			modelo.addColumn(Principal_Proyecto2017_2.listaPa.getColumnName(i));
		}
		tblTabla.setModel(modelo);
		listar();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
	}

	protected void actionPerformedBtnIngresar(ActionEvent e) {
		DlgIngreso_Paciente dlg = new DlgIngreso_Paciente();
		dlg.setLocationRelativeTo(this);
		dlg.setVisible(true);
	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
		int seleccionadoIdx = tblTabla.getSelectedRow();
		if (seleccionadoIdx != -1) {
			seleccionado = Principal_Proyecto2017_2.listaPa.obtener(seleccionadoIdx);
			DlgModificar_Paciente dlg = new DlgModificar_Paciente();
			dlg.setLocationRelativeTo(this);
			dlg.setVisible(true);
		} else {
			lib.mensajeAdvertencia(this, "Debe seleccionar un paciente");
		}

	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int seleccionadoIdx = tblTabla.getSelectedRow();
		if (seleccionadoIdx != -1) {
			int ok = lib.mensajeConfirmacion(this, "\u00bfDesea eliminar paciente?");
			if (ok == 0) {
				seleccionado = Principal_Proyecto2017_2.listaPa.obtener(seleccionadoIdx);
				Principal_Proyecto2017_2.listaPa.eliminar(seleccionadoIdx);
				Principal_Proyecto2017_2.listaPa.grabarPaciente();
				listar();
			}

		} else {
			lib.mensajeAdvertencia(this, "Debe seleccionar un paciente");
		}
	}

	public static void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < Principal_Proyecto2017_2.listaPa.tamanio(); i++) {
			Object fila[] = {
					Principal_Proyecto2017_2.listaPa.obtener(i).getCodigoPaciente(),
					Principal_Proyecto2017_2.listaPa.obtener(i).getDni(),
					Principal_Proyecto2017_2.listaPa.obtener(i).getApellidos(),
					Principal_Proyecto2017_2.listaPa.obtener(i).getNombres(),
					Principal_Proyecto2017_2.listaPa.obtener(i).getTelefono() };
			modelo.addRow(fila);
		}
		;
	}

}
