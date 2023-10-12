package ar.edu.unlp.info.oo1.ejercicio14IntervaloTiempo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

//esta es otra manera de hacer el test, esta se peor
public class DateLapse2Test {
	
	private DateLapse2 rango;
	private DateLapse2 rangoPrueba;
	
	private LocalDate before2;
	private LocalDate before;
	private LocalDate from;
	private LocalDate middle;
	private LocalDate to;
	private int longitud;
	private int longitud2;
	private LocalDate after;
	
	@BeforeEach
	public void setup() {
		this.before2=LocalDate.of(2000, 1, 1);
		this.before= LocalDate.of(2000,  1, 3);
		this.from= LocalDate.of(2000,1,5);
		this.middle= LocalDate.of(2000,  1, 7);
		this.to= LocalDate.of(2000, 1, 9);
		this.after= LocalDate.of(2000,  1, 13);
		this.longitud=4;
		this.longitud2=2;
		this.rango = new DateLapse2(this.from, this.longitud );
	}
	
	@Test
	public void testGetTo() {
		assertEquals(this.to, this.rango.getTo());
	}
	
	@Test
	public void testSizeInDays() {//2000 es año biciesto, cada 4 años
		assertEquals(this.longitud, this.rango.sizeInDays());
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
	
	public void testOverlaps() {
		rangoPrueba = new DateLapse2(this.before2, this.longitud2);
		assertFalse(rango.overlaps(rangoPrueba));
		
		rangoPrueba = new DateLapse2(this.before, this.longitud2);
		assertTrue(rango.overlaps(rangoPrueba));
		
		rangoPrueba = new DateLapse2(this.from, this.longitud2);
		assertTrue(rango.overlaps(rangoPrueba));
		
		rangoPrueba = new DateLapse2(this.middle, this.longitud2);
		assertTrue(rango.overlaps(rangoPrueba));
		
		rangoPrueba = new DateLapse2(this.to, this.longitud2);
		assertTrue(rango.overlaps(rangoPrueba));
		
		rangoPrueba = new DateLapse2(this.after, this.longitud2);
		assertFalse(rango.overlaps(rangoPrueba));
	}
	
	@Test
	public void testDaysOverLaps() {
		rangoPrueba = new DateLapse2(this.before2, 2);
		assertEquals(0, rango.daysOverLaps(rangoPrueba));
		
		rangoPrueba = new DateLapse2(this.before, this.longitud2);//local date pone todos los días en la mima hora, si coinciden en un día eso no significa que todo el día se superpongan
		assertEquals(0, rango.daysOverLaps(rangoPrueba));	//chronoUnit cuenta la cantidad de días completos
		
		rangoPrueba = new DateLapse2(this.from, this.longitud2);
		assertEquals(2, rango.daysOverLaps(rangoPrueba));
		
		rangoPrueba = new DateLapse2(this.middle, this.longitud2);
		assertEquals(2, rango.daysOverLaps(rangoPrueba));
		
		rangoPrueba = new DateLapse2(this.to, this.longitud2);
		assertEquals(0, rango.daysOverLaps(rangoPrueba));
		
		rangoPrueba = new DateLapse2(this.after, this.longitud2);
		assertEquals(0, rango.daysOverLaps(rangoPrueba));
	}
}
