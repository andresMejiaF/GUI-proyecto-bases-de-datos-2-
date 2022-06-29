package model;

public class Hotel {
	int id_hotel;
	String nombre;
	String tipo;
	
	//Constructor
	public Hotel(int id_hotel, String nombre, String tipo) {
		super();
		this.id_hotel = id_hotel;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public Hotel() {
		// TODO Auto-generated constructor stub
	}

	//Getter and Setter
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
	
	public int getId_hotel() {
		return id_hotel;
	}

	public void setId_hotel(int id_hotel) {
		this.id_hotel = id_hotel;
	}
}
