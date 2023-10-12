package ar.edu.unlp.info.oo1.ejercicio14IntervaloTiempo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class UsuarioTest {
	private Usuario usuario;
	
	private Propiedad propiedad1;
	private Propiedad propiedad2;
	
	private DateLapse bc;
	private DateLapse de;
	private DateLapse fg;
	private DateLapse hi;
	
	private DateLapse ai;
	private DateLapse fh;
	private DateLapse ef;
	private DateLapse eg;
	private DateLapse ae;
	
	private LocalDate a;
	private LocalDate b;
	private LocalDate c;
	private LocalDate d;
	private LocalDate e;
	private LocalDate f;
	private LocalDate g;
	private LocalDate h;
	private LocalDate i;
	
	private int precioPorNoche1;
	private int precioPorNoche2;
	
	@BeforeEach
	public void setup() {
		
		this.a= LocalDate.of(2000, 1, 1);
		this.b= LocalDate.of(2000, 1, 2);
		this.c= LocalDate.of(2000, 1, 3);
		this.d= LocalDate.of(2000, 1, 5);
		this.e= LocalDate.of(2000, 1, 7);
		this.f= LocalDate.of(2000, 1, 9);
		this.g= LocalDate.of(2000, 1, 13);
		this.h= LocalDate.of(2000, 1, 14);
		this.i= LocalDate.of(2000, 1, 15);
		
		bc = new DateLapse1(this.b, this.c);
		de = new DateLapse1(this.d, this.e);
		fg = new DateLapse1(this.f, this.g);
		hi = new DateLapse1(this.h, this.i);
		
		ai = new DateLapse1(this.a, this.i);
		fh = new DateLapse1(this.f, this.h);
		ef = new DateLapse1(this.e, this.f);
		eg= new DateLapse1(this.e, this.g);
		ae= new DateLapse1(this.a, this.e);
		
		precioPorNoche1=10;
		propiedad1 = new Propiedad("propiedad1", "propiedad1", "123", precioPorNoche1);
				
		precioPorNoche2=20;
		propiedad2 = new Propiedad("propiedad2", "propiedad2", "321", precioPorNoche2);
		
		propiedad1.agregarReserva(null, bc);
		propiedad1.agregarReserva(null, de);
		propiedad2.agregarReserva(null, fg);
		
		usuario = new Usuario("Mateo", "calle 2", 45377135);
		usuario.agregrarPropiedad(propiedad1);
		usuario.agregrarPropiedad(propiedad2);	
	}
	
	@Test
	public void testBuscarPropiedad() { //el identificador de una propiedad es la dirección
		assertEquals(propiedad1.getDireccion(), usuario.buscarPropiedad(propiedad1).getDireccion());
		assertEquals(propiedad2.getDireccion(), usuario.buscarPropiedad(propiedad2).getDireccion());
	}
	
	@Test
	public void testBuscarPropiedadesDisponibles() { //el identificador de una propiedad es la dirección
		assertEquals(0, usuario.buscarPropiedadesDisponibles(ai).size());
		assertEquals(0, usuario.buscarPropiedadesDisponibles(ef).size());
		assertEquals(0, usuario.buscarPropiedadesDisponibles(eg).size());
		
		assertEquals(1, usuario.buscarPropiedadesDisponibles(fh).size());
		assertEquals(1, usuario.buscarPropiedadesDisponibles(ae).size());
		
		assertEquals(2, usuario.buscarPropiedadesDisponibles(hi).size());
	}
	
	@Test
	public void testCalcularIngresos() {
		assertEquals(110, usuario.calcularIngresos(ai));
		assertEquals(0, usuario.calcularIngresos(ef));
		assertEquals(80, usuario.calcularIngresos(eg));	
		assertEquals(80, usuario.calcularIngresos(fh));
		assertEquals(30, usuario.calcularIngresos(ae));		
		assertEquals(0, usuario.calcularIngresos(hi));
	}
	
	@Test
	public void testObtenerReservas() {
		assertEquals(3, usuario.obtenerReservas().size());
		
		usuario.agregrarPropiedad(propiedad2);
		assertEquals(4, usuario.obtenerReservas().size());
		
		usuario.agregrarPropiedad(propiedad1);
		assertEquals(6, usuario.obtenerReservas().size());
	}
	
	@Test
	public void testRegistrarPropiedad() {
		assertEquals("111", usuario.registrarPropiedad("propiedad3", "muy fea", "111", 30).getDireccion());
		assertEquals(3, usuario.obtenerReservas().size());
	}
	
}
