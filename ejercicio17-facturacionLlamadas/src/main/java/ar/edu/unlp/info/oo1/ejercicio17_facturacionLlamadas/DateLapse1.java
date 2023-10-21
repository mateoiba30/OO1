package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;
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
		
		if (( other.isAfter(this.from) && other.isBefore(this.to) ) || other.equals(this.from) ||  other.equals(this.to) ) //se usan equals para comparar fechas
			return true;
		else
			return false;
	}
	
	public boolean overlaps(DateLapse other) {//from o to dentro de date lapse = ver si un date lapse  se superpone con otro
//		return this.includesDate(other.getFrom()) || this.includesDate(other.getTo());
		//esto está mal, porque puede ser que si se superpongan pero el más chicho no cubre el inicio o el fin del mas grande
		return this.includesDate(other.getFrom()) || this.includesDate(other.getTo()) || other.includesDate(this.from) || other.includesDate(this.to);

	}

	public int daysOverLaps(DateLapse other) {//cantidad de días que se superponen
		if (this.overlaps(other)==false)//me salva de devolver negativos
			return 0;
		
		//cuento desde el from mas reciente hasta el to mas viejo
			DateLapse1 aux = new DateLapse1(this.from, this.to);
			if(other.getFrom().isAfter(this.from))
				aux.setFrom(other.getFrom());
			if(other.getTo().isBefore(this.to) )
				aux.setTo(other.getTo());
			return aux.sizeInDays();
	}
	
	public void setFrom(LocalDate from) {
		this.from = from;
	}
	
	public void setTo(LocalDate to) {
		this.to = to;
	}
}
