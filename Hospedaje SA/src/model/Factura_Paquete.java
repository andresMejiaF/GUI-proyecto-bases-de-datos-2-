package model;

public class Factura_Paquete {
	int numero_personas;
	int total_descuento;
	int total_pagar;
	String fecha;
	
	//Constructor
	public Factura_Paquete(int numero_personas, int total_descuento, int total_pagar, String fecha) {
		super();
		this.numero_personas = numero_personas;
		this.total_descuento = total_descuento;
		this.total_pagar = total_pagar;
		this.fecha = fecha;
	}

	//Getter and Setter
	public int getNumero_personas() {
		return numero_personas;
	}

	public void setNumero_personas(int numero_personas) {
		this.numero_personas = numero_personas;
	}

	public int getTotal_descuento() {
		return total_descuento;
	}

	public void setTotal_descuento(int total_descuento) {
		this.total_descuento = total_descuento;
	}

	public int getTotal_pagar() {
		return total_pagar;
	}

	public void setTotal_pagar(int total_pagar) {
		this.total_pagar = total_pagar;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
