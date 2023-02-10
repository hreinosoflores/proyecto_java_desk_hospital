package clases;

public class Atencion {
	private int codigoAtencion, codigoPaciente, estado;
	private String fechaAtencion;
	private double totalPagar;

	public Atencion(int codigoAtencion, int codigoPaciente, String fechaAtencion, double totalPagar, int estado) {
		this.codigoAtencion = codigoAtencion;
		this.codigoPaciente = codigoPaciente;
		this.fechaAtencion = fechaAtencion;
		this.totalPagar = totalPagar;
		this.estado = estado;
	}

	public void setCodigoAtencion(int codigoAtencion) {
		this.codigoAtencion = codigoAtencion;
	}

	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
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

	public int getCodigoPaciente() {
		return codigoPaciente;
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

	public String DetalleAtencion() {
		switch (estado) {
		case 0:
			return "Pendiente";
		default:
			return "Pagado";
		}
	}

}
