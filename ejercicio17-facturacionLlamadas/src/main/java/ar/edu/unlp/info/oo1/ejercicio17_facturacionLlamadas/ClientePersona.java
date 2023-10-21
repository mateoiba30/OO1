package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;

public class ClientePersona extends Cliente {
	private long dni;
	
	public ClientePersona(String nombre, String direccion, long dni, int telefono) {
		super(nombre, direccion, telefono);
		this.dni=dni;
	}
	
	public double calcularMonto(DateLapse periodo) {
		return super.calcularMonto(periodo) * 0.9;
	}
}
