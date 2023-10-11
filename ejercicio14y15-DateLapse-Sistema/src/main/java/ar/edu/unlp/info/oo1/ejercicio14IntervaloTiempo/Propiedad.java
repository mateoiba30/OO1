package ar.edu.unlp.info.oo1.ejercicio14IntervaloTiempo;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Propiedad {
	private String nombre;
	private String descripcion;
	private String direccion;
	private double precioPorNoche;
	private List<Reserva> reservas;
	
	public Propiedad(String nombre, String descripcion, String direccion, double precioPorNoche) {
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.direccion=direccion;
		this.precioPorNoche=precioPorNoche;
		this.reservas= new ArrayList<>();
	}
	
	public void agregarReserva(Usuario inquilino, DateLapse periodo) {
		if (this.disponible(periodo)) {
			Reserva reserva= new Reserva(this, inquilino, periodo);
			reservas.add(reserva);
		}
			
	}
	
	public boolean disponible(DateLapse periodo) { //devuleve true si ninguna reserva de la propoiedad se superpone
//		if (this.reservas.stream().filter(r -> r.disponible(periodo)==false).findFirst().orElse(null) !=null)//me quedo con el primero que se superponga (no disponible)
//			return false;//si es diferente a null, entonces hay al menos 1 false
//		else
//			return true;
		return this.reservas.stream().allMatch(r -> r.disponible(periodo)==true);
	}
	
	public List<Reserva> getReservas(){
		return this.reservas;
	}
	
	public double calcularIngresos(DateLapse periodo){//en cada reserva debo
//		return this.reservas.stream().mapToDouble(r -> r.daysOverlaps(periodo)*this.precioPorNoche).sum();
		return this.reservas.stream().mapToDouble(r -> r.calcularPrecioReserva()).sum(); //mejor usando una funcion del sistema
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void eliminarReserva(Reserva reserva){
		if (reserva.getPeriodo().getFrom().isAfter( LocalDate.now() ) )//si la reserva es posterior a la fecha de hoy
			this.reservas.remove(reserva);
	}
	
	public double getPrecioPorNoche() {
		return this.precioPorNoche;
	}
}
