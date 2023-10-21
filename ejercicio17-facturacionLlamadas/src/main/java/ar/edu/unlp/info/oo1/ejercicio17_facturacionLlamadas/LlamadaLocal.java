package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;
import java.time.LocalDate;

public class LlamadaLocal extends Llamada {
	
	public LlamadaLocal(LocalDate fechaInicio, int horaInicio, int minutosDuracion, long telefonoLlamador, long telefonoReceptor) {
		super(fechaInicio, horaInicio, minutosDuracion, telefonoLlamador, telefonoReceptor);
	}
	
	public double calcularCosto() {
		return super.getMinutosDuracion();
	}
}
