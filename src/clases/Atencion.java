package clases;

import libreria.lib;

public class Atencion {

	private int codigoAtencion, estado;
	private Internamiento internamiento;
	private String fechaAtencion;
	private double totalPagar;

	public Atencion(int codigoAtencion, Internamiento internamiento, String fechaAtencion, double totalPagar,
			int estado) {
		this.codigoAtencion = codigoAtencion;
		this.estado = estado;
		this.internamiento = internamiento;
		this.fechaAtencion = fechaAtencion;
		this.totalPagar = totalPagar;
	}

	public int getCodigoAtencion() {
		return codigoAtencion;
	}

	public void setCodigoAtencion(int codigoAtencion) {
		this.codigoAtencion = codigoAtencion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Internamiento getInternamiento() {
		return internamiento;
	}

	public void setInternamiento(Internamiento internamiento) {
		this.internamiento = internamiento;
	}

	public String getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(String fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public String EstadoDescr() {
		return lib.tiposdeEstadoAtencion[estado];
	}

}
