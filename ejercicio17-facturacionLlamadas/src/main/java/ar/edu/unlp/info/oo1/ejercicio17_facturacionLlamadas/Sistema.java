package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Sistema {
	private List<Integer> numerosDisponibles; //uso el wrapper de long para la coleccion
	private List<Cliente> clientes;
	
	public Sistema() {
		this.numerosDisponibles= new ArrayList<>();
		this.clientes= new ArrayList<>();
	}
	
	public void agregarNumero(int numero) {
		this.numerosDisponibles.add(numero);
	}
	
	public ClientePersona agregarClientePersona(String nombre, String direccion, long dni) {
		ClientePersona cliente = new ClientePersona(nombre, direccion, dni, this.numerosDisponibles.get(0));
		this.numerosDisponibles.remove(0);
		this.clientes.add(cliente);
		return cliente;
	}
	
	public ClienteJuridico agregarClienteJuridico(String nombre, String direccion, int cuit, String tipo) {
		ClienteJuridico cliente = new ClienteJuridico(nombre, direccion, this.numerosDisponibles.get(0), cuit, tipo);
		this.numerosDisponibles.remove(0);
		this.clientes.add(cliente);
		return cliente;
	}
	
	public LlamadaLocal registrarLlamadaLocal(LocalDate fechaInicio, int horaInicio, int minutosDuracion, int telefonoLlamador, int telefonoReceptor) {//debo delegar esta tarea al cliente, que es quien hace las llamadas (el mas cercano a la llamada que lo puede hacer)
		Cliente llamador= buscarDuenio(telefonoLlamador);
		return llamador.registrarLlamadaLocal(fechaInicio, horaInicio, minutosDuracion, telefonoLlamador, telefonoReceptor);
	}
	
	public LlamadaInterurbana registrarLlamadaInterurbana(LocalDate fechaInicio, int horaInicio, int minutosDuracion, int telefonoLlamador, int telefonoReceptor, double kmDistancia) {
		Cliente llamador= buscarDuenio(telefonoLlamador);
		return llamador.registrarLlamadaInterurbana(fechaInicio, horaInicio, minutosDuracion, telefonoLlamador, telefonoReceptor, kmDistancia);
	}
	
	public LlamadaInternacional registrarLlamadaInternacional(LocalDate fechaInicio, int horaInicio, int minutosDuracion, int telefonoLlamador, int telefonoReceptor, String paisOrigen, String paisDestino) {
		Cliente llamador= buscarDuenio(telefonoLlamador);
		return llamador.registrarLlamadaInternacional(fechaInicio, horaInicio, minutosDuracion, telefonoLlamador, telefonoReceptor, paisOrigen, paisDestino);
	}
	
	public Factura facturarLlamadas(Cliente cliente, LocalDate inicio, LocalDate fin) {//delegar tarea al mas cercano
		DateLapse periodo = new DateLapse1(inicio, fin);
		return cliente.facturarLlamadas(periodo);
	}
	
	public Cliente buscarDuenio(int telefonoLlamador){//lo hago en metodo para no repetir codigo
		return this.clientes.stream().filter(c -> c.getTelefono()==telefonoLlamador).findFirst().orElse(null);//hacer esto o que telefono sea una clase con variable que indique su dueño
	}
}
