package ar.edu.unlp.info.cookbookv2;

import java.util.List;

public class Alumno {
	
	private int anioIngreso;
	private String nombre;
	private List<Examen> examenes; 

	public Alumno(int anioIngreso, String nombre, List<Examen> examenes) {
		this.examenes= examenes;
		this.anioIngreso = anioIngreso;
		this.nombre = nombre;
	}
	
	public int getAnioIngreso() {
		return anioIngreso;
	}
	
	public void setAnioIngreso(int anioIngreso) {
		this.anioIngreso = anioIngreso;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Examen> getExamenes(){
		return examenes;
	}
	
	/**
	 * Permite consultar el promedio sin aplazos del alumno.
	 * @return el promedio sin tener en cuenta los examenes desaprobados
	 */
	public double getPromedioSinAplazos() {
		return examenes.stream()
				.filter(e -> e.estaAprobado())
				.mapToDouble(e -> e.getNota())
				.average().orElse(0);
	}
	
	/**
	 * Permite consultar el promedio del alumno.
	 * @return el promedio, teniendo en cuenta todos los exámenes rendidos
	 */
	public double getPromedio() {
		return examenes.stream()
				.mapToDouble(e -> e.getNota())
				.average().orElse(0);
	}
	
	/**
	 * Permite consultar la cantidad de exámenes rendidos en un anio dado.
	 * @param anio
	 * @return
	 */
	public int cantidadExamenesRendidos(int anio) {
		return (int)examenes.stream()
				.filter(examen -> examen.rendidoElAnio(anio))
				.count();
	}
}
