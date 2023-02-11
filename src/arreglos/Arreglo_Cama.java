package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import clases.Cama;

public class Arreglo_Cama extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	ArrayList<Cama> listaCa;

	public Arreglo_Cama() {
		listaCa = new ArrayList<Cama>();
		cargarCama();
	}

	public void cargarCama() {
		try {
			BufferedReader br;
			String linea;
			String[] s;
			int numcama, cat, est;

			br = new BufferedReader(new FileReader(getArchivo()));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				numcama = Integer.parseInt(s[0].trim());
				cat = Integer.parseInt(s[1].trim());
				est = Integer.parseInt(s[2].trim());
				adicionar(new Cama(numcama, cat, est));
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void grabarCama() {
		try {
			PrintWriter pw;
			String linea;
			Cama x;
			pw = new PrintWriter(new FileWriter(getArchivo()));
			for (int i = 0; i < tamanio(); i++) {
				x = obtener(i);
				linea = x.getNumeroCama() + ";" + x.getCategoria() + ";" + x.getEstado();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int tamanio() {
		return listaCa.size();
	}

	public Cama obtener(int i) {
		return listaCa.get(i);
	}

	public void adicionar(Cama x) {
		listaCa.add(x);
	}

	public String getArchivo() {
		return "cama.txt";
	}

	public void modificar(int i, Cama x) {
		listaCa.set(i, x);
	}

	public void eliminar(int i) {
		listaCa.remove(i);
	}

	public boolean existeArchivo() {
		File f = new File(getArchivo());
		return f.exists();
	}

	public Cama buscar(int numCama) {
		for (int i = 0; i < tamanio(); i++)
			if (obtener(i).getNumeroCama() == numCama)
				return obtener(i);
		return null;
	}

	public int buscarindice(int numCama) {
		for (int i = 0; i < tamanio(); i++)
			if (obtener(i).getNumeroCama() == numCama)
				return i;
		return -1;
	}

	public int PrimeraCamaDisponible() {
		for (int i = 0; i < tamanio(); i++)
			if (obtener(i).getEstado() == 0)
				return obtener(i).getNumeroCama();
		return -1;
	}
	
	public int generarCodigo() {
		if (tamanio() == 0)
			return 101;
		else
			return obtener(tamanio() - 1).getNumeroCama() + 1;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaCa.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
