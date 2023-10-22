package ar.edu.unlp.info.oo1.ejercicio18_liquidacionHaberes;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
//import java.util.List;
//import java.util.ArrayList;

public class ContratoDePlantaTest {

	private ContratoDePlanta contrato;
	private ContratoDePlanta contratoConHijos;
	private ContratoDePlanta contratoConConyugue;
	private ContratoDePlanta contratoConHijosYConyugue;
	
	private Empleado empleado;
	private Empleado empleadoConHijos;
	private Empleado empleadoConConyugue;
	private Empleado empleadoConHijosYConyugue;
	
	private double sueldoMensual;
	private double montoHijos;
	private double montoConyugue;

	@BeforeEach
	void setup() {
		sueldoMensual=123.3;
		montoHijos=321.3;
		montoConyugue=43.3;
		
		empleado = new Empleado ("", "", 0, LocalDate.now(), false, false);
		empleadoConHijos = new Empleado ("", "", 0, LocalDate.now(), false, true);
		empleadoConConyugue = new Empleado ("", "", 0, LocalDate.now(), true, false);
		empleadoConHijosYConyugue = new Empleado ("", "", 0, LocalDate.now(), true, true);
		
		contrato= new ContratoDePlanta(LocalDate.of(2023, 10, 22), sueldoMensual, montoHijos, montoConyugue, empleado);
		contratoConHijos= new ContratoDePlanta(LocalDate.of(2022, 10, 22), sueldoMensual, montoHijos, montoConyugue, empleadoConHijos);
		contratoConConyugue= new ContratoDePlanta(LocalDate.of(2022, 10, 10), sueldoMensual, montoHijos, montoConyugue, empleadoConConyugue);
		contratoConHijosYConyugue= new ContratoDePlanta(LocalDate.of(2020, 1, 1), sueldoMensual, montoHijos, montoConyugue, empleadoConHijosYConyugue);
	}
	
	@Test
	void calcularMontoBasicoTest() {
		assertEquals(sueldoMensual, contrato.calcularMontoBasico());
		assertEquals(sueldoMensual + montoHijos, contratoConHijos.calcularMontoBasico());
		assertEquals(sueldoMensual + montoConyugue, contratoConConyugue.calcularMontoBasico());
		assertEquals(sueldoMensual + montoHijos + montoConyugue, contratoConHijosYConyugue.calcularMontoBasico());
	}
	
	@Test
	void vencidoTest() {
		assertFalse(contrato.vencido());
	}
	
	@Test
	void calcularAniosTest() {
		assertEquals(0, contrato.calcularAnios());
		assertEquals(1, contratoConHijos.calcularAnios());
		assertEquals(1, contratoConConyugue.calcularAnios());
		assertEquals(3, contratoConHijosYConyugue.calcularAnios());
	}
	
	@Test
	void admiteFechaTest() {
		assertFalse(contrato.admiteFecha(LocalDate.now()));
	}
}