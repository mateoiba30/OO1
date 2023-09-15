package ar.edu.unlp.info.oo1.ej5genealogia;

import java.time.LocalDate;

public class Mamifero {
	
	private String identificador;
	private String especie;
	private LocalDate fechaNacimiento;
	private Mamifero padre;
	private Mamifero madre;//no desarrollo abuelos porque los consigo con los padres
	
	public Mamifero() {
		this.identificador="";
		this.especie="";
		this.fechaNacimiento=LocalDate.now();
//		this.madre = new Mamifero();//creo el objeto, pero llamo al constructor porque y me crea infinitos ancestros
//		this.padre = new Mamifero();
	}
	
	public Mamifero(String identificador) {
		this.identificador=identificador;
		this.especie="";
		this.fechaNacimiento=LocalDate.now();
//		this.madre = new Mamifero();
//		this.padre = new Mamifero();
	}
	
//	public boolean tieneComoAncestroA(Mamifero mamifero) {//hay que verificar que tenga madre, no voy a tener un arbol infinito
//		boolean esAncestro=false;
//		String id = mamifero.getIdentificador();
//		
//		if (this.identificador.equals(id))
//			esAncestro=false; //si busco al mismo mamifero, ya no es ancestro
//		else {
//			if ( Objects.nonNull(this.padre) && this.padre.getIdentificador().equals(id) )
//				esAncestro=true;
//			else {
//				if ( Objects.nonNull(this.madre) && this.madre.getIdentificador().equals(id) )
//					esAncestro=true;
//				else {
//					esAncestro=this.madre.tieneComoAncestroA(mamifero);
//					if (!esAncestro)
//						esAncestro=this.padre.tieneComoAncestroA(mamifero);
//				}
//			}
//		}
//		
//		return esAncestro;
//	}
	
//	public boolean tieneComoAncestroA(Mamifero mamifero) {//hay que verificar que tenga madre, no voy a tener un arbol infinito
//		boolean esAncestro=false;
//		String id = mamifero.getIdentificador();
//		
//		if (this.identificador.equals(id))
//			esAncestro=false; //si busco al mismo mamifero, ya no es ancestro
//		else 
//			if ( Objects.nonNull(this.padre) && this.padre.getIdentificador().equals(id) )
//				esAncestro=true;
//			else 
//				tieneComoAncestroARecursivo(id, esAncestro);
//		
//		return esAncestro;
//	}
//	
//	//lo escribo de manera más prolija
//	private void tieneComoAncestroARecursivo(String id, boolean esAncestro) {
//		if ( Objects.nonNull(this.madre) && this.madre.getIdentificador().equals(id) )
//			esAncestro=true;
//		else {
//			this.madre.tieneComoAncestroARecursivo(id,esAncestro);
//			if (!esAncestro)//si encontre en madre, no pisar el resultado al analizar el padre
//				this.padre.tieneComoAncestroARecursivo(id, esAncestro);
//		}
//	}
//	
	
	public boolean tieneComoAncestroA(Mamifero mamifero) {
		return this.vienePorPapi(mamifero) || this.vienePorMami(mamifero);
	}
	
	private boolean vienePorPapi(Mamifero mamifero) {
		if (this.padre == null) return false;
		return this.padre.equals(mamifero) || this.padre.tieneComoAncestroA(mamifero);
	}

	private boolean vienePorMami(Mamifero mamifero) {
		if (this.madre == null) return false;
		return this.madre.equals(mamifero) || this.madre.tieneComoAncestroA(mamifero);
	}
	
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String ididentificador) {
		this.identificador = ididentificador;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Mamifero getPadre() {
		return padre;
	}
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	public Mamifero getMadre() {
		return madre;
	}
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	public Mamifero getAbueloPaterno() {
		return this.padre == null ? null : this.padre.getPadre();
	}
	public Mamifero getAbuelaPaterna() {
		return this.padre == null ? null : this.padre.getMadre();
	}
	public Mamifero getAbueloMaterno() {
		return this.madre == null ? null : this.madre.getPadre();
	}
	public Mamifero getAbuelaMaterna() {
		return this.madre == null ? null : this.madre.getMadre();
	}


}
