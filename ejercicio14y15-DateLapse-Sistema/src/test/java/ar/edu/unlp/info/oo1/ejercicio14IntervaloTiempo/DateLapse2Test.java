package ar.edu.unlp.info.oo1.ejercicio14IntervaloTiempo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class DateLapse2Test {
	
	private DateLapse2 rango;
	private LocalDate from;
	private LocalDate to;
	private LocalDate middle;
	private LocalDate before;
	private LocalDate after;
	
	@BeforeEach
	public void setup() {
		this.from= LocalDate.of(2000,1,1);
		this.to= LocalDate.of(2100, 1, 1);
		this.rango = new DateLapse2(this.from, 365*100 + (2100 - 2000) / 4 );
		
		this.middle= LocalDate.of(2050,  1, 1);
		this.before= LocalDate.of(1900,  1, 1);
		this.after= LocalDate.of(2200,  1, 1);
	}
	
	@Test
	public void testGetTo() {
		assertEquals(this.to, this.rango.getTo());
	}
	
	@Test
	public void testSizeInDays() {//2000 es año biciesto, cada 4 años
		int biciestos = (2100 - 2000) / 4;
		assertEquals(365*100 + biciestos, this.rango.sizeInDays());
	}
	
	@Test
	public void testIncludesDate() {
		//analizo frontera
		assertTrue(this.rango.includesDate(this.from));
		assertTrue(this.rango.includesDate(this.to));
		
		//analizo particiones
		assertTrue(this.rango.includesDate(this.middle));
		assertFalse(this.rango.includesDate(this.before));
		assertFalse(this.rango.includesDate(this.after));
	}
}
