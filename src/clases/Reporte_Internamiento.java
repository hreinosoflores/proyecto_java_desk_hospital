package clases;

public class Reporte_Internamiento {
	private int codigoInternamiento, codigoPaciente, numeroCama;
	private String fechaIngreso, fechaSalida, horaIngreso, horaSalida;
	// contructor

	public Reporte_Internamiento(int codigoInternamiento, int codigoPaciente, int numeroCama, String fechaIngreso,
			String fechaSalida, String horaSalida, String horaIngreso) {

		this.codigoInternamiento = codigoInternamiento;
		this.codigoPaciente = codigoPaciente;
		this.numeroCama = numeroCama;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.horaIngreso = horaIngreso;
		this.horaSalida = horaSalida;

	}

	// metodos set / get
	public void setCodigoInternamiento(int codigoInternamiento) {
		this.codigoInternamiento = codigoInternamiento;
	}

	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}

	public void setnumeroCama(int numeroCama) {
		this.numeroCama = numeroCama;
	}

	public void setfechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public void setfechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getCodigoInternamiento() {
		return codigoInternamiento;
	}

	public int getCodigoPaciente() {
		return codigoPaciente;
	}

	public int getnumeroCama() {
		return numeroCama;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public String getfechaSalida() {
		return fechaSalida;
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
