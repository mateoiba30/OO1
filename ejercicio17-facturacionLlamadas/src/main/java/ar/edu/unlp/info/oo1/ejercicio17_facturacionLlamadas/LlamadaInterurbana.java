package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;
import java.time.LocalDate;

public class LlamadaInterurbana extends Llamada{
	private double kmDistancia;
	
	public LlamadaInterurbana(LocalDate fechaInicio, int horaInicio, int minutosDuracion, long telefonoLlamador, long telefonoReceptor, double kmDistancia) {
		super(fechaInicio, horaInicio, minutosDuracion, telefonoLlamador, telefonoReceptor);
		this.kmDistancia=kmDistancia;
	}
	
	public double calcularCosto() {
		double multiplicador;
		if (this.kmDistancia < 100)
			multiplicador=2;
		else
			if(this.kmDistancia < 500)
				multiplicador=2.5;
			else
				multiplicador=3;
		return 5 + multiplicador*super.getMinutosDuracion();
	}
}
