package ar.edu.unlp.info.oo1.figurasycuerpos;

public class Circulo implements Figura{

	private double radio;//como todo depende del radio, solo me quedo con este -> ESTÁ BIEN? porque necesita menos varibales pero pierde presicion
//	private double pi = Math.PI;
//	Math.PI es una clase estática, no hace falta crear la variable pi
	
	public Circulo() {
		this.radio=0;
	}	
	public double getDiametro() {
		return radio*2;
	}
	public void setDiametro(double diametro) {
		this.radio = diametro/2;
	}
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	public double getArea() {
		return Math.PI*this.radio*this.radio;
	}
	public void setArea(double area) {
		this.radio = Math.sqrt(area/Math.PI);//no necesario invocar ninguna librería
	}
	public double getPerimetro() {
		return Math.PI*radio*2;
	}
	public void setPerimetro(double perimetro) {
		this.radio = perimetro/(Math.PI*2);
	}

	
}
