package clases;

public class Reporte_Internamiento {
	private int codigoInternamiento, codigoPaciente, numeroCama;
	private String fechaIngreso, fechaSalida, horaIngreso, horaSalida;

	// constructor
	public Reporte_Internamiento(int codigoInternamiento, int codigoPaciente, int numeroCama, String fechaIngreso,
			String fechaSalida, String horaIngreso, String horaSalida) {
		super();
		this.codigoInternamiento = codigoInternamiento;
		this.codigoPaciente = codigoPaciente;
		this.numeroCama = numeroCama;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.horaIngreso = horaIngreso;
		this.horaSalida = horaSalida;
	}

	// metodos set / get
	public int getCodigoInternamiento() {
		return codigoInternamiento;
	}

	public void setCodigoInternamiento(int codigoInternamiento) {
		this.codigoInternamiento = codigoInternamiento;
	}

	public int getCodigoPaciente() {
		return codigoPaciente;
	}

	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}

	public int getNumeroCama() {
		return numeroCama;
	}

	public void setNumeroCama(int numeroCama) {
		this.numeroCama = numeroCama;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(String horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

}
