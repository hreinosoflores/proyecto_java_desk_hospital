package clases;

public class Reporte_Atenciones {

	private int codigoAt, codigoPa;
	private double totPag;
	String fechAtenc;

	// constructor
	public Reporte_Atenciones(int codigoAt, int codigoPa, double totPag, String fechAtenc) {
		super();
		this.codigoAt = codigoAt;
		this.codigoPa = codigoPa;
		this.totPag = totPag;
		this.fechAtenc = fechAtenc;
	}

	// metodos set / get
	public int getCodigoAt() {
		return codigoAt;
	}

	public void setCodigoAt(int codigoAt) {
		this.codigoAt = codigoAt;
	}

	public int getCodigoPa() {
		return codigoPa;
	}

	public void setCodigoPa(int codigoPa) {
		this.codigoPa = codigoPa;
	}

	public double getTotPag() {
		return totPag;
	}

	public void setTotPag(double totPag) {
		this.totPag = totPag;
	}

	public String getFechAtenc() {
		return fechAtenc;
	}

	public void setFechAtenc(String fechAtenc) {
		this.fechAtenc = fechAtenc;
	}

}
