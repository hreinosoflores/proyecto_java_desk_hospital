package arreglos;

import java.util.ArrayList;

import clases.Reporte_Pacientes;;

public class Arreglo_Reporte_Pacientes {

	// atributo privado
	private ArrayList<Reporte_Pacientes> repPac;

	// contructor
	public Arreglo_Reporte_Pacientes() {
		repPac = new ArrayList<Reporte_Pacientes>();
	}

	// operaciones publicas

	public int tamanio() {
		return repPac.size();
	}

	public Reporte_Pacientes obtener(int i) {
		return repPac.get(i);
	}
}
