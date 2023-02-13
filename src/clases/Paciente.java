package clases;

public class Paciente {
	private int codigoPaciente;
	private String apellidos, nombres, telefono, dni;

	public Paciente(int codigoPaciente, String apellidos, String nombres, String telefono, String dni) {
		this.apellidos = apellidos;
		this.codigoPaciente = codigoPaciente;
		this.dni = dni;
		this.nombres = nombres;
		this.telefono = telefono;
	}

	public int getCodigoPaciente() {
		return codigoPaciente;
	}

	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return apellidos + ", " + nombres;
	}
}
