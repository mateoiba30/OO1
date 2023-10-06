package ar.edu.unlp.info.oo1.ejercicio13Correo;
import java.util.List;
import java.util.ArrayList;

public class Email {

	private String titulo;
	private String cuerpo;
	private List<Archivo> adjuntos;
	
	public Email(String titulo, String cuerpo) {
		this.titulo=titulo;
		this.cuerpo=cuerpo;
		this.adjuntos = new ArrayList<>();
		}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	
	public List<Archivo> getAdjuntos(){
		return this.adjuntos;
	}
	
	public void agregarArchivo( Archivo archivo) {
		this.adjuntos.add(archivo);
	}
	
	public int getTamanio() { //El tamaño de un email es la suma del largo del título, el largo del cuerpo, y del tamaño de sus adjuntos
		
		int tamanio=this.titulo.length();
		tamanio+=this.cuerpo.length();
		
//		for (Archivo archivo : adjuntos) 
//			tamanio+=archivo.getTamanio();
//		
//		return tamanio;
		
		return tamanio + this.adjuntos.stream().mapToInt(a -> a.getTamanio()).sum();
	}
	
	public boolean esIgual(String titulo, String cuerpo) {
		if (this.titulo.equals(titulo) || this.cuerpo.equals(cuerpo))
			return true;
		else
			return false;
		//getTitulo().equals(titulo) || e.getCuerpo().equals(cuerpo);
	}
	
}
