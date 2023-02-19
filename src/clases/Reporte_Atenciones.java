package clases;

public class Reporte_Atenciones {

	private int codigoAt;
	private String totPag;
	String nomPac, fechAtenc, horaAtenc;

	public Reporte_Atenciones(int codigoAt, String totPag, String nomPac, String fechAtenc, String horaAtenc) {
		this.codigoAt = codigoAt;
		this.totPag = totPag;
		this.nomPac = nomPac;
		this.fechAtenc = fechAtenc;
		this.horaAtenc = horaAtenc;
	}

	public int getCodigoAt() {
		return codigoAt;
	}

	public void setCodigoAt(int codigoAt) {
		this.codigoAt = codigoAt;
	}

	public String getTotPag() {
		return totPag;
	}

	public void setTotPag(String totPag) {
		this.totPag = totPag;
	}

	public String getNomPac() {
		return nomPac;
	}

	public void setNomPac(String nomPac) {
		this.nomPac = nomPac;
	}

	public String getFechAtenc() {
		return fechAtenc;
	}

	public void setFechAtenc(String fechAtenc) {
		this.fechAtenc = fechAtenc;
	}

	public String getHoraAtenc() {
		return horaAtenc;
	}

	public void setHoraAtenc(String horaAtenc) {
		this.horaAtenc = horaAtenc;
	}

}
