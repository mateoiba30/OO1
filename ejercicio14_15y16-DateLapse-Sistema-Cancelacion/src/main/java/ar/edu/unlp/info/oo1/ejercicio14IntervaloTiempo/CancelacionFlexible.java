package ar.edu.unlp.info.oo1.ejercicio14IntervaloTiempo;
import java.time.LocalDate;

public class CancelacionFlexible implements Cancelacion{
	
	public double calcularReembolso(Reserva reserva,  LocalDate fecha) {
		if (fecha.isBefore(reserva.getPeriodo().getFrom()))
			return reserva.calcularPrecioReserva();
		else
			return (-1);//para indicar error
	}
}
