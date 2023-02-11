package clases;

public class Reporte_Pacientes {

	private int codigo, numCama;
	String fechingreso, nombre, apellido;
	
	// constructor
	
	public Reporte_Pacientes(int codigo, int numCama, String fechingreso, String nombre, String apellido) {
		super();
		this.codigo = codigo;
		this.numCama = numCama;
		this.fechingreso = fechingreso;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	// metodos set / get

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getNumCama() {
		return numCama;
	}
	public void setNumCama(int numCama) {
		this.numCama = numCama;
	}
	public String getFechingreso() {
		return fechingreso;
	}
	public void setFechingreso(String fechingreso) {
		this.fechingreso = fechingreso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	


}
