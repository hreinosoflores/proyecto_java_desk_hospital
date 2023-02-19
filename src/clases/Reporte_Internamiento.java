package clases;

public class Reporte_Internamiento {
	private int codigoInt;
	private String nomPac, descCama, fechaIngreso, fechaSalida, horaIngreso, horaSalida;

	public Reporte_Internamiento(int codigoInt, String nomPac, String descCama, String fechaIngreso, String fechaSalida,
			String horaIngreso, String horaSalida) {
		this.codigoInt = codigoInt;
		this.nomPac = nomPac;
		this.descCama = descCama;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.horaIngreso = horaIngreso;
		this.horaSalida = horaSalida;
	}

	public int getCodigoInt() {
		return codigoInt;
	}

	public void setCodigoInt(int codigoInt) {
		this.codigoInt = codigoInt;
	}

	public String getNomPac() {
		return nomPac;
	}

	public void setNomPac(String nomPac) {
		this.nomPac = nomPac;
	}

	public String getDescCama() {
		return descCama;
	}

	public void setDescCama(String descCama) {
		this.descCama = descCama;
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

}
