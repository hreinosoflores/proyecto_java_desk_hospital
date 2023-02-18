package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import clases.Paciente;

public class Arreglo_Paciente extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Paciente> listaPa;

	public Arreglo_Paciente() {
		listaPa = new ArrayList<Paciente>();
		cargarPaciente();
	}

	public void cargarPaciente() {
		try {
			BufferedReader br;
			String linea;
			String[] s;
			String apellidos, nombres, telefono, dni;
			int codigoPaciente;

			br = new BufferedReader(new FileReader(getArchivo()));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoPaciente = Integer.parseInt(s[0].trim());
				apellidos = s[1].trim();
				nombres = s[2].trim();
				telefono = s[3].trim();
				dni = s[4].trim();
				adicionar(new Paciente(codigoPaciente, apellidos, nombres, telefono, dni));
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void grabarPaciente() {
		try {
			PrintWriter pw;
			String linea;
			Paciente x;
			pw = new PrintWriter(new FileWriter(getArchivo()));
			for (int i = 0; i < getRowCount(); i++) {
				x = obtener(i);
				linea = x.getCodigoPaciente() + ";" + x.getApellidos() + ";" + x.getNombres() + ";" + x.getTelefono()
						+ ";" + x.getDni();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}



	public Paciente obtener(int i) {
		return listaPa.get(i);
	}

	public void adicionar(Paciente x) {
		listaPa.add(x);
	}

	public String getArchivo() {
		return "paciente.txt";
	}

	public void modificar(int i, Paciente x) {
		listaPa.set(i, x);
	}

	public void eliminar(int i) {
		listaPa.remove(i);
	}

	public boolean existeArchivo() {
		File f = new File(getArchivo());
		return f.exists();
	}

	public int buscarindice(int cod) {
		for (int i = 0; i < getRowCount(); i++)
			if (obtener(i).getCodigoPaciente() == cod)
				return i;
		return -1;
	}

	public Paciente buscar(int cod) {
		for (int i = 0; i < getRowCount(); i++)
			if (obtener(i).getCodigoPaciente() == cod)
				return obtener(i);
		return null;
	}
	
	public Paciente buscarDNI(String dni) {
		for (int i = 0; i < getRowCount(); i++)
			if (obtener(i).getDni().equals(dni))
				return obtener(i);
		return null;
	}


	public int generarCodigo() {
		if (getRowCount() == 0)
			return 1001;
		else
			return obtener(getRowCount() - 1).getCodigoPaciente() + 1;
	}

	private String nombreColumnas[] = {	"C\u00f3digo", "Dni", "Apellidos", "Nombres", "Tel\u00e9fono" };

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
		return listaPa.size();
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Paciente[] RellenarCombo() {
		Paciente[] arr = new Paciente[getRowCount()];
		// ArrayList to Array Conversion
		for (int i = 0; i < getRowCount(); i++)
			arr[i] = obtener(i);		
		return arr;
	}

}
