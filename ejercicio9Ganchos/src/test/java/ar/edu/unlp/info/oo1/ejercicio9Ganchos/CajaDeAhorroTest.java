package ar.edu.unlp.info.oo1.ejercicio9Ganchos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CajaDeAhorroTest {
	
	private CajaDeAhorro cajaCero;//las variables que seteo en beforeeach
	private CajaDeAhorro caja200;
	private double aumento;
	private double descuento;
	
	@BeforeEach
	public void setup() {
		this.cajaCero = new CajaDeAhorro(0);
		this.caja200 = new CajaDeAhorro(200);
		this.aumento=1.02;
		this.descuento=0.98;
	}
	
	@Test
	public void testConstructor() {
		assertEquals(0, cajaCero.getSaldo());
	}
	
	@Test
	public void testPuedeExtraer() {
		assertTrue(this.cajaCero.puedeExtraer(0));
		assertTrue(this.caja200.puedeExtraer(200*this.descuento));
		assertFalse(this.caja200.puedeExtraer(200));
	}
	
	@Test
	public void testExtraerSinControlar() {
		this.caja200.extraerSinControlar(200);
		assertEquals(this.caja200.getSaldo(), 200-200*aumento);
	}
	
	@Test
	public void testDepostitar() {
		this.cajaCero.depositar(100);
		assertEquals(100*descuento, cajaCero.getSaldo());
	}
	
}
