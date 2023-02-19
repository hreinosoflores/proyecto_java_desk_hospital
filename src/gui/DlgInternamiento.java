package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import clases.Cama;
import libreria.Fecha;
import libreria.lib;

public class DlgInternamiento extends JDialog implements ActionListener, WindowListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnIngresar;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private JButton btnSalir;
	private static DefaultTableModel modelo;
	private static JLabel lblAvisoCamas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgInternamiento dialog = new DlgInternamiento();
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
	public DlgInternamiento() {

		getContentPane().setBackground(SystemColor.textInactiveText);
		addWindowListener(this);
		setResizable(false);
		setTitle("Internamiento");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(DlgInternamiento.class.getResource("/Imagenes/ingresar internamiento.png")));
		setBounds(100, 100, 1024, 768);
		getContentPane().setLayout(null);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Cambria", Font.BOLD, 12));
		btnIngresar.addActionListener(this);
		btnIngresar.setIcon(new ImageIcon(DlgInternamiento.class.getResource("/Imagenes/ingresar.png")));
		btnIngresar.setBounds(10, 31, 123, 38);
		getContentPane().add(btnIngresar);

		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Cambria", Font.BOLD, 12));
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(DlgInternamiento.class.getResource("/Imagenes/exit.png")));
		btnSalir.setBounds(860, 31, 123, 38);
		getContentPane().add(btnSalir);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 973, 625);
		getContentPane().add(scrollPane);

		tblTabla = new JTable();
		tblTabla.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tblTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);

		modelo = new DefaultTableModel();
		for (int i = 0; i < Principal_Proyecto2017_2.listaIn.getColumnCount(); i++) {
			modelo.addColumn(Principal_Proyecto2017_2.listaIn.getColumnName(i));
		}
		tblTabla.setModel(modelo);

		lblAvisoCamas = new JLabel("¡No hay más camas disponibles!");
		lblAvisoCamas.setForeground(new Color(233, 150, 122));
		lblAvisoCamas.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAvisoCamas.setBackground(Color.WHITE);
		lblAvisoCamas.setBounds(387, 31, 330, 38);
		getContentPane().add(lblAvisoCamas);

		listar();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalir(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}

	protected void actionPerformedBtnIngresar(ActionEvent e) {
		int camaDisponible = Principal_Proyecto2017_2.listaAc.PrimeraCamaDisponible();
		if (camaDisponible == -1) {
			lib.mensajeError(this, "No hay camas disponibles para registrar un internamiento");
		} else {
			DlgIngreso_Datos_Internamiento dat = new DlgIngreso_Datos_Internamiento();
			dat.setLocationRelativeTo(this);
			dat.setVisible(true);
		}
	}

	protected void actionPerformedBtnSalir(ActionEvent e) {
		Principal_Proyecto2017_2.listaIn.grabarInternamiento();
		dispose();
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
		Principal_Proyecto2017_2.listaIn.grabarInternamiento();
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
	}

	public static void listar() {
		int camaDisponible = Principal_Proyecto2017_2.listaAc.PrimeraCamaDisponible();
		if (camaDisponible != -1)
			lblAvisoCamas.setVisible(false);
		else
			lblAvisoCamas.setVisible(true);

		modelo.setRowCount(0);

		for (int i = 0; i < Principal_Proyecto2017_2.listaIn.getRowCount(); i++) {

			Cama camaInt = Principal_Proyecto2017_2.listaAc
					.buscar(Principal_Proyecto2017_2.listaIn.obtener(i).getCama().getNumeroCama());

			Object[] fila = { Principal_Proyecto2017_2.listaIn.obtener(i).getCodigoInternamiento(),
					Principal_Proyecto2017_2.listaIn.obtener(i).getPaciente().getCodigoPaciente(),
					camaInt.getNumeroCama(), camaInt.EstadoDescr(),
					Principal_Proyecto2017_2.listaIn.obtener(i).EstadoDescr(),
					Fecha.dd_mm_aaaa(Integer
							.parseInt(Principal_Proyecto2017_2.listaIn.obtener(i).getFechaRegistro().substring(0, 8)))
							+ " "
							+ Fecha.HH_MM_SS(Integer.parseInt(
									Principal_Proyecto2017_2.listaIn.obtener(i).getFechaRegistro().substring(8))),
					Fecha.dd_mm_aaaa(Integer.parseInt(Principal_Proyecto2017_2.listaIn.obtener(i).getFechaIngreso())),
					Fecha.HH_MM(Integer.parseInt(Principal_Proyecto2017_2.listaIn.obtener(i).getHoraIngreso())),
					Principal_Proyecto2017_2.listaIn.obtener(i).getFechaSalida(),
					Principal_Proyecto2017_2.listaIn.obtener(i).getHoraSalida(),

			};
			modelo.addRow(fila);
		}

	}
}
