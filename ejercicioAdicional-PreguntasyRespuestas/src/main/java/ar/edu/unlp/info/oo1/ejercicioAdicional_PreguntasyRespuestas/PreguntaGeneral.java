package ar.edu.unlp.info.oo1.ejercicioAdicional_PreguntasyRespuestas;
import java.util.List;
import java.util.ArrayList;

public class PreguntaGeneral extends Pregunta {
//	private String texto;
//	private Usuario autor;
//	private List<Respuesta> respuestas;

	public PreguntaGeneral(String texto, Usuario autor) {
		super(texto, autor); //lamo al constructor padre
//		this.texto=texto;
//		this.autor=autor;
//		this.respuestas=new ArrayList<>();
	}
	
	public Respuesta obtenerMejorRespuesta() {
		return super.getRespuestas().stream().max((r1, r2) -> Double.compare(r1.diferenciaDeVotos(), r2.diferenciaDeVotos())).orElse(null);
	}
}
