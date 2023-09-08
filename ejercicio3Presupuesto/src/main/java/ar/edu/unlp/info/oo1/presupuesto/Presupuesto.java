package ar.edu.unlp.info.oo1.presupuesto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List; //NO OLVIDAR

public class Presupuesto {
	
	private LocalDate fecha;
	private String cliente;
	private List<Item> items;
	
	public Presupuesto() {
		this.fecha=LocalDate.now();
		this.items= new ArrayList<Item>();
	}
	
	public Presupuesto(String cliente) {
		this.fecha=LocalDate.now();
		this.items= new ArrayList<Item>();
		this.cliente=cliente;
	}
	
	
	public void agregarItem(Item item) {
		this.items.add(item);
	}
	
	public double calcularTotal() {
		double total=0;
		int max = items.size();
		for(int i=0; i<max ; i++) { // NO PONER <=max , porque la posicion inicia en 0 y llega hasta tamaño - 1
			total+= items.get(i).costo();
		}
		return total;
	}
	
	
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

}
