package gui;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import clases.Cama;
import clases.Internamiento;
import clases.Paciente;
import clases.Reporte_Pacientes;
import libreria.Fecha;

public class DlgReporte_Pacientes_Salientes extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblFechaSalida;
	private JButton btnListar;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnSalir;
	private JButton btnCsv;
	private JComboBox<String> cboDia;
	private JComboBox<String> cboMes;
	private JComboBox<String> cboAnio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgReporte_Pacientes_Salientes dialog = new DlgReporte_Pacientes_Salientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgReporte_Pacientes_Salientes() {
		setTitle("Reporte paciente Salida");
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 600, 500);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(DlgReporte_Pacientes_Salientes.class.getResource("/Imagenes/paciente salida.png")));
		getContentPane().setLayout(null);

		lblFechaSalida = new JLabel("Fecha Salida:");
		lblFechaSalida.setForeground(Color.WHITE);
		lblFechaSalida.setBounds(10, 18, 86, 14);
		getContentPane().add(lblFechaSalida);

		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setIcon(new ImageIcon(DlgReporte_Pacientes_Salientes.class.getResource("/Imagenes/reportar.png")));
		btnListar.setBounds(10, 75, 120, 32);
		getContentPane().add(btnListar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 118, 564, 332);
		getContentPane().add(scrollPane);

		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);

		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(DlgReporte_Pacientes_Salientes.class.getResource("/Imagenes/exit.png")));
		btnSalir.setBounds(170, 75, 120, 32);
		getContentPane().add(btnSalir);

		btnCsv = new JButton("Exportar");
		btnCsv.setIcon(new ImageIcon(DlgReporte_Pacientes_Salientes.class.getResource("/Imagenes/excel.png")));
		btnCsv.setBounds(337, 75, 120, 32);
		getContentPane().add(btnCsv);

		cboDia = new JComboBox<String>();
		cboDia.setBounds(118, 10, 58, 22);
		Fecha.colocarItems(cboDia, 1, 31);
		Fecha.colocarDiaActual(cboDia);
		getContentPane().add(cboDia);

		cboMes = new JComboBox<String>();
		cboMes.setBounds(186, 10, 145, 22);
		Fecha.colocarMeses(cboMes);
		Fecha.colocarMesActual(cboMes);
		getContentPane().add(cboMes);

		cboAnio = new JComboBox<String>();
		cboAnio.setBounds(341, 10, 102, 22);
		Fecha.colocarItems(cboAnio, Fecha.anioActual() - 20, Fecha.anioActual() + 20);
		Fecha.colocarAnioActual(cboAnio);
		getContentPane().add(cboAnio);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnListar) {
			actionPerformedBtnListar(arg0);
		}
	}

	protected void actionPerformedBtnListar(ActionEvent arg0) {

		int fechaSeleccionada = Fecha.getFecha(cboDia, cboMes, cboAnio);

		String reporte = "";
		reporte += "\t\tReporte de pacientes salientes del d\u00eda " + Fecha.dd_mm_aaaa(fechaSeleccionada) + "\n";
		reporte += "Cod.Paciente\tDNIPaciente\tNom.Paciente\t\tApe.Paciente\t\tNum.Cama\tHoraSalida\n";

		Reporte_Pacientes reportePac;
		int cont = 0;
		for (int i = 0; i < Principal_Proyecto2017_2.listaIn.getRowCount(); i++) {
			Internamiento x = Principal_Proyecto2017_2.listaIn.obtener(i);
			if (x.getFechaSalida().equals(fechaSeleccionada + "")) {
				cont++;
				Paciente paciente = Principal_Proyecto2017_2.listaPa.buscar(x.getPaciente().getCodigoPaciente());
				Cama cama = Principal_Proyecto2017_2.listaAc.buscar(x.getCama().getNumeroCama());
				reportePac = new Reporte_Pacientes(paciente.getCodigoPaciente(), paciente.getDni(),
						paciente.getNombres(), paciente.getApellidos(), cama.getNumeroCama(), "", "", "",
						Fecha.HH_MM(Integer.parseInt(x.getHoraSalida())), "");
				reporte += imprimir(reportePac);
			}
		}

		if (cont > 0) {
			txtS.setText(reporte);
		} else {
			txtS.setText("No hay pacientes que salgan ese d\u00eda");
		}
	}

	private String imprimir(Reporte_Pacientes reporte) {
		return reporte.getCodPac() + "\t" + reporte.getDniPac() + "\t" + reporte.getNomPac() + "\t"
				+ reporte.getApePac() + "\t" + reporte.getNumCama() + "\t" + reporte.getHoraSalida() + "\n";
	}

	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}
}
