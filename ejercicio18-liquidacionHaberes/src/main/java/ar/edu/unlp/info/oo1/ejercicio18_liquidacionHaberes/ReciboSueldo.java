package ar.edu.unlp.info.oo1.ejercicio18_liquidacionHaberes;
import java.time.LocalDate;

public class ReciboSueldo {
	
	private Empleado empleado;
	private int antiguedad;
	private LocalDate fechaGenerado;
	private double montoTotal;
	
	public ReciboSueldo(int antiguedad, double montoTotal) {
		this.antiguedad=antiguedad;
		this.fechaGenerado=LocalDate.now();
		this.montoTotal=montoTotal;
	}
}
