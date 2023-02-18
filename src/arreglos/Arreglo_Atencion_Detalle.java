package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import clases.Atencion;
import clases.AtencionDetalle;
import clases.Medicina;

public class Arreglo_Atencion_Detalle extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	// Atributos privados
	private ArrayList<AtencionDetalle> listaAtDet;

	// Constructor
	public Arreglo_Atencion_Detalle() {
		listaAtDet = new ArrayList<AtencionDetalle>();
		cargarAtencionDetalle();
	}


	public AtencionDetalle obtener(int i) {
		return listaAtDet.get(i);
	}

	public void adicionar(AtencionDetalle x) {
		listaAtDet.add(x);
	}

	public String getArchivo() {
		return "atenciondetalle.txt";
	}

	public void eliminar(int i) {
		listaAtDet.remove(i);
	}

	public void eliminarAlFinal() {
		listaAtDet.remove(getRowCount() - 1);
	}

	public void eliminarTodo() {
		listaAtDet.clear();
	}
	
	public void eliminar(AtencionDetalle x) {
		listaAtDet.remove(x);
	}

	public AtencionDetalle buscar(int codigoAtencion, int codigoMedicina) {
		for (int i = 0; i < getRowCount(); i++)
			if (obtener(i).getAtencion().getCodigoAtencion() == codigoAtencion
					&& obtener(i).getMedicina().getCodigoMedicina() == codigoMedicina)
				return obtener(i);
		return null;
	}
	
	public int buscarIndice(int codigoAtencion, int codigoMedicina) {
		for (int i = 0; i < getRowCount(); i++)
			if (obtener(i).getAtencion().getCodigoAtencion() == codigoAtencion
					&& obtener(i).getMedicina().getCodigoMedicina() == codigoMedicina)
				return i;
		return -1;
	}

	public ArrayList<AtencionDetalle> buscarPorAtencion(int codigoAtencion) {
		ArrayList<AtencionDetalle> lista = new ArrayList<AtencionDetalle>();
		for (int i = 0; i < getRowCount(); i++)
			if (obtener(i).getAtencion().getCodigoAtencion() == codigoAtencion)
				lista.add(obtener(i));
		return lista;
	}



	public void cargarAtencionDetalle() {
		try {
			BufferedReader br;
			String linea;
			String[] s;
			Atencion atencion;
			Medicina medicina;
			int cantidad;
			double precioUnitario;

			br = new BufferedReader(new FileReader(getArchivo()));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				atencion = new Atencion(Integer.parseInt(s[0].trim()), null, null, 0, 0);
				medicina = new Medicina(Integer.parseInt(s[1].trim()), null, null, 0, 0);
				cantidad = Integer.parseInt(s[2].trim());
				precioUnitario = Double.parseDouble(s[3].trim());
				adicionar(new AtencionDetalle(atencion, medicina, cantidad, precioUnitario));
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void grabarAtencionDetalle() {
		try {
			PrintWriter pw;
			String linea;
			AtencionDetalle x;
			pw = new PrintWriter(new FileWriter(getArchivo()));
			for (int i = 0; i < getRowCount(); i++) {
				x = obtener(i);
				linea = x.getAtencion().getCodigoAtencion() + ";" + x.getMedicina().getCodigoMedicina() + ";"
						+ x.getCantidad() + ";" + x.getPrecioUnitario();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean existeArchivo() {
		File f = new File(getArchivo());
		return f.exists();
	}

	private String nombreColumnas[] = { "Cod. Atenci\u00f3n", "Paciente","Cod. Internamiento", "Medicina", "Precio", "Cantidad",
			"Subtotal" };

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return nombreColumnas.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaAtDet.size();
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
