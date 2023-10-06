package ar.edu.unlp.info.oo1.ejercicio13Correo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmailTest {
	
	private Archivo archivo1;
	private String nombreArchivo1;
	private Archivo archivo2;
	private String nombreArchivo2;
	private Email email;
	private String titulo;
	private String cuerpo;
	
	@BeforeEach
	public void setup() {
		nombreArchivo1="lectura.pdf";
		int tamanioArchivo = nombreArchivo1.length();
		this.archivo1 = new Archivo( nombreArchivo1 );
		
		nombreArchivo2="wordDocument.doc";
		int tamanioArchivo2 = nombreArchivo2.length();
		this.archivo2 = new Archivo( nombreArchivo2 );
		
		this.titulo="nuevoEmail";
		this.cuerpo="Buenos dias";
		this.email = new Email(titulo, cuerpo);
		email.agregarArchivo(archivo1);
		email.agregarArchivo(archivo2);
	}
	
	@Test
	public void testGetTamanio() {
		int tamanio = this.titulo.length() + this.cuerpo.length() + nombreArchivo1.length() + nombreArchivo2.length();
		assertEquals(tamanio, email.getTamanio());
	}
	
	

}
