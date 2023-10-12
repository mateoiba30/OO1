package ar.edu.unlp.info.oo1.ejercicio14IntervaloTiempo;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private String direccion;
	private long dni;
	private List<Propiedad> propiedades;
	
	public Usuario(String nombre, String direccion, long dni) {
		this.nombre=nombre;
		this.direccion=direccion;
		this.dni=dni;
		this.propiedades=new ArrayList<>();
	}
	
	public Propiedad buscarPropiedad(Propiedad propiedad) {
		return this.propiedades.stream().filter(p -> p.getDireccion().equals(propiedad.getDireccion())).findFirst().orElse(null);
	}
	
	public List<Propiedad> buscarPropiedadesDisponibles(DateLapse periodo){
		return this.propiedades.stream().filter(p -> p.disponible(periodo)).collect(Collectors.toList());
	}
	
	public double calcularIngresos(LocalDate from, LocalDate to) {
		DateLapse periodo = new DateLapse1(from, to);
		return this.propiedades.stream().mapToDouble(p -> p.calcularIngresos(periodo)).sum();
	}
	
	public List<Reserva> obtenerReservas(){
		//return this.propiedades.stream().map(p -> p.getReservas().stream()).collect(Collectors.toList());   //map() se utiliza para transformar individualmente cada elemento del stream original
		return this.propiedades.stream().flatMap(p -> p.getReservas().stream()).collect(Collectors.toList()); //flatMap() se utiliza cuando necesitas transformar cada elemento en un nuevo stream y luego combinar todos esos streams intermedios en uno solo
		}
	
	public List<Propiedad> getPropiedades(){
		return this.propiedades;
	}
	
	public Propiedad registrarPropiedad(String nombre, String descripcion, String direccion, double precioPorNoche, Cancelacion politicaCancelacion) {
		Propiedad propiedad = new Propiedad(nombre, descripcion, direccion, precioPorNoche, politicaCancelacion);
		this.propiedades.add(propiedad);
		return propiedad;
	}
	
	public void agregrarPropiedad(Propiedad propiedad){
		this.propiedades.add(propiedad);
	}
	
	public long getDni() {
		return this.dni;
	}
}
