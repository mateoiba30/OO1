package ar.edu.unlp.info.oo1.ejercicio12Solidos;

public class PrismaRectangular extends Pieza{

	private int ladoMayor;
	private int ladoMenor;
	private int altura;
	
	public PrismaRectangular(String material, String color, int ladoMayor, int ladoMenor,int altura) {
		this.material=material;
		this.color=color;
		this.ladoMayor = ladoMayor;
		this.ladoMenor = ladoMenor;
		this.altura = altura;
	}
	
	public double getVolumen() {
		return this.ladoMayor * this.ladoMenor * this.altura;
	}
	
	public double getSuperficie() {
		return 2 * (this.ladoMayor * this.ladoMenor + this.ladoMayor * this.altura + this.ladoMenor * altura ) ;
	}
}

