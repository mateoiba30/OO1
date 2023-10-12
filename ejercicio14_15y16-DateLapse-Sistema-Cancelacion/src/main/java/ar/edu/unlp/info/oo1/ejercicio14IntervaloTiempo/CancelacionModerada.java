package ar.edu.unlp.info.oo1.ejercicio14IntervaloTiempo;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CancelacionModerada implements Cancelacion {
	
	public double calcularReembolso(Reserva reserva,  LocalDate fecha) {
		int diasDeAnticipacion = (int) ChronoUnit.DAYS.between(fecha, reserva.getPeriodo().getFrom());//la primer fecha debe ser anterior
		
		if(diasDeAnticipacion >= 7)
			return reserva.calcularPrecioReserva();
		else
			if(diasDeAnticipacion >=2 )
				return (double) reserva.calcularPrecioReserva() / 2;
			else 
				if (diasDeAnticipacion > 0)
					return 0;
				else
					return (-1); //indica error, el alquiler ya inicio hace unos días atrás
	}
}