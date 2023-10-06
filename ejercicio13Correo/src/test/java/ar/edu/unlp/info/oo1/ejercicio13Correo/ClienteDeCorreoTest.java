package ar.edu.unlp.info.oo1.ejercicio13Correo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteDeCorreoTest {

	private ClienteDeCorreo cliente;
	private Carpeta carpeta1;
	private Carpeta carpeta2;
	private Carpeta inbox;
	
	private Email email1;
	private Email email2;
	private Archivo archivo1;
	private Archivo archivo2;
	
	@BeforeEach
	public void setup() {
		this.archivo1 = new Archivo( "archivo 1" );
		this.archivo2 = new Archivo( "archivo 2" );
		
		this.email1 = new Email("1er Email", "este es el mail 1" );
		this.email2 = new Email("2do Email", "este es el email numero 2" );
		
		this.carpeta1= new Carpeta("carpeta1");
		this.carpeta2= new Carpeta("carpeta2");
		this.inbox= new Carpeta("inbox");

		this.carpeta1.agregarEmail(email1);
		this.carpeta1.agregarEmail(email2);
		this.carpeta2.agregarEmail(email1);
		this.carpeta2.agregarEmail(email2);
		this.inbox.agregarEmail(email1);
		this.inbox.agregarEmail(email2);

		
		this.cliente = new ClienteDeCorreo(this.inbox);
		this.cliente.agregarCarpeta(this.carpeta1);
		this.cliente.agregarCarpeta(this.carpeta2);
	}
	
//	private void setCarpeta(Carpeta carpeta) {
//		archivo1 = new Archivo( "archivo 1" );
//		archivo2 = new Archivo( "archivo 2" );
//		email1 = new Email("1er Email", "este es el mail 1" );
//		email2 = new Email("2do Email", "este es el email numero 2" );
////		carpeta = new Carpeta("carpeta"); //NO HACER EL NEW, ESTO HACE QUE SEA UN NUEVO PUNTERO Y QUE NO MODIFIQUE AL PARAMETRO PASADO
//		carpeta.agregarEmail(email1);	//como no puedo hacer carpeta = new Carpeta(), las variables de carpeta estan en null y no puedo llamar a alguna de sus funciones
//		carpeta.agregarEmail(email2);
//	}
//	
	@Test
	public void testMover() {
		this.cliente.mover(this.email1, this.carpeta1, this.carpeta2);
		assertEquals(null, this.carpeta1.buscarEmail("1er Email", null));
		assertEquals(this.email1, this.carpeta2.buscarEmail("1er Email", null));
	}

	@Test
	public void testBuscarEmail() {
		assertEquals(this.cliente.buscarEmail("1er Email", null), this.email1);
		assertEquals(this.cliente.buscarEmail(null, "este es el email numero 2"), this.email2);
		
		this.cliente.mover(this.email1, this.carpeta1, this.carpeta2);
		this.cliente.mover(this.email2, this.carpeta1, this.carpeta2);
		this.cliente.mover(this.email1, this.inbox, this.carpeta2);
		this.cliente.mover(this.email2, this.inbox, this.carpeta2);
		//va a encontrar en la 2da carpeta recien
		
		assertEquals(this.cliente.buscarEmail("1er Email", null), this.email1);
		assertEquals(this.cliente.buscarEmail(null, "este es el email numero 2"), this.email2);
		
	}
	
	@Test
	public void testEspacioOcupado() {
		int tamanio = this.carpeta1.getTamanio() + this.carpeta2.getTamanio() + this.inbox.getTamanio(); ; //tengo 3 carpetas de igual tamanio
		assertEquals(tamanio, this.cliente.espacioOcupado());
	}
}
