package ar.edu.unlp.info.oo1.ejercicio14IntervaloTiempo;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse1 implements DateLapse  {
	
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse1(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
	}
	
	public LocalDate getFrom() {
		return this.from;
	}
	
	public LocalDate getTo() {
		return this.to;
	}
	
	public int sizeInDays() {
		return (int)ChronoUnit.DAYS.between(this.from,this.to);//hacer la conversión
	}

	public boolean includesDate(LocalDate other) {
		
		if (( other.isAfter(this.from) && other.isBefore(this.to) ) || other==this.from || other==this.to )
			return true;
		else
			return false;
	}
}
