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
import clases.Cama;
import clases.Medicina;

public class Arreglo_Atencion_Detalle  extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	// Atributos privados
	private ArrayList<AtencionDetalle> listaAtDet;

	// Constructor
	public Arreglo_Atencion_Detalle() {
		listaAtDet = new ArrayList<AtencionDetalle>();
		cargarAtencionDetalle();
	}

	public int tamanio() {
		return listaAtDet.size();
	}

	public AtencionDetalle obtener(int i) {
		return listaAtDet.get(i);
	}


	public void adicionar(AtencionDetalle x) {
		listaAtDet.add(x);
	}

	public String getArchivo() {
		return "detalleatencion.txt";
	}

	public void eliminarAlFinal() {
		listaAtDet.remove(tamanio() - 1);
	}

	public void eliminarTodo() {
		listaAtDet.clear();
	}

	public AtencionDetalle buscar(int codigo) {
		for (int i = 0; i < tamanio(); i++)
			if (obtener(i).getMedicina().getCodigoMedicina() == codigo)
				return obtener(i);
		return null;
	}
	
	

	

	public void eliminar(AtencionDetalle x) {
		listaAtDet.remove(x);
	}


	public void cargarAtencionDetalle() {
		try {
			BufferedReader br;
			String linea;
			String[] s;
			Atencion atencion;
			Medicina medicina;
			int  cantidad;
			double precioUnitario;
			
			br = new BufferedReader(new FileReader(getArchivo()));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				atencion = new Atencion(Integer.parseInt(s[0].trim()), null, null, 0, 0);
				medicina = new Medicina(Integer.parseInt(s[1].trim()),null,null,0,0);
				cantidad = Integer.parseInt(s[2].trim());
				precioUnitario = Double.parseDouble(s[3].trim());
				adicionar(new AtencionDetalle(atencion, medicina, cantidad, precioUnitario));
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void grabarDetalleAtencion() {
		try {
			PrintWriter pw;
			String linea;
			AtencionDetalle x;
			pw = new PrintWriter(new FileWriter(getArchivo()));
			for (int i = 0; i < tamanio(); i++) {
				x = obtener(i);
				linea = x.getAtencion().getCodigoAtencion() + ";" + x.getMedicina().getCodigoMedicina() + ";" + x.getCantidad() + ";"
						+ x.getPrecioUnitario();
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
	
	private String nombreColumnas[] = { "Cod. Atenci\u00f3n", "Paciente", "Medicina", "Precio",
			 "Cantidad", "Subtotal" };


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
