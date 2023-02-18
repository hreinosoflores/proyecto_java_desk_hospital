package clases;

import java.util.Iterator;

import gui.Principal_Proyecto2017_2;
import libreria.Fecha;
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

	public void obtenerTotalPagado() {
		double total = 0.0;

		// Obtener precio del internamiento
		internamiento = Principal_Proyecto2017_2.listaIn.buscar(internamiento.getCodigoInternamiento());
		Cama cama = Principal_Proyecto2017_2.listaAc.buscar(internamiento.getCama().getNumeroCama());
		total += cama.Precio();

		// Obtener precio de las atenciones
		for (int i = 0; i < Principal_Proyecto2017_2.listaAt.getRowCount(); i++) {
			Atencion x = Principal_Proyecto2017_2.listaAt.obtener(i);
			if (x.getInternamiento().getCodigoInternamiento() == internamiento.getCodigoInternamiento())
				total += x.getTotalPagar();
		}

		totalPagado = total;
	}

	public String GenerarStringPago() {
		String texto="";
		texto += "         HOSPITAL MN GLOBAL           \n";
		texto += "      Av. Javier Prado Oeste 3456     \n";
		texto += "----------PAGO INTERNAMIENTO----------\n";
		texto += Fecha.fechaHoraActual() + "\n";
		internamiento = Principal_Proyecto2017_2.listaIn.buscar(internamiento.getCodigoInternamiento());
		Paciente paciente = Principal_Proyecto2017_2.listaPa.buscar(internamiento.getPaciente().getCodigoPaciente());
		texto += "Paciente: " + paciente.getApellidos() + ", " + paciente.getNombres() + "\n";
		texto += "DNI: " + paciente.getDni() + "\n";;
		texto += "--------------------------------------\n";
		texto += "Internamiento nro. " + internamiento.getCodigoInternamiento() + "\n";
		
		
		return texto;
	}
}
