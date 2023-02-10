package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class DlgInternamiento extends JDialog implements ActionListener, WindowListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnIngresar;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private int tipoOperacion;
	private JButton btnSalir;
	private static DefaultTableModel modelo;

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
		setIconImage(new ImageIcon("imagenes/medicos.png").getImage());
		setBounds(100, 100, 890, 550);
		getContentPane().setLayout(null);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Cambria", Font.BOLD, 12));
		btnIngresar.addActionListener(this);
		btnIngresar.setIcon(new ImageIcon("imagenes/ingresar.png"));
		btnIngresar.setBounds(10, 11, 123, 38);
		getContentPane().add(btnIngresar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 864, 430);
		getContentPane().add(scrollPane);

		tblTabla = new JTable();
		tblTabla.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);

		modelo = new DefaultTableModel();
		modelo.addColumn("CodInternamiento");
		modelo.addColumn("CodPaciente");
		modelo.addColumn("NumCama");
		modelo.addColumn("FechaIngreso");
		modelo.addColumn("HoraIngreso");
		modelo.addColumn("FechaSalida");
		modelo.addColumn("HoraSalida");
		modelo.addColumn("Estado");
		tblTabla.setModel(modelo);

		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Cambria", Font.BOLD, 12));
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon("imagenes/Salir.png"));
		btnSalir.setBounds(751, 11, 123, 38);
		getContentPane().add(btnSalir);
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
		tipoOperacion = 0;
		lanzarFormulario();
	}

	protected void actionPerformedBtnSalir(ActionEvent e) {
		Principal_Proyecto2017_2.ai.grabarInternamiento();
		dispose();
	}

	private String obtenerTitulo() {
		String titulo[] = { "Ingresar", "Modificar" };
		return titulo[tipoOperacion];
	}

	private void lanzarFormulario() {
		DlgIngreso_Datos_Internamiento dat = new DlgIngreso_Datos_Internamiento();
		dat.setTipoOperacion(tipoOperacion);
		dat.setTitle(this.getTitle() + " | " + obtenerTitulo());
		dat.configurarFormulario();
		dat.setLocationRelativeTo(this);
		if (tipoOperacion != 0)
			dat.cargarDatosInternamiento(Principal_Proyecto2017_2.ai.obtener(tblTabla.getSelectedRow()));
		dat.setVisible(true);
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
		Principal_Proyecto2017_2.ai.grabarInternamiento();
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
		modelo.setRowCount(0);
		for (int i = 0; i < Principal_Proyecto2017_2.ai.tamanio(); i++) {
			Object[] fila = { Principal_Proyecto2017_2.ai.obtener(i).getCodigoInternamiento(),
					Principal_Proyecto2017_2.ai.obtener(i).getCodigoPaciente(),
					Principal_Proyecto2017_2.ai.obtener(i).getNumCama(),
					Principal_Proyecto2017_2.ai.obtener(i).getFechaIngreso(),
					Principal_Proyecto2017_2.ai.obtener(i).getHoraIngreso(),
					Principal_Proyecto2017_2.ai.obtener(i).getFechaSalida(),
					Principal_Proyecto2017_2.ai.obtener(i).getHoraSalida(),
					Principal_Proyecto2017_2.ai.obtener(i).DetalleEstado(),

			};
			modelo.addRow(fila);
		}

	}
}
