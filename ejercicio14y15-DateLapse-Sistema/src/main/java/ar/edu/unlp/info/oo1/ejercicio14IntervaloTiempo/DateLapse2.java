package ar.edu.unlp.info.oo1.ejercicio14IntervaloTiempo;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse2 implements DateLapse {
	
	private LocalDate from;
	private int sizeInDays;
	
	public DateLapse2(LocalDate from, int sizeInDays) {
		this.from = from;
		this.sizeInDays= sizeInDays;
	}
	
	public LocalDate getFrom() {
		return this.from;
	}
	
	public LocalDate getTo() {
		LocalDate to = LocalDate.of(1,  1,  1);
		
		while ( ChronoUnit.DAYS.between(this.from, to) != this.sizeInDays)
			to = to.plusDays(1);
		
		return to;
	}
	
	public int sizeInDays() {
		return this.sizeInDays;
	}

	public boolean includesDate(LocalDate other) {
		
		//asegurarme de analizar si devuelve un valor negativo, donde significa que other es anterior a from
		int diferencia = (int)ChronoUnit.DAYS.between(this.from, other);
		if (  diferencia <= this.sizeInDays && diferencia >= 0 )
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
			DateLapse1 aux = new DateLapse1(this.from, this.getTo());
			if(other.getFrom().isAfter(this.from))
				aux.setFrom(other.getFrom());
			if(other.getTo().isBefore(this.getTo()) )
				aux.setTo(other.getTo());
			return aux.sizeInDays();
		}
	}
	
	public void setFrom(LocalDate from) {
		this.from = from;
	}
}
