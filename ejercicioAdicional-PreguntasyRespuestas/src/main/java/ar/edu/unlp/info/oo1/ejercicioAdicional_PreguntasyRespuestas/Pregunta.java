package ar.edu.unlp.info.oo1.ejercicioAdicional_PreguntasyRespuestas;

import java.util.ArrayList;
import java.util.List;

public abstract class Pregunta  {
	private String texto;
	private Usuario autor;
	private List<Respuesta> respuestas;//no poner protected porque pueden acceder todas las variables del paquete, si el hijo la usa, que use un getter
	
	public Pregunta(String texto, Usuario autor) {
		this.texto=texto;
		this.autor=autor;
		this.respuestas=new ArrayList<>();
	}
	
	abstract public Respuesta obtenerMejorRespuesta();

	public boolean tieneRespuestaPositiva() {
		return this.respuestas.stream().anyMatch(r -> r.tieneVotoPositivo()==true);
	}
	
	public void agregarRespuesta(Respuesta respuesta) {
		this.respuestas.add(respuesta);
	}
	
	public void eliminarRespuesta(Respuesta respuesta) {
		this.respuestas.remove(respuesta);
	}
	
	public List<Respuesta> getRespuestas() {
		return this.respuestas;
	}
	
	public String getTexto() {
		return this.texto;
	}
}