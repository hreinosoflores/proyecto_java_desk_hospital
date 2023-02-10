package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import clases.Atencion;

public class Arreglo_Atencion extends AbstractTableModel {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	ArrayList<Atencion> at;

	public Arreglo_Atencion() {
		at = new ArrayList<Atencion>();
		cargarAtencion();
	}

	public void cargarAtencion() {
		try {
			BufferedReader br;
			String linea;
			String[] s;
			int codigoAtencion, codigoPaciente, estado;
			String fechaAtencion;
			double totalPagar;

			br = new BufferedReader(new FileReader("atencion.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoAtencion = Integer.parseInt(s[0].trim());
				codigoPaciente = Integer.parseInt(s[1].trim());
				fechaAtencion = s[2].trim();
				totalPagar = Double.parseDouble(s[3].trim());
				estado = Integer.parseInt(s[3].trim());
				adicionar(new Atencion(codigoAtencion, codigoPaciente, fechaAtencion, totalPagar, estado));
			}
			br.close();
		} catch (Exception e) {

		}

	}

	public void grabarAtencion() {
		try {
			PrintWriter pw;
			String linea;
			Atencion x;
			pw = new PrintWriter(new FileWriter("atencion.txt"));
			for (int i = 0; i < tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodigoAtencion() + ";" +
						x.getCodigoPaciente() + ";" + 
						x.getFechaAtencion() + ";"+ 
						x.getTotalPagar() + ";" + 
						x.getEstado();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	public int generarCodigo() {
		if (tamanio() == 0)
			return 10001;
		else
			return obtener(tamanio() - 1).getCodigoAtencion() + 1;
	}

	private String nombreColumnas[] = { "Cod. Atencion", "Cod. Paciente", "Fecha Atencion", "Estado atencion",
			"Codigo Medicina", "Precio Unitario", "Cantidad", "Total Pagar" };

	public int tamanio() {
		return at.size();
	}

	public void adicionar(Atencion x) {
		at.add(x);
		fireTableDataChanged();
	}

	public String getArchivo() {
		return "atencion.txt";
	}

	public Atencion obtener(int i) {
		return at.get(i);
	}

	public Atencion buscar(int codigo) {
		Atencion x;
		for (int i = 0; i < tamanio(); i++) {
			x = obtener(i);
			if (x.getCodigoAtencion() == codigo)
				return x;
		}
		return null;
	}

	public Atencion buscarPac(int codigo) {
		Atencion x;
		for (int i = 0; i < tamanio(); i++) {
			x = obtener(i);
			if (x.getCodigoPaciente() == codigo)
				return x;
		}
		return null;
	}

	public void eliminar(Atencion x) {
		at.remove(x);
		fireTableDataChanged();
	}

	public boolean existeArchivo() {
		File f = new File("atencion.txt");
		return f.exists();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return nombreColumnas.length;
	}

	@Override
	public int getRowCount() {

		return at.size();
	}

	@Override
	public String getColumnName(int columna) {
		return nombreColumnas[columna];
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
