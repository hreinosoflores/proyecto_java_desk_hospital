package clases;

import java.io.BufferedReader;
import java.io.FileReader;

public class Usuario {
	private String id;
	private String contrasenia;

	public Usuario(String id, String contrasenia) {
		super();
		this.id = id;
		this.contrasenia = contrasenia;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public boolean Login() {
		boolean existe = false;
		try {
			BufferedReader br;
			String linea;
			String[] s;

			br = new BufferedReader(new FileReader(getArchivo()));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				String _id = s[0].trim();
				String _contra = s[1].trim();
				if (id.equals(_id) && contrasenia.equals(_contra)) {
					existe = true;
					break;
				}
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return existe;
	}

	public String getArchivo() {
		return "usuario.txt";
	}

}
