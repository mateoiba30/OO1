package ar.edu.unlp.info.oo1.ejercicioAdicional_PreguntasyRespuestas;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Sistema {

	private List<Usuario> usuarios;
	
	public Sistema() {
		this.usuarios= new ArrayList<>();
	}
	
	public List<Pregunta> obtenerPreguntasRespondidasPositivamente() {
//		return this.usuarios.stream().flatMap(u -> u.getPreguntas().stream()).filter(p -> p.tieneRespuestaPositiva()).collect(Collectors.toList());
		return this.usuarios.stream().flatMap(u -> u.buscarPreguntasRespondidasPositivamente().stream()).collect(Collectors.toList());
		//lo mejor es que el usuario busque las preguntas positivas
	}
	
	public void agregarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public List<Usuario> getUsuarios(){
		return this.usuarios;
	}
}
