package ar.edu.unlp.info.oo1.ejercicio2;

import java.time.LocalDate;

public class Ticket {
	 
	private LocalDate fecha;
	private int cantidadDeProductos;
	private double precioTotal; //conviene usar double antes que float, porque aunque ponga que es una variable float no es sufuciente para ser guardada como float
	private double pesoTotal;

//	public Ticket() {
//		
//	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public void setFecha() {
		this.fecha=LocalDate.now();
	}

	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}

	public void setCantidadDeProductos(int cantidadDeProductos) {
		this.cantidadDeProductos = cantidadDeProductos;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}
	
	public double impuesto(){ 
		return (this.precioTotal * 0.21); //pongo 0.21 en lugar de 1.21 porque quiero saber solo el impuesto, no el precio final + el impuesto
	}
	
	
}