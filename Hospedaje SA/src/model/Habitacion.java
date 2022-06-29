package model;

public class Habitacion {
	int id_habitacion;
	int numero;
	String descripcion;
	String tipo;
	String nivel;
	float precio_noche;
	int id_hotel;
	
	public int getId_hotel() {
		return id_hotel;
	}

	public void setId_hotel(int id_hotel) {
		this.id_hotel = id_hotel;
	}

	//Constructor
	public Habitacion(int id_habitacion, int numero, String descripcion, String tipo, String nivel, float precio_noche) {
		super();
		this.id_habitacion = id_habitacion;
		this.numero = numero;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.nivel = nivel;
		this.precio_noche = precio_noche;
	}

	public Habitacion() {
		// TODO Auto-generated constructor stub
	}

	//Setter and Getter
	public int getId_habitacion() {
		return id_habitacion;
	}

	public void setId_habitacion(int id_habitacion) {
		this.id_habitacion = id_habitacion;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public float getPrecio_noche() {
		return precio_noche;
	}

	public void setPrecio_noche(float precio_noche) {
		this.precio_noche = precio_noche;
	}
}
