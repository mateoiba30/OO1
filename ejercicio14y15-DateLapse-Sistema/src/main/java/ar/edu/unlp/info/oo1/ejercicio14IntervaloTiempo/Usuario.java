package ar.edu.unlp.info.oo1.ejercicio14IntervaloTiempo;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private String direccion;
	private int dni;
	private List<Propiedad> propiedades;
	
	public Usuario(String nombre, String direccion, int dni) {
		this.nombre=nombre;
		this.direccion=direccion;
		this.dni=dni;
		this.propiedades=new ArrayList<>();
	}
	
	public Propiedad BuscarPropiedad(Propiedad propiedad) {
		return this.propiedades.stream().filter(p -> p.getNombre().equals(propiedad.getNombre())).findFirst().orElse(null);
	}
	
	public List<Propiedad> BuscarPropiedadesDisponibles(DateLapse periodo){
		return this.propiedades.stream().filter(p -> p.disponible(periodo)).collect(Collectors.toList());
	}
	
	public double calcularIngresos(DateLapse periodo) {
		return this.propiedades.stream().mapToDouble(p -> p.calcularIngresos(periodo)).sum();
	}
	
	public List<Reserva> obtenerReservas(){
		//return this.propiedades.stream().map(p -> p.getReservas().stream()).collect(Collectors.toList());   //map() se utiliza para transformar individualmente cada elemento del stream original
		return this.propiedades.stream().flatMap(p -> p.getReservas().stream()).collect(Collectors.toList()); //flatMap() se utiliza cuando necesitas transformar cada elemento en un nuevo stream y luego combinar todos esos streams intermedios en uno solo
		}
	
	public List<Propiedad> getPropiedades(){
		return this.propiedades;
	}
	
	public Propiedad registrarPropiedad(String nombre, String descripcion, String direccion, double precioPorNoche) {
		Propiedad propiedad = new Propiedad(nombre, descripcion, direccion, precioPorNoche );
		this.propiedades.add(propiedad);
		return propiedad;
	}
}
