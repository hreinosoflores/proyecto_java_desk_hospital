package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

import clases.Atencion;
import clases.Cama;
import clases.Internamiento;
import clases.Paciente;
import clases.Pago;
import libreria.Fecha;
import libreria.lib;

public class DlgIngresarPago extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblPaciente;
	private JButton btnImprimir;
	private JButton btnSalir;
	private JButton btnCobrar;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JScrollPane scrollPane_1;
	private JTable tblTabla;
	private DefaultTableModel modelo;
	private JButton btnVer;
	private JComboBox<Paciente> cboPaciente;
	private JTextField txtTotalPagar;
	private JButton btnGenerar;
	private JLabel lblTotalpagar;
	public int codigoPago;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgIngresarPago dialog = new DlgIngresarPago();
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

	public DlgIngresarPago() {

		getContentPane().setBackground(new Color(255, 165, 0));
		setTitle("Ingreso Pago");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(DlgIngresarPago.class.getResource("/Imagenes/chanchito.png")));
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);

		lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(10, 11, 110, 17);
		getContentPane().add(lblPaciente);

		cboPaciente = new JComboBox<Paciente>();
		cboPaciente.setModel(new DefaultComboBoxModel<Paciente>(Principal_Proyecto2017_2.listaPa.RellenarCombo()));
		cboPaciente.setBounds(69, 8, 349, 22);
		getContentPane().add(cboPaciente);

		btnVer = new JButton("Ver");
		btnVer.setIcon(new ImageIcon(DlgIngresarPago.class.getResource("/Imagenes/generar.png")));
		btnVer.addActionListener(this);
		btnVer.setBounds(10, 57, 110, 39);
		getContentPane().add(btnVer);

		btnCobrar = new JButton("Cobrar");
		btnCobrar.setBounds(658, 492, 116, 38);
		btnCobrar.addActionListener(this);
		btnCobrar.setIcon(new ImageIcon(DlgIngresarPago.class.getResource("/Imagenes/chanchito.png")));
		getContentPane().add(btnCobrar);

		btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(447, 57, 116, 38);
		btnImprimir.addActionListener(this);
		btnImprimir.setIcon(new ImageIcon(DlgIngresarPago.class.getResource("/Imagenes/imprimir.png")));
		getContentPane().add(btnImprimir);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(658, 57, 116, 38);
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(DlgIngresarPago.class.getResource("/Imagenes/exit.png")));
		getContentPane().add(btnSalir);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 228, 764, 248);
		getContentPane().add(scrollPane);

		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 125, 764, 74);
		getContentPane().add(scrollPane_1);

		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(tblTabla);

		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo Paciente");
		modelo.addColumn("Codigo Internamiento");
		modelo.addColumn("Estado Internamiento");
		modelo.addColumn("Nro Cama");
		modelo.addColumn("Estado Cama");
		modelo.addColumn("Fecha Ingreso");
		modelo.addColumn("Hora Ingreso");
		modelo.addColumn("Fecha Salida");
		modelo.addColumn("Hora Salida");
		tblTabla.setModel(modelo);

		btnGenerar = new JButton("Generar Pago");
		btnGenerar.addActionListener(this);
		btnGenerar.setIcon(new ImageIcon(DlgIngresarPago.class.getResource("/Imagenes/registrar.png")));
		btnGenerar.setBounds(185, 57, 169, 39);
		getContentPane().add(btnGenerar);

		lblTotalpagar = new JLabel("Total a pagar");
		lblTotalpagar.setBounds(10, 504, 75, 14);
		getContentPane().add(lblTotalpagar);

		txtTotalPagar = new JTextField("S/. 0.00");
		txtTotalPagar.setEditable(false);
		txtTotalPagar.setColumns(10);
		txtTotalPagar.setBounds(89, 501, 157, 20);
		getContentPane().add(txtTotalPagar);

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnVer) {
			actionPerformedBtnVer(arg0);
		}
		if (arg0.getSource() == btnGenerar) {
			actionPerformedBtnGenerar(arg0);
		}
		if (arg0.getSource() == btnImprimir) {
			actionPerformedBtnImprimir(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnCobrar) {
			actionPerformedBtnCobrar(arg0);
		}

	}

	protected void actionPerformedBtnVer(ActionEvent arg0) {
		listarInternamiento();
	}

	void listarInternamiento() {
		// Elegir ultimo internamiento atendido del paciente
		Paciente pacSeleccionado = (Paciente) cboPaciente.getSelectedItem();
		Internamiento internamientoActual = Principal_Proyecto2017_2.listaIn
				.buscarInternamientoAtendido(pacSeleccionado.getCodigoPaciente());
		if (internamientoActual == null) {
			lib.mensajeInformacion(this, "El paciente no tiene internamientos pendientes de pagar");
		} else {
			Cama camaInternado = Principal_Proyecto2017_2.listaAc.buscar(internamientoActual.getCama().getNumeroCama());
			modelo.setRowCount(0);

			Object fila[] = { pacSeleccionado.getCodigoPaciente(), internamientoActual.getCodigoInternamiento(),
					internamientoActual.EstadoDescr(), camaInternado.getNumeroCama(), camaInternado.EstadoDescr(),
					Fecha.dd_mm_aaaa(Integer.parseInt(internamientoActual.getFechaIngreso())),
					Fecha.HH_MM(Integer.parseInt(internamientoActual.getHoraIngreso())), "", "" };
			modelo.addRow(fila);
		}

	}

	protected void actionPerformedBtnGenerar(ActionEvent arg0) {
		int seleccionadoIdx = tblTabla.getSelectedRow();

		if (seleccionadoIdx != -1) {
			int ok = lib.mensajeConfirmacion(this, "\u00bfEst\u00e1 seguro(a) que desea generar el pago?");
			if (ok == 0) {
				// Validar archivo
				if (!Principal_Proyecto2017_2.listaPago.existeArchivo()) {
					Principal_Proyecto2017_2.listaPago.grabarPago();
				}

				try {
					int codigoInternamiento = (int) tblTabla.getValueAt(seleccionadoIdx, 1);
					// Validar pago internamiento
					Pago buscado = Principal_Proyecto2017_2.listaPago.buscarPorInternamiento(codigoInternamiento);
					if (buscado != null) {
						lib.mensajeError(this, "Ya se tiene un pago generado para este internamiento");
					} else {
						// Ingresar Pago
						codigoPago = Principal_Proyecto2017_2.listaPago.generarCodigo();

						int estado = 0;
						Pago pago = new Pago(codigoPago,
								new Internamiento(codigoInternamiento, null, null, null, null, null, null, null, 0),
								0.0, estado);
						pago.setPagado();
						Principal_Proyecto2017_2.listaPago.adicionar(pago);
						Principal_Proyecto2017_2.listaPago.grabarPago();
						listarInternamiento();
						txtS.setText(pago.GenerarBoletaString());
						txtTotalPagar.setText(lib.formatSoles(pago.getTotalPagado()));
					}
				} catch (Exception e) {
					// TODO: handle exception
					lib.mensajeError(this, "Hubo un error: " + e.getMessage());
				}

			}

		} else {
			lib.mensajeAdvertencia(this, "Debe seleccionar un internamiento");
		}
	}

	protected void actionPerformedBtnImprimir(ActionEvent arg0) {
		if (codigoPago <= 0) {
			lib.mensajeAdvertencia(this, "Todavia no se ha generado un pago");
		} else {
			JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			// restrict the user to select files of all types
			j.setAcceptAllFileFilterUsed(false);
			// set a title for the dialog
			j.setDialogTitle("Specify a file to save");
			// default file name
			j.setSelectedFile(new File("boleta_" + codigoPago + "_" + Fecha.fechaHoraActual() + ".txt"));
			// only allow files of .txt extension
			FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files", "txt");
			j.addChoosableFileFilter(restrict);
			// invoke the showsOpenDialog function to show the save dialog
			int r = j.showSaveDialog(this);
			// if the user selects a file
			if (r == JFileChooser.APPROVE_OPTION) {
				try {
					// set the label to the path of the selected file
					String rutaTxt = j.getSelectedFile().getAbsolutePath();
					PrintWriter pw;
					if (codigoPago <= 0) {
						lib.mensajeAdvertencia(this, "Todavia no se ha generado un pago");
					} else {
						Pago pago = Principal_Proyecto2017_2.listaPago.buscar(codigoPago);
						pw = new PrintWriter(new FileWriter(rutaTxt));
						pw.println(pago.GenerarBoletaString());
						pw.close();
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}

	protected void actionPerformedBtnCobrar(ActionEvent arg0) {
		if (codigoPago <= 0) {
			lib.mensajeAdvertencia(this, "Todavia no se ha generado un pago");
		} else {
			int ok = lib.mensajeConfirmacion(this, "\u00bfDesea cobrar el pago generado?");
			if (ok == 0) {
				
				//Setear cambios
				Pago pagoActual = Principal_Proyecto2017_2.listaPago.buscar(codigoPago);
				pagoActual.setEstado(1);
				Internamiento interActual = Principal_Proyecto2017_2.listaIn
						.buscar(pagoActual.getInternamiento().getCodigoInternamiento());
				String fecha = Fecha.fechaHoraActual();
				interActual.setFechaSalida(fecha.substring(0, 8));
				interActual.setHoraSalida(fecha.substring(8, 12));
				interActual.setEstado(2);
				ArrayList<Atencion> atencionesActuales = Principal_Proyecto2017_2.listaAt
						.listarPorInternamiento(interActual.getCodigoInternamiento());
				for (Atencion atencion : atencionesActuales) {
					atencion.setEstado(1);
				}
				Cama camaActual = Principal_Proyecto2017_2.listaAc.buscar(interActual.getCama().getNumeroCama());
				camaActual.setEstado(0);

				// Grabar Cambios
				Principal_Proyecto2017_2.listaPago
						.modificar(Principal_Proyecto2017_2.listaPago.buscarindice(codigoPago), pagoActual);
				Principal_Proyecto2017_2.listaIn.modificar(
						Principal_Proyecto2017_2.listaIn.buscarindice(interActual.getCodigoInternamiento()),
						interActual);
				for (Atencion atencion : atencionesActuales) {
					Principal_Proyecto2017_2.listaAt.modificar(
							Principal_Proyecto2017_2.listaAt.buscarindice(atencion.getCodigoAtencion()), atencion);
				}
				Principal_Proyecto2017_2.listaAc.modificar(
						Principal_Proyecto2017_2.listaAc.buscarindice(camaActual.getNumeroCama()), camaActual);

				Principal_Proyecto2017_2.listaPago.grabarPago();
				Principal_Proyecto2017_2.listaIn.grabarInternamiento();
				Principal_Proyecto2017_2.listaAt.grabarAtencion();
				Principal_Proyecto2017_2.listaAc.grabarCama();

				//Actualizar Tabla
				tblTabla.removeAll();
				modelo.setRowCount(0);			
				Object fila[] = { interActual.getPaciente().getCodigoPaciente(), interActual.getCodigoInternamiento(),
						interActual.EstadoDescr(), camaActual.getNumeroCama(), camaActual.EstadoDescr(),
						Fecha.dd_mm_aaaa(Integer.parseInt(interActual.getFechaIngreso())),
						Fecha.HH_MM(Integer.parseInt(interActual.getHoraIngreso())), 
						Fecha.dd_mm_aaaa(Integer.parseInt(interActual.getFechaSalida())), 
						Fecha.HH_MM(Integer.parseInt(interActual.getHoraSalida())) };
				modelo.addRow(fila);				

				lib.mensajeInformacion(this, "Los datos se grabaron correctamente");
				dispose();

			}
		}

	}

}
