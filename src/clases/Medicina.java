package clases;

public class Medicina {
	private int codigoMedicina, stock;
	private String nombre, laboratorio;
	private double precio;

	public Medicina(int codigoMedicina, String nombre, String laboratorio, double precio, int stock) {
		this.codigoMedicina = codigoMedicina;
		this.nombre = nombre;
		this.laboratorio = laboratorio;
		this.precio = precio;
		this.stock = stock;
	}

	public int getCodigoMedicina() {
		return codigoMedicina;
	}

	public void setCodigoMedicina(int codigoMedicina) {
		this.codigoMedicina = codigoMedicina;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombre;
	}

}
