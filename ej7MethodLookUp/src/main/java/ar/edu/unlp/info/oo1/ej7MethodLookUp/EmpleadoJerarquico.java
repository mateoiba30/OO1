package ar.edu.unlp.info.oo1.ej7MethodLookUp;

public class EmpleadoJerarquico extends Empleado {
	
	public EmpleadoJerarquico() {
		
	}
	public double montoBasico() {
		return 45000;
	}
	public double bonoPorCategoria() {
		return 8000;
	}
	public double sueldoBasico() {
		return super.sueldoBasico() + this.bonoPorCategoria();
	}
}
