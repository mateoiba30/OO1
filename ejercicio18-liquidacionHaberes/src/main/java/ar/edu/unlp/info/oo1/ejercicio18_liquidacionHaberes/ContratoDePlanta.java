package ar.edu.unlp.info.oo1.ejercicio18_liquidacionHaberes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoDePlanta extends Contrato {
	
	private double sueldoMensual;
	private double montoHijos;
	private double montoConyugue;
	private Empleado empleado;
	
	public ContratoDePlanta(LocalDate fechaInicio, double sueldoMensual, double montoHijos, double montoConyugue, Empleado empleado) {
		super(fechaInicio);
		this.sueldoMensual=sueldoMensual;
		this.montoHijos=montoHijos;
		this.montoConyugue=montoConyugue;
		this.empleado=empleado;
	}
	
	@Override //no es obligatorio ponerlo, pero es de bueno practica
	public double calcularMontoBasico() {
		if (this.empleado.getTieneConyugue()) {
			if (this.empleado.getTieneHijos())
				return this.sueldoMensual + this.montoHijos + this.montoConyugue;
			else
				return this.sueldoMensual + this.montoConyugue;
		}
		else {
			if(this.empleado.getTieneHijos())
				return this.sueldoMensual + this.montoHijos;
			else
				return this.sueldoMensual;
		}
			
	}
	
	@Override
	public boolean vencido() { // vencido :los que tienen fecha de fin, cuando dicha fecha es inferior o igual a la fecha actual)
		return false;
	}
	
	@Override
	public int calcularAnios() {
		return (int)ChronoUnit.YEARS.between(this.getFechaInicio(), LocalDate.now());
	}
	
	@Override
	public boolean admiteFecha(LocalDate fechaInicio) { //no admite nadie mientras este vigente
		return this.vencido();
	}
}
