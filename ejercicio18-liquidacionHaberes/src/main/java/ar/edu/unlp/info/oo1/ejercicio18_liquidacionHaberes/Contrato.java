package ar.edu.unlp.info.oo1.ejercicio18_liquidacionHaberes;
import java.time.LocalDate;

public abstract class Contrato {

	private LocalDate fechaInicio;
	
	public Contrato(LocalDate fechaInicio){
		this.fechaInicio=fechaInicio;
	}
	
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public abstract double calcularMontoBasico();
	public abstract boolean vencido();
	public abstract int calcularAnios();
	public abstract boolean admiteFecha(LocalDate fechaInicio);
}
