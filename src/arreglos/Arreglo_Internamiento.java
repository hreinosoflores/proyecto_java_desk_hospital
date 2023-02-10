package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import clases.Ingreso_Datos_Internamiento;

public class Arreglo_Internamiento extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	ArrayList<Ingreso_Datos_Internamiento> idi;

	public Arreglo_Internamiento() {
		idi = new ArrayList<Ingreso_Datos_Internamiento>();
		cargarInternamiento();
	}

	public int tamanio() {
		return idi.size();
	}

	public void adicionar(Ingreso_Datos_Internamiento x) {
		idi.add(x);
		fireTableDataChanged();
	}

	public Ingreso_Datos_Internamiento obtener(int i) {
		return idi.get(i);
	}

	public Ingreso_Datos_Internamiento buscar(int codigo) {
		Ingreso_Datos_Internamiento x;
		for (int i = 0; i < tamanio(); i++) {
			x = obtener(i);
			if (x.getCodigoInternamiento() == codigo)
				return x;
		}
		return null;
	}

	public Ingreso_Datos_Internamiento buscarPac(int codigo) {
		Ingreso_Datos_Internamiento x;
		for (int i = 0; i < tamanio(); i++) {
			x = obtener(i);
			if (x.getCodigoPaciente() == codigo)
				return x;
		}
		return null;
	}

	public void eliminar(Ingreso_Datos_Internamiento x) {
		idi.remove(x);
		fireTableDataChanged();
	}

	public void cargarInternamiento() {
		try {
			BufferedReader br;
			String linea;
			String[] s;
			int codigoInternamiento, codigoPaciente, numCama, estado;
			String fechaIngreso, horaIngreso, fechaSalida, horaSalida;
			br = new BufferedReader(new FileReader("internamiento.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoInternamiento = Integer.parseInt(s[0].trim());
				codigoPaciente = Integer.parseInt(s[1].trim());
				numCama = Integer.parseInt(s[2].trim());
				fechaIngreso = s[3].trim();
				horaIngreso = s[4].trim();
				fechaSalida = s[5].trim();
				horaSalida = s[6].trim();
				estado = Integer.parseInt(s[7].trim());
				adicionar(new Ingreso_Datos_Internamiento(codigoInternamiento, codigoPaciente, numCama, fechaIngreso,
						horaIngreso, fechaSalida, horaSalida, estado));
			}
			br.close();
		} catch (Exception e) {

		}
	}

	public void grabarInternamiento() {
		try {
			PrintWriter pw;
			String linea;
			Ingreso_Datos_Internamiento x;
			pw = new PrintWriter(new FileWriter("internamiento.txt"));
			for (int i = 0; i < tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodigoInternamiento() + ";" + 
						x.getCodigoPaciente() + ";" + 
						x.getNumCama() + ";"+ 
						x.getFechaIngreso() + ";" + 
						x.getHoraIngreso() + ";" + 
						x.getFechaSalida() + ";"+ 
						x.getHoraSalida() + ";" + 
						x.getEstado();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	public int generarCodigo() {
		if (tamanio() == 0)
			return 1001;
		else
			return obtener(tamanio() - 1).getCodigoInternamiento() + 1;
	}

	private String nombreColumnas[] = { "Cod. Internamiento", "Cod. Paciente", "N� Cama", "Est. Cama",
			"Est.Internamiento", "Fecha Registro", "Fecha Ingreso", "Fecha Salida", "Hora Ingreso", "Hora Salida" };

	public int generarDias(int fechaIng, int fechaSal) {
		int dia1, dia2;
		dia1 = fechaIng % 100;
		dia2 = fechaSal % 100;

		return dia2 - dia1;
	}

	public int getRowCount() {
		return idi.size();
	}

	public int getColumnCount() {
		return nombreColumnas.length;
	}

	public String getColumnName(int columna) {
		return nombreColumnas[columna];
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
