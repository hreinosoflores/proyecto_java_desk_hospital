package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
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
import clases.AtencionDetalle;
import clases.Medicina;
import clases.Paciente;
import libreria.Fecha;
import libreria.lib;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

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
	private JLabel lblCodAtencion;
	private JTextField txtAtencion;
	private JLabel lblPaciente;
	private JLabel lblMedicina;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblCantidad;
	private JButton btnGrabar;
	private JButton btnIngresar;
	private JComboBox<Paciente> cboPaciente;
	private JComboBox<Medicina> cboMedicina;
	private JButton btnEditarPrecio;
	private JSpinner spCantidad;
	private static DefaultTableModel modelo;
	double suma = 0.0;

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
		getContentPane().setBackground(new Color(153, 255, 204));
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgAtencion.class.getResource("/Imagenes/atencion.png")));
		setResizable(false);
		setTitle(" Atenci\u00f3n");
		setBounds(100, 100, 890, 604);
		getContentPane().setLayout(null);

		btnGrabar = new JButton("Grabar");
		btnGrabar.setIcon(new ImageIcon(DlgAtencion.class.getResource("/Imagenes/grabar.png")));
		btnGrabar.setFont(new Font("Cambria", Font.BOLD, 12));
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(543, 492, 123, 38);
		getContentPane().add(btnGrabar);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setIcon(new ImageIcon(DlgAtencion.class.getResource("/Imagenes/ingresar.png")));
		btnIngresar.setFont(new Font("Cambria", Font.BOLD, 12));
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(722, 111, 123, 38);
		getContentPane().add(btnIngresar);

		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Cambria", Font.BOLD, 12));
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(DlgAtencion.class.getResource("/Imagenes/exit.png")));
		btnSalir.setBounds(722, 492, 123, 38);
		getContentPane().add(btnSalir);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 170, 835, 306);
		getContentPane().add(scrollPane);

		tblTabla = new JTable();
		tblTabla.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);

		lblCodAtencion = new JLabel(Principal_Proyecto2017_2.listaAt.getColumnName(0));
		lblCodAtencion.setBounds(10, 26, 97, 14);
		getContentPane().add(lblCodAtencion);

		txtAtencion = new JTextField(Principal_Proyecto2017_2.listaAt.generarCodigo() + "");
		txtAtencion.setEditable(false);
		txtAtencion.setColumns(10);
		txtAtencion.setBounds(133, 22, 86, 20);
		getContentPane().add(txtAtencion);

		lblPaciente = new JLabel(Principal_Proyecto2017_2.listaAt.getColumnName(1));
		lblPaciente.setBounds(10, 81, 97, 14);
		getContentPane().add(lblPaciente);

		cboPaciente = new JComboBox<Paciente>();
		cboPaciente.setModel(new DefaultComboBoxModel<Paciente>(Principal_Proyecto2017_2.listaPa.RellenarCombo()));
		cboPaciente.setBounds(133, 76, 312, 22);
		getContentPane().add(cboPaciente);

		lblMedicina = new JLabel(Principal_Proyecto2017_2.listaAt.getColumnName(4));
		lblMedicina.setBounds(475, 26, 97, 14);
		getContentPane().add(lblMedicina);

		cboMedicina = new JComboBox<Medicina>();
		cboMedicina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setPrecioMedicina();
			}
		});
		cboMedicina.setModel(new DefaultComboBoxModel<Medicina>(Principal_Proyecto2017_2.listaMe.RellenarCombo()));
		cboMedicina.setBounds(563, 22, 245, 22);
		getContentPane().add(cboMedicina);

		lblPrecio = new JLabel(Principal_Proyecto2017_2.listaAt.getColumnName(5));
		lblPrecio.setBounds(475, 74, 97, 14);
		getContentPane().add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setText("0.00");
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(563, 66, 86, 20);
		getContentPane().add(txtPrecio);

		btnEditarPrecio = new JButton("Editar");
		btnEditarPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtPrecio.setEditable(true);
				txtPrecio.requestFocus();
			}
		});
		btnEditarPrecio.setFont(new Font("Cambria", Font.BOLD, 12));
		btnEditarPrecio.setIcon(new ImageIcon(DlgAtencion.class.getResource("/Imagenes/modificar.png")));
		btnEditarPrecio.setBounds(658, 65, 97, 23);
		getContentPane().add(btnEditarPrecio);

		lblCantidad = new JLabel(Principal_Proyecto2017_2.listaAt.getColumnName(6));
		lblCantidad.setBounds(475, 117, 97, 14);
		getContentPane().add(lblCantidad);

		spCantidad = new JSpinner();
		spCantidad.setBounds(563, 111, 86, 20);
		getContentPane().add(spCantidad);

		lblTotalpagar = new JLabel(Principal_Proyecto2017_2.listaAt.getColumnName(7));
		lblTotalpagar.setBounds(10, 505, 75, 14);
		getContentPane().add(lblTotalpagar);

		txtTotal = new JTextField(lib.formatSoles(suma));
		txtTotal.setEditable(false);
		txtTotal.setBounds(89, 502, 157, 20);
		txtTotal.setColumns(10);
		getContentPane().add(txtTotal);

		modelo = new DefaultTableModel();
		for (int i = 0; i < Principal_Proyecto2017_2.listaAtDet.getColumnCount(); i++) {
			modelo.addColumn(Principal_Proyecto2017_2.listaAtDet.getColumnName(i));
		}
		tblTabla.setModel(modelo);

		setPrecioMedicina();

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

	protected void actionPerformedBtnIngresar(ActionEvent e) {
		int codAtencion = lib.leerEntero(txtAtencion);
		Paciente pacSeleccionado = (Paciente) cboPaciente.getSelectedItem();
		Medicina medSeleccionada = (Medicina) cboMedicina.getSelectedItem();
		try {
			double precio = lib.leerDouble(txtPrecio);
			if (precio <= 0) {
				lib.mensajeError(this, "Ingrese precio positivo");
				txtPrecio.setEditable(true);
				txtPrecio.requestFocus();
			} else {
				try {
					int cantidad = (Integer) spCantidad.getValue();
					if (cantidad <= 0) {
						lib.mensajeError(this, "Ingrese cantidad positiva");
						spCantidad.requestFocus();
					} else {
						Atencion ateActual = new Atencion(codAtencion, pacSeleccionado, Fecha.fechaHoraActual(), 0.0,
								0);
						AtencionDetalle nuevoDetalleAtencion = new AtencionDetalle(ateActual, medSeleccionada, cantidad,
								precio);
						suma += nuevoDetalleAtencion.Subtotal();
						ateActual.setTotalPagar(suma);

						if (tblTabla.getRowCount() == 0) {
							// No cambiar paciente
							cboPaciente.setEnabled(false);
							Principal_Proyecto2017_2.listaAt.adicionar(ateActual);
						} else {
							Principal_Proyecto2017_2.listaAt
									.modificar(Principal_Proyecto2017_2.listaAt.buscarindice(codAtencion), ateActual);
						}

						Principal_Proyecto2017_2.listaAtDet.adicionar(nuevoDetalleAtencion);

						limpiezaDetalle();
						listar();
					}
				} catch (Exception ex) {
					lib.mensajeError(this, "Ingrese numero en cantidad");
					spCantidad.requestFocus();
				}
			}
		} catch (Exception ex) {
			lib.mensajeError(this, "Ingrese numero en precio");
			txtPrecio.setEditable(true);
			txtPrecio.requestFocus();
		}
	}

	public static void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < Principal_Proyecto2017_2.listaAtDet.tamanio(); i++) {
			AtencionDetalle detalle = Principal_Proyecto2017_2.listaAtDet.obtener(i);
			Atencion at = detalle.getAtencion();
			Paciente pa = Principal_Proyecto2017_2.listaPa.buscar(at.getPaciente().getCodigoPaciente());
			Medicina me = Principal_Proyecto2017_2.listaMe.buscar(detalle.getMedicina().getCodigoMedicina());
			String precio = lib.formatSoles(detalle.getPrecioUnitario());
			String cantidad = detalle.getCantidad() + " unds.";
			Object fila[] = { at.getCodigoAtencion(), pa.toString(), me.getNombre(), precio, cantidad,
					lib.formatSoles(detalle.Subtotal()) };
			modelo.addRow(fila);
		}

	}

	public void limpiezaDetalle() {
		cboMedicina.setSelectedIndex(0);
		txtPrecio.setText("0.00");
		txtPrecio.setEditable(false);
		spCantidad.setValue(0);
		txtTotal.setText(lib.formatSoles(suma));
		setPrecioMedicina();
	}

	public void setPrecioMedicina() {
		Medicina sel = (Medicina) cboMedicina.getSelectedItem();
		txtPrecio.setText(sel.getPrecio() + "");
	}

	protected void actionPerformedBtnSalir(ActionEvent e) {
		dispose();
	}

	protected void actionPerformedBtnGrabar(ActionEvent e) {
		if (Principal_Proyecto2017_2.listaAt.existeArchivo()) {
			int ok = confirmar("� Desea actualizar \"" + Principal_Proyecto2017_2.listaAt.getArchivo() + "\" ?");
			if (ok == 0) {
				Principal_Proyecto2017_2.listaAt.grabarAtencion();
				mensaje("\"" + Principal_Proyecto2017_2.listaAt.getArchivo() + "\" ha sido actualizado");
			} else
				mensaje("No se actualiz�  \"" + Principal_Proyecto2017_2.listaAt.getArchivo() + "\"");
		} else {
			Principal_Proyecto2017_2.listaAt.grabarAtencion();
			mensaje("\"" + Principal_Proyecto2017_2.listaAt.getArchivo() + "\" ha sido creado");
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

}
