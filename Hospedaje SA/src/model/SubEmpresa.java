package model;

public class SubEmpresa {
	String nombre;
	String telefono;
	String email;
	String contrase�a;
	int id_subEmpresa;
	
	public int getId_subEmpresa() {
		return id_subEmpresa;
	}

	public void setId_subEmpresa(int id_subEmpresa) {
		this.id_subEmpresa = id_subEmpresa;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	//Constructor
	public SubEmpresa(String nombre, String telefono, String email) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}

	public SubEmpresa() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
