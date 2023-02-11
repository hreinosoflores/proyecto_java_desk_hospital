package arreglos;

import java.util.ArrayList;

import clases.Reporte_Internamiento;;

public class Arreglo_Reporte_Internamiento {

	// atributo privado
	private ArrayList<Reporte_Internamiento> intpag;

	// contructor
	public Arreglo_Reporte_Internamiento() {
		intpag = new ArrayList<Reporte_Internamiento>();
	}

	// operaciones publicas

	public int tamanio() {
		return intpag.size();
	}

	public Reporte_Internamiento obtener(int i) {
		return intpag.get(i);
	}
}
