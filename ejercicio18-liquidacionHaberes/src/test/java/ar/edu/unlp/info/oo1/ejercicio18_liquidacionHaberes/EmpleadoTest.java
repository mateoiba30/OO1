package ar.edu.unlp.info.oo1.ejercicio18_liquidacionHaberes;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
//import java.util.List;
//import java.util.ArrayList;

public class EmpleadoTest {
	
	private double valorPorHora;
	private int horasAlMes;
	private Empleado empleado;
	private Empleado empleado2;
	
	@BeforeEach
	void setup() {
		empleado = new Empleado("", "", 123, LocalDate.now(), true, true);
		empleado2 = new Empleado("", "", 123, LocalDate.now(), true, true);
		
		valorPorHora=10.6; //probar con valores con coma, porque puede ser que me olvide de hacer una conversion a double en algun lugar
		horasAlMes=34;

		empleado.cargarContratoPorHora(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 10), valorPorHora, horasAlMes);
		empleado.cargarContratoPorHora(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 10, 22), valorPorHora, horasAlMes);//actual vigente
		empleado.cargarContratoPorHora(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), valorPorHora, horasAlMes);
	
		empleado2.cargarContratoPorHora(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), valorPorHora, horasAlMes);

	}
	
	@Test
	void obtenerContratoActualTest() {
		assertTrue(empleado.obtenerContratoActual().map(c -> c.vencido()).orElse(false));
		empleado.cargarContratoPorHora(LocalDate.of(2023, 2, 1), LocalDate.of(2023, 12, 1), valorPorHora, horasAlMes);
		assertFalse(empleado.obtenerContratoActual().map(c -> c.vencido()).orElse(false));
	}
	
	@Test
	void calcularAntiguedadTest() {
		assertEquals(0, empleado.calcularAntiguedad());
		empleado.cargarContratoPorHora(LocalDate.of(2000, 1, 1), LocalDate.of(2020, 1, 1), valorPorHora, horasAlMes);
		empleado.cargarContratoPorHora(LocalDate.of(2020, 1, 1), LocalDate.of(2021, 1, 1), valorPorHora, horasAlMes);
		assertEquals(21, empleado.calcularAntiguedad());
	}
	
	@Test
	void calcularAumentoPorAntiguedad() {
		
		empleado2.cargarContratoPorHora(LocalDate.of(1000, 1, 1), LocalDate.of(1020, 1, 1), valorPorHora, horasAlMes);
		assertEquals(20, empleado2.calcularAntiguedad());
		
		assertEquals(0, empleado.calcularAumentoPorAntiguedad());
		
		empleado.cargarContratoPorHora(LocalDate.of(2015, 1, 1), LocalDate.of(2020, 1, 1), valorPorHora, horasAlMes);
		assertEquals(30, empleado.calcularAumentoPorAntiguedad());
		
		empleado.cargarContratoPorHora(LocalDate.of(2015, 1, 1), LocalDate.of(2020, 1, 1), valorPorHora, horasAlMes);
		assertEquals(50, empleado.calcularAumentoPorAntiguedad());
		
		empleado.cargarContratoPorHora(LocalDate.of(2015, 1, 1), LocalDate.of(2020, 1, 1), valorPorHora, horasAlMes);
		assertEquals(70, empleado.calcularAumentoPorAntiguedad());
		
		empleado.cargarContratoPorHora(LocalDate.of(2015, 1, 1), LocalDate.of(2020, 1, 1), valorPorHora, horasAlMes);
		assertEquals(100, empleado.calcularAumentoPorAntiguedad());
		
		empleado.cargarContratoPorHora(LocalDate.of(2015, 1, 1), LocalDate.of(2020, 1, 1), valorPorHora, horasAlMes);
		assertEquals(100, empleado.calcularAumentoPorAntiguedad());
	}
	
	@Test
	void calcularMontoTotalTest() {
		assertEquals(0, empleado2.calcularMontoTotal());
		
		empleado.cargarContratoPorHora(LocalDate.of(2023, 2, 1), LocalDate.of(2023, 12, 1), valorPorHora, horasAlMes);
		assertEquals(valorPorHora*horasAlMes, empleado.calcularMontoTotal());
		
		empleado2.cargarContratoPorHora(LocalDate.of(1000, 1, 1), LocalDate.of(1020, 1, 1), valorPorHora, horasAlMes);
		empleado2.cargarContratoPorHora(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 12, 1), valorPorHora, horasAlMes);

		assertEquals(3, empleado2.getContratos().size());
		assertEquals(100, empleado2.calcularAumentoPorAntiguedad());
		assertEquals(valorPorHora*horasAlMes*2, empleado2.calcularMontoTotal());
	}
}
