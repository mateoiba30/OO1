package ar.edu.unlp.info.oo1.ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ticket {
	 
	private LocalDate fecha;
//	private int cantidadDeProductos;
	private List<Producto> productos;
	private double precioTotal; //conviene usar double antes que float, porque aunque ponga que es una variable float no es sufuciente para ser guardada como float
	private double pesoTotal;

	public Ticket() {
		this.fecha=LocalDate.now();
		this.productos = new ArrayList<Producto>();
		this.precioTotal=0;
		this.pesoTotal=0;
		
	}
	
	public void setVariosProductos(List<Producto> productos) {
		this.productos = productos; //apuntan al mismo inicio
	}
	
	public List<Producto> getProductos(){
		return this.productos;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public void setFecha() {
		this.fecha=LocalDate.now();
	}

	public int getCantidadDeProductos() {
		return productos.size();
	}

//	public void setCantidadDeProductos(int cantidadDeProductos) {
//		this.cantidadDeProductos = cantidadDeProductos;
//	}

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