package ar.edu.unlp.info.oo1.ej11Inversiones;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class InversorTest {
	private Inversor inversorPlazoCero;
	private Inversor inversorAccion;
	private Inversor inversorDoble;
	private InversionEnAcciones accion;
	private PlazoFijo plazoFijoCero;
	private PlazoFijo plazoFijoCincuenta;
	
	@BeforeEach
	public void setup() {
		accion = new InversionEnAcciones("accion1", 5, 15);
		LocalDate hoy= LocalDate.now();
		LocalDate anteayer = hoy.minusDays(2);
		plazoFijoCero = new PlazoFijo(anteayer, 5, 0 );
		plazoFijoCincuenta = new PlazoFijo(anteayer, 5, 50 );
		
		inversorPlazoCero = new Inversor ("inversorPlazoCero");
		inversorAccion = new Inversor ("inversorAccion");
		inversorDoble = new Inversor ("inversorDoble");
		
		inversorPlazoCero.agregarInversion(plazoFijoCero);
		inversorAccion.agregarInversion(accion);
		inversorDoble.agregarInversion(plazoFijoCincuenta);
		inversorDoble.agregarInversion(accion);
		
	}
	
	@Test
	void testPlazoFijo() {
		assertEquals(plazoFijoCero.valorActual(), 5);
		assertEquals(plazoFijoCincuenta.valorActual(), 11.25);
	}
	
	@Test
	void testAccion() {
		assertEquals(accion.valorActual(), 5*15);
	}

	@Test
	void testInversor() {
		assertEquals(inversorPlazoCero.valorActual(), plazoFijoCero.valorActual());
		assertEquals(inversorAccion.valorActual(), accion.valorActual());
		assertEquals(inversorDoble.valorActual(), plazoFijoCincuenta.valorActual() + accion.valorActual());
	}
}
