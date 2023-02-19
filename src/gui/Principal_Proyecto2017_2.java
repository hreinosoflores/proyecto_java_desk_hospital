package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import arreglos.Arreglo_Atencion;
import arreglos.Arreglo_Atencion_Detalle;
import arreglos.Arreglo_Cama;
import arreglos.Arreglo_Internamiento;
import arreglos.Arreglo_Medicina;
import arreglos.Arreglo_Paciente;
import arreglos.Arreglo_Pago;
import libreria.Fecha;
import libreria.lib;

public class Principal_Proyecto2017_2 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel IblFondo;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenu mnInternamiento;
	private JMenu mnAtencion;
	private JMenu mnPago;
	private JMenu mnReporte;
	private JMenuItem mntmCama;
	private JMenuItem mntmMedicina;
	private JMenuItem mntmPaciente;
	private JMenuItem mntmInternamientosPagados;
	private JMenuItem mntmReporteDePacientesInternados;
	private JMenuItem mntmIngresarInternamiento;
	private JMenuItem mntmIngresarAtencion;
	private JMenuItem mntmIngresarPago;
	private JMenuItem mntmReporteDePacientesSalientes;
	private JMenuItem mntmReporteAtenciones;

	public static Arreglo_Cama listaAc = new Arreglo_Cama();
	public static Arreglo_Medicina listaMe = new Arreglo_Medicina();
	public static Arreglo_Paciente listaPa = new Arreglo_Paciente();
	public static Arreglo_Internamiento listaIn = new Arreglo_Internamiento();
	public static Arreglo_Atencion listaAt = new Arreglo_Atencion();
	public static Arreglo_Atencion_Detalle listaAtDet = new Arreglo_Atencion_Detalle();
	public static Arreglo_Pago listaPago = new Arreglo_Pago();

	private int ALTO;
	private int ANCHO;
	private JMenuItem mntmListarPago;

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
		setTitle(titulo());
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Principal_Proyecto2017_2.class.getResource("/Imagenes/medicos.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnArchivo = new JMenu("Archivo");
		mnArchivo.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		menuBar.add(mnArchivo);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(Principal_Proyecto2017_2.class.getResource("/Imagenes/salir.png")));
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);

		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		menuBar.add(mnMantenimiento);

		mntmCama = new JMenuItem("Cama");
		mntmCama.setIcon(new ImageIcon(Principal_Proyecto2017_2.class.getResource("/Imagenes/cama.png")));
		mntmCama.addActionListener(this);
		mnMantenimiento.add(mntmCama);

		mntmMedicina = new JMenuItem("Medicina");
		mntmMedicina.setIcon(new ImageIcon(Principal_Proyecto2017_2.class.getResource("/Imagenes/medicina.png")));
		mntmMedicina.addActionListener(this);
		mnMantenimiento.add(mntmMedicina);

		mntmPaciente = new JMenuItem("Paciente");
		mntmPaciente.setIcon(new ImageIcon(Principal_Proyecto2017_2.class.getResource("/Imagenes/paciente.png")));
		mntmPaciente.addActionListener(this);
		mnMantenimiento.add(mntmPaciente);

		mnInternamiento = new JMenu("Internamiento");
		mnInternamiento.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		menuBar.add(mnInternamiento);

		mntmIngresarInternamiento = new JMenuItem("Ingresar Internamiento");
		mntmIngresarInternamiento.setIcon(
				new ImageIcon(Principal_Proyecto2017_2.class.getResource("/Imagenes/ingresar internamiento.png")));
		mntmIngresarInternamiento.addActionListener(this);
		mnInternamiento.add(mntmIngresarInternamiento);

		mnAtencion = new JMenu("Atencion");
		mnAtencion.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		menuBar.add(mnAtencion);

		mntmIngresarAtencion = new JMenuItem("Ingresar Atencion");
		mntmIngresarAtencion
				.setIcon(new ImageIcon(Principal_Proyecto2017_2.class.getResource("/Imagenes/atencion.png")));
		mntmIngresarAtencion.addActionListener(this);
		mnAtencion.add(mntmIngresarAtencion);

		mnPago = new JMenu("Pago");
		mnPago.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		menuBar.add(mnPago);

		mntmListarPago = new JMenuItem("Lista de Pagos");
		mntmListarPago.setIcon(new ImageIcon(Principal_Proyecto2017_2.class.getResource("/Imagenes/chanchito.png")));
		mntmListarPago.addActionListener(this);
		mnPago.add(mntmListarPago);		
		
		mntmIngresarPago = new JMenuItem("Ingresar Pago");
		mntmIngresarPago.setIcon(new ImageIcon(Principal_Proyecto2017_2.class.getResource("/Imagenes/chanchito.png")));
		mntmIngresarPago.addActionListener(this);
		mnPago.add(mntmIngresarPago);	
		

		mnReporte = new JMenu("Reporte");
		mnReporte.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		menuBar.add(mnReporte);

		mntmReporteDePacientesInternados = new JMenuItem("Reporte de Pacientes Internados");
		mntmReporteDePacientesInternados
				.setIcon(new ImageIcon(Principal_Proyecto2017_2.class.getResource("/Imagenes/paciente internado.png")));
		mntmReporteDePacientesInternados.addActionListener(this);

		mntmReporteAtenciones = new JMenuItem("Reporte Atenciones");
		mntmReporteAtenciones
				.setIcon(new ImageIcon(Principal_Proyecto2017_2.class.getResource("/Imagenes/reporte atencion.png")));
		mntmReporteAtenciones.addActionListener(this);
		mnReporte.add(mntmReporteAtenciones);

		mntmInternamientosPagados = new JMenuItem("Reporte Internamientos Pagados");
		mntmInternamientosPagados
				.setIcon(new ImageIcon(Principal_Proyecto2017_2.class.getResource("/Imagenes/reporte pagos.png")));
		mnReporte.add(mntmInternamientosPagados);
		mntmInternamientosPagados.addActionListener(this);
		mnReporte.add(mntmReporteDePacientesInternados);

		mntmReporteDePacientesSalientes = new JMenuItem("Reporte de Pacientes Salientes");
		mntmReporteDePacientesSalientes
				.setIcon(new ImageIcon(Principal_Proyecto2017_2.class.getResource("/Imagenes/paciente salida.png")));
		mntmReporteDePacientesSalientes.addActionListener(this);
		mnReporte.add(mntmReporteDePacientesSalientes);

		IblFondo = new JLabel(new ImageIcon(Principal_Proyecto2017_2.class.getResource("/Imagenes/fondo clinica.jpg")));
		IblFondo.setText("");
		IblFondo.setBounds(0, 0, ANCHO, ALTO);
		getContentPane().add(IblFondo);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmReporteAtenciones) {
			actionPerformedMntmReporteAtenciones(arg0);
		}
		if (arg0.getSource() == mntmReporteDePacientesSalientes) {
			actionPerformedMntmReporteDePacientes_1(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
		if (arg0.getSource() == mntmListarPago) {
			actionPerformedMntmListarPago(arg0);
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
		if (arg0.getSource() == mntmReporteDePacientesInternados) {
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
	
	private void actionPerformedMntmListarPago(ActionEvent arg0) {
		DlgPago MnGlobal = new DlgPago();
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
		return lib.mensajeConfirmacion(null, "Desea salir del programa?");
	}

	public String titulo() {
		String fecha = Fecha.fechaHoraActual();
		return "Principal - ( " + Fecha.formatoFecha(Integer.parseInt(fecha.substring(0, 8))) + ", "
				+ Fecha.HH_MM_SS(Integer.parseInt(fecha.substring(8))) + " )";
	}

}
