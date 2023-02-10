package clases;

public class ClaseDetalleAtencion {
	private int codigoAtencion, codigoMedicina, cantidad;
	private double precioUnitario;

	public ClaseDetalleAtencion(int codigoAtencion, int codigoMedicina, int cantidad, double precioUnitario) {
		this.codigoAtencion = codigoAtencion;
		this.codigoMedicina = codigoMedicina;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}

	public void setCodigoAtencion(int codigoAtencion) {
		this.codigoAtencion = codigoAtencion;
	}

	public void setCodigoMedicina(int codigoMedicina) {
		this.codigoMedicina = codigoMedicina;
	}

	public void setcantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setprecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getCodigoAtencion() {
		return codigoAtencion;
	}

	public int getCodigoMedicina() {
		return codigoMedicina;
	}

	public int getcantidad() {
		return cantidad;
	}

	public double getprecioUnitario() {
		return precioUnitario;
	}

	public double Subtotal() {
		return cantidad * precioUnitario;
	}

}
