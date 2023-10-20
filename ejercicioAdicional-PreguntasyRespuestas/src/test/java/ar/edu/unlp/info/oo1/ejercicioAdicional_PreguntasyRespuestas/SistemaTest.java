package ar.edu.unlp.info.oo1.ejercicioAdicional_PreguntasyRespuestas;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaTest {
	
	private Voto votoT;
	private Voto votoF;
	
	private Respuesta respuesta1;
	private Respuesta respuesta2;
	private Respuesta respuesta3;
	private Respuesta respuesta4;
	private Respuesta respuesta5;
	
	private Pregunta preguntaG;
	private Pregunta preguntaG2;
	private Pregunta preguntaT;
	
	private Usuario usuarioG;
	private Usuario usuarioT;
	
	private Sistema sistema;
	
	@BeforeEach
	public void setup() {
		votoT=new Voto(true);
		votoF=new Voto(false);
		
		respuesta1=new Respuesta("respuesta1", usuarioG, preguntaG);
		respuesta2=new Respuesta("respuesta2", usuarioG, preguntaG);
		respuesta3=new Respuesta("respuesta3", usuarioG, preguntaG2);
		
		respuesta4=new Respuesta("respuesta4", usuarioT, preguntaT);
		respuesta5=new Respuesta("respuesta5", usuarioT, preguntaT);
		
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
		
		respuesta5.agregarVoto(votoT);
		respuesta5.agregarVoto(votoF);
		respuesta5.agregarVoto(votoT);
		
		preguntaG = new PreguntaGeneral("preguntaG", usuarioG);
		preguntaG.agregarRespuesta(respuesta1);
		preguntaG.agregarRespuesta(respuesta2);
		
		preguntaG2= new PreguntaGeneral("preguntaG2", usuarioG);
		preguntaG2.agregarRespuesta(respuesta3);
		
		preguntaT = new PreguntaGeneral("preguntaT", usuarioT);
		preguntaT.agregarRespuesta(respuesta4);
		preguntaT.agregarRespuesta(respuesta5);
		
		usuarioG = new Usuario("Mateo", "mateoiba@gmail.com");
		usuarioG.agregarPregunta(preguntaG);
		usuarioG.agregarPregunta(preguntaG2);
		
		usuarioT = new Usuario("Sanitno", "enano@gmail.com");
		usuarioT.agregarPregunta(preguntaT);
		
		sistema=new Sistema();
		sistema.agregarUsuario(usuarioG);
		sistema.agregarUsuario(usuarioT);
	}
	
	@Test
	public void testAgregarUsuario() {
		assertEquals(sistema.getUsuarios().size(), 2);
		sistema.agregarUsuario(usuarioG);
		assertEquals(sistema.getUsuarios().size(), 3);
	}
	
	@Test 
	public void testObtenerPreguntasRespondidasPositivamente() {
		assertEquals(sistema.obtenerPreguntasRespondidasPositivamente().size(), 2);
	}
	
}