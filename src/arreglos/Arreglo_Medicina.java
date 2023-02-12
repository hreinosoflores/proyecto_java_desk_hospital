package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import clases.Medicina;

public class Arreglo_Medicina extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	ArrayList<Medicina> listaMe;

	public Arreglo_Medicina() {
		listaMe = new ArrayList<Medicina>();
		cargarMedicina();
	}

	public void cargarMedicina() {
		try {
			BufferedReader br;
			String linea;
			String[] s;
			String nombre, laboratorio;
			int codigoMedicina, stock;
			double precio;

			br = new BufferedReader(new FileReader(getArchivo()));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoMedicina = Integer.parseInt(s[0].trim());
				nombre = s[1].trim();
				laboratorio = s[2].trim();
				precio = Double.parseDouble(s[3].trim());
				stock = Integer.parseInt(s[4].trim());
				adicionar(new Medicina(codigoMedicina, nombre, laboratorio, precio, stock));
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void grabarMedicina() {
		try {
			PrintWriter pw;
			String linea;
			Medicina x;
			pw = new PrintWriter(new FileWriter(getArchivo()));
			for (int i = 0; i < tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodigoMedicina() + ";" + x.getNombre() + ";" + x.getLaboratorio() + ";" + x.getPrecio()
						+ ";" + x.getStock();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int tamanio() {
		return listaMe.size();
	}

	public Medicina obtener(int i) {
		return listaMe.get(i);
	}

	public void adicionar(Medicina x) {
		listaMe.add(x);
	}

	public String getArchivo() {
		return "medicina.txt";
	}

	public void modificar(int i, Medicina x) {
		listaMe.set(i, x);
	}

	public void eliminar(int i) {
		listaMe.remove(i);
	}

	public boolean existeArchivo() {
		File f = new File(getArchivo());
		return f.exists();
	}

	public Medicina buscar(int cod) {
		for (int i = 0; i < tamanio(); i++)
			if (obtener(i).getCodigoMedicina() == cod)
				return obtener(i);
		return null;
	}

	public int buscarindice(int cod) {
		for (int i = 0; i < tamanio(); i++)
			if (obtener(i).getCodigoMedicina() == cod)
				return i;
		return -1;
	}

	public int generarCodigo() {
		if (tamanio() == 0)
			return 10001;
		else
			return obtener(tamanio() - 1).getCodigoMedicina() + 1;
	}

	private String nombreColumnas[] = { "C\u00f3digo", "Nombre", "Laboratorio", "Precio", "Stock", };

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return nombreColumnas.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaMe.size();
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return nombreColumnas[column];
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
