package ar.edu.unlp.info.oo1.ejercicio8;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String domicilio;
	private String nombre;
	private List<Factura> facturas;
	private List<Consumo> consumos;
	
	public Usuario(String nombre, String domicilio) {
		this.domicilio=domicilio;
		this.nombre=nombre;
		this.facturas=new ArrayList<>();
		this.consumos=new ArrayList<>();
	}
	
	public void agregarMedicion(Consumo medicion) {
		this.consumos.add(medicion);
	}
	
	public double ultimoConsumoActiva() {
//	MAL, hay que poner orElse(null). return this.consumos.stream().reduce((primero, segundo) -> segundo).orElse(0).map(consumo -> consumo.consumoEnergiaActiva());

		return this.getUltimoConsumo().getConsumoEnergiaActiva();
	}
	
	public Factura facturarEnBaseA(double precioKWh) {
		Factura factura = new Factura(0, 0, this);
		if ( this.getUltimoConsumo() != null )
			factura.setMontoEnergiaActiva( this.getUltimoConsumo().costoEnBaseA(precioKWh) );
		if ( this.getUltimoConsumo() != null &&	 this.getUltimoConsumo().hayDescuento())
			factura.setDescuento(10);
		else
			factura.setDescuento(0);
		return factura;
		
	}
	
	public List<Factura> facturas(){
		return this.facturas;
	}

	public String getDomicilio() {
		return this.domicilio;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Consumo getUltimoConsumo() {
		if (consumos.size()!=0)
			return this.consumos.stream().max( (a, b) -> a.getFecha().compareTo( b.getFecha() ) ).orElse(null);
			// PARA BUSCAR ULTIMO ELEMENTO CON LAMBDA: 		return this.consumos.stream().reduce( (a, b) -> b).orElseGet(null);
		//si no hay maximo retorno null. si no pongo el orElse devuleve un OPtional (puede ser Consumo o null). 
//			return consumos.get(consumos.size()-1); //esto no era lo que pedian
		else
			return null;
	}
}
