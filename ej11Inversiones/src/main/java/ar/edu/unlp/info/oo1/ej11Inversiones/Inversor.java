package ar.edu.unlp.info.oo1.ej11Inversiones;
import java.util.ArrayList;
import java.util.List;

public class Inversor {
	
	private String nombre;
	private List<Inversion> inversiones;
	
	public Inversor(String nombre) {
		this.nombre=nombre;
		this.inversiones=new ArrayList<Inversion>();;
	}
	
	public double valorActual() {
		return inversiones.stream().mapToDouble(a -> a.valorActual()).sum();
	}
	
	public void agregarInversion(Inversion inversion) {
		inversiones.add(inversion);
	}
}
