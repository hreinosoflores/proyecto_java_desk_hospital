package clases;

public class Ingreso_Datos_Internamiento {
	private int codigoInternamiento, codigoPaciente, numCama, estado;
	private String fechaIngreso, horaIngreso, fechaSalida, horaSalida;

	public Ingreso_Datos_Internamiento(int codigoInternamiento, int codigoPaciente, int numCama, String fechaIngreso,
			String horaIngreso, String fechaSalida, String horaSalida, int estado) {
		this.codigoInternamiento = codigoInternamiento;
		this.codigoPaciente = codigoPaciente;
		this.numCama = numCama;
		this.fechaIngreso = fechaIngreso;
		this.horaIngreso = horaIngreso;
		this.fechaSalida = fechaSalida;
		this.horaSalida = horaSalida;
		this.estado = estado;
	}

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

	public int getNumCama() {
		return numCama;
	}

	public void setNumCama(int numCama) {
		this.numCama = numCama;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(String horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String DetalleEstado() {
		switch (estado) {
		case 0:
			return "Alojado";
		default:
			return "Pagado";
		}
	}

}
