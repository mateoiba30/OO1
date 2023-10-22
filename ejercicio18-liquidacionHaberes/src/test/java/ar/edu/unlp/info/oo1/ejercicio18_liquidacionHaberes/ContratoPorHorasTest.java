package ar.edu.unlp.info.oo1.ejercicio18_liquidacionHaberes;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
//import java.util.List;
//import java.util.ArrayList;

public class ContratoPorHorasTest {

	private ContratoPorHoras contratoVencido;
	private ContratoPorHoras contratoFrontera;
	private ContratoPorHoras contratoVigente;
	private double valorPorHora;
	private int horasAlMes;

	@BeforeEach
	void setup() {
		valorPorHora=10.6; //probar con valores con coma, porque puede ser que me olvide de hacer una conversion a double en algun lugar
		horasAlMes=34;
		contratoVencido= new ContratoPorHoras(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 10), valorPorHora, horasAlMes);
		contratoFrontera= new ContratoPorHoras(LocalDate.of(2023,10, 22), LocalDate.of(2023, 10, 22), valorPorHora, horasAlMes);
		contratoVigente= new ContratoPorHoras(LocalDate.of(2020, 12, 1), LocalDate.of(2023, 12, 1), valorPorHora, horasAlMes);
	}
	
	@Test
	void calcularMontoBasicoTest() {
		assertEquals(valorPorHora*horasAlMes, contratoVencido.calcularMontoBasico());
	}
	
	@Test
	void vencidoTest() {
		assertTrue(contratoVencido.vencido());
		assertTrue(contratoFrontera.vencido());
		assertFalse(contratoVigente.vencido());
	}
	
	@Test
	void calcularAniosTest() {
		assertEquals(0, contratoVencido.calcularAnios());
		assertEquals(0, contratoFrontera.calcularAnios());
		assertEquals(2, contratoVigente.calcularAnios());//la fecha actual es anterior a la del fin
		contratoVigente= new ContratoPorHoras(LocalDate.of(2020, 1, 1), LocalDate.of(2023, 1, 1), valorPorHora, horasAlMes);
		assertEquals(3, contratoVigente.calcularAnios());//la fecha actual es posterior a la del fin
	}
	
	@Test
	void admiteFechaTest() {
		assertTrue(contratoVencido.admiteFecha(LocalDate.now()));
		assertTrue(contratoFrontera.admiteFecha(LocalDate.now()));
		assertFalse(contratoVigente.admiteFecha(LocalDate.of(2023, 11, 1)));
		assertFalse(contratoVigente.admiteFecha(LocalDate.of(2023, 12, 1)));
		assertTrue(contratoVigente.admiteFecha(LocalDate.of(2023, 12, 2)));
	}
}
