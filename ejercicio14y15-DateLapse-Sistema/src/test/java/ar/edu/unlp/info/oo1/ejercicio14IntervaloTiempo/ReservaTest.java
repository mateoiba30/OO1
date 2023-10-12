package ar.edu.unlp.info.oo1.ejercicio14IntervaloTiempo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class ReservaTest {
	
	private Reserva reserva;
	private Propiedad propiedad;
	private double precio;

	private DateLapse periodo;
	private LocalDate before2;
	private LocalDate before;
	private LocalDate from;
	private LocalDate middle;
	private LocalDate to;
	private LocalDate after;
	private LocalDate after2;
	
	private DateLapse1 rango1;
	private DateLapse1 rango2;
	private DateLapse1 rango3;
	private DateLapse1 rango4;
	private DateLapse1 rango5;
	private DateLapse1 rango6;
	
	@BeforeEach
	public void setup() {
		this.precio=10.2;
		this.propiedad = new Propiedad("casa", "casa", "123", this.precio);
		
		this.before2=LocalDate.of(2000, 1, 1);
		this.before= LocalDate.of(2000,  1, 3);
		this.from= LocalDate.of(2000,1,5);
		this.middle= LocalDate.of(2000,  1, 7);
		this.to= LocalDate.of(2000, 1, 9);
		this.after= LocalDate.of(2000,  1, 13);
		this.after2= LocalDate.of(2000,  1, 15);
		
		this.periodo = new DateLapse1(this.from, this.to);
		rango1 = new DateLapse1(this.before2, this.before);
		rango2 = new DateLapse1(this.before, this.from);
		rango3 = new DateLapse1(this.from, this.middle);
		rango4 = new DateLapse1(this.middle, this.to);
		rango5 = new DateLapse1(this.to, this.after);
		rango6 = new DateLapse1(this.after, this.after2);
		
		this.reserva=new Reserva(this.propiedad, null, this.periodo);
	}
	
	@Test
	public void testDisponible() {
		assertTrue(this.reserva.disponible(rango1));
		assertFalse(this.reserva.disponible(rango2));//si un día coincide pongo false, porque no estoy teniendo en cuenta la hora
		assertFalse(this.reserva.disponible(rango3));
		assertFalse(this.reserva.disponible(rango4));
		assertFalse(this.reserva.disponible(rango5));
		assertTrue(this.reserva.disponible(rango6));
	}
	
	@Test
	public void testOverlaps() {
		assertFalse(periodo.overlaps(rango1));
		assertTrue(periodo.overlaps(rango2));
		assertTrue(periodo.overlaps(rango3));
		assertTrue(periodo.overlaps(rango4));
		assertTrue(periodo.overlaps(rango5));
		assertFalse(periodo.overlaps(rango6));
	}
}
