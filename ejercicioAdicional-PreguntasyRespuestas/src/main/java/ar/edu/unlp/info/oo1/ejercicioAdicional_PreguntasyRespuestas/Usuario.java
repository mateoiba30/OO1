package ar.edu.unlp.info.oo1.ejercicioAdicional_PreguntasyRespuestas;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Usuario {
	
	private String nombre;
	private String email;
	private List<Pregunta> preguntas;
	
	public Usuario(String nombre, String email) {
		this.nombre=nombre;
		this.email=email;
		this.preguntas=new ArrayList<>();	
	}
	
	public void agregarPregunta(Pregunta pregunta) {
		this.preguntas.add(pregunta);
	}
	
	public void eliminarPregunta(Pregunta pregunta) {
		this.preguntas.remove(pregunta);
	}
	
	public Pregunta crearPregunta(String texto, boolean esTecnica) {
		Pregunta pregunta;
		if(esTecnica)
			pregunta=new PreguntaTecnica(texto, this);
		else
			pregunta=new PreguntaGeneral(texto, this);
		this.preguntas.add(pregunta);
		return pregunta;
	}
	
	public Respuesta crearRespuesta(String texto, Pregunta pregunta) {
		Respuesta respuesta = new Respuesta(texto, this, pregunta);
		pregunta.agregarRespuesta(respuesta);
		return respuesta;
	}
	
	public Voto votarRespuesta(Respuesta respuesta, boolean votoPositivo) {
		Voto voto = new Voto(votoPositivo);
		respuesta.agregarVoto(voto);
		return voto;
	}
	
	public List<Pregunta> getPreguntas(){
		return this.preguntas;
	}
	
	public List<Pregunta> buscarPreguntasRespondidasPositivamente(){
		return this.preguntas.stream().filter(p -> p.tieneRespuestaPositiva()).collect(Collectors.toList());
	}
}
