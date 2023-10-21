package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaTest {
	
	private Sistema sistema = new Sistema();
	private Cliente fisica1;
	private Cliente fisica2;
	private Cliente juridica1;

	@BeforeEach
	void setUp() throws Exception {
		this.sistema.agregarNumero(22123);
		this.sistema.agregarNumero(22122);
		this.sistema.agregarNumero(22165);
		
		this.fisica1= this.sistema.agregarClientePersona("Pepito", "Avenida Siempre Viva 742", 4421);
		this.fisica2 =this.sistema.agregarClientePersona("Jose", "Avenida Siempre Viva 762", 4421);
		this.juridica1 = this.sistema.agregarClienteJuridico("Holas", "Dir1", 1234, "tipo");
	}

	@Test
	void testBuscarDuenio() {
//		assertEquals(0, this.fisica1.getTelefono());
		assertEquals(this.fisica1, this.sistema.buscarDuenio(22123));
		assertEquals(this.fisica2, this.sistema.buscarDuenio(22122));
		assertEquals(this.juridica1, this.sistema.buscarDuenio(22165));
	}
	
	@Test
	void testRegistrarLlamada() {
		this.sistema.registrarLlamadaLocal(LocalDate.of(2022, 10, 6), 16 , 10, 22123, 22165);
		Factura factura1 = this.sistema.facturarLlamadas(fisica1, LocalDate.of(2022, 10, 6), LocalDate.of(2022, 10, 6));
		this.sistema.registrarLlamadaLocal(LocalDate.of(2022, 10, 6), 16, 10, 22123, 22165);
		assertEquals(2,this.fisica1.getLlamadas().size());
	}
	
	@Test
	void testFacturar() {
		this.sistema.registrarLlamadaLocal(LocalDate.of(2022, 10, 6), 16, 10, 22123, 22165);
		this.sistema.registrarLlamadaLocal(LocalDate.of(2022, 10, 6), 16, 10, 22123, 22165);
		Factura factura1 = this.sistema.facturarLlamadas(fisica1, LocalDate.of(2022, 10, 5), LocalDate.of(2022, 10, 7));
		assertEquals(18,factura1.getMonto());
		this.sistema.registrarLlamadaInterurbana(LocalDate.of(2022, 10, 6), 16, 10, 22122, 22165,99);
		Factura factura2 = this.sistema.facturarLlamadas(fisica2, LocalDate.of(2022, 10, 5), LocalDate.of(2022, 10, 7));
		assertEquals(22.5,factura2.getMonto());
		this.sistema.registrarLlamadaInternacional(LocalDate.of(2022, 10, 23), 20, 10, 22165, 22123, "Argentina", "Arabia Saudita");
		Factura factura3 = this.sistema.facturarLlamadas(juridica1, LocalDate.of(2022, 10, 23), LocalDate.of(2022, 10, 23));
		assertEquals(30,factura3.getMonto());
	}

}