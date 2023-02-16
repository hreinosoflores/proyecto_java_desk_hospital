package gui;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import clases.Cama;
import clases.Internamiento;
import clases.Paciente;
import libreria.Fecha;
import libreria.lib;

import java.awt.Toolkit;
import javax.swing.JComboBox;
import java.awt.Color;

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
		if (arg0.getSource() == btnImprimir) {
			actionPerformedBtnImprimir(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnGenerar) {
			actionPerformedBtnGenerar(arg0);
		}

	}

	protected void actionPerformedBtnVer(ActionEvent arg0) {
		listar();
	}

	void listar() {
		// Elegir ultimo internamiento atendido del paciente
		Paciente pacSeleccionado = (Paciente) cboPaciente.getSelectedItem();
		Internamiento internamientoActual = Principal_Proyecto2017_2.listaIn
				.buscarInternamientoAtendido(pacSeleccionado.getCodigoPaciente());
		if (internamientoActual == null) {
			lib.mensajeInformacion(this, "El paciente no tiene internamientos pendientes de pagar");
		} else {

			Cama camaInternado = Principal_Proyecto2017_2.listaAc.buscar(internamientoActual.getCama().getNumeroCama());

			String fecSalida = "";
			try {
				fecSalida = Fecha.dd_mm_aaaa(Integer.parseInt(internamientoActual.getFechaSalida()));
			} catch (Exception e) {
				// TODO: handle exception
			}

			String horaSalida = "";
			try {
				horaSalida = Fecha.HH_MM(Integer.parseInt(internamientoActual.getHoraSalida()));
			} catch (Exception e) {
				// TODO: handle exception
			}

			modelo.setRowCount(0);
			Object fila[] = { pacSeleccionado.getCodigoPaciente(), internamientoActual.getCodigoInternamiento(),
					internamientoActual.EstadoDescr(), camaInternado.getNumeroCama(), camaInternado.EstadoDescr(),
					Fecha.dd_mm_aaaa(Integer.parseInt(internamientoActual.getFechaIngreso())),
					Fecha.HH_MM(Integer.parseInt(internamientoActual.getHoraIngreso())), fecSalida, horaSalida, };
			modelo.addRow(fila);
		}

	}

	protected void actionPerformedBtnCobrar(ActionEvent arg0) {

		int codPac = leerCodPaciente();
		int numcam = Principal_Proyecto2017_2.listaIn.buscarPac(codPac).getCama().getNumeroCama();
		String fecha = Fecha.fechaHoraActual();
		Principal_Proyecto2017_2.listaIn.buscarPac(codPac).setFechaSalida(Integer.parseInt(fecha.substring(0, 8)) + "");
		Principal_Proyecto2017_2.listaIn.buscarPac(codPac).setHoraSalida(Integer.parseInt(fecha.substring(8)) + "");
		Principal_Proyecto2017_2.listaAc.buscar(numcam).setEstado(0);
		Principal_Proyecto2017_2.listaIn.buscarPac(codPac).setEstado(1);
		Principal_Proyecto2017_2.listaAt.buscarPac(codPac).setEstado(1);
		listar();
		txtPaciente.setText("");

	}

	protected void actionPerformedBtnGenerar(ActionEvent arg0) {
		int seleccionadoIdx = tblTabla.getSelectedRow();

		if (seleccionadoIdx != -1) {
			int ok = lib.mensajeConfirmacion(this, "\u00bfEst\u00e1 seguro(a) que desea generar el pago?");
			if (ok == 0) {
				
			}
			
		} else {
			lib.mensajeAdvertencia(this, "Debe seleccionar un internamiento");
		}
	}

	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}

	protected void actionPerformedBtnImprimir(ActionEvent arg0) {
		txtS.setText("");
	}

	void imprimir(String s) {
		txtS.append(s + "\n");
	}

}
