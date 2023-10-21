package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;
import java.time.LocalDate;

public abstract class Llamada {
	
	private LocalDate fechaInicio;
	private int horaInicio;
	private int minutosDuracion;
	private long telefonoLlamador;
	private long telefonoReceptor;
	
	public Llamada(LocalDate fechaInicio, int horaInicio, int minutosDuracion, long telefonoLlamador, long telefonoReceptor) {
		this.fechaInicio=fechaInicio;
		this.horaInicio=horaInicio;
		this.minutosDuracion=minutosDuracion;
		this.telefonoLlamador=telefonoLlamador;
		this.telefonoReceptor=telefonoReceptor;
	}
	
	public LocalDate getFechaInicio() {
		return this.fechaInicio;
	}
	
	public int getHoraInicio() {
		return horaInicio;
	}

	public int getMinutosDuracion() {
		return minutosDuracion;
	}

	public abstract double calcularCosto();
}
