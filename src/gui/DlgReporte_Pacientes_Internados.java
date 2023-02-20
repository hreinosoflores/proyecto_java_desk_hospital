package gui;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import clases.Cama;
import clases.Internamiento;
import clases.Paciente;
import clases.Reporte_Pacientes;
import libreria.Fecha;

public class DlgReporte_Pacientes_Internados extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JButton btnListar;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnSalir;
	private JButton btnCsv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgReporte_Pacientes_Internados dialog = new DlgReporte_Pacientes_Internados();
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DlgReporte_Pacientes_Internados() {
		setTitle("Reporte Pacientes Internados");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(DlgReporte_Pacientes_Internados.class.getResource("/Imagenes/paciente internado.png")));
		setBounds(100, 100, 600, 300);

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnListar = new JButton("Listar");
		btnListar.setBounds(10, 11, 120, 32);
		btnListar.addActionListener(this);
		btnListar.setIcon(new ImageIcon(DlgReporte_Pacientes_Internados.class.getResource("/Imagenes/reportar.png")));
		contentPane.add(btnListar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 564, 202);
		contentPane.add(scrollPane);

		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);

		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(DlgReporte_Pacientes_Internados.class.getResource("/Imagenes/exit.png")));
		btnSalir.setBounds(169, 11, 120, 32);
		contentPane.add(btnSalir);

		btnCsv = new JButton("Exportar");
		btnCsv.setIcon(new ImageIcon(DlgReporte_Pacientes_Internados.class.getResource("/Imagenes/excel.png")));
		btnCsv.setBounds(327, 11, 120, 32);
		contentPane.add(btnCsv);

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnListar) {
			actionPerformedBtnListar(arg0);
		}
	}

	private void actionPerformedBtnListar(ActionEvent arg0) {

		String reporte = "";
		reporte += "\t\tReporte de pacientes alojados y/o atendidos\n";
		reporte += "Cod.Paciente\tDNIPaciente\tNom.Paciente\t\tApe.Paciente\t\tNum.Cama\tFechaIngreso\tHoraIngreso\tEstado\n";
		Reporte_Pacientes reportePac;
		for (int i = 0; i < Principal_Proyecto2017_2.listaIn.getRowCount(); i++) {
			Internamiento x = Principal_Proyecto2017_2.listaIn.obtener(i);
			if (x.getEstado() == 0 || x.getEstado() == 1) {
				Paciente paciente = Principal_Proyecto2017_2.listaPa.buscar(x.getPaciente().getCodigoPaciente());
				Cama cama = Principal_Proyecto2017_2.listaAc.buscar(x.getCama().getNumeroCama());
				reportePac = new Reporte_Pacientes(paciente.getCodigoPaciente(), paciente.getDni(),
						paciente.getNombres(), paciente.getApellidos(), cama.getNumeroCama(),
						Fecha.dd_mm_aaaa(Integer.parseInt(x.getFechaIngreso())),
						 "",Fecha.HH_MM(Integer.parseInt(x.getHoraIngreso())), "", x.EstadoDescr());
				reporte += imprimir(reportePac);
			}
		}

		txtS.setText(reporte);

	}

	private String imprimir(Reporte_Pacientes reporte) {
		return reporte.getCodPac() + "\t" + reporte.getDniPac() + "\t" + reporte.getNomPac() + "\t"
				+ reporte.getApePac() + "\t" + reporte.getNumCama() + "\t" + reporte.getFechaIngreso() + "\t"
				+ reporte.getHoraIngreso() + "\t" + reporte.getEstadoInt() + "\n";
	}

	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}

}
