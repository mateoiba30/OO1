package ar.edu.unlp.info.oo1.figurasycuerpos;
//conviene interfaz porque uso VI diferentes en circulo y cuadrado, y además no hay métodos con el mismo desarrollo
//1ro pensar como clase abstracta, si me quedo sin atributos ni VI me paso a interfaz ( la inversa es mas complicada)

public interface Figura {
	
//	private double perimetro;
//	private double area; //no me deja hacer constructores ni variables internas, para eeso me conviene hacer una clase normal que sea el padre
	
	public double getPerimetro();
	
	public double getArea();
	
	public void setPerimetro(double perimetro);
	
	public void setArea(double area);//no olvidar que para completar la firma debo poner los parámetros

}
