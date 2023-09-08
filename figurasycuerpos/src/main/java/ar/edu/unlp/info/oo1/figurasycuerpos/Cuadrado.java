package ar.edu.unlp.info.oo1.figurasycuerpos;

public class Cuadrado implements Figura{

	private double lado;//todo depende del lado
	
	public Cuadrado() {
		this.lado=0;
	}
	
	public double getLado() {
		return lado;
	}
	public void setLado(double lado) {
		this.lado = lado;
	}
	public double getPerimetro() {
		return 4*lado;
	}
	public void setPerimetro(double perimetro) {
		this.lado = perimetro/4;
	}
	public double getArea() {
		return this.lado*this.lado;
	}
	public void setArea(double area) {
		this.lado = Math.sqrt(area);
	}
	
	
}
