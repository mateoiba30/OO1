package ar.edu.unlp.info.oo1.ejercicio2; //es mucho mejor manejarse con double que con float

import java.util.ArrayList;
import java.util.List;

public class Balanza {
	
//	private int cantidadDeProductos;
	private double precioTotal;//no necesario almacenarlo, pero aún así conviene porque es mejor que cada vez que quiero saber el precio total tener que recorrer toda la lista
	private double pesoTotal;
	private List<Producto> productos;
	
	public Balanza() {//NO OLVIDAR DE USAR EL CONSTRUCTOR, puedo hacer que no esté vacío
		super();
		this.ponerEnCero();
	}

	public void ponerEnCero() {
		productos= new ArrayList<Producto>();
//		this.cantidadDeProductos = 0;
		this.precioTotal = 0;
		this.pesoTotal = 0; //estos valores valores tal vez me los da el constructor, pero depende de la version de java, además si es un constructor solo lo puedo usar 1 vez al momento de crear el objeto
	}
	
	public List<Producto> getProductos(){
		return this.productos;
	}

	public void agregarProducto (Producto producto) {
		this.precioTotal += producto.getPrecio();
		this.pesoTotal += producto.getPeso();
		this.productos.add(producto);
	}

	public int getCantidadDeProductos() {
		return this.productos.size();
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

	public void setPeso(double peso) {
		this.pesoTotal=peso;
	}
	
	public Ticket emitirTicket() {
		Ticket t = new Ticket();
		t.setFecha();
//		t.setCantidadDeProductos(this.cantidadDeProductos);
//		t.setCantidadDeProductos(this.productos.size());
		t.setPrecioTotal(this.precioTotal); //incluye el impuesto el ticket, no la balanza (ella solo dice el precio por producto)
		t.setPesoTotal(this.pesoTotal);	
		t.setVariosProductos(this.productos);
		return t;
	}
}
