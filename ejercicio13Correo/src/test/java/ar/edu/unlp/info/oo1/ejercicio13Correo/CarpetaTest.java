package ar.edu.unlp.info.oo1.ejercicio13Correo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarpetaTest {
	
	private Carpeta carpeta;
	private Email email1;
	private Email email2;
	private Archivo archivo1;
	private Archivo archivo2;

	@BeforeEach
	public void setup() {
		archivo1 = new Archivo( "archivo 1" );
		archivo2 = new Archivo( "archivo 2" );
		email1 = new Email("1er Email", "este es el mail 1" );
		email2 = new Email("2do Email", "este es el email numero 2" );
		this.carpeta = new Carpeta("carpeta");
		this.carpeta.agregarEmail(email1);
		this.carpeta.agregarEmail(email2);
	}
	
	//porque me deja en null los email que paso por parametro?
	public void setEmail(Email email, String titulo, String cuerpo) {
		archivo1 = new Archivo( "archivo 1" );
		archivo2 = new Archivo( "archivo 2" );
		email = new Email(titulo, cuerpo);
		email.agregarArchivo(archivo1);
		email.agregarArchivo(archivo2);
	}
	
	@Test
	public void testBuscarEmail() {
		assertEquals(this.email1, this.carpeta.buscarEmail("1er Email", null));
		assertEquals(this.email1, this.carpeta.buscarEmail(null, "este es el mail 1"));
		assertEquals(this.email2, this.carpeta.buscarEmail("2do Email", null));
		assertEquals(this.email2, this.carpeta.buscarEmail(null, "este es el email numero 2"));
	}
	
	@Test
	public void testEliminarEmail() {
		this.carpeta.eliminarEmail(email1);
		assertEquals(null, this.carpeta.buscarEmail("1er Email", "este es el mail 1"));
	}
	
	@Test
	public void testGetTamanio() {
		int tamanio = this.email1.getTamanio() + this.email2.getTamanio();
		assertEquals(tamanio, carpeta.getTamanio());
	}
}
