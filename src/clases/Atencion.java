package clases;

import libreria.lib;

public class Atencion {
	
	private int codigoAtencion, estado;
	private Paciente paciente;
	private String fechaAtencion;
	private double totalPagar;

	public Atencion(int codigoAtencion, Paciente paciente, String fechaAtencion, double totalPagar, int estado) {
		this.codigoAtencion = codigoAtencion;
		this.paciente = paciente;
		this.fechaAtencion = fechaAtencion;
		this.totalPagar = totalPagar;
		this.estado = estado;
	}

	public void setCodigoAtencion(int codigoAtencion) {
		this.codigoAtencion = codigoAtencion;
	}



	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void setFechaAtencion(String fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getCodigoAtencion() {
		return codigoAtencion;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public String getFechaAtencion() {
		return fechaAtencion;
	}

	public double getTotalPagar() {
		return totalPagar;
	}

	public int getEstado() {
		return estado;
	}

	public String EstadoDescr() {
		return lib.tiposdeEstadoAtencion[estado];
	}

}
