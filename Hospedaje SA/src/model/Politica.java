package model;

public class Politica {
	int id_politica;
	String nombre;
	String descripcion;
	
	//Constructor
	public Politica(int id_politica, String nombre, String descripcion) {
		super();
		this.id_politica = id_politica;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	//Setter and Getter
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getId_politica() {
		return id_politica;
	}

	public void setId_politica(int id_politica) {
		this.id_politica = id_politica;
	}
}
