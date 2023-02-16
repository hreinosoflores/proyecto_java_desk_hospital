package clases;

import libreria.lib;

public class Pago {
	private int codigoPago;
	private Internamiento internamiento;
	private double totalPagado;
	private int estado;
	public Pago(int codigoPago, Internamiento internamiento, double totalPagado, int estado) {
		this.codigoPago = codigoPago;
		this.internamiento = internamiento;
		this.totalPagado = totalPagado;
		this.estado = estado;
	}
	public int getCodigoPago() {
		return codigoPago;
	}
	public void setCodigoPago(int codigoPago) {
		this.codigoPago = codigoPago;
	}
	public Internamiento getInternamiento() {
		return internamiento;
	}
	public void setInternamiento(Internamiento internamiento) {
		this.internamiento = internamiento;
	}
	public double getTotalPagado() {
		return totalPagado;
	}
	public void setTotalPagado(double totalPagado) {
		this.totalPagado = totalPagado;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public String EstadoDescr() {
		return lib.tiposdeEstadoPago[estado];
	}
}
