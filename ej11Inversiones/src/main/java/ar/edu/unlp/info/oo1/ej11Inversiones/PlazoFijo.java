package ar.edu.unlp.info.oo1.ej11Inversiones;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo implements Inversion {
	
	public LocalDate fecha;
	private double montoDepositado;
	private double porcentajeDeInteresDiario;
	
	public PlazoFijo(LocalDate fecha, double montoDepositado, double porcentajeDeInteresDiario) {
		this.fecha = fecha;
		this.montoDepositado = montoDepositado;
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}
	
	public double valorActual() {
		LocalDate fechaActual= LocalDate.now();
		long diasPasados = ChronoUnit.DAYS.between(this.fecha, fechaActual);
		double valorActual=this.montoDepositado;
		double cambio = (double)(100 + this.porcentajeDeInteresDiario)/100;
		
		for(int i=0; i<diasPasados; i++)
			valorActual=valorActual*cambio;
		
		return valorActual;
		
	}
}
