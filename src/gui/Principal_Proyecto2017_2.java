package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import arreglos.Arreglo_Paciente;
import arreglos.Arreglo_Atencion;
import arreglos.Arreglo_Cama;
import arreglos.Arreglo_Atencion_Detalle;
import arreglos.Arreglo_Internamiento;
import arreglos.Arreglo_Medicina;

public class Principal_Proyecto2017_2 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel IblFondo;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnNewMenu;
	private JMenu mnInternamiento;
	private JMenu mnAtencion;
	private JMenu mnPago;
	private JMenu mnReporte;
	private JMenuItem mntmCama;
	private JMenuItem mntmMedicina;
	private JMenuItem mntmPaciente;
	private JMenuItem mntmInternamientosPagados;
	private JMenuItem mntmReporteDePacientes;
	private JMenuItem mntmIngresarInternamiento;
	private JMenuItem mntmIngresarAtencion;
	private JMenuItem mntmIngresarPago;

	public static Arreglo_Cama ac = new Arreglo_Cama();
	public static Arreglo_Medicina me = new Arreglo_Medicina();
	public static Arreglo_Paciente ap = new Arreglo_Paciente();
	public static Arreglo_Internamiento ai = new Arreglo_Internamiento();
	public static Arreglo_Atencion at = new Arreglo_Atencion();
	public static Arreglo_Atencion_Detalle adt = new Arreglo_Atencion_Detalle();
	private JMenuItem mntmReporteDePacientes_1;
	private JMenuItem mntmReporteAtenciones;

	private int ALTO;

	private int ANCHO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal_Proyecto2017_2 frame = new Principal_Proyecto2017_2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal_Proyecto2017_2() {
		setResizable(false);
		setTitle("Principal");
		setIconImage(new ImageIcon("imagenes/medicos.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnArchivo = new JMenu("Archivo");
		mnArchivo.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		menuBar.add(mnArchivo);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon("imagenes/salir.png"));
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);

		mnNewMenu = new JMenu("Mantenimiento");
		mnNewMenu.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		menuBar.add(mnNewMenu);

		mntmCama = new JMenuItem("Cama");
		mntmCama.setIcon(new ImageIcon("imagenes/cama.png"));
		mntmCama.addActionListener(this);
		mnNewMenu.add(mntmCama);

		mntmMedicina = new JMenuItem("Medicina");
		mntmMedicina.setIcon(new ImageIcon("imagenes/medicina.png"));
		mntmMedicina.addActionListener(this);
		mnNewMenu.add(mntmMedicina);

		mntmPaciente = new JMenuItem("Paciente");
		mntmPaciente.setIcon(new ImageIcon("imagenes/paciente.png"));
		mntmPaciente.addActionListener(this);
		mnNewMenu.add(mntmPaciente);

		mnInternamiento = new JMenu("Internamiento");
		mnInternamiento.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		menuBar.add(mnInternamiento);

		mntmIngresarInternamiento = new JMenuItem("Ingresar Internamiento");
		mntmIngresarInternamiento.setIcon(new ImageIcon("imagenes/ingresar internamiento.png"));
		mntmIngresarInternamiento.addActionListener(this);
		mnInternamiento.add(mntmIngresarInternamiento);

		mnAtencion = new JMenu("Atencion");
		mnAtencion.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		menuBar.add(mnAtencion);

		mntmIngresarAtencion = new JMenuItem("Ingresar Atencion");
		mntmIngresarAtencion.setIcon(new ImageIcon("imagenes/atencion.png"));
		mntmIngresarAtencion.addActionListener(this);
		mnAtencion.add(mntmIngresarAtencion);

		mnPago = new JMenu("Pago");
		mnPago.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		menuBar.add(mnPago);

		mntmIngresarPago = new JMenuItem("Ingresar Pago");
		mntmIngresarPago.setIcon(new ImageIcon("imagenes/chanchito.png"));
		mntmIngresarPago.addActionListener(this);
		mnPago.add(mntmIngresarPago);

		mnReporte = new JMenu("Reporte");
		mnReporte.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		menuBar.add(mnReporte);

		mntmReporteDePacientes = new JMenuItem("Reporte de Pacientes Internados");
		mntmReporteDePacientes.setIcon(new ImageIcon("imagenes/paciente internado.png"));
		mntmReporteDePacientes.addActionListener(this);

		mntmReporteAtenciones = new JMenuItem("Reporte Atenciones");
		mntmReporteAtenciones.setIcon(new ImageIcon("imagenes/reporte atencion.png"));
		mntmReporteAtenciones.addActionListener(this);
		mnReporte.add(mntmReporteAtenciones);

		mntmInternamientosPagados = new JMenuItem("Reporte Internamientos Pagados");
		mntmInternamientosPagados.setIcon(new ImageIcon("imagenes/reporte pagos.png"));
		mnReporte.add(mntmInternamientosPagados);
		mntmInternamientosPagados.addActionListener(this);
		mnReporte.add(mntmReporteDePacientes);

		mntmReporteDePacientes_1 = new JMenuItem("Reporte de Pacientes Salientes");
		mntmReporteDePacientes_1.setIcon(new ImageIcon("imagenes/paciente salida.png"));
		mntmReporteDePacientes_1.addActionListener(this);
		mnReporte.add(mntmReporteDePacientes_1);
		IblFondo = new JLabel(new ImageIcon("imagenes/fondo clinica.jpg"));
		IblFondo.setText("");
		IblFondo.setVerticalAlignment(SwingConstants.TOP);
		IblFondo.setBounds(0, 0, ANCHO, ALTO);
		getContentPane().add(IblFondo);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmReporteAtenciones) {
			actionPerformedMntmReporteAtenciones(arg0);
		}
		if (arg0.getSource() == mntmReporteDePacientes_1) {
			actionPerformedMntmReporteDePacientes_1(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
		if (arg0.getSource() == mntmIngresarPago) {
			actionPerformedMntmIngresarPago(arg0);
		}
		if (arg0.getSource() == mntmIngresarAtencion) {
			actionPerformedMntmIngresarAtencion(arg0);
		}
		if (arg0.getSource() == mntmIngresarInternamiento) {
			actionPerformedMntmIngresarInternamiento(arg0);
		}
		if (arg0.getSource() == mntmReporteDePacientes) {
			actionPerformedMntmReporteDePacientes(arg0);
		}
		if (arg0.getSource() == mntmInternamientosPagados) {
			actionPerformedMntmInternamientosPagados(arg0);
		}
		if (arg0.getSource() == mntmPaciente) {
			actionPerformedMntmPaciente(arg0);
		}
		if (arg0.getSource() == mntmMedicina) {
			actionPerformedMntmMedicina(arg0);
		}
		if (arg0.getSource() == mntmCama) {
			actionPerformedMntmCama(arg0);
		}
	}

	protected void actionPerformedMntmCama(ActionEvent arg0) {
		DlgCama MnGlobal = new DlgCama();
		MnGlobal.setLocationRelativeTo(this);
		MnGlobal.setVisible(true);
	}

	protected void actionPerformedMntmMedicina(ActionEvent arg0) {
		DlgMedicina MnGlobal = new DlgMedicina();
		MnGlobal.setLocationRelativeTo(this);
		MnGlobal.setVisible(true);
	}

	protected void actionPerformedMntmPaciente(ActionEvent arg0) {
		DlgPaciente MnGlobal = new DlgPaciente();
		MnGlobal.setLocationRelativeTo(this);
		MnGlobal.setVisible(true);
	}

	protected void actionPerformedMntmInternamientosPagados(ActionEvent arg0) {
		DlgReporte_Internamiento MnGlobal = new DlgReporte_Internamiento();
		MnGlobal.setLocationRelativeTo(this);
		MnGlobal.setVisible(true);
	}

	protected void actionPerformedMntmReporteDePacientes(ActionEvent arg0) {
		DlgReporte_Pacientes_Internados MnGlobal = new DlgReporte_Pacientes_Internados();
		MnGlobal.setLocationRelativeTo(this);
		MnGlobal.setVisible(true);
	}

	protected void actionPerformedMntmIngresarInternamiento(ActionEvent arg0) {
		DlgInternamiento MnGlobal = new DlgInternamiento();
		MnGlobal.setLocationRelativeTo(this);
		MnGlobal.setVisible(true);
	}

	protected void actionPerformedMntmIngresarAtencion(ActionEvent arg0) {
		DlgAtencion MnGlobal = new DlgAtencion();
		MnGlobal.setLocationRelativeTo(this);
		MnGlobal.setVisible(true);
	}

	protected void actionPerformedMntmIngresarPago(ActionEvent arg0) {
		DlgIngresarPago MnGlobal = new DlgIngresarPago();
		MnGlobal.setLocationRelativeTo(this);
		MnGlobal.setVisible(true);
	}

	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		int ok = confirmacionDeSalida();
		if (ok == 0)
			System.exit(0);
	}

	protected void actionPerformedMntmReporteDePacientes_1(ActionEvent arg0) {
		DlgReporte_Paciente_Salida MnGlobal = new DlgReporte_Paciente_Salida();
		MnGlobal.setLocationRelativeTo(this);
		MnGlobal.setVisible(true);
	}

	protected void actionPerformedMntmReporteAtenciones(ActionEvent arg0) {
		DlgReporteAtenciones MnGlobal = new DlgReporteAtenciones();
		MnGlobal.setLocationRelativeTo(this);
		MnGlobal.setVisible(true);
	}

	public int confirmacionDeSalida() {
		return JOptionPane.showConfirmDialog(this, "� Desea salir del programa ?", "� >>> Clinica Cibertec �", 0, 3,
				null);
	}

	public static String FechaSistema() {
		String fecha;
		int dd, mm, aa;
		Calendar c = new GregorianCalendar();
		dd = c.get(Calendar.DAY_OF_MONTH);
		mm = c.get(Calendar.MONTH) + 1;
		aa = c.get(Calendar.YEAR);
		fecha = ajustar(dd) + "/" + ajustar(mm) + "/" + aa;
		return fecha;
	}

	public static String HoraSistema() {
		String hora;
		int hh, mn, ss;
		Calendar c = new GregorianCalendar();
		hh = c.get(Calendar.HOUR_OF_DAY);
		mn = c.get(Calendar.MINUTE);
		ss = c.get(Calendar.SECOND);
		hora = ajustar(hh) + ":" + ajustar(mn) + ":" + ajustar(ss);
		return hora;
	}

	public static String ajustar(int numero) {
		return String.format("%02d", numero);
	}

}
