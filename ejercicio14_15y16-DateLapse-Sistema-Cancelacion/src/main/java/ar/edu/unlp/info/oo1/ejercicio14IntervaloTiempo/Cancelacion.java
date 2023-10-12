package ar.edu.unlp.info.oo1.ejercicio14IntervaloTiempo;
import java.time.LocalDate;

public interface Cancelacion {
	
	public double calcularReembolso(Reserva reserva, LocalDate fecha); //reembolso = plata que se devuelve
}
