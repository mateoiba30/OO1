package ar.edu.unlp.info.oo1.ejercicio12Solidos;

public abstract class Pieza {
	
	private String material; //en general hacemos las variables privadas de todas formas, no protected
	private String color;
	
	abstract protected double getVolumen();
	abstract protected double getSuperficie();
	
	public Pieza (String material, String color) {
		this.material = material;
		this.color = color;
	}
	
	public String getMaterial() {
		return this.material;
	}
	
	public String getColor() {
		return this.color;
	}
}
