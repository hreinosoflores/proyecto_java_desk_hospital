package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import clases.Atencion;
import clases.Internamiento;
import clases.Pago;

public class Arreglo_Pago extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Atributos privados
	private ArrayList<Pago> listaPago;

	public Arreglo_Pago() {
		listaPago = new ArrayList<Pago>();
		cargarPago();
	}

	public void cargarPago() {
		try {
			BufferedReader br;
			String linea;
			String[] s;
			Internamiento internamiento;
			double totalPagado;
			int codigoPago, estado;

			br = new BufferedReader(new FileReader(getArchivo()));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoPago = Integer.parseInt(s[0].trim());
				internamiento = new Internamiento(Integer.parseInt(s[1].trim()), null, null, null, null, null, null,
						null, 0);
				totalPagado = Double.parseDouble(s[2].trim());
				estado = Integer.parseInt(s[3].trim());
				adicionar(new Pago(codigoPago, internamiento, totalPagado, estado));
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void grabarPago() {
		try {
			PrintWriter pw;
			String linea;
			Pago x;
			pw = new PrintWriter(new FileWriter(getArchivo()));
			for (int i = 0; i < getRowCount(); i++) {
				x = obtener(i);
				linea = x.getCodigoPago() + ";" + x.getInternamiento().getCodigoInternamiento() + ";"
						+ x.getTotalPagado() + ";" + x.getEstado();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Pago obtener(int i) {
		return listaPago.get(i);
	}

	public void adicionar(Pago x) {
		listaPago.add(x);
	}

	public String getArchivo() {
		return "pago.txt";
	}
	
	public boolean existeArchivo() {
		File f = new File(getArchivo());
		return f.exists();
	}
	
	public Pago buscar(int codigo) {
		for (int i = 0; i < getRowCount(); i++)
			if (obtener(i).getCodigoPago() == codigo)
				return obtener(i);
		return null;
	}
	
	public Pago buscarPorInternamiento(int codigo) {
		Pago x;
		for (int i = 0; i < getRowCount(); i++) {
			x = obtener(i);
			if (x.getInternamiento().getCodigoInternamiento() == codigo)
				return x;
		}
		return null;
	}
	
	public int generarCodigo() {
		if (getRowCount() == 0)
			return 100001;
		else
			return obtener(getRowCount() - 1).getCodigoPago() + 1;
	}
	
	private String nombreColumnas[] = { "C\u00f3digo", "Dni", "Apellidos", "Nombres", "Tel\u00e9fono" };

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return nombreColumnas.length;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return nombreColumnas[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaPago.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
