package ar.edu.unlp.info.oo1.ejercicioAdicional_PreguntasyRespuestas;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RespuestaTest {
	private Voto voto1;
	private Voto voto2;
	private Voto voto3;
	private Respuesta respuesta;
	
	@BeforeEach
	public void setup() {
		voto1=new Voto(false);
		voto2=new Voto(false);
		voto3=new Voto(true);
		respuesta=new Respuesta ("Hola", null, null);
		respuesta.agregarVoto(voto1);
		respuesta.agregarVoto(voto2);
		respuesta.agregarVoto(voto3);
	}
	
	@Test
	public void testCalcularAdhesion() {
		assertEquals((double)1/3, respuesta.calcularAdhesion());
		respuesta.agregarVoto(voto3);
		assertEquals((double)2/4, respuesta.calcularAdhesion());
	}
	
	@Test
	public void testTieneVotoPositivo() {
		assertEquals(true, respuesta.tieneVotoPositivo());
		respuesta.eliminarVoto(voto3);
		assertEquals(false, respuesta.tieneVotoPositivo());
	}
	
	@Test
	public void testDIferenciaDeVotos() {
		assertEquals(1-2, respuesta.diferenciaDeVotos());
		respuesta.agregarVoto(voto1);
		respuesta.agregarVoto(voto3);
		assertEquals(2-3, respuesta.diferenciaDeVotos());
	}
}
