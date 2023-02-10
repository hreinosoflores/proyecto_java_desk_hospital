package clases;

public class Reporte_Pacientes {

	private int codigo, numCama;
	String fechingreso, nombre, apellido;
	// contructor

	public Reporte_Pacientes(int codigo, int numCama, String fechIngreso, String nombre, String apellido) {

		this.codigo = codigo;
		this.numCama = numCama;
		this.fechingreso = fechIngreso;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	// metodos set / get
	public void setCodigoAT(int codigo) {
		this.codigo = codigo;
	}

	public void setnumCama(int numCama) {
		this.numCama = numCama;
	}

	public void setfechIngreso(String fechIngreso) {
		this.fechingreso = fechIngreso;
	}

	public void setnombre(String nombre) {
		this.nombre = nombre;
	}

	public void setapellido(String apellido) {
		this.apellido = apellido;
	}

	public int getCodigo() {
		return codigo;
	}

	public int getnumCama() {
		return numCama;
	}

	public String getFechIngreso() {
		return fechingreso;
	}

	public String getnombre() {
		return nombre;
	}

	public String getapellido() {
		return apellido;
	}
}
