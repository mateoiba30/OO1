package ar.edu.unlp.info.oo1.ej7MethodLookUp;

public class Gerente {
	public Gerente() {
		
	}
	public double montoBasico() {
		return 57000;
	}
	public double aportes() {
		return this.montoBasico() * 0.05d;// 0.05d da el mismo resultado que 0.05 en este caso, pero sirve para aclarar que es un numero del tipo double
	}
}


//Gerente alan = new Gerente("Alan Turing"); //creo nuevo gerente con solo el constructor vacío
//double aportesDeAlan = alan.aportes(); //usa el método en aportes del gerente, el cual necesita al mpetodo montoBasico de gerente

//double sueldoBasicoDeAlan = alan.sueldoBasico(); //no encuentra nada en la clase gerente, hace look up en el padre empleado jerarquico, va al método sueldo basico de empleadojerarquico el cual llama al metodo bonoporcategoria de emppleadojerarquico y al metodo suledo basico del padre empleado. este metodo de la clase empleado llama a los otros metodos de monot basico y aportes