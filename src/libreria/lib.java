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
		JOptionPane.showMessageDialog(jd, s, "MN-Global  >>> PrimaTaxi ", JOptionPane.ERROR_MESSAGE);
	}

	public static void mensajeInformacion(JDialog jd, String s) {
		JOptionPane.showMessageDialog(jd, s, "MN-Global  >>> PrimaTaxi ", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void mensajeAdvertencia(JDialog jd, String s) {
		JOptionPane.showMessageDialog(jd, s, "MN-Global  >>> PrimaTaxi ", JOptionPane.WARNING_MESSAGE);
	}

	public static int mensajeConfirmacion(JDialog jd, String s) {
		return JOptionPane.showConfirmDialog(jd, s, "MN-Global  >>> PrimaTaxi ", 0, JOptionPane.QUESTION_MESSAGE, null);
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

}
