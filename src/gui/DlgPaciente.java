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

public class DlgPaciente extends JDialog implements ActionListener {
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
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setTitle("Paciente");
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
		btnModificar.setBounds(148, 11, 123, 38);
		btnModificar.setIcon(new ImageIcon("imagenes/modificar.png"));
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
		modelo.addColumn("Apellidos");
		modelo.addColumn("Nombre");
		modelo.addColumn("Telefono");
		modelo.addColumn("Dni");
		tblTabla.setModel(modelo);

		listar();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
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
		DlgIngreso_Paciente MnGlobal = new DlgIngreso_Paciente();
		MnGlobal.setLocationRelativeTo(this);
		MnGlobal.setVisible(true);
	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
		DlgModificar_Paciente MnGlobal = new DlgModificar_Paciente();
		MnGlobal.setLocationRelativeTo(this);
		MnGlobal.setVisible(true);

	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		Principal_Proyecto2017_2.ap.eliminar(Principal_Proyecto2017_2.ap.tamanio() - 1);
		listar();
	}

	protected void actionPerformedBtnGrabar(ActionEvent e) {
		if (Principal_Proyecto2017_2.ap.existeArchivo()) {
			int ok = confirmar("� Desea actualizar \"" + Principal_Proyecto2017_2.ap.getArchivo() + "\" ?");
			if (ok == 0) {
				Principal_Proyecto2017_2.ap.grabarPaciente();
				mensaje("\"" + Principal_Proyecto2017_2.ap.getArchivo() + "\" ha sido actualizado");
			} else
				mensaje("No se actualiz�  \"" + Principal_Proyecto2017_2.ap.getArchivo() + "\"");
		} else {
			Principal_Proyecto2017_2.ap.grabarPaciente();
			mensaje("\"" + Principal_Proyecto2017_2.ap.getArchivo() + "\" ha sido creado");
		}
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s);
	}

	public static void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < Principal_Proyecto2017_2.ap.tamanio(); i++) {
			Object fila[] = { Principal_Proyecto2017_2.ap.obtener(i).getCodigoPaciente(),

					Principal_Proyecto2017_2.ap.obtener(i).getApellidos(),
					Principal_Proyecto2017_2.ap.obtener(i).getNombres(),
					Principal_Proyecto2017_2.ap.obtener(i).getTelefono(),
					Principal_Proyecto2017_2.ap.obtener(i).getDni() };
			modelo.addRow(fila);
		}
		;
	}

}
