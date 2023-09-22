package ar.edu.unlp.info.oo1.ejercicio8;
import java.time.LocalDate;

public class Factura {
	
	private double montoEnergiaActiva;
	private double descuento;
	private LocalDate fecha;
	private Usuario usuario;
	
	public Factura(int montoEnergiaActiva, int descuento, Usuario usuario) {
		this.montoEnergiaActiva=montoEnergiaActiva;
		this.descuento=descuento;
		this.fecha=LocalDate.now();
		this.usuario=usuario;
	}
	
	public double montoTotal() {
		return this.montoEnergiaActiva * ( 100 - this.descuento ) / 100;
	}
	
	public void setMontoEnergiaActiva(double monto) {
		this.montoEnergiaActiva = monto;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario=usuario;
	}

	public double getMontoEnergiaActiva() {
		return montoEnergiaActiva;
	}

	public double getDescuento() {
		return descuento;
	}
	
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	
	
}
