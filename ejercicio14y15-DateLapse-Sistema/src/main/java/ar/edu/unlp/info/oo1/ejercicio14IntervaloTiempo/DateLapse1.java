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
	
	public boolean overlaps(DateLapse other) {//from o to dentro de date lapse = ver si un date lapse  se superpone con otro
		return this.includesDate(other.getFrom()) || this.includesDate(other.getTo());
	}

	public int daysOverLaps(DateLapse other) {
		if (this.overlaps(other)==false)
			return 0;
		else {//cuento desde el from mas reciente hasta el to mas viejo
			DateLapse1 aux = new DateLapse1(this.from, this.to);
			if(other.getFrom().isAfter(this.from))
				aux.setFrom(other.getFrom());
			if(other.getTo().isBefore(this.to) )
				aux.setTo(other.getTo());
			return aux.sizeInDays();
		}
	}
	
	public void setFrom(LocalDate from) {
		this.from = from;
	}
	
	public void setTo(LocalDate to) {
		this.to = to;
	}
}