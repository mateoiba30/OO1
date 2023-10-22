package ar.edu.unlp.info.oo1.ejercicio18_liquidacionHaberes;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
//import java.util.List;
//import java.util.ArrayList;

public class SistemaTest {

	private Empleado empleadoVencido;
	private Empleado empleadoVigente;
	private Empleado empleadoVigente2;
	private Sistema sistema;
	
	@BeforeEach
	void setup() {
		empleadoVencido= new Empleado("1", "", 123, LocalDate.now(), true, true);
		empleadoVigente= new Empleado("2", "", 321, LocalDate.now(), true, true);
		empleadoVigente2= new Empleado("3", "", 111, LocalDate.now(), true, true);
		
		sistema=new Sistema();
		sistema.cargarContratoPorHoras(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 10), 0, 0, empleadoVencido);
		sistema.cargarContratoPorHoras(LocalDate.of(2022, 1, 1), LocalDate.of(2025, 1, 10), 0, 0, empleadoVigente);
		sistema.cargarContratoPorHoras(LocalDate.of(2022, 1, 1), LocalDate.of(2025, 1, 10), 0, 0, empleadoVigente2);
	}
	
	@Test
	void buscarEmpleadoTest() {//no encuantra los empleados, ni usando la version con optional ni con la version normal. problema similar al de obtenerContratoActual
		assertEquals(sistema.buscarEmpleado(111).map(e -> e.getCuit()).orElse(0l), 111);
		assertEquals(sistema.buscarEmpleado(123).map(e -> e.getCuit()).orElse(0l), 123);
		assertEquals(sistema.buscarEmpleado(321).map(e -> e.getCuit()).orElse(0l), 321);
//		assertNull(sistema.buscarEmpleado(1112));
	}
	@Test
	void obtenerEmpleadosVencidosTest() {
		assertEquals(1, sistema.obtenerEmlpeadosVencidos().size());
	}
	
	@Test
	void generarReciboSueldoTest() {
		assertEquals(1, sistema.generarRecibosSueldo().size());
	}
}
