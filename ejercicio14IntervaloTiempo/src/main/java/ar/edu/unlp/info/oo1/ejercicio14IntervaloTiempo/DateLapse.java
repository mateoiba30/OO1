package ar.edu.unlp.info.oo1.ejercicio14IntervaloTiempo;
import java.time.LocalDate;

public interface DateLapse {
	
	//las interfaces no deben tener variables de instancia creo
	
	public LocalDate getFrom();
	public LocalDate getTo();
	public int sizeInDays() ;
	public boolean includesDate(LocalDate other);
}
