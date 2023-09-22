package ar.edu.unlp.info.oo1.ejercicio8;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Distribuidora {
	
	private double precioKWh;
	private List<Usuario> usuarios;
	
	public Distribuidora(double precioKWh) {
		this.precioKWh=precioKWh;
		this.usuarios=new ArrayList<>();
	}
	
	public void agregarUsuario(Usuario usuario) {
		if (! this.usuarios.stream().anyMatch(user -> user.getDomicilio().equals(usuario.getDomicilio())) )
			this.usuarios.add(usuario);//no hay que poner .stream() para poder usar add
	}
	
	public List<Factura> facturar(){
		return usuarios.stream().map(usuario -> usuario.facturarEnBaseA(this.precioKWh)).collect(Collectors.toList());
	}
	public double consumoTotalActiva() {
		return usuarios.stream().mapToDouble(usuario -> usuario.ultimoConsumoActiva()).sum();//usar mapToInt o mapToDouble para poder usar sum()
	}
	public double getPrecioKW() {
		return this.precioKWh;
	}
	public List<Usuario> getUsuarios(){
		return this.usuarios;
	}
}
