package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import clases.Atencion;
import clases.Paciente;

public class Arreglo_Atencion extends AbstractTableModel {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	ArrayList<Atencion> listaAt;

	public Arreglo_Atencion() {
		listaAt = new ArrayList<Atencion>();
		cargarAtencion();
	}

	public void cargarAtencion() {
		try {
			BufferedReader br;
			String linea;
			String[] s;
			Paciente paciente;
			int codigoAtencion, estado;
			String fechaAtencion;
			double totalPagar;

			br = new BufferedReader(new FileReader(getArchivo()));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoAtencion = Integer.parseInt(s[0].trim());
				paciente = new Paciente(Integer.parseInt(s[1].trim()), null,null, null, null);
				fechaAtencion = s[2].trim();
				totalPagar = Double.parseDouble(s[3].trim());
				estado = Integer.parseInt(s[4].trim());
				adicionar(new Atencion(codigoAtencion, paciente, fechaAtencion, totalPagar, estado));
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void grabarAtencion() {
		try {
			PrintWriter pw;
			String linea;
			Atencion x;
			pw = new PrintWriter(new FileWriter(getArchivo()));
			for (int i = 0; i < tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodigoAtencion() + ";" + x.getPaciente().getCodigoPaciente() + ";" + x.getFechaAtencion() + ";"
						+ x.getTotalPagar() + ";" + x.getEstado();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int generarCodigo() {
		if (tamanio() == 0)
			return 10001;
		else
			return obtener(tamanio() - 1).getCodigoAtencion() + 1;
	}

	private String nombreColumnas[] = { "Cod. Atenci\u00f3n", "Paciente", "Fecha Atenci\u00f3n", "Estado Atenci\u00f3n",
			"Medicina", "Precio Unitario", "Cantidad", "Total a pagar" };

	public int tamanio() {
		return listaAt.size();
	}

	public void adicionar(Atencion x) {
		listaAt.add(x);
		fireTableDataChanged();
	}
	
	public void modificar(int i, Atencion x) {
		listaAt.set(i, x);
		fireTableDataChanged();
	}


	public String getArchivo() {
		return "atencion.txt";
	}

	public Atencion obtener(int i) {
		return listaAt.get(i);
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
	
	public int buscarindice(int codigo) {
		for (int i = 0; i < tamanio(); i++)
			if (obtener(i).getCodigoAtencion() == codigo)
				return i;
		return -1;
	}


	public Atencion buscarPac(int codigo) {
		Atencion x;
		for (int i = 0; i < tamanio(); i++) {
			x = obtener(i);
			if (x.getPaciente().getCodigoPaciente() == codigo)
				return x;
		}
		return null;
	}

	public void eliminar(Atencion x) {
		listaAt.remove(x);
		fireTableDataChanged();
	}

	public boolean existeArchivo() {
		File f = new File(getArchivo());
		return f.exists();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return nombreColumnas.length;
	}

	@Override
	public int getRowCount() {
		return listaAt.size();
	}

	@Override
	public String getColumnName(int column) {
		return nombreColumnas[column];
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
