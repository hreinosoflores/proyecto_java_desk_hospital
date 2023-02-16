package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import clases.Cama;
import clases.Internamiento;
import clases.Paciente;
import libreria.Fecha;
import libreria.lib;

import java.awt.Toolkit;
import javax.swing.JComboBox;

public class DlgIngreso_Datos_Internamiento extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCodPaciente;
	private JLabel lblCodInternamiento;
	private JButton btnCancelar;
	private JButton btnInternar;
	private JTextField txtInternamiento;
	private JComboBox<Paciente> cboPacientes;
	private JLabel lblFecha;
	private JLabel lblHora;
	private JComboBox<String> cboDia;
	private JComboBox<String> cboMes;
	private JComboBox<String> cboAnio;
	private JComboBox<String> cboHora;
	private JComboBox<String> cboMinuto;
	private int tipoOperacion;

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
					DlgIngreso_Datos_Internamiento dialog = new DlgIngreso_Datos_Internamiento();
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
	public DlgIngreso_Datos_Internamiento() {
		setTitle("Ingreso de datos ");
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(DlgIngreso_Datos_Internamiento.class.getResource("/Imagenes/ingresar internamiento.png")));
		getContentPane().setFont(new Font("Cambria", Font.BOLD, 12));
		setResizable(false);
		setBounds(100, 100, 531, 283);
		getContentPane().setLayout(null);

		lblCodInternamiento = new JLabel(Principal_Proyecto2017_2.listaIn.getColumnName(0));
		lblCodInternamiento.setBounds(10, 14, 117, 16);
		getContentPane().add(lblCodInternamiento);

		txtInternamiento = new JTextField(Principal_Proyecto2017_2.listaIn.generarCodigo() + "");
		txtInternamiento.setEditable(false);
		txtInternamiento.setBounds(126, 12, 86, 20);
		txtInternamiento.setColumns(10);
		getContentPane().add(txtInternamiento);

		lblCodPaciente = new JLabel(Principal_Proyecto2017_2.listaIn.getColumnName(1));
		lblCodPaciente.setBounds(10, 81, 86, 14);
		getContentPane().add(lblCodPaciente);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setIcon(new ImageIcon(DlgIngreso_Datos_Internamiento.class.getResource("/Imagenes/exit.png")));
		btnCancelar.setFont(new Font("Cambria", Font.BOLD, 12));
		btnCancelar.setBounds(388, 14, 117, 45);
		getContentPane().add(btnCancelar);

		btnInternar = new JButton("Internar");
		btnInternar.setFont(new Font("Cambria", Font.BOLD, 12));
		btnInternar.setIcon(new ImageIcon(DlgIngreso_Datos_Internamiento.class.getResource("/Imagenes/registrar.png")));
		btnInternar.addActionListener(this);
		btnInternar.setBounds(250, 14, 117, 45);
		getContentPane().add(btnInternar);

		cboPacientes = new JComboBox<Paciente>();
		cboPacientes.setModel(new DefaultComboBoxModel<Paciente>(Principal_Proyecto2017_2.listaPa.RellenarCombo()));
		cboPacientes.setBounds(106, 77, 325, 22);
		getContentPane().add(cboPacientes);

		lblFecha = new JLabel("Fecha Ingreso");
		lblFecha.setBounds(10, 125, 134, 14);
		getContentPane().add(lblFecha);

		lblHora = new JLabel("Hora Ingreso");
		lblHora.setBounds(10, 170, 86, 14);
		getContentPane().add(lblHora);

		cboDia = new JComboBox<String>();
		cboDia.setBounds(106, 125, 58, 22);
		Fecha.colocarItems(cboDia, 1, 31);
		Fecha.colocarDiaActual(cboDia);
		getContentPane().add(cboDia);

		cboMes = new JComboBox<String>();
		cboMes.setBounds(174, 125, 145, 22);
		Fecha.colocarMeses(cboMes);
		Fecha.colocarMesActual(cboMes);
		getContentPane().add(cboMes);

		cboAnio = new JComboBox<String>();
		cboAnio.setBounds(329, 125, 102, 22);
		Fecha.colocarItems(cboAnio, Fecha.anioActual() - 20, Fecha.anioActual() + 20);
		Fecha.colocarAnioActual(cboAnio);
		getContentPane().add(cboAnio);

		cboHora = new JComboBox<String>();
		cboHora.setBounds(106, 162, 58, 22);
		Fecha.colocarItems(cboHora, 0, 23);
		Fecha.colocarHoraActual(cboHora);
		getContentPane().add(cboHora);

		cboMinuto = new JComboBox<String>();
		cboMinuto.setBounds(174, 162, 58, 22);
		Fecha.colocarItems(cboMinuto, 0, 59);
		Fecha.colocarMinutoActual(cboMinuto);
		getContentPane().add(cboMinuto);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnInternar) {
			actionPerformedBtnInternar(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
	}

	protected void actionPerformedBtnInternar(ActionEvent arg0) {

		int ok = lib.mensajeConfirmacion(this, "\u00bfDesea registrar el internamiento?");
		if (ok == 0) {
			// Validar archivo
			if (!Principal_Proyecto2017_2.listaIn.existeArchivo()) {
				Principal_Proyecto2017_2.listaIn.grabarInternamiento();
			}

			try {
				// Ingresar Internamiento
				Paciente pac = (Paciente) cboPacientes.getSelectedItem();
				int codInternamiento, numCama, estado;
				String fechaRegistro, fechaIngreso, horaIngreso, fechaSalida, horaSalida;

				codInternamiento = lib.leerEntero(txtInternamiento);
				if (tipoOperacion == 0)
					numCama = Principal_Proyecto2017_2.listaAc.PrimeraCamaDisponible();
				else
					numCama = Principal_Proyecto2017_2.listaIn.buscar(codInternamiento).getCama().getNumeroCama();
				fechaRegistro = Fecha.fechaHoraActual();
				// TODO: seleccionar fechas
				fechaIngreso = Fecha.getFecha(cboDia, cboMes, cboAnio) + "";
				horaIngreso = Fecha.getHora(cboHora, cboMinuto) + "";
				fechaSalida = "";
				horaSalida = "";
				estado = 0;

				Internamiento nuevo = new Internamiento(codInternamiento, pac, new Cama(numCama, 0, 0), fechaRegistro,
						fechaIngreso, horaIngreso, fechaSalida, horaSalida, estado);

				if (tipoOperacion == 0) {
					Principal_Proyecto2017_2.listaIn.adicionar(nuevo);
					Principal_Proyecto2017_2.listaIn.grabarInternamiento();
					Principal_Proyecto2017_2.listaAc.buscar(numCama).setEstado(1);
					Principal_Proyecto2017_2.listaAc.grabarCama();
				} else {
					Principal_Proyecto2017_2.listaIn
							.modificar(Principal_Proyecto2017_2.listaIn.buscarindice(codInternamiento), nuevo);
					Principal_Proyecto2017_2.listaIn.grabarInternamiento();
				}

				limpieza();

				// Refrescar lista
				DlgInternamiento.listar();
			} catch (Exception e) {
				// TODO: handle exception
				lib.mensajeError(this, "Hubo un error: " + e.getMessage());
			}

		}
	}

	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		dispose();
	}

	public void cargarDatosInternamiento(Internamiento idi) {
		txtInternamiento.setText(idi.getCodigoInternamiento() + "");
		cboPacientes
				.setSelectedIndex(Principal_Proyecto2017_2.listaPa.buscarindice(idi.getPaciente().getCodigoPaciente()));
		Fecha.setFecha(cboDia, cboMes, cboAnio, Integer.parseInt(idi.getFechaIngreso()));
		Fecha.setHora(cboHora, cboMinuto, Integer.parseInt(idi.getHoraIngreso()));
	}

	public int getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(int tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public void limpieza() {
		txtInternamiento.setText("");
		cboPacientes.setSelectedIndex(0);
		cboDia.setSelectedIndex(0);
		cboMes.setSelectedIndex(0);
		cboAnio.setSelectedIndex(0);
		cboHora.setSelectedIndex(0);
		cboMinuto.setSelectedIndex(0);
		// Cerrar ventanita
		dispose();
	}
}
