package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import clases.Atencion;
import clases.Internamiento;
import clases.Paciente;
import clases.Reporte_Atenciones;
import libreria.Fecha;
import libreria.lib;
import java.awt.Toolkit;
import java.awt.Color;

public class DlgReporte_Atenciones extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnListar;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgReporte_Atenciones dialog = new DlgReporte_Atenciones();
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
	public DlgReporte_Atenciones() {
		setTitle("Reporte Atenciones");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(DlgReporte_Atenciones.class.getResource("/Imagenes/reporte atencion.png")));
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setIcon(new ImageIcon(DlgReporte_Atenciones.class.getResource("/Imagenes/reportar.png")));
		btnListar.setBounds(10, 19, 108, 30);
		contentPane.add(btnListar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 564, 190);
		contentPane.add(scrollPane);

		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);

		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(DlgReporte_Atenciones.class.getResource("/Imagenes/exit.png")));
		btnSalir.setBounds(160, 19, 108, 30);
		contentPane.add(btnSalir);

		JButton btnCsv = new JButton("Exportar");
		btnCsv.setIcon(new ImageIcon(DlgReporte_Atenciones.class.getResource("/Imagenes/excel.png")));
		btnCsv.setBounds(301, 19, 108, 30);
		contentPane.add(btnCsv);

	}

	@Override
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
		reporte += "\t\tReporte de atenciones\n";
		reporte += "Cod.Atencion\t PagoAtencion\t Nom.Paciente\t\t Fecha Atencion\t HoraAtencion\n";
		Reporte_Atenciones reporteAte;
		for (int i = 0; i < Principal_Proyecto2017_2.listaAt.getRowCount(); i++) {
			Atencion x = Principal_Proyecto2017_2.listaAt.obtener(i);
			Internamiento intern = Principal_Proyecto2017_2.listaIn
					.buscar(x.getInternamiento().getCodigoInternamiento());
			Paciente paciente = Principal_Proyecto2017_2.listaPa.buscar(intern.getPaciente().getCodigoPaciente());
			reporteAte = new Reporte_Atenciones(x.getCodigoAtencion(), lib.formatSoles(x.getTotalPagar()),
					paciente.toString(), Fecha.dd_mm_aaaa(Integer.parseInt(x.getFechaAtencion().substring(0, 8))),
					Fecha.HH_MM_SS(Integer.parseInt(x.getFechaAtencion().substring(8))));
			reporte += imprimir(reporteAte);
		}

		txtS.setText(reporte);

	}

	private String imprimir(Reporte_Atenciones reporte) {
		return reporte.getCodigoAt() + "\t " + reporte.getTotPag() + "\t " + reporte.getNomPac() + "\t "
				+ reporte.getFechAtenc() + "\t " + reporte.getHoraAtenc() + "\n";
	}

	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}
}