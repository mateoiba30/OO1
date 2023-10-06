package ar.edu.unlp.info.oo1.ejercicio13Correo;

public class Archivo {
	
	private String nombre;
	//el tamanio es el largo del nombre
	
	public Archivo(String nombre) {
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getTamanio() {
		return this.nombre.length();
	}
	
}
