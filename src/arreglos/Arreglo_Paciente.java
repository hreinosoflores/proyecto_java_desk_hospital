package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import clases.Paciente;;

public class Arreglo_Paciente extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Paciente> pa;

	public Arreglo_Paciente() {
		pa = new ArrayList<Paciente>();

		cargarPaciente();
	}

	public int tamanio() {
		return pa.size();
	}

	public Paciente obtener(int i) {
		return pa.get(i);
	}

	public void adicionar(Paciente x) {
		pa.add(x);
	}

	public String getArchivo() {
		return "paciente.txt";
	}

	public void modificar(int i, Paciente x) {
		pa.set(i, x);
	}

	public void eliminar(int i) {
		pa.remove(i);
	}

	public void cargarPaciente() {
		try {
			BufferedReader br;
			String linea;
			String[] s;
			String apellidos, nombres, telefono, dni;
			int codigoPaciente;

			br = new BufferedReader(new FileReader("paciente.txt"));
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
		}
	}

	public void grabarPaciente() {
		try {
			PrintWriter pw;
			String linea;
			Paciente x;
			pw = new PrintWriter(new FileWriter("paciente.txt"));
			for (int i = 0; i < tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodigoPaciente() + ";" + 
						x.getApellidos() + ";" + 
						x.getNombres() + ";" + 
						x.getTelefono() + ";" + 
						x.getDni();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	public boolean existeArchivo() {
		File f = new File("paciente.txt");
		return f.exists();
	}

	public int buscarindice(int cod) {
		for (int i = 0; i < tamanio(); i++)
			if (obtener(i).getCodigoPaciente() == cod)
				return i;
		return -1;
	}

	public Paciente buscar(int cod) {
		for (int i = 0; i < tamanio(); i++)
			if (obtener(i).getCodigoPaciente() == cod)
				return obtener(i);
		return null;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
