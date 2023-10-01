package ar.edu.unlp.info.oo1.ejercicio12Solidos;

public abstract class Pieza {
	
	protected String material;
	protected String color;
	
	abstract protected double getVolumen();
	abstract protected double getSuperficie();
	
	public String getMaterial() {
		return this.material;
	}
	
	public String getColor() {
		return this.color;
	}
}
