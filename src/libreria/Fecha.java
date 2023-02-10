package libreria;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JComboBox;

public class Fecha {

	// M�todos static tipo void (con par�metros)
	public static void colocarMeses(JComboBox<String> cbo) {
		cbo.addItem("Enero");
		cbo.addItem("Febrero");
		cbo.addItem("Marzo");
		cbo.addItem("Abril");
		cbo.addItem("Mayo");
		cbo.addItem("Junio");
		cbo.addItem("Julio");
		cbo.addItem("Agosto");
		cbo.addItem("Setiembre");
		cbo.addItem("Octubre");
		cbo.addItem("Noviembre");
		cbo.addItem("Diciembre");
	}

	public static void colocarDiaActual(JComboBox<String> cbo) {
		Calendar calendario = new GregorianCalendar();
		cbo.setSelectedIndex(calendario.get(Calendar.DAY_OF_MONTH) - 1);
	}

	public static void colocarMesActual(JComboBox<String> cbo) {
		Calendar calendario = new GregorianCalendar();
		cbo.setSelectedIndex(calendario.get(Calendar.MONTH));
	}

	public static void colocarItems(JComboBox<String> cbo, int inicio, int fin) {
		if (inicio < fin)
			while (inicio <= fin) {
				cbo.addItem(inicio + "");
				inicio++;
			}
		else
			while (inicio >= fin) {
				cbo.addItem(inicio + "");
				inicio--;
			}
	}

	public static void setFecha(JComboBox<String> dia, JComboBox<String> mes, JComboBox<String> anio, int fecha) {
		int dd = fecha % 100, mm = (fecha / 100) % 100, aa = fecha / 10000;
		dia.setSelectedIndex(dd - 1);
		mes.setSelectedIndex(mm - 1);
		anio.setSelectedItem(aa + "");
	}

	public static void setHora(JComboBox<String> hora, JComboBox<String> minuto, int fechaHora) {
		int MM = fechaHora % 100, HH = fechaHora / 100;

		minuto.setSelectedIndex(MM - 1);
		hora.setSelectedItem(HH + "");
	}

	// M�todos static que retornan valor (sin par�metros)
	public static int anioActual() {
		Calendar c = new GregorianCalendar();
		return c.get(Calendar.YEAR);
	}

	// M�todos static que retornan valor (con par�metros)
	public static String dd_mm_aaaa(int fecha) {
		String s = "" + fecha;
		return "" + s.charAt(6) + s.charAt(7) + '/' + s.charAt(4) + s.charAt(5) + '/' + s.charAt(0) + s.charAt(1)
				+ s.charAt(2) + s.charAt(3);
	}

	public static String HH_MM(int hora) {
		String s = "" + hora;
		if (hora > 1000) {
			return "" + s.charAt(0) + s.charAt(1) + ':' + s.charAt(2) + s.charAt(3);
		} else
			return "" + s.charAt(0) + ':' + s.charAt(1) + s.charAt(2);
	}

	public static int getFecha(JComboBox<String> dia, JComboBox<String> mes, JComboBox<String> anio) {
		int dd = dia.getSelectedIndex() + 1, mm = mes.getSelectedIndex() + 1,
				aa = Integer.parseInt(anio.getSelectedItem().toString());
		return (aa * 100 + mm) * 100 + dd;
	}

	public static int getHora(JComboBox<String> hora, JComboBox<String> minuto) {
		int mm = minuto.getSelectedIndex() + 1, hh = Integer.parseInt(hora.getSelectedItem().toString());

		return hh * 100 + mm;
	}

	public static void colocarHoraActual(JComboBox<String> cbo) {
		Calendar calendario = new GregorianCalendar();
		cbo.setSelectedIndex(calendario.get(Calendar.HOUR_OF_DAY) - 1);
	}

	public static void colocarMinutoActual(JComboBox<String> cbo) {
		Calendar calendario = new GregorianCalendar();
		cbo.setSelectedIndex(calendario.get(Calendar.MINUTE) - 1);
	}

}
