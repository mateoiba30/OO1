package ar.edu.unlp.info.oo1.ejercicioAdicional_PreguntasyRespuestas;
import java.util.List;
import java.util.ArrayList;

public class Respuesta {
	private String texto;
	private List<Voto> votos;
	private Usuario autor;
	private Pregunta preguntaRespondida;
	
	public Respuesta(String texto, Usuario autor, Pregunta preguntaRespondida) {
		this.texto=texto;
		this.autor=autor;
		this.preguntaRespondida=preguntaRespondida;
		this.votos= new ArrayList<>();
	}
	
	public double calcularAdhesion() {
		return (double) this.votos.stream().filter(v -> v.getVotoAFavor()==true).count() / this.votos.size();
	}
	
	public boolean tieneVotoPositivo() {
//		return this.votos.stream().filter(v -> v.getVotoAFavor()==true).findFirst().orElse(false); //esto no se puede porque el orElse no puede devolver false
		return this.votos.stream().anyMatch(v -> v.getVotoAFavor()==true);
	}
	
	public int diferenciaDeVotos() {
		return this.votos.size() - 2* (int)this.votos.stream().filter(v -> v.getVotoAFavor()==false).count(); // total = positivos - negativos -->  total - 2*negativos = positivos - negativos
	}
	
	public void agregarVoto(Voto voto) {
		this.votos.add(voto);
	}
	
	public void eliminarVoto(Voto voto) {
		this.votos.remove(voto);
	}
	
	public String getTexto() {
		return this.texto;
	}
	
	public List<Voto> getVotos(){
		return this.votos;
	}
}
