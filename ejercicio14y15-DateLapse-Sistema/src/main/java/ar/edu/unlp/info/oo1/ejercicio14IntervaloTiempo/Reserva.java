package ar.edu.unlp.info.oo1.ejercicio14IntervaloTiempo;

public class Reserva {
	private Propiedad propiedad;//para distinguir entre reservas de diferentes propiedades cuando me la pasan por parámetro
	private Usuario inquilino;
	private DateLapse periodo; //puedo poenr DateLapse,lo que no puedo es instanciar un objeto en una interfaz
	
	public Reserva(Propiedad propiedad, Usuario inquilino, DateLapse periodo) {
		this.propiedad=propiedad;
		this.inquilino= inquilino;
		this.periodo=periodo;
	}
	
	public boolean disponible(DateLapse periodo) {
		return ! this.periodo.overlaps(periodo); //si se superpone, entonces no esta disponible
	}
	
	public int daysOverlaps(DateLapse periodo) {//devuleve al cantidad de días que se superponen
		return this.periodo.daysOverLaps(periodo);
	}
	
	public Propiedad getPropiedad() {
		return this.propiedad;
	}
	
	public DateLapse getPeriodo() {
		return this.periodo;
	}
	
	public double calcularPrecioReserva() {
		return this.periodo.sizeInDays() * this.propiedad.getPrecioPorNoche();
	}
}
