package ar.edu.unlp.info.oo1.ejercicio14IntervaloTiempo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class DataLapse1Test {
	
	private DateLapse1 rango;
	private DateLapse1 rango1;
	private DateLapse1 rango2;
	private DateLapse1 rango3;
	private DateLapse1 rango4;
	private DateLapse1 rango5;
	private DateLapse1 rango6;
	private DateLapse1 rangoTotal;
	
	private LocalDate before2;
	private LocalDate before;
	private LocalDate from;
	private LocalDate middle;
	private LocalDate to;
	private LocalDate after;
	private LocalDate after2;
	

	
	@BeforeEach
	public void setup() {
		this.before2=LocalDate.of(2000, 1, 1);
		this.before= LocalDate.of(2000,  1, 3);
		this.from= LocalDate.of(2000,1,5);
		this.middle= LocalDate.of(2000,  1, 7);
		this.to= LocalDate.of(2000, 1, 9);
		this.after= LocalDate.of(2000,  1, 13);
		this.after2= LocalDate.of(2000,  1, 15);
		
		this.rango = new DateLapse1(this.from, this.to);
		rango1 = new DateLapse1(this.before2, this.before);
		rango2 = new DateLapse1(this.before, this.from);
		rango3 = new DateLapse1(this.from, this.middle);
		rango4 = new DateLapse1(this.middle, this.to);
		rango5 = new DateLapse1(this.to, this.after);
		rango6 = new DateLapse1(this.after, this.after2);
		rangoTotal=new DateLapse1(before2, after2);
	}
	
	@Test
	public void testSizeInDays() {//2000 es año biciesto, cada 4 años
		assertEquals(4, this.rango.sizeInDays());
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
	
	@Test
	public void testOverlaps() {
		assertFalse(rango.overlaps(rango1));
		assertTrue(rango.overlaps(rango2));
		assertTrue(rango.overlaps(rango3));
		assertTrue(rango.overlaps(rango4));
		assertTrue(rango.overlaps(rango5));
		assertFalse(rango.overlaps(rango6));
		
		assertTrue(rangoTotal.overlaps(rango));
		assertTrue(rango.overlaps(rangoTotal));
	}
	
	@Test
	public void testDaysOverLaps() {
		assertEquals(rango.sizeInDays(), rango.daysOverLaps(rango));
		assertEquals(0, rango.daysOverLaps(rango1));//local date pone todos los días en la mima hora, si coinciden en un día eso no significa que todo el día se superpongan
		assertEquals(0, rango.daysOverLaps(rango2));	//chronoUnit cuenta la cantidad de días completos
		assertEquals(2, rango.daysOverLaps(rango3));
		assertEquals(2, rango4.daysOverLaps(rango));
		assertEquals(0, rango.daysOverLaps(rango5));
		assertEquals(0, rango.daysOverLaps(rango6));
		
		assertEquals(rango.sizeInDays(), rango.daysOverLaps(rangoTotal));
	}
}
