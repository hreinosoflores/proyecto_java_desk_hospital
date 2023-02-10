package arreglos;

import java.util.ArrayList;

import clases.Reporte_Internamiento;;

public class Arreglo_Reporte_Internamiento {

	// atributo privado
	private ArrayList<Reporte_Internamiento> intpag;

	// contructor
	public Arreglo_Reporte_Internamiento() {
		intpag = new ArrayList<Reporte_Internamiento>();
		intpag.add(new Reporte_Internamiento(001, 1001, 0, "04/05/2016", "04/05/2017", null, null));
		intpag.add(new Reporte_Internamiento(002, 1005, 1, "01/05/2017", "04/05/2018", null, null));
		intpag.add(new Reporte_Internamiento(003, 1004, 2, "06/01/2019", "04/05/2020", null, null));
		intpag.add(new Reporte_Internamiento(004, 1000, 3, "05/09/2011", "04/05/2012", null, null));
		intpag.add(new Reporte_Internamiento(005, 1009, 4, "01/06/2014", "04/05/2015", null, null));
	}

	// operaciones publicas

	public int tamanio() {
		return intpag.size();
	}

	public Reporte_Internamiento obtener(int i) {
		return intpag.get(i);
	}
}
