package clases;

public class Reporte_Atenciones {

	private int codigoAt, codigoPa;
	private double totPag;
	String fechAtenc;
	// contructor

	public Reporte_Atenciones(int codigoAt, int codigoPa, String fechAtenc, double totPag) {

		this.codigoAt = codigoAt;
		this.codigoPa = codigoPa;
		this.fechAtenc = fechAtenc;
		this.totPag = totPag;
	}

	// metodos set / get
	public void setCodigoAT(int codigoAt) {
		this.codigoAt = codigoAt;
	}

	public void setCodigoPa(int codigoPa) {
		this.codigoPa = codigoPa;
	}

	public void setfechAtenc(String fechAtenc) {
		this.fechAtenc = fechAtenc;
	}

	public void settotPag(double totPag) {
		this.totPag = totPag;
	}

	public int getCodigoAt() {
		return codigoAt;
	}

	public int getCodigoPa() {
		return codigoPa;
	}

	public String getFechAtenc() {
		return fechAtenc;
	}

	public double gettotPag() {
		return totPag;
	}
}
