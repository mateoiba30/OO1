package ar.edu.unlp.info.oo1.presupuesto;

public class Item {
	
	private String detalle;
	private int cantidad;
	private double costoUnitario;
	
	public Item() {//este constructor esta bien?
		this.cantidad=0;
		this.costoUnitario=0;
	}
	
	public Item(String detalle, int cantidad, double costoUnitario) {
		this.detalle = detalle;
		this.cantidad = cantidad;
		this.costoUnitario = costoUnitario;
	}
	
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getCostoUnitario() {
		return costoUnitario;
	}
	public void setCostoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}
	
	public double costo() {
		return this.cantidad * this.costoUnitario;
	}

}
