package ar.edu.unlp.info.oo1.ejercicio14IntervaloTiempo;
import java.time.LocalDate;

public interface DateLapse {
	
	//las interfaces no deben tener variables de instancia creo
	
	public LocalDate getFrom();
	public LocalDate getTo();
	public int sizeInDays() ;
	public boolean includesDate(LocalDate other);
	public boolean overlaps(DateLapse other);
	public int daysOverLaps(DateLapse other);
	public void setFrom(LocalDate from);
//	public void setTo(LocalDate to);
}
