package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente {
	private String nombre;
	private String direccion;
	private List<Llamada> llamadas;
	private int telefono;
	private List<Factura> facturas;
	
	public Cliente(String nombre, String direccion, int telefono) {
		this.nombre=nombre;
		this.direccion=direccion;
		this.llamadas= new ArrayList<>();
		this.telefono=telefono;
		this.facturas= new ArrayList<>();//no olvidar
	}

	public double calcularMonto(DateLapse periodo) {
		return this.llamadas.stream().filter(l -> periodo.includesDate(l.getFechaInicio())==true).mapToDouble(l -> l.calcularCosto()).sum();
	}
	
	public long getTelefono() {
		return this.telefono;
	}
	
	public void agregarLlamada(Llamada llamada) {
		this.llamadas.add(llamada);
	}
	
	public void agregarFactura(Factura factura) {
		this.facturas.add(factura);
	}
	
	public List<Llamada> getLlamadas(){
		return this.llamadas;
	}
	
	public LlamadaLocal registrarLlamadaLocal(LocalDate fechaInicio, int horaInicio, int minutosDuracion, long telefonoLlamador, long telefonoReceptor) {
		LlamadaLocal llamada= new LlamadaLocal(fechaInicio, horaInicio, minutosDuracion, telefonoLlamador, telefonoReceptor);
		this.llamadas.add(llamada);
		return llamada;
	}
	
	public LlamadaInterurbana registrarLlamadaInterurbana(LocalDate fechaInicio, int horaInicio, int minutosDuracion, long telefonoLlamador, long telefonoReceptor, double kmDistancia) {
		LlamadaInterurbana llamada = new LlamadaInterurbana(fechaInicio, horaInicio, minutosDuracion, telefonoLlamador, telefonoReceptor, kmDistancia);
		this.llamadas.add(llamada);
		return llamada;
	}
	
	public LlamadaInternacional registrarLlamadaInternacional(LocalDate fechaInicio, int horaInicio, int minutosDuracion, long telefonoLlamador, long telefonoReceptor, String paisOrigen, String paisDestino) {
		LlamadaInternacional llamada = new LlamadaInternacional(fechaInicio, horaInicio, minutosDuracion, telefonoLlamador, telefonoReceptor, paisOrigen, paisDestino);
		this.llamadas.add(llamada);
		return llamada;
	}
	
	public Factura facturarLlamadas(DateLapse periodo) {//delegar tarea al mas cercano
		Factura factura = new Factura (this, periodo, this.calcularMonto(periodo));
		this.agregarFactura(factura);
		return factura;
	}
}
