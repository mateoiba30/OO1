package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;

public class ClienteJuridico extends Cliente {
	private int cuit;
	private String tipo;
	
	public ClienteJuridico(String nombre, String direccion, int telefono, int cuit, String tipo) {
		super(nombre, direccion, telefono);
		this.cuit=cuit;
		this.tipo=tipo;
	}
}
