package arreglos;

import java.util.ArrayList;

import clases.Reporte_Atenciones;

public class Arreglo_Reporte_Atenciones {

	// atributo privado
	private ArrayList<Reporte_Atenciones> repPag;

	// contructor
	public Arreglo_Reporte_Atenciones() {
		repPag = new ArrayList<Reporte_Atenciones>();
	}

	// operaciones publicas

	public int tamanio() {
		return repPag.size();
	}

	public Reporte_Atenciones obtener(int i) {
		return repPag.get(i);
	}
}
