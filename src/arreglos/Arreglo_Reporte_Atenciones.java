package arreglos;

import java.util.ArrayList;

import clases.Reporte_Atenciones;

public class Arreglo_Reporte_Atenciones {

	// atributo privado
	private ArrayList<Reporte_Atenciones> repPag;

	// contructor
	public Arreglo_Reporte_Atenciones() {
		repPag = new ArrayList<Reporte_Atenciones>();
		repPag.add(new Reporte_Atenciones(001, 1001, "04/05/2016", 10.0));
		repPag.add(new Reporte_Atenciones(002, 1005, "01/05/2017", 12.5));
		repPag.add(new Reporte_Atenciones(003, 1004, "06/01/2019", 13.6));
		repPag.add(new Reporte_Atenciones(004, 1000, "05/09/2011", 12.8));
		repPag.add(new Reporte_Atenciones(005, 1009, "01/06/2014", 15.3));
	}

	// operaciones publicas

	public int tamanio() {
		return repPag.size();
	}

	public Reporte_Atenciones obtener(int i) {
		return repPag.get(i);
	}
}
