package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;
import java.time.LocalDate;

public class LlamadaInternacional extends Llamada{

	private String paisOrigen;
	private String paisDestino;
	
	public LlamadaInternacional(LocalDate fechaInicio, int horaInicio, int minutosDuracion, long telefonoLlamador, long telefonoReceptor, String paisOrigen, String paisDestino) {
		super(fechaInicio, horaInicio, minutosDuracion, telefonoLlamador, telefonoReceptor);
		this.paisOrigen=paisOrigen;
		this.paisDestino=paisDestino;
	}
	
	public double calcularCosto() {
		int hora = super.getHoraInicio();
		int multiplicador;
		
		if(hora >= 8 && hora < 20)
			multiplicador=4;
		else
			multiplicador=3;
		
		return super.getMinutosDuracion()*multiplicador;
	}
}
