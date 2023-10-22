package ar.edu.unlp.info.oo1.ejercicio18_liquidacionHaberes;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.ArrayList;

public class Sistema {

	private List<Empleado> empleados;
	
	public Sistema() {
		this.empleados= new ArrayList<>();
	}
	
	public void darDeAltaEmleado(String nombre, String apellido, long cuit, LocalDate fechaNacimiento, boolean tieneConyugue, boolean tieneHijos) {
		Empleado empleado = new Empleado(nombre, apellido, cuit, fechaNacimiento, tieneConyugue, tieneHijos);
		this.empleados.add(empleado);
	}
	
//	public Empleado buscarEmpleado(long cuit) {
////		return this.empleados.stream().filter(e -> e.getCuit()==cuit).findFirst().orElse(null);
//	}
	
	public Optional<Empleado> buscarEmpleado(long cuit){
		return this.empleados.stream().filter(e -> e.getCuit()==cuit).findFirst();
	}
	
	public void darDeBajaEmpleado(Empleado empleado) {
		this.empleados.remove(empleado);
	}
	
	public void cargarContratoPorHoras(LocalDate fechaInicio, LocalDate fechaFin, double valorPorHora, int horasAlMes, Empleado empleado) {
		empleado.cargarContratoPorHora(fechaInicio, fechaFin, valorPorHora, horasAlMes);
	}
	
	public void cargarContratoDePlanta(LocalDate fechaInicio, double sueldoMensual, double montoHijos, double montoConyugue, Empleado empleado) {
		empleado.cargarContratoDePlanta(fechaInicio, sueldoMensual, montoHijos, montoConyugue);
	}
	
	public List<Empleado> obtenerEmlpeadosVencidos(){
		return this.empleados.stream().filter(e -> e.obtenerContratoActual().map(c -> c.vencido()).orElse(true)==true).collect(Collectors.toList());
	}
	
	public List<ReciboSueldo> generarRecibosSueldo(){
		return this.empleados.stream().filter(e -> e.obtenerContratoActual().map(c -> c.vencido()).orElse(true) ==false).map(e -> e.agregarRecibo()).collect(Collectors.toList());
	}
}
