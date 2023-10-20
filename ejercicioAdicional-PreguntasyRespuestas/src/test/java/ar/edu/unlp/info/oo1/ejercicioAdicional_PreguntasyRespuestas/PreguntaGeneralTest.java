package ar.edu.unlp.info.oo1.ejercicioAdicional_PreguntasyRespuestas;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PreguntaGeneralTest {
	private Voto votoT;
	private Voto votoF;
	private Respuesta respuesta1;
	private Respuesta respuesta2;
	private Pregunta preguntaG;

	@BeforeEach
	public void setup() {
		votoT=new Voto(true);
		votoF=new Voto(false);
		
		respuesta1=new Respuesta("respuesta1", null, preguntaG);
		respuesta2=new Respuesta("respuesta2", null, preguntaG);
		
		respuesta1.agregarVoto(votoT);
		respuesta1.agregarVoto(votoT);
		respuesta1.agregarVoto(votoF);
		
		respuesta2.agregarVoto(votoF);
		respuesta2.agregarVoto(votoF);
		respuesta2.agregarVoto(votoT);
		
		preguntaG = new PreguntaGeneral("preguntaG", null);
		preguntaG.agregarRespuesta(respuesta1);
		preguntaG.agregarRespuesta(respuesta2);
	}
	
	@Test
	public void testObtenerMejorRespuesta() {
		assertEquals(preguntaG.obtenerMejorRespuesta(), respuesta1);//rta1 2/3 , rta2 1/3
		respuesta2.agregarVoto(votoT);
		respuesta2.agregarVoto(votoT);
		assertEquals(preguntaG.obtenerMejorRespuesta(), respuesta1);//rta2 3/5 < 2/3
		respuesta2.agregarVoto(votoT);
		respuesta2.agregarVoto(votoT);
		assertEquals(preguntaG.obtenerMejorRespuesta(), respuesta2);//rta2 5/7 > 2/3
	}
	
	@Test
	public void testTieneRespuestaPositiva() {
		assertTrue(preguntaG.tieneRespuestaPositiva());
		preguntaG.eliminarRespuesta(respuesta1);
		assertTrue(preguntaG.tieneRespuestaPositiva());
		respuesta2.eliminarVoto(votoT);
		assertFalse(preguntaG.tieneRespuestaPositiva());
		preguntaG.eliminarRespuesta(respuesta2);
		assertFalse(preguntaG.tieneRespuestaPositiva());
	}
	
	
}
