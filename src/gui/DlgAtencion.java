package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import clases.Atencion;
import clases.ClaseDetalleAtencion;

public class DlgAtencion extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private JButton btnSalir;
	private JLabel lblTotalpagar;
	private JTextField txtTotal;
	private JLabel label;
	private JTextField txtAtencion;
	private JLabel label_1;
	private JTextField txtPaciente;
	private JTextField txtMedicina;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JLabel label_4;
	private JButton btnGrabar;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgAtencion dialog = new DlgAtencion();
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
	public DlgAtencion() {
		getContentPane().setBackground(SystemColor.menu);
		setIconImage(new ImageIcon("imagenes/medicos.png").getImage());
		setResizable(false);
		setTitle("Atencion");
		setBounds(100, 100, 890, 604);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 170, 864, 340);
		getContentPane().add(scrollPane);

		tblTabla = new JTable();
		tblTabla.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane.setViewportView(tblTabla);
		tblTabla.setModel(Principal_Proyecto2017_2.at);
		tblTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);

		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Cambria", Font.BOLD, 12));
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon("imagenes/salir.png"));
		btnSalir.setBounds(751, 113, 123, 38);
		getContentPane().add(btnSalir);

		lblTotalpagar = new JLabel("TotalPagar");
		lblTotalpagar.setBounds(10, 537, 75, 14);
		getContentPane().add(lblTotalpagar);

		txtTotal = new JTextField("0.00");
		txtTotal.setEditable(false);
		txtTotal.setBounds(89, 534, 157, 20);
		getContentPane().add(txtTotal);
		txtTotal.setColumns(10);

		label = new JLabel("Codigo Atencion");
		label.setBounds(10, 67, 97, 14);
		getContentPane().add(label);

		txtAtencion = new JTextField();
		txtAtencion.setColumns(10);
		txtAtencion.setBounds(121, 64, 86, 20);
		getContentPane().add(txtAtencion);

		label_1 = new JLabel("Codigo Paciente");
		label_1.setBounds(10, 98, 97, 14);
		getContentPane().add(label_1);

		txtPaciente = new JTextField();
		txtPaciente.setColumns(10);
		txtPaciente.setBounds(121, 95, 86, 20);
		getContentPane().add(txtPaciente);

		txtMedicina = new JTextField();
		txtMedicina.setColumns(10);
		txtMedicina.setBounds(347, 64, 86, 20);
		getContentPane().add(txtMedicina);

		label_2 = new JLabel("Codigo Medicina");
		label_2.setBounds(241, 67, 97, 14);
		getContentPane().add(label_2);

		label_3 = new JLabel("Precio");
		label_3.setBounds(241, 98, 97, 14);
		getContentPane().add(label_3);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(347, 95, 86, 20);
		getContentPane().add(txtPrecio);

		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(347, 123, 86, 20);
		getContentPane().add(txtCantidad);

		label_4 = new JLabel("Cantidad");
		label_4.setBounds(241, 126, 65, 14);
		getContentPane().add(label_4);

		modelo = new DefaultTableModel();
		modelo.addColumn("CodAtencion");
		modelo.addColumn("CodPaciente");
		modelo.addColumn("CodMedicina");
		modelo.addColumn("Precio");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Subtotal");
		tblTabla.setModel(modelo);

		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(463, 123, 89, 23);
		getContentPane().add(btnGrabar);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(463, 63, 89, 23);
		getContentPane().add(btnIngresar);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalir(e);
		}
	}

	double suma = 0.0;
	private JButton btnIngresar;

	protected void actionPerformedBtnGrabar(ActionEvent e) {
		if (Principal_Proyecto2017_2.at.existeArchivo()) {
			int ok = confirmar("� Desea actualizar \"" + Principal_Proyecto2017_2.at.getArchivo() + "\" ?");
			if (ok == 0) {
				Principal_Proyecto2017_2.at.grabarAtencion();
				mensaje("\"" + Principal_Proyecto2017_2.at.getArchivo() + "\" ha sido actualizado");
			} else
				mensaje("No se actualiz�  \"" + Principal_Proyecto2017_2.at.getArchivo() + "\"");
		} else {
			Principal_Proyecto2017_2.at.grabarAtencion();
			mensaje("\"" + Principal_Proyecto2017_2.at.getArchivo() + "\" ha sido creado");
		}

		if (Principal_Proyecto2017_2.adt.existeArchivo()) {
			int ok = confirmar("� Desea actualizar \"" + Principal_Proyecto2017_2.adt.getArchivo() + "\" ?");
			if (ok == 0) {
				Principal_Proyecto2017_2.adt.grabarDetalleAtencion();
				mensaje("\"" + Principal_Proyecto2017_2.adt.getArchivo() + "\" ha sido actualizado");
			} else
				mensaje("No se actualiz�  \"" + Principal_Proyecto2017_2.adt.getArchivo() + "\"");
		} else {
			Principal_Proyecto2017_2.adt.grabarDetalleAtencion();
			mensaje("\"" + Principal_Proyecto2017_2.adt.getArchivo() + "\" ha sido creado");
		}

	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s);
	}

	protected void actionPerformedBtnSalir(ActionEvent e) {
		dispose();
	}

	int leerCodigoAtencion() {
		return Integer.parseInt(txtAtencion.getText().trim());
	}

	int leerCodigoPaciente() {
		return Integer.parseInt(txtPaciente.getText().trim());
	}

	int leerCodigoMedicina() {
		return Integer.parseInt(txtMedicina.getText().trim());
	}

	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText().trim());
	}

	int leerCantidad() {
		return Integer.parseInt(txtCantidad.getText().trim());
	}

	double leerTotalPagar() {
		return Double.parseDouble(txtTotal.getText().trim());
	}

	double subtotal() {
		return leerPrecio() * leerCantidad();
	}

	void listar() {

		Object fila[] = { leerCodigoAtencion(), leerCodigoPaciente(), leerCodigoMedicina(), leerPrecio(),
				leerCantidad(), subtotal() };
		modelo.addRow(fila);
		txtMedicina.setText("");
		txtPrecio.setText("");
		txtCantidad.setText("");
		txtMedicina.requestFocus();
	}

	protected void actionPerformedBtnIngresar(ActionEvent e) {
		suma += subtotal();
		listar();
		txtTotal.setText("" + suma);

		Atencion nuevaAtencion = new Atencion(leerCodigoAtencion(), leerCodigoPaciente(),
				Principal_Proyecto2017_2.FechaSistema(), leerTotalPagar(), 0);

		ClaseDetalleAtencion nuevaDetalleAtencion = new ClaseDetalleAtencion(leerCodigoAtencion(), leerCodigoMedicina(),
				leerCantidad(), leerPrecio());

		Principal_Proyecto2017_2.at.adicionar(nuevaAtencion);
		Principal_Proyecto2017_2.adt.adicionar(nuevaDetalleAtencion);
	}
}
