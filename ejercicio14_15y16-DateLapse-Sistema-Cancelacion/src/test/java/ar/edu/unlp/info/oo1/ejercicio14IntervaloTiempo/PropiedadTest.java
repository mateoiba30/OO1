package ar.edu.unlp.info.oo1.ejercicio14IntervaloTiempo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class PropiedadTest {
	
	private Propiedad propiedad;
	private Cancelacion politicaCancelacion;
	
	private Reserva reserva1;
	private Reserva reserva2;
	private Reserva reserva3;
	
	private DateLapse ab;
	private DateLapse bc;
	private DateLapse cd;
	private DateLapse de;
	private DateLapse fg;
	private DateLapse gh;
	private DateLapse hi;
	
	private DateLapse ai;
	private DateLapse fh;
	private DateLapse ef;
	private DateLapse eg;
	
	private LocalDate a;
	private LocalDate b;
	private LocalDate c;
	private LocalDate d;
	private LocalDate e;
	private LocalDate f;
	private LocalDate g;
	private LocalDate h;
	private LocalDate i;
	
	private int precioPorNoche;
	
	@BeforeEach
	public void setup() {	
		precioPorNoche=10;
		politicaCancelacion = new CancelacionFlexible();
		propiedad = new Propiedad("propiedad", "propiedad", "123", precioPorNoche, politicaCancelacion);
		
		this.a= LocalDate.of(2000, 1, 1);
		this.b= LocalDate.of(2000, 1, 2);
		this.c= LocalDate.of(2000, 1, 3);
		this.d= LocalDate.of(2000, 1, 5);
		this.e= LocalDate.of(2000, 1, 7);
		this.f= LocalDate.of(2000, 1, 9);
		this.g= LocalDate.of(2000, 1, 13);
		this.h= LocalDate.of(2000, 1, 14);
		this.i= LocalDate.of(2000, 1, 15);
		
		ab = new DateLapse1(this.a, this.b);
		bc = new DateLapse1(this.b, this.c);
		cd = new DateLapse1(this.c, this.d);
		de = new DateLapse1(this.d, this.e);
		fg = new DateLapse1(this.f, this.g);
		gh = new DateLapse1(this.g, this.h);
		hi = new DateLapse1(this.h, this.i);
		
		ai = new DateLapse1(this.a, this.i);
		fh = new DateLapse1(this.f, this.h);
		ef = new DateLapse1(this.e, this.f);
		eg= new DateLapse1(this.e, this.g);
		
		reserva1 = new Reserva(propiedad, null, bc);
		reserva2 = new Reserva(propiedad, null, de);
		reserva3 = new Reserva(propiedad, null, fg);
		
		propiedad.agregarReserva(reserva1);
		propiedad.agregarReserva(reserva2);
		propiedad.agregarReserva(reserva3);
	}
	
	@Test
	public void testAgregarReserva() {
		assertEquals(propiedad.getReservas().size(), 3);
		
		propiedad.agregarReserva(null, ab);
		assertEquals(propiedad.getReservas().size(), 3);
		
		propiedad.agregarReserva(null, cd);
		assertEquals(propiedad.getReservas().size(), 3);
		
		propiedad.agregarReserva(null, gh);
		assertEquals(propiedad.getReservas().size(), 3);
		
		propiedad.agregarReserva(null, hi);
		assertEquals(propiedad.getReservas().size(), 4);
	}
	
	@Test
	public void testDisponible() {
		assertFalse(propiedad.disponible(ab));
		assertFalse(propiedad.disponible(cd));
		assertFalse(propiedad.disponible(gh));
		assertTrue(propiedad.disponible(hi));
		
		assertFalse(propiedad.disponible(ef));
		assertFalse(propiedad.disponible(eg));
	}
	
	@Test
	public void testCalcularIngresos() {
//		assertEquals(0, propiedad.calcularIngresos(ai));
//		assertEquals(0, propiedad.calcularIngresos(fg));
//		assertEquals(0, propiedad.calcularIngresos(fh));
//		assertEquals(0, propiedad.calcularIngresos(eg));
//		assertEquals(0, propiedad.calcularIngresos(ef));
//		
//		//las reservas pasan a ser alquileres, por lo cual dan plata
//		propiedad.agregarAlquiler(reserva1);
//		propiedad.agregarAlquiler(reserva2);
//		propiedad.agregarAlquiler(reserva3);
//		
//		assertEquals(propiedad.getAlquileres().size(), 3);
		
		assertEquals(70, propiedad.calcularIngresos(ai));
		assertEquals(40, propiedad.calcularIngresos(fg));
		assertEquals(40, propiedad.calcularIngresos(fh));
		assertEquals(40, propiedad.calcularIngresos(eg));
		assertEquals(0, propiedad.calcularIngresos(ef));
	}
	
}


