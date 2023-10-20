package ar.edu.unlp.info.oo1.ejercicioAdicional_PreguntasyRespuestas;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
	private Voto votoT;
	private Voto votoF;
	private Respuesta respuesta1;
	private Respuesta respuesta2;
	private Respuesta respuesta3;
	private Respuesta respuesta4;
	private Pregunta preguntaG;
	private Pregunta preguntaT;
	private Usuario usuario;
	
	@BeforeEach
	public void setup() {
		votoT=new Voto(true);
		votoF=new Voto(false);
		
		respuesta1=new Respuesta("respuesta1", usuario, preguntaG);
		respuesta2=new Respuesta("respuesta2", usuario, preguntaG);
		respuesta3=new Respuesta("respuesta2", usuario, preguntaT);
		respuesta4=new Respuesta("respuesta2", usuario, preguntaT);
		
		respuesta1.agregarVoto(votoT);
		respuesta1.agregarVoto(votoT);
		respuesta1.agregarVoto(votoF);
		
		respuesta2.agregarVoto(votoF);
		respuesta2.agregarVoto(votoF);
		respuesta2.agregarVoto(votoT);
		
		respuesta3.agregarVoto(votoF);
		respuesta3.agregarVoto(votoF);
		respuesta3.agregarVoto(votoF);
		
		respuesta4.agregarVoto(votoT);
		respuesta4.agregarVoto(votoT);
		respuesta4.agregarVoto(votoT);
		
		preguntaG = new PreguntaGeneral("preguntaG", usuario);
		preguntaG.agregarRespuesta(respuesta1);
		preguntaG.agregarRespuesta(respuesta2);
		
		preguntaT = new PreguntaGeneral("preguntaT", usuario);
		preguntaT.agregarRespuesta(respuesta3);
		preguntaT.agregarRespuesta(respuesta4);
		
		usuario = new Usuario("Mateo", "mateoiba@gmail.com");
		usuario.agregarPregunta(preguntaG);
		usuario.agregarPregunta(preguntaT);
	}
	
	@Test
	public void testCrearPregunta() {
		assertTrue(usuario.crearPregunta("hola", true).getTexto().equals("hola"));
		assertEquals(usuario.getPreguntas().size(), 3);
	}
	
	@Test
	public void testCrearRespuesta() {
		assertTrue(usuario.crearRespuesta("hola", preguntaG).getTexto().equals("hola"));
		assertEquals(usuario.getPreguntas().get(0).getRespuestas().size(), 3);
	}
	
	@Test
	public void testVotarRespuesta() {
		assertTrue(usuario.votarRespuesta(respuesta3, true).getVotoAFavor());
		assertEquals(respuesta3.getVotos().size(), 4);
		assertTrue(respuesta3.tieneVotoPositivo());
	}
	
	@Test
	public void testBuscarPreguntasRespondidasPositivamente() {
		assertEquals(usuario.buscarPreguntasRespondidasPositivamente().size(), 2);
		usuario.eliminarPregunta(preguntaG);
		assertEquals(usuario.buscarPreguntasRespondidasPositivamente().size(), 1);
		preguntaT.eliminarRespuesta(respuesta4);
		assertEquals(usuario.buscarPreguntasRespondidasPositivamente().size(), 0);
	}
}
