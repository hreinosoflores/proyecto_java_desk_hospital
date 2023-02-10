package arreglos;

import java.util.ArrayList;

import clases.Reporte_Pacientes;;

public class Arreglo_Reporte_Pacientes {

	// atributo privado
	private ArrayList<Reporte_Pacientes> repPac;

	// contructor
	public Arreglo_Reporte_Pacientes() {
		repPac = new ArrayList<Reporte_Pacientes>();
		repPac.add(new Reporte_Pacientes(001, 1001, "04/05/2016", "jorge", "chavez"));
		repPac.add(new Reporte_Pacientes(002, 1005, "01/05/2017", "karina", "quaresma"));
		repPac.add(new Reporte_Pacientes(003, 1004, "06/01/2019", "pepe", "rodriguez"));
		repPac.add(new Reporte_Pacientes(004, 1000, "05/09/2011", "lionel", "messi"));
		repPac.add(new Reporte_Pacientes(005, 1009, "01/06/2014", "juan", "castro"));
	}

	// operaciones publicas

	public int tamanio() {
		return repPac.size();
	}

	public Reporte_Pacientes obtener(int i) {
		return repPac.get(i);
	}
}
