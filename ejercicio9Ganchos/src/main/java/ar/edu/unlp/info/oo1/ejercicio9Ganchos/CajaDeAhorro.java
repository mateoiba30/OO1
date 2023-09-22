package ar.edu.unlp.info.oo1.ejercicio9Ganchos;

public class CajaDeAhorro extends Cuenta{
	
	private double saldo;
	private double aumento;
	private double descuento;//usar variables antes que poner en varios lugares un mismo "numero magico" que no se que significa
	
	public CajaDeAhorro(double saldo) {
		this.saldo=saldo;
		this.aumento=1.02;
		this.descuento=0.98;
	}
	
	protected boolean puedeExtraer(double monto) {
		return this.saldo >= monto*this.aumento;//mejor que hacer un if, me queda en una linea
	}
	
	@Override
	  protected void extraerSinControlar(double monto) {
		  this.saldo -= monto*this.aumento;
	  }

	@Override
	  public void depositar(double monto) {
		  this.saldo += monto*this.descuento;
	  }
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo=saldo;
	}
	
}
