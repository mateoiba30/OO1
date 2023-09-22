package ar.edu.unlp.info.oo1.ejercicio8;
import java.time.LocalDate;

public class Consumo {
	
	private LocalDate fecha;
	private double consumoEnergiaActiva;
	private double consumoReactiva;
	
	public Consumo(LocalDate fecha, int consumoEnergiaActiva, int consumoReactiva) {
		this.fecha=fecha;
		this.consumoEnergiaActiva=consumoEnergiaActiva;
		this.consumoReactiva=consumoReactiva;
	}
	
	public double costoEnBaseA(double precioKWh) {
		return ( this.consumoEnergiaActiva * precioKWh);
	}
	
	public double factorDePotencia() {
		return this.consumoEnergiaActiva / Math.sqrt( Math.pow(this.consumoEnergiaActiva, 2) + Math.pow(this.consumoReactiva, 2) );
	}
	
	public double getConsumoEnergiaActiva() {
		return this.consumoEnergiaActiva;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public boolean hayDescuento() {
		if (this.factorDePotencia() > 0.8)
			return true;
		else
			return false;
	}
}
