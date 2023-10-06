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
}
