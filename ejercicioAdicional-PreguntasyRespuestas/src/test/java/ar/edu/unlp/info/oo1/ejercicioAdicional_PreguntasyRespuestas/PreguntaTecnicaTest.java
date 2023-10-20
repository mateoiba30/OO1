package ar.edu.unlp.info.oo1.ejercicioAdicional_PreguntasyRespuestas;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PreguntaTecnicaTest {
	private Voto votoT;
	private Voto votoF;
	private Respuesta respuesta1;
	private Respuesta respuesta2;
	private Pregunta preguntaT;

	@BeforeEach
	public void setup() {
		votoT=new Voto(true);
		votoF=new Voto(false);
		
		respuesta1=new Respuesta("respuesta1", null, preguntaT);
		respuesta2=new Respuesta("respuesta2", null, preguntaT);
		
		respuesta1.agregarVoto(votoT);
		respuesta1.agregarVoto(votoT);
		respuesta1.agregarVoto(votoF);
		
		respuesta2.agregarVoto(votoF);
		respuesta2.agregarVoto(votoF);
		respuesta2.agregarVoto(votoT);
		
		preguntaT = new PreguntaTecnica("preguntaT", null);
		preguntaT.agregarRespuesta(respuesta1);
		preguntaT.agregarRespuesta(respuesta2);
	}
	
	@Test
	public void testObtenerMejorRespuesta() {
		assertEquals(preguntaT.obtenerMejorRespuesta(), respuesta1);//rta1 2/3 , rta2 1/3
		respuesta2.agregarVoto(votoT);
		respuesta2.agregarVoto(votoT);
		assertEquals(preguntaT.obtenerMejorRespuesta(), respuesta1);//rta2 3/5 < 2/3
		respuesta2.agregarVoto(votoT);
		respuesta2.agregarVoto(votoT);
		assertEquals(preguntaT.obtenerMejorRespuesta(), respuesta2);//rta2 5/7 > 2/3
	}
	
	@Test
	public void testTieneRespuestaPositiva() {
		assertTrue(preguntaT.tieneRespuestaPositiva());
		preguntaT.eliminarRespuesta(respuesta1);
		assertTrue(preguntaT.tieneRespuestaPositiva());
		respuesta2.eliminarVoto(votoT);
		assertFalse(preguntaT.tieneRespuestaPositiva());
		preguntaT.eliminarRespuesta(respuesta2);
		assertFalse(preguntaT.tieneRespuestaPositiva());
	}
	
	
}