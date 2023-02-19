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

import clases.Cama;
import clases.Internamiento;
import clases.Paciente;
import clases.Reporte_Internamiento;
import libreria.Fecha;

import java.awt.Toolkit;
import java.awt.Color;

public class DlgReporte_Internamiento extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JButton btnListar;
	private JScrollPane scrollPane;
	private JButton btnSalir;
	private JTextArea txtS;
	private JButton btnCsv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgReporte_Internamiento dialog = new DlgReporte_Internamiento();
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
	public DlgReporte_Internamiento() {
		setTitle("Internamiento Pagados");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(DlgReporte_Internamiento.class.getResource("/Imagenes/reporte pagos.png")));
		setBounds(100, 100, 600, 300);

		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setIcon(new ImageIcon(DlgReporte_Internamiento.class.getResource("/Imagenes/reportar.png")));
		btnListar.setBounds(10, 9, 120, 32);
		contentPane.add(btnListar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 564, 202);
		contentPane.add(scrollPane);

		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);

		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(DlgReporte_Internamiento.class.getResource("/Imagenes/exit.png")));
		btnSalir.setBounds(189, 9, 120, 32);
		contentPane.add(btnSalir);

		btnCsv = new JButton("Exportar");
		btnCsv.setIcon(new ImageIcon(DlgReporte_Internamiento.class.getResource("/Imagenes/excel.png")));
		btnCsv.setBounds(362, 9, 120, 32);
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
		reporte += "\t\tReporte de internamientos\n";
		reporte += "Cod.Inter.\t Nom.Paciente\t\t\t Cama\t FechaIngreso\t HoraIngreso\t FechaSalida\t HoraSalida\n";
		Reporte_Internamiento reporteInt;
		for (int i = 0; i < Principal_Proyecto2017_2.listaIn.getRowCount(); i++) {
			Internamiento x = Principal_Proyecto2017_2.listaIn.obtener(i);
			if (x.getEstado() == 2) {
				Paciente paciente = Principal_Proyecto2017_2.listaPa.buscar(x.getPaciente().getCodigoPaciente());
				Cama cama = Principal_Proyecto2017_2.listaAc.buscar(x.getCama().getNumeroCama());
				reporteInt = new Reporte_Internamiento(x.getCodigoInternamiento(), paciente.toString(),
						cama.getNumeroCama() + "-" + cama.CategoriaDescr(),
						Fecha.dd_mm_aaaa(Integer.parseInt(x.getFechaIngreso())),
						Fecha.dd_mm_aaaa(Integer.parseInt(x.getFechaSalida())),
						Fecha.HH_MM(Integer.parseInt(x.getHoraIngreso())),					
						Fecha.HH_MM(Integer.parseInt(x.getHoraSalida())));
				reporte += imprimir(reporteInt);
			}
		}

		txtS.setText(reporte);
	}

	private String imprimir(Reporte_Internamiento reporte) {
		return reporte.getCodigoInt() + "\t " + reporte.getNomPac() + "\t " + reporte.getDescCama() + "\t "
				+ reporte.getFechaIngreso() + "\t " + reporte.getHoraIngreso() +"\t " + reporte.getFechaSalida() + "\t "
				+ reporte.getHoraSalida() + "\n";

	}

	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}
}