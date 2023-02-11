package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import clases.Cama;
import clases.Ingreso_Datos_Internamiento;
import clases.Paciente;

public class Arreglo_Internamiento extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	ArrayList<Ingreso_Datos_Internamiento> listaIdi;

	public Arreglo_Internamiento() {
		listaIdi = new ArrayList<Ingreso_Datos_Internamiento>();
		cargarInternamiento();
	}

	public void cargarInternamiento() {
		try {
			BufferedReader br;
			String linea;
			String[] s;
			Paciente paciente;
			Cama cama;
			int codigoInternamiento, estado;
			String fechaIngreso, horaIngreso, fechaSalida, horaSalida;

			br = new BufferedReader(new FileReader(getArchivo()));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoInternamiento = Integer.parseInt(s[0].trim());
				paciente = new Paciente(Integer.parseInt(s[1].trim()), null, null, null, null);
				cama = new Cama(Integer.parseInt(s[2].trim()), 0, 0);
				fechaIngreso = s[3].trim();
				horaIngreso = s[4].trim();
				fechaSalida = s[5].trim();
				horaSalida = s[6].trim();
				estado = Integer.parseInt(s[7].trim());
				adicionar(new Ingreso_Datos_Internamiento(paciente, cama, codigoInternamiento, estado, fechaIngreso,
						horaIngreso, fechaSalida, horaSalida));
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void grabarInternamiento() {
		try {
			PrintWriter pw;
			String linea;
			Ingreso_Datos_Internamiento x;
			pw = new PrintWriter(new FileWriter(getArchivo()));
			for (int i = 0; i < tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodigoInternamiento() + ";" + x.getPaciente().getCodigoPaciente() + ";" + x.getCama().getNumeroCama()
						+ ";" + x.getFechaIngreso() + ";" + x.getHoraIngreso() + ";" + x.getFechaSalida() + ";"
						+ x.getHoraSalida() + ";" + x.getEstado();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int tamanio() {
		return listaIdi.size();
	}

	public void adicionar(Ingreso_Datos_Internamiento x) {
		listaIdi.add(x);
		fireTableDataChanged();
	}

	public Ingreso_Datos_Internamiento obtener(int i) {
		return listaIdi.get(i);
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
			if (x.getPaciente().getCodigoPaciente() == codigo)
				return x;
		}
		return null;
	}

	public void eliminar(Ingreso_Datos_Internamiento x) {
		listaIdi.remove(x);
		fireTableDataChanged();
	}

	public String getArchivo() {
		return "internamiento.txt";
	}

	public boolean existeArchivo() {
		File f = new File(getArchivo());
		return f.exists();
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
		return listaIdi.size();
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
