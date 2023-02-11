package clases;

import libreria.lib;

public class Cama {
	private int numeroCama, categoria, estado;

	public Cama(int numeroCama, int categoria, int estado) {
		this.numeroCama = numeroCama;
		this.categoria = categoria;
		this.estado = estado;
	}

	public int getNumeroCama() {
		return numeroCama;
	}

	public void setNumeroCama(int numeroCama) {
		this.numeroCama = numeroCama;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	//  Operaciones publicas
	public String CategoriaDescr() {
		return lib.tiposdeCategoria[categoria];
	}

	public String EstadoDescr() {
		return lib.tiposdeEstadoCama[categoria];
	}

	public double Precio() {
		switch (categoria) {
		case 0:
			return 6.50;
		case 1:
			return 15.00;
		default:
			return 22.50;
		}
	}
}
