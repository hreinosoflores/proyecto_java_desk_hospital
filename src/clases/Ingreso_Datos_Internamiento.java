package clases;

import libreria.lib;

public class Ingreso_Datos_Internamiento {
	private Paciente paciente;
	private Cama cama;
	private int codigoInternamiento, estado;
	private String fechaRegistro,fechaIngreso, horaIngreso, fechaSalida, horaSalida;

	public Ingreso_Datos_Internamiento(Paciente paciente, Cama cama, int codigoInternamiento, int estado,
			String fechaRegistro, String fechaIngreso, String horaIngreso, String fechaSalida, String horaSalida) {
		this.paciente = paciente;
		this.cama = cama;
		this.codigoInternamiento = codigoInternamiento;
		this.estado = estado;
		this.fechaRegistro = fechaRegistro;
		this.fechaIngreso = fechaIngreso;
		this.horaIngreso = horaIngreso;
		this.fechaSalida = fechaSalida;
		this.horaSalida = horaSalida;
	}

	public int getCodigoInternamiento() {
		return codigoInternamiento;
	}

	public void setCodigoInternamiento(int codigoInternamiento) {
		this.codigoInternamiento = codigoInternamiento;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Cama getCama() {
		return cama;
	}

	public void setCama(Cama cama) {
		this.cama = cama;
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

	public String EstadoDescr() {
		return lib.tiposdeEstadoInternamiento[estado];

	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	

}
