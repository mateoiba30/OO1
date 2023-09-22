package ar.edu.unlp.info.oo1.ejercicio9Ganchos;

public class CuentaCorriente extends Cuenta {
	
	private double descubierto;
	private double saldo;
	
	public CuentaCorriente(double saldo, double descubierto) {
		this.descubierto=descubierto;
		this.saldo=saldo;
	}
	
	public double getDescubierto() {
		return this.descubierto;
	}

	public void setDescubierto(double descubierto) {
		this.descubierto=descubierto;
	}
	
	protected boolean puedeExtraer(double monto) {
//		if ( (saldo - monto) >= descubierto)
//			return true;
//		else
//			return false;
		return  (saldo - monto) >= (-1)*this.descubierto; //esta manera es mas legible
	}
}
