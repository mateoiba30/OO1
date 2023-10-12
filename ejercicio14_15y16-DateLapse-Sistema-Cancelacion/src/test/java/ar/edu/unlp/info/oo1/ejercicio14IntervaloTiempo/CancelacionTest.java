package ar.edu.unlp.info.oo1.ejercicio14IntervaloTiempo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class CancelacionTest {
	Cancelacion cancelacionFlexible;
	Cancelacion cancelacionModerada;
	Cancelacion cancelacionEstricta;

	private DateLapse periodo;
	
	private Reserva reservaFlexible;
	private Reserva reservaModerada;
	private Reserva reservaEstricta;
	
	private LocalDate from1WeekBefore;
	private LocalDate from4DaysBefore;
	private LocalDate from2DaysBefore;
	private LocalDate fromADaysBefore;
	private LocalDate from;
	private LocalDate to;
	
	private int precioPorNoche;
	private Propiedad propiedadFlexible;
	private Propiedad propiedadModerada;
	private Propiedad propiedadEstricta;
	
	@BeforeEach
	public void setup() {
		from1WeekBefore= LocalDate.of(2000, 1, 1);
		from4DaysBefore= LocalDate.of(2000, 1, 4);
		from2DaysBefore= LocalDate.of(2000, 1, 6);
		fromADaysBefore= LocalDate.of(2000, 1, 7);
		
		from= LocalDate.of(2000, 1, 8);
		to= LocalDate.of(2000, 1, 10);
		periodo = new DateLapse1(from, to);
		precioPorNoche=10;
		
		propiedadFlexible = new Propiedad("propiedad", "propiedad", "123", precioPorNoche, cancelacionFlexible);
		propiedadModerada = new Propiedad("propiedad", "propiedad", "321", precioPorNoche, cancelacionModerada);
		propiedadEstricta = new Propiedad("propiedad", "propiedad", "111", precioPorNoche, cancelacionEstricta);
		
		reservaFlexible= new Reserva(propiedadFlexible, null, periodo);
		reservaModerada= new Reserva(propiedadModerada, null, periodo);
		reservaEstricta= new Reserva(propiedadEstricta, null, periodo);
		
		propiedadFlexible.agregarReserva(reservaFlexible);
		propiedadModerada.agregarReserva(reservaModerada);
		propiedadEstricta.agregarReserva(reservaEstricta);
		
		cancelacionFlexible = new CancelacionFlexible();
		cancelacionModerada = new CancelacionModerada();
		cancelacionEstricta = new CancelacionEstricta();
	}
	
	@Test
	public void testCalcularReembolsoFlexible() {
		assertEquals(reservaFlexible.calcularPrecioReserva(), cancelacionFlexible.calcularReembolso(reservaFlexible, from1WeekBefore));
		assertEquals(reservaFlexible.calcularPrecioReserva(), cancelacionFlexible.calcularReembolso(reservaFlexible, from4DaysBefore));
		assertEquals(reservaFlexible.calcularPrecioReserva(), cancelacionFlexible.calcularReembolso(reservaFlexible, from2DaysBefore));
		assertEquals(reservaFlexible.calcularPrecioReserva(), cancelacionFlexible.calcularReembolso(reservaFlexible, fromADaysBefore));
		assertEquals(-1, cancelacionFlexible.calcularReembolso(reservaFlexible, from));
	}
	
	@Test
	public void testCalcularReembolsoModerada() {
	    assertEquals(reservaModerada.calcularPrecioReserva(), cancelacionModerada.calcularReembolso(reservaModerada, from1WeekBefore));
	    assertEquals((double)reservaModerada.calcularPrecioReserva()/2, cancelacionModerada.calcularReembolso(reservaModerada, from4DaysBefore));
	    assertEquals((double)reservaModerada.calcularPrecioReserva()/2, cancelacionModerada.calcularReembolso(reservaModerada, from2DaysBefore));
	    assertEquals(0, cancelacionModerada.calcularReembolso(reservaModerada, fromADaysBefore));
	    assertEquals(-1, cancelacionModerada.calcularReembolso(reservaModerada, from));
	}
	
	@Test
	public void testCalcularReembolsoEstricta() {
	    assertEquals(0, cancelacionEstricta.calcularReembolso(reservaEstricta, from1WeekBefore));
	    assertEquals(0, cancelacionEstricta.calcularReembolso(reservaEstricta, from4DaysBefore));
	    assertEquals(0, cancelacionEstricta.calcularReembolso(reservaEstricta, from2DaysBefore));
	    assertEquals(0, cancelacionEstricta.calcularReembolso(reservaEstricta, fromADaysBefore));
	    assertEquals(-1, cancelacionEstricta.calcularReembolso(reservaEstricta, from));
	}


}
