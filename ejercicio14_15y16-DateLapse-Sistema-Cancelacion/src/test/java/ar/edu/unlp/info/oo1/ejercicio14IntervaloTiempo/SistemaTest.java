package ar.edu.unlp.info.oo1.ejercicio14IntervaloTiempo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class SistemaTest {
	
	private Sistema sistema;
	private List<Usuario> propietarios;
	private Cancelacion politicaCancelacion;
	
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;
	
	private Propiedad propiedad1;
	private Propiedad propiedad2;
	private Propiedad propiedad3;

	private DateLapse bc;
	private DateLapse de;
	private DateLapse fg;
	private DateLapse hi;
	
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
	private int precioPorNoche3;
	
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

		politicaCancelacion = new CancelacionFlexible();
		precioPorNoche1=10;
		propiedad1 = new Propiedad("propiedad1", "propiedad1", "123", precioPorNoche1, politicaCancelacion);
				
		precioPorNoche2=20;
		propiedad2 = new Propiedad("propiedad2", "propiedad2", "321", precioPorNoche2, politicaCancelacion);
		
		precioPorNoche3=30;
		propiedad3 = new Propiedad("propiedad3", "propiedad3", "111", precioPorNoche3, politicaCancelacion);
		
		propiedad1.agregarReserva(null, bc);
		propiedad1.agregarReserva(null, de);
		propiedad2.agregarReserva(null, fg);
		propiedad3.agregarReserva(null, hi);
		
		usuario1 = new Usuario("Mateo", "calle 2", 45377135);
		usuario1.agregrarPropiedad(propiedad1);
		usuario1.agregrarPropiedad(propiedad2);	
		
		usuario2 = new Usuario("Santino", "cerro otto", 45377136);
		usuario2.agregrarPropiedad(propiedad3);
		
		propietarios = new ArrayList<>();
		propietarios.add(usuario1);
		propietarios.add(usuario2);
		
		sistema = new Sistema(propietarios);
	}
	
//	@Test
//	public void testCalcularIngresos() {
//		//todos los de un usuario
//		assertEquals(110, sistema.calcularIngresosPropietario(usuario1, a, i));
//		assertEquals(30, sistema.calcularIngresosPropietario(usuario2, a, i));
//		
//		//ninguno de un usuario
//		assertEquals(0, sistema.calcularIngresosPropietario(usuario1, e, f));
//		assertEquals(0, sistema.calcularIngresosPropietario(usuario2, e, f));
//		
////		alguno de un usuario
//		assertEquals(80, sistema.calcularIngresosPropietario(usuario1, f, i));
//		assertEquals(30, sistema.calcularIngresosPropietario(usuario2, f, i));
//	}
//	
	@Test
	public void testRegistrarUsuario() {
		usuario3 = new Usuario("Carlos", "calle 5" , 50377135);
		assertEquals(usuario3.getDni(), sistema.registrarUsuario("Carlos", "calle 5", 50377135).getDni() );
		assertEquals(3, sistema.getPropietarios().size());
	}
	
	@Test
	public void testBuscarDisponibles() {
		assertEquals(0, sistema.buscarDisponibles(a, i).size());
		assertEquals(1, sistema.buscarDisponibles(a, g).size());
		assertEquals(2, sistema.buscarDisponibles(a, e).size());
		assertEquals(1, sistema.buscarDisponibles(f, i).size());
	}

}
