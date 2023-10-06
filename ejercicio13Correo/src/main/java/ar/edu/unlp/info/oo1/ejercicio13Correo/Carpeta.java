package ar.edu.unlp.info.oo1.ejercicio13Correo;
import java.util.List;
import java.util.ArrayList;

public class Carpeta {//es una carpeta de emails (quien los agrupa lo hace porque tienen algo en comun)

	private List<Email> emails;
	private String nombre;
	
	public Carpeta(String nombre) {
		this.nombre=nombre;
		this.emails= new ArrayList<>();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarEmail(Email email) {
		this.emails.add(email);//recordar que add agrega al final
	}
	
	public void eliminarEmail(Email email) {
//		this.emails= this.emails.stream().filter(e -> ! e.getTitulo().equals(email.getTitulo())).collect(Collectors.toList()); //me quedo con los mails diferentes al titulo
		//NO OLVIDAR IGUALAR AL INICIO
		
		//this.emails.remove me sirve mejor
		this.emails.remove(email);
	}
	
	public Email buscarEmail(String titulo, String cuerpo) {
		return this.emails.stream().filter(e -> e.esIgual(titulo, cuerpo) == true ).findFirst().orElse(null); //si pongo collectors devuleve una lista, así devuelve el primer objeto que coincida
	}//	return this.emails.stream().filter(e -> e.getTitulo().equals(titulo) || e.getCuerpo().equals(cuerpo)) = true ).findFirst().orElse(null);//delegarle este metodo al email

	public int getTamanio() {
		return this.emails.stream().mapToInt(e -> e.getTamanio()).sum();
	}
}
