package model;

public class Factura_Automovil {
	int costo;
	String dias;
	String fecha;

	//Constructor
	public Factura_Automovil(int costo, String dias, String fecha) {
		super();
		this.costo = costo;
		this.dias = dias;
		this.fecha = fecha;
	}

	//Getter y Setter
	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
