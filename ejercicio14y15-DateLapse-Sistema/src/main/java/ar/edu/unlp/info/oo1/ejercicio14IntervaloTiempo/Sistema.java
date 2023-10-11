package ar.edu.unlp.info.oo1.ejercicio14IntervaloTiempo;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.time.LocalDate;

public class Sistema {
	private List<Usuario> propietarios;
	
	public Sistema() {
		this.propietarios = new ArrayList<>();
	}
	
	public double calcularIngresosPropietario(Usuario usuario, LocalDate from, LocalDate to) {
		DateLapse periodo = new DateLapse1(from, to);
		return usuario.calcularIngresos(periodo);//no necesario buscarlo entre la lista de propietarios, sería necesario si me pasan solo el nombre
	}
	
	public void eliminarReserva(Reserva reserva) {
		//solucion cuando la reserva no decia la propiedad// this.propietarios.stream().map(user -> user.getPropiedades().stream().map(prop -> prop.getReservas().remove(reserva))); //en cada propiedad hago: propiedad.remove(reserva), y si no la tiene no pasa nada
		reserva.getPropiedad().eliminarReserva(reserva);
	}
	
	public double calcularPrecioReserva(Reserva reserva) {
//		this.propietarios.stream().map(user -> user.getPropiedades().stream().filter(prop -> prop.getNombre().equals(reserva.getPropiedad().getNombre())) );
//				stream().map(prop -> prop.getReservas())).filter( res -> res.(reserva));
		return reserva.calcularPrecioReserva();
	}
	
	public Usuario registrarUsuario(String nombre, String direccion, int dni) {
		Usuario usuario = new Usuario(nombre, direccion, dni);
		return usuario;
	}
	
	public Propiedad registrarPropiedad(String nombre, String descripcion, String direccion, double precioPorNoche, Usuario propietario) {
		return propietario.registrarPropiedad(nombre, descripcion, direccion, precioPorNoche);
	}
	
	public List<Propiedad> buscarDisponibles(LocalDate inicio, LocalDate fin){
		DateLapse periodo = new DateLapse1(inicio, fin);
		return this.propietarios.stream().flatMap(user -> user.getPropiedades().stream()).filter(pro -> pro.disponible(periodo)).collect(Collectors.toList());
	}
	
	public void hacerReserva(Propiedad propiedad, DateLapse periodo, Usuario inquilino) {
//		Reserva reserva = new Reserva(propiedad, inquilino, periodo); //mejor esto hacerlo en usuario
		propiedad.agregarReserva(inquilino, periodo);
	}
}
