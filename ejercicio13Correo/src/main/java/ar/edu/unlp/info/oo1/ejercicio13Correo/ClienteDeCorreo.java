package ar.edu.unlp.info.oo1.ejercicio13Correo;
import java.util.List;
import java.util.ArrayList;

public class ClienteDeCorreo {
	
	private Carpeta inbox; //inbox = carpeta especifica, si tuviera varias carpetas especificas las agregaría a todas al inicio de la lista y además tener un arreglo de estas carpetas especiaes
	private List<Carpeta> carpetas;
	
	public ClienteDeCorreo(Carpeta inbox) {
		this.inbox=inbox;
		this.carpetas= new ArrayList<>();
		this.carpetas.add(inbox); //el agregar nibox acá hace que se me simplifiquen las busquedas de los siguientes modulos
	}
	
	public void recibir(Email email){
		this.inbox.agregarEmail(email);
	}
	
	public void mover(Email email, Carpeta origen, Carpeta destino) {
			origen.eliminarEmail(email);
			destino.agregarEmail(email);
	}
	
	public Email buscarEmail(String titulo, String cuerpo) {
		
//		for ( Carpeta carpeta : carpetas){ //es como el for i in ${array[*]}
//			Email email = carpeta.buscarEmail(titulo, cuerpo);
//			if (carpeta.buscarEmail(titulo, cuerpo) !=null )
//				return email;
//		}
//		return null;
				
		return this.carpetas.stream().map(c -> c.buscarEmail(titulo, cuerpo)).filter(e -> e != null).findFirst().orElse(null); //si pongo collectors devuleve una lista, así devuelve el primer objeto que coincida
	}
	
	public int espacioOcupado() {
		return this.carpetas.stream().mapToInt(c -> c.getTamanio()).sum();
	}
	
	public void agregarCarpeta(Carpeta carpeta) {
		this.carpetas.add(carpeta);
	}
}
