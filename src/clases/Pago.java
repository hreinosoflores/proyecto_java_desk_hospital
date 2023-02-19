package clases;

import java.util.ArrayList;
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

	public void setPagado() {
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

	public String GenerarBoletaString() {
		String texto = "";
		texto += "\tHOSPITAL MN GLOBAL\n";
		texto += "\tAv. Javier Prado Oeste 3456\n";
		texto += "\tPAGO INTERNAMIENTO\n";
		String fecha = Fecha.fechaHoraActual();
		texto += Fecha.dd_mm_aaaa(Integer.parseInt(fecha.substring(0, 8))) + " "
				+ Fecha.HH_MM_SS(Integer.parseInt(fecha.substring(8))) + "\n";
		internamiento = Principal_Proyecto2017_2.listaIn.buscar(internamiento.getCodigoInternamiento());
		Paciente paciente = Principal_Proyecto2017_2.listaPa.buscar(internamiento.getPaciente().getCodigoPaciente());
		texto += "Paciente: " + paciente.getApellidos() + ", " + paciente.getNombres() + "\n";
		texto += "DNI: " + paciente.getDni() + "\n";
		texto += "--------------------------------------------------------------------------------\n";
		texto += "Nro. Internamiento: " + internamiento.getCodigoInternamiento() + "\n";
		Cama camaInternado = Principal_Proyecto2017_2.listaAc.buscar(internamiento.getCama().getNumeroCama());
		double camaPrecio = camaInternado.Precio();
		texto += "Articulo\t Cant\t PU\t Importe\n";
		texto += "Cama " + camaInternado.CategoriaDescr() + "\t 1\t " + lib.formatSoles(camaPrecio) + "\t "
				+ lib.formatSoles(camaPrecio) + "\n";
		// texto += "TOTAL A PAGAR: " + lib.formatSoles(camaPrecio) + "\n";
		texto += "--------------------------------------------------------------------------------\n";
		ArrayList<Atencion> atenciones = Principal_Proyecto2017_2.listaAt
				.listarPorInternamiento(internamiento.getCodigoInternamiento());
		for (Atencion atencion : atenciones) {
			texto += "Nro. Atenci\u00f3n: " + atencion.getCodigoAtencion() + "\n";
			texto += "Articulo\t Cant\t PU\t Importe\n";
			ArrayList<AtencionDetalle> detalles = Principal_Proyecto2017_2.listaAtDet
					.listarPorAtencion(atencion.getCodigoAtencion());
			for (AtencionDetalle detalle : detalles) {
				Medicina med = Principal_Proyecto2017_2.listaMe.buscar(detalle.getMedicina().getCodigoMedicina());
				texto += med.getNombre() + "\t " + detalle.getCantidad() + "\t "
						+ lib.formatSoles(detalle.getPrecioUnitario()) + "\t " + lib.formatSoles(detalle.Subtotal())
						+ "\n";
			}
			texto += "--------------------------------------------------------------------------------\n";
			// texto += "TOTAL A PAGAR: " + lib.formatSoles(atencion.getTotalPagar()) +
			// "\n";
		}
		texto += "TOTAL A PAGAR:\t\t" + lib.formatSoles(getTotalPagado()) + "\n";
		texto += "\tMN GLOBAL AGRADECE SU PREFERENCIA !!";
		return texto;
	}
}
