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
	private List<Reserva> alquileres;
	private Cancelacion politicaCancelacion;
	
	public Propiedad(String nombre, String descripcion, String direccion, double precioPorNoche, Cancelacion politicaCancelacion) {
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.direccion=direccion;
		this.precioPorNoche=precioPorNoche;
		this.reservas= new ArrayList<>();
		this.alquileres= new ArrayList<>();
		this.politicaCancelacion=politicaCancelacion;
	}
	
	public Cancelacion getPoliticaCancelacion() {
		return this.politicaCancelacion;
	}
	
	public void agregarReserva(Usuario inquilino, DateLapse periodo) {
		if (this.disponible(periodo)) {
			Reserva reserva= new Reserva(this, inquilino, periodo);
			reservas.add(reserva);
		}
			
	}
	
	//esta es para facilitar los tests
	public void agregarReserva(Reserva reserva) {
		if (this.disponible(reserva.getPeriodo())) {
			reservas.add(reserva);
		}
			
	}
	
	public boolean disponible(DateLapse periodo) { //devuleve true si ninguna reserva de la propoiedad se superpone
//		if (this.reservas.stream().filter(r -> r.disponible(periodo)==false).findFirst().orElse(null) !=null)//me quedo con el primero que se superponga (no disponible)
//			return false;//si es diferente a null, entonces hay al menos 1 false
//		else
//			return true;
		return this.reservas.stream().allMatch(r -> r.disponible(periodo)==true) && this.alquileres.stream().allMatch(r -> r.disponible(periodo)==true) ;
	}
	
	public List<Reserva> getReservas(){
		return this.reservas;
	}
	
	public List<Reserva> getAlquileres(){
		return this.alquileres;
	}
	
	//si al cancelar una reserva se devuelve plata, entonces al calcular los ingresos debo calcular reservas  y alquileres
	public double calcularIngresos(DateLapse periodo){//en cada reserva debo calcular los ingresoso de los alquileres, de las reservas no porque estas se pueden cancelar
//		return this.reservas.stream().mapToDouble(r -> r.daysOverlaps(periodo)*this.precioPorNoche).sum();
//	estas soluciones anteriores eran solo para evaluar todas las reservas	return this.reservas.stream().mapToDouble(r -> r.calcularPrecioReserva()).sum(); //mejor usando una funcion del sistema
		return this.alquileres.stream().mapToDouble(r -> r.getPeriodo().daysOverLaps(periodo) * this.precioPorNoche).sum() + this.reservas.stream().mapToDouble(r -> r.getPeriodo().daysOverLaps(periodo) * this.precioPorNoche).sum();
	}
	
	public String getDireccion() {
		return this.direccion;
	}
	
	public void eliminarReserva(Reserva reserva){
		if (reserva.getPeriodo().getFrom().isAfter( LocalDate.now() ) )//si la reserva es posterior a la fecha de hoy
			this.reservas.remove(reserva);
	}
	
	public double getPrecioPorNoche() {
		return this.precioPorNoche;
	}
	
	public void agregarAlquiler(Reserva alquiler) {
		this.alquileres.add(alquiler);
	}
	
	//para los tests
	public void agregarAlquiler(Usuario inquilino, DateLapse periodo) {
		Reserva alquiler = new Reserva(this, inquilino, periodo);
		this.alquileres.add(alquiler);
	}
}
