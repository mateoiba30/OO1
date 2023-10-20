package ar.edu.unlp.info.oo1.ejercicioAdicional_PreguntasyRespuestas;
import java.time.LocalDate;

public class Voto {
	private boolean votoAFavor;
	private LocalDate fecha;
	
	public Voto(boolean votoAFavor) {
		this.votoAFavor = votoAFavor;
		this.fecha=LocalDate.now();
	}
	
	public boolean getVotoAFavor() {
		return this.votoAFavor;
	}
	
}
