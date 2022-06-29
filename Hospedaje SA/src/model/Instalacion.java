package model;

public class Instalacion {
	int id_instalacion;
	String nombre;

	public Instalacion(int id_instalacion, String nombre) {
		super();
		this.nombre = nombre;
		this.id_instalacion = id_instalacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId_instalacion() {
		return id_instalacion;
	}

	public void setId_instalacion(int id_instalacion) {
		this.id_instalacion = id_instalacion;
	}
}
