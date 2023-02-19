package clases;

public class Reporte_Pacientes {

	private int codPac;
	private String dniPac;
	private String nomPac;
	private String apePac;
	private int numCama;
	private String fechaIngreso, fechaSalida, horaIngreso, horaSalida, estadoInt;

	public Reporte_Pacientes(int codPac, String dniPac, String nomPac, String apePac, int numCama,
			String fechaIngreso, String fechaSalida, String horaIngreso, String horaSalida, String estadoInt ) {
		this.codPac = codPac;
		this.dniPac = dniPac;
		this.nomPac = nomPac;
		this.apePac = apePac;
		this.numCama = numCama;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.horaIngreso = horaIngreso;
		this.horaSalida = horaSalida;
		this.estadoInt = estadoInt;
	}

	public int getCodPac() {
		return codPac;
	}

	public void setCodPac(int codPac) {
		this.codPac = codPac;
	}

	public String getDniPac() {
		return dniPac;
	}

	public void setDniPac(String dniPac) {
		this.dniPac = dniPac;
	}

	public String getNomPac() {
		return nomPac;
	}

	public void setNomPac(String nomPac) {
		this.nomPac = nomPac;
	}

	public String getApePac() {
		return apePac;
	}

	public void setApePac(String apePac) {
		this.apePac = apePac;
	}

	public int getNumCama() {
		return numCama;
	}

	public void setNumCama(int numCama) {
		this.numCama = numCama;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(String horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getEstadoInt() {
		return estadoInt;
	}

	public void setEstadoInt(String estadoInt) {
		this.estadoInt = estadoInt;
	}
	
	

}
