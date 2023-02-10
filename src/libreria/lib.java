package libreria;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class lib {

	public static String tiposdeCategoria[] = { "Basico", "Estandar", "Premium" };
	public static String tiposdeEstadoCama[] = { "libre", "ocupado" };
	public static String tiposdeEstadoInternamiento[] = { "alojado", "pagado" };
	public static String tiposdeEstadoAtencion[] = { "pendiente", "pagado" };

	public static void mensajeError(JDialog jd, String s) {
		JOptionPane.showMessageDialog(jd, s, "MN-Global � >>> PrimaTaxi �", 0);
	}

	public static void mensajeInformacion(JDialog jd, String s) {
		JOptionPane.showMessageDialog(jd, s, "MN-Global � >>> PrimaTaxi �", 1);
	}

	public static void mensajeAdvertencia(JDialog jd, String s) {
		JOptionPane.showMessageDialog(jd, s, "MN-Global � >>> PrimaTaxi �", 2);
	}

	public static String leerCadena(JTextField txt) {
		return txt.getText().trim();
	}

	public static String leerCadenaGrande(JTextArea txt) {
		return txt.getText().trim();
	}

	public static int leerEntero(JTextField txt) {
		return Integer.parseInt(txt.getText().trim());
	}

	public static int leerEntero(JLabel lbl) {
		return Integer.parseInt(lbl.getText().trim());
	}

	public static int mensajeConfirmacion(JDialog jd, String s) {
		return JOptionPane.showConfirmDialog(jd, s, "MN-Global � >>> PrimaTaxi �", 0, 3, null);
	}

	public static String formatoFecha(int fecha) {
		String s = fecha % 100 + " de ";
		fecha /= 100;
		switch (fecha % 100) {
		case 1:
			s += "Enero";
			break;
		case 2:
			s += "Febrero";
			break;
		case 3:
			s += "Marzo";
			break;
		case 4:
			s += "Abril";
			break;
		case 5:
			s += "Mayo";
			break;
		case 6:
			s += "Junio";
			break;
		case 7:
			s += "Julio";
			break;
		case 8:
			s += "Agosto";
			break;
		case 9:
			s += "Setiembre";
			break;
		case 10:
			s += "Octubre";
			break;
		case 11:
			s += "Noviembre";
			break;
		default:
			s += "Diciembre";
			break;
		}
		s = s + " de " + fecha / 100;
		return s;
	}
}
