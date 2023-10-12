package ar.edu.unlp.info.oo1.ejercicio14IntervaloTiempo;
import java.time.LocalDate;

public class CancelacionEstricta implements Cancelacion {
	
	public double calcularReembolso(Reserva reserva,  LocalDate fecha) {
		if (fecha.isBefore(reserva.getPeriodo().getFrom()))
			return 0;
		else
			return (-1);//para indicar error
	}
}