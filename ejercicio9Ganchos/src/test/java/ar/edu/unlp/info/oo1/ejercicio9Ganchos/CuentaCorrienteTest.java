package ar.edu.unlp.info.oo1.ejercicio9Ganchos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaCorrienteTest {
	
	private CuentaCorriente cajaCero;//las variables que seteo en beforeeach
	private double descubierto;
	
	@BeforeEach
	public void setup() {
		this.descubierto=100;
		this.cajaCero = new CuentaCorriente(0, this.descubierto);
		
	}
	
	@Test
	public void testPuedeExtraerEn() {
		assertTrue( cajaCero.puedeExtraer( this.descubierto -1 ));
		assertFalse( cajaCero.puedeExtraer(this.descubierto + 1));
	}
}
