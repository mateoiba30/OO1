package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;

import java.time.LocalDate;

public class Factura {
	private Cliente cliente;
	private LocalDate fechaCreacion;
	private DateLapse periodo;
	private double monto;
	
	public Factura(Cliente cliente, DateLapse periodo, double monto) {
		this.cliente=cliente;
		this.periodo=periodo;
		this.fechaCreacion=LocalDate.now();
		this.monto= monto;
	}
	
	public double getMonto() {
		return this.monto;
	}
}
