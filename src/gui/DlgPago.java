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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
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
import java.awt.Font;

public class DlgPago extends JDialog implements ActionListener {
	/**
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnIngresar;
	private JButton btnImprimir;
	private JButton btnCobrar;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private static DefaultTableModel modelo;
	public static Pago seleccionado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgPago dialog = new DlgPago();
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
	public DlgPago() {
		getContentPane().setBackground(new Color(255, 165, 0));
		setTitle("Pagos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgPago.class.getResource("/Imagenes/chanchito.png")));
		setBounds(100, 100, 750, 400);
		getContentPane().setLayout(null);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Cambria", Font.BOLD, 12));
		btnIngresar.addActionListener(this);
		btnIngresar.setIcon(new ImageIcon(DlgPago.class.getResource("/Imagenes/ingresar.png")));
		btnIngresar.setBounds(10, 11, 123, 38);
		getContentPane().add(btnIngresar);

		btnImprimir = new JButton("Imprimir");
		btnImprimir.setFont(new Font("Cambria", Font.BOLD, 12));
		btnImprimir.addActionListener(this);
		btnImprimir.setIcon(new ImageIcon(DlgPago.class.getResource("/Imagenes/imprimir.png")));
		btnImprimir.setBounds(170, 11, 123, 38);
		getContentPane().add(btnImprimir);

		btnCobrar = new JButton("Cobrar");
		btnCobrar.setFont(new Font("Cambria", Font.BOLD, 12));
		btnCobrar.addActionListener(this);
		btnCobrar.setIcon(new ImageIcon(DlgPago.class.getResource("/Imagenes/chanchito.png")));
		btnCobrar.setBounds(337, 11, 123, 38);
		getContentPane().add(btnCobrar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 714, 289);
		getContentPane().add(scrollPane);

		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		tblTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblTabla);

		modelo = new DefaultTableModel();
		for (int i = 0; i < Principal_Proyecto2017_2.listaPago.getColumnCount(); i++) {
			modelo.addColumn(Principal_Proyecto2017_2.listaPago.getColumnName(i));
		}
		tblTabla.setModel(modelo);
		listar();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnImprimir) {
			actionPerformedBtnImprimir(e);
		}
		if (e.getSource() == btnCobrar) {
			actionPerformedBtnCobrar(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}

	protected void actionPerformedBtnIngresar(ActionEvent e) {
		DlgIngresarPago dlg = new DlgIngresarPago();
		dlg.setLocationRelativeTo(this);
		dlg.setVisible(true);
		dispose();
	}

	protected void actionPerformedBtnImprimir(ActionEvent e) {
		int seleccionadoIdx = tblTabla.getSelectedRow();
		if (seleccionadoIdx != -1) {
			seleccionado = Principal_Proyecto2017_2.listaPago.obtener(seleccionadoIdx);
			JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			// restrict the user to select files of all types
			j.setAcceptAllFileFilterUsed(false);
			// set a title for the dialog
			j.setDialogTitle("Specify a file to save");
			// default file name
			j.setSelectedFile(new File("boleta_" + seleccionado.getCodigoPago() + "_" + Fecha.fechaHoraActual() + ".txt"));
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
					pw = new PrintWriter(new FileWriter(rutaTxt));
					pw.println(seleccionado.GenerarBoletaString());
					pw.close();
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		} else {
			lib.mensajeAdvertencia(this, "Debe seleccionar un pago");
		}
	}

	protected void actionPerformedBtnCobrar(ActionEvent e) {
		int seleccionadoIdx = tblTabla.getSelectedRow();
		if (seleccionadoIdx != -1) {
			seleccionado = Principal_Proyecto2017_2.listaPago.obtener(seleccionadoIdx);
			if(seleccionado.getEstado() != 0) {
				lib.mensajeAdvertencia(this, "Debe seleccionar un pago en estado generado");
			}else {
				int ok = lib.mensajeConfirmacion(this, "\u00bfDesea cobrar el pago generado?");
				if (ok == 0) {
					//Setear cambios
					seleccionado.setEstado(1);
					Internamiento interActual = Principal_Proyecto2017_2.listaIn
							.buscar(seleccionado.getInternamiento().getCodigoInternamiento());
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
							.modificar(Principal_Proyecto2017_2.listaPago.buscarindice(seleccionado.getCodigoPago()), seleccionado);
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
					lib.mensajeInformacion(this, "El pago fue cobrado exitosamente");
					listar();
				}
			}	
		} else {
			lib.mensajeAdvertencia(this, "Debe seleccionar un pago en estado generado");
		}
	}

	public static void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < Principal_Proyecto2017_2.listaPago.getRowCount(); i++) {
			Pago x = Principal_Proyecto2017_2.listaPago.obtener(i);
			Internamiento intern = Principal_Proyecto2017_2.listaIn
					.buscar(x.getInternamiento().getCodigoInternamiento());
			Paciente paciente = Principal_Proyecto2017_2.listaPa.buscar(intern.getPaciente().getCodigoPaciente());
			String codAtenciones = "";
			ArrayList<Atencion> atenciones = Principal_Proyecto2017_2.listaAt
					.listarPorInternamiento(intern.getCodigoInternamiento());
			for (Atencion atencion : atenciones) {
				if (atenciones.indexOf(atencion) == atenciones.size() - 1) {
					codAtenciones += atencion.getCodigoAtencion();
				} else {
					codAtenciones += atencion.getCodigoAtencion() + ", ";
				}
			}

			Object fila[] = { x.getCodigoPago(), paciente.toString(), intern.getCodigoInternamiento(), codAtenciones,
					lib.formatSoles(x.getTotalPagado()), x.EstadoDescr() };
			modelo.addRow(fila);
		}
	}

}
