package model;

public class Servicios {
	int id_servicio;
	String descripcion;
	String costo;
	String nombre;
	String tipo;
	
	//Constructor
	public Servicios(int id_servicio, String descripcion, String costo, String nombre, String tipo) {
		super();
		this.id_servicio = id_servicio;
		this.descripcion = descripcion;
		this.costo = costo;
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	//Getter and Setter
	public int getId_servicio() {
		return id_servicio;
	}
	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCosto() {
		return costo;
	}
	public void setCosto(String costo) {
		this.costo = costo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
