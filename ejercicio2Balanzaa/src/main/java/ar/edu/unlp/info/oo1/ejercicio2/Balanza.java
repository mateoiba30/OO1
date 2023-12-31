package ar.edu.unlp.info.oo1.ejercicio2; //es mucho mejor manejarse con double que con float

public class Balanza {
	
	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	
	public void ponerEnCero() {
		this.cantidadDeProductos = 0;
		this.precioTotal = 0;
		this.pesoTotal = 0; //estos valores valores tal vez me los da el constructor, pero depende de la version de java, además si es un constructor solo lo puedo usar 1 vez al momento de crear el objeto
	}

	public void agregarProducto (Producto producto) {
		this.cantidadDeProductos ++;
		this.precioTotal += producto.getPrecio();
		this.pesoTotal += producto.getPeso(); // hay una forma donde no la necesite?
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

	public void setPeso(double peso) {
		this.pesoTotal=peso;
	}
	
	public Ticket emitirTicket() {
		Ticket t = new Ticket();
		t.setFecha();
		t.setCantidadDeProductos(this.cantidadDeProductos);
		t.setPrecioTotal(this.precioTotal); //incluye el impuesto el ticket, no la balanza (ella solo dice el precio por producto)
		t.setPesoTotal(this.pesoTotal);	
		return t;
	}
}
