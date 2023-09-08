package ar.edu.unlp.info.cookbookv2;

import java.time.LocalDate;

public class Examen {
	private int nota;
	private String materia;
	private LocalDate fecha;

	public Examen(int nota, String materia, LocalDate fecha) {
		this.nota = nota;
		this.fecha = fecha;
		this.materia = materia;
	}

	public boolean estaAprobado() {
		return nota >= 4;
	}

	public int getNota() {
		return nota;
	}

	public boolean rendidoElAnio(int anio) {
		return fecha.getYear() == anio;
	}

	public String getMateria() {
		return materia;
	}

}