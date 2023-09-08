package ar.edu.unlp.info.oo1.figurasycuerpos;

public class Cuerpo3D{
	
	private Figura caraBasal;
	private double altura;
	
	
	public Figura getCaraBasal() {
		return caraBasal;
	}
	public void setCaraBasal(Figura caraBasal) {
		this.caraBasal = caraBasal;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getVolumen() {
		return this.caraBasal.getArea()*this.altura;
	}
	public double getSuperficieExterior() {
		return 2*this.caraBasal.getArea() + this.caraBasal.getPerimetro()*this.altura;
	}
	

}
