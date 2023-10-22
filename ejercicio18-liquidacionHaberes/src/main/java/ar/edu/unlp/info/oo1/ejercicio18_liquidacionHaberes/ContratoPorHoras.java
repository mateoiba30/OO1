package ar.edu.unlp.info.oo1.ejercicio18_liquidacionHaberes;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoPorHoras extends Contrato{

	private double valorPorHora;
	private int horasAlMes;
	private LocalDate fechaFin;
	
	public ContratoPorHoras(LocalDate fechaInicio, LocalDate fechaFin, double valorPorHora, int horasAlMes) {
		super(fechaInicio);
		this.valorPorHora=valorPorHora;
		this.horasAlMes=horasAlMes;
		this.fechaFin=fechaFin;
	}
	
	@Override //no es obligatorio ponerlo, pero es de bueno practica
	public double calcularMontoBasico() {
		return this.valorPorHora * this.horasAlMes;
	}
	
	@Override
	public boolean vencido() {
		return this.fechaFin.isBefore(LocalDate.now()) || this.fechaFin.equals(LocalDate.now()); //si el contrato vence hoy, hoy NO tiene que trabajar
	}
	
	@Override
	public int calcularAnios() {
		if (this.fechaFin.isBefore(LocalDate.now())) //anios hasta el fin o hasta hoy si es que no terminó
			return (int)ChronoUnit.YEARS.between(this.getFechaInicio(), this.fechaFin);
		else
			return (int)ChronoUnit.YEARS.between(this.getFechaInicio(), LocalDate.now()); //el metodo lo hereda esta clase, el constructor no
	}
	
	@Override
	public boolean admiteFecha(LocalDate fechaInicio) { //lo admite si empieza luego de que this termine
		if (this.vencido())
			return true;
		else
			return fechaInicio.isAfter(this.fechaFin); //la admite si inicia despues
	}
}
