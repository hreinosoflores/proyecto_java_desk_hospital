package clases;

public class AtencionDetalle {
	private Atencion atencion;
	private Medicina medicina;
	private int cantidad;
	private double precioUnitario;

	public AtencionDetalle(Atencion atencion, Medicina medicina, int cantidad, double precioUnitario) {
		this.atencion = atencion;
		this.medicina = medicina;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}

	public Atencion getAtencion() {
		return atencion;
	}

	public void setAtencion(Atencion atencion) {
		this.atencion = atencion;
	}

	public Medicina getMedicina() {
		return medicina;
	}

	public void setMedicina(Medicina medicina) {
		this.medicina = medicina;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public double Subtotal() {
		return cantidad * precioUnitario;
	}

}
