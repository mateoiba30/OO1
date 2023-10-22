package ar.edu.unlp.info.oo1.ejercicio18_liquidacionHaberes;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Empleado {
	
	private String nombre;
	private String apellido;
	private long cuit;
	private LocalDate fechaNacimiento;
	private LocalDate fechaInicio;
	private boolean tieneConyugue;
	private boolean tieneHijos;
	private List<ReciboSueldo> recibos;
	private List<Contrato> contratos;
	
	public Empleado(String nombre, String apellido, long cuit, LocalDate fechaNacimiento, boolean tieneConyugue, boolean tieneHijos) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.cuit=cuit;
		this.fechaNacimiento=fechaNacimiento;
		this.fechaInicio=LocalDate.now();
		this.tieneConyugue=tieneConyugue;
		this.tieneHijos=tieneHijos;
		this.recibos=new ArrayList<>();
		this.contratos= new ArrayList<>();
	}
	
	public Optional<Contrato> obtenerContratoActual() {
//		return this.contratos.stream().max((c1, c2) -> c1.getFechaInicio().compareTo(c2.getFechaInicio())).orElse(null); //no funciona (la funcion devuelve Contrato)
			return this.contratos.stream().max((Contrato c1, Contrato c2)-> c1.getFechaInicio().compareTo(c2.getFechaInicio()));
	}
	
	public int calcularAntiguedad() {
		return this.contratos.stream().mapToInt(c -> c.calcularAnios()).sum();
	}
	
	public int calcularAumentoPorAntiguedad() {
		int antiguedad = calcularAntiguedad();
		int aumento;
		
		if (antiguedad < 5)
			aumento=0;
		else
			if (antiguedad < 10)
				aumento=30;
			else
				if(antiguedad < 15)
					aumento=50;
				else
					if(antiguedad < 20)
						aumento=70;
					else
						aumento=100;
		
		return aumento;
	}
	
	public double calcularMontoTotal() {
//		return contrato.calcularMontoBasico() * (double)(100 + this.calcularAumentoPorAntiguedad())/100; //esto no me sirve, porque debo calcular solo para el contrato actual
		if(! obtenerContratoActual().map(c -> c.vencido()).orElse(true)) //similar a usar ifPresent, del optional mapeo lo que quiero solo si el optional no esta vacío, caso contrario asume true
			return this.obtenerContratoActual().map(c -> c.calcularMontoBasico()).orElse(0d) * (double)(100 + this.calcularAumentoPorAntiguedad())/100; //NO  OVLIDAR PONER (double) AL MOMENTO DE USAR /
		else
			return 0;
	}
	
	public boolean getTieneConyugue() {
		return this.tieneConyugue;
	}
	
	public boolean getTieneHijos() {
		return this.tieneHijos;
	}
	
	//preguntar si el contrato actual esta vencido o no
	//solo puede tener un contrato activo a la vez, así que: si el contrato activo es de planta entonces no puedo tener otro
	//si el contrato activo es por horas entonces la fecha inicio del nuevo contrato tiene que ser luego de la fecha fin del actual

	public void cargarContratoPorHora(LocalDate fechaInicio, LocalDate fechaFin, double valorPorHora, int horasAlMes) { //podria hacer que devuelva al  objeto solo para poder hacer mas exacto el test, no es 100 porciento necesario
		if (this.obtenerContratoActual().map(c -> c.admiteFecha(fechaInicio)).orElse(true)) {
			ContratoPorHoras contrato = new ContratoPorHoras(fechaInicio, fechaFin, valorPorHora, horasAlMes);
			this.contratos.add(contrato);
		}	
	}
	
	public void cargarContratoDePlanta(LocalDate fechaInicio, double sueldoMensual, double montoHijos, double montoConyugue) { //hago que devuelva al  objeto solo para poder hacer mas exacto el test, no es 100 porciento necesario
		if (this.obtenerContratoActual().map(c -> c.admiteFecha(fechaInicio)).orElse(true)) {
			ContratoDePlanta contrato = new ContratoDePlanta(fechaInicio, sueldoMensual, montoHijos, montoConyugue, this);
			this.contratos.add(contrato);
		}	
	}
	
	public ReciboSueldo agregarRecibo() {
		ReciboSueldo recibo = new ReciboSueldo(this.calcularAntiguedad(), this.calcularMontoTotal());
		this.recibos.add(recibo);
		return recibo;
	}
	
	public long getCuit() {
		return this.cuit;
	}
	
	public List<Contrato> getContratos(){
		return this.contratos;
	}
}
