package gui;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DlgIngresarPago extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCodigoDePaciente;
	private JButton btnImprimir;
	private JButton btnSalir;
	private JButton btnCobrar;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JTextField txtPaciente;
	private JScrollPane scrollPane_1;
	private JTable tblTabla;
	private DefaultTableModel modelo;
	private JButton btnVer;

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
		getContentPane().setBackground(SystemColor.controlShadow);
		setTitle("Ingreso Pago");
		setIconImage(new ImageIcon("imagenes/medicos.png").getImage());
		setBounds(100, 100, 642, 540);
		getContentPane().setLayout(null);

		lblCodigoDePaciente = new JLabel("Codigo de paciente");
		lblCodigoDePaciente.setBounds(10, 11, 110, 17);
		getContentPane().add(lblCodigoDePaciente);

		btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(374, 8, 116, 23);
		btnImprimir.addActionListener(this);
		btnImprimir.setIcon(new ImageIcon("imagenes/imprimir.png"));
		getContentPane().add(btnImprimir);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(500, 8, 116, 23);
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon("imagenes/exit.png"));
		getContentPane().add(btnSalir);

		btnCobrar = new JButton("Cobrar");
		btnCobrar.setBounds(248, 8, 116, 23);
		btnCobrar.addActionListener(this);
		btnCobrar.setIcon(new ImageIcon("imagenes/grabar.png"));
		getContentPane().add(btnCobrar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 215, 554, 275);
		getContentPane().add(scrollPane);

		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);

		txtPaciente = new JTextField();
		txtPaciente.setBounds(140, 9, 86, 20);
		getContentPane().add(txtPaciente);
		txtPaciente.setColumns(10);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 89, 553, 115);
		getContentPane().add(scrollPane_1);

		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(tblTabla);

		modelo = new DefaultTableModel();
		modelo.addColumn("CodPaciente");
		modelo.addColumn("FechaSalida");
		modelo.addColumn("HoraSalida");
		modelo.addColumn("EstadoCama");
		modelo.addColumn("EstadoInternamiento");
		modelo.addColumn("EstadoAtencion");
		tblTabla.setModel(modelo);

		btnVer = new JButton("ver");
		btnVer.addActionListener(this);
		btnVer.setBounds(10, 39, 89, 23);
		getContentPane().add(btnVer);

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
		if (arg0.getSource() == btnCobrar) {
			actionPerformedBtnCobrar(arg0);
		}

	}

	protected void actionPerformedBtnVer(ActionEvent arg0) {
		listar();
	}

	protected void actionPerformedBtnCobrar(ActionEvent arg0) {
		int codPac = leerCodPaciente();
		int numcam = Principal_Proyecto2017_2.ai.buscarPac(codPac).getNumCama();

		Principal_Proyecto2017_2.ai.buscarPac(codPac).setFechaSalida(Principal_Proyecto2017_2.FechaSistema());
		Principal_Proyecto2017_2.ai.buscarPac(codPac).setHoraSalida(Principal_Proyecto2017_2.HoraSistema());
		Principal_Proyecto2017_2.ac.buscar(numcam).setEstado(0);
		Principal_Proyecto2017_2.ai.buscarPac(codPac).setEstado(1);
		Principal_Proyecto2017_2.at.buscarPac(codPac).setEstado(1);
		listar();
		txtPaciente.setText("");
	}

	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}

	void listar() {
		int codPac = leerCodPaciente();
		String fecSalida = Principal_Proyecto2017_2.ai.buscarPac(codPac).getFechaSalida();
		String horaSalida = Principal_Proyecto2017_2.ai.buscarPac(codPac).getHoraSalida();
		int numcam = Principal_Proyecto2017_2.ai.buscarPac(codPac).getNumCama();
		String estadoCama = Principal_Proyecto2017_2.ac.buscar(numcam).detalleEstado();
		String estadoInternamiento = Principal_Proyecto2017_2.ai.buscarPac(codPac).DetalleEstado();
		String estadoAtencion = Principal_Proyecto2017_2.at.buscarPac(codPac).DetalleAtencion();
		modelo.setRowCount(0);
		Object fila[] = { codPac, fecSalida, horaSalida, numcam, estadoCama, estadoInternamiento, estadoAtencion };
		modelo.addRow(fila);
	}

	protected void actionPerformedBtnImprimir(ActionEvent arg0) {
		txtS.setText("");
	}

	void imprimir(String s) {
		txtS.append(s + "\n");
	}

	int leerCodPaciente() {
		return Integer.parseInt(txtPaciente.getText().trim());
	}

}
