package ar.edu.unlp.info.oo1.ejercicio12Solidos;

public class Esfera extends Pieza {
	
	private double radio;
	
	public Esfera(String material, String color, double radio) {
		this.material=material;
		this.color=color;
		this.radio=radio;
	}
	
	public double getVolumen() {
		return (double)(4/3) * Math.PI * Math.pow(this.radio,3);
	}
	
	public double getSuperficie() {
		return 4 * Math.PI * Math.pow(this.radio, 2);
	}
}
