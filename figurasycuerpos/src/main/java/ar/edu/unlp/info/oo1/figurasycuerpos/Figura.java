package ar.edu.unlp.info.oo1.figurasycuerpos;

public interface Figura {
	
//	private double perimetro;
//	private double area; //no me deja hacer constructores ni variables internas, para eeso me conviene hacer una clase normal que sea el padre
	
	public double getPerimetro();
	
	public double getArea();
	
	public void setPerimetro(double perimetro);
	
	public void setArea(double area);//no olvidar que para completar la firma debo poner los parámetros

}
