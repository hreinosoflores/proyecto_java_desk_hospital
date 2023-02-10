package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.ClaseDetalleAtencion;

public class Arreglo_Detalle_Atencion {

	// Atributos privados
	private ArrayList<ClaseDetalleAtencion> da;

	// Constructor
	public Arreglo_Detalle_Atencion() {
		da = new ArrayList<ClaseDetalleAtencion>();
		cargarDetalleAtencion();

	}

	public int tamanio() {
		return da.size();
	}

	public ClaseDetalleAtencion obtener(int i) {
		return da.get(i);
	}

	public void adicionar(ClaseDetalleAtencion x) {
		da.add(x);
	}

	public String getArchivo() {
		return "detalleatencion.txt";
	}

	public void eliminarAlFinal() {
		da.remove(tamanio() - 1);
	}

	public void eliminarTodo() {
		da.clear();
	}

	public ClaseDetalleAtencion buscar(int codigo) {
		for (int i = 0; i < tamanio(); i++)
			if (obtener(i).getCodigoMedicina() == codigo)
				return obtener(i);
		return null;
	}

	public void eliminar(ClaseDetalleAtencion x) {
		da.remove(x);
	}

	public void grabarDetalleAtencion() {
		try {
			PrintWriter pw;
			String linea;
			ClaseDetalleAtencion x;
			pw = new PrintWriter(new FileWriter("detalleatencion.txt"));
			for (int i = 0; i < tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodigoAtencion() + ";" + 
						x.getCodigoMedicina() + ";" + 
						x.getcantidad() + ";"+ 
						x.getprecioUnitario();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	public void cargarDetalleAtencion() {
		try {
			BufferedReader br;
			String linea;
			String[] s;
			int codigoAtencion, codigoMedicina, cantidad;
			double precioUnitario;
			br = new BufferedReader(new FileReader("detalleatencion.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoAtencion = Integer.parseInt(s[0].trim());
				codigoMedicina = Integer.parseInt(s[1].trim());
				cantidad = Integer.parseInt(s[2].trim());
				precioUnitario = Double.parseDouble(s[3].trim());
				adicionar(new ClaseDetalleAtencion(codigoAtencion, codigoMedicina, cantidad, precioUnitario));
			}
			br.close();
		} catch (Exception e) {
		}
	}

	public boolean existeArchivo() {
		File f = new File("detalleatencion.txt");
		return f.exists();
	}

}
