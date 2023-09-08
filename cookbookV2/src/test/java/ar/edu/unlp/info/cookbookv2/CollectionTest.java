package ar.edu.unlp.info.cookbookv2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Clase con ejemplos de uso del protocolo de Stream.
 */
public class CollectionTest {
	Alumno rodrigo, joel, matias, amalia;
	List<Alumno> alumnos;

	@BeforeEach
	void setUp() {
		alumnos = new ArrayList<>();
		// se instancian y agregan cuatro alumnos con algunos examenes rendidos
		rodrigo = new Alumno(2020, "Rodrigo", Arrays.asList(
				new Examen(9, "Mate 1", LocalDate.of(2020, 9, 10)),
				new Examen(9, "Mate 2", LocalDate.of(2021, 9, 10))
			));
		joel = new Alumno(2020, "Joel", Arrays.asList(
				new Examen(3, "Mate 2", LocalDate.of(2020, 9, 10)),
				new Examen(7, "OO1", LocalDate.of(2020, 9, 10))
			));
		matias = new Alumno(2021, "Matias", Arrays.asList(
				new Examen(10, "Mate 2", LocalDate.of(2021, 9, 10)),
				new Examen(10, "OO1", LocalDate.of(2021, 9, 10))
			));
		amalia = new Alumno(2022, "Amalia", Arrays.asList(
				new Examen(6, "Mate 2", LocalDate.of(2022, 9, 10)),
				new Examen(7, "OO2", LocalDate.of(2022, 9, 10))
			));

		alumnos.add(rodrigo);
		alumnos.add(joel);
		alumnos.add(matias);
		alumnos.add(amalia);
	}

	@Test
	public void testIngresantesEnAnio2020() {
		// rodrigo y joel son los únicos alumnos ingresantes del 2020.
		List<Alumno> alumnos2020Esperados = Arrays.asList(rodrigo, joel);
		List<Alumno> alumnosIngresantes2020 =
			alumnos.stream()
				.filter(alumno -> alumno.getAnioIngreso() == 2020)
				.collect(Collectors.toList());
		assertEquals(alumnos2020Esperados, alumnosIngresantes2020);
	}

	@Test
	public void testNombresAlumnos() {
		List<String> nombresAlumnosEsperados = Arrays.asList("Rodrigo", "Joel", "Matias", "Amalia");
		List<String> nombresAlumnos =
			alumnos.stream()
				.map(alumno -> alumno.getNombre())
				.collect(Collectors.toList());
		assertEquals(nombresAlumnosEsperados, nombresAlumnos);
	}

	@Test
	public void testPrimerosTresAlumnos() {
		List<Alumno> primerosTresEsperados = Arrays.asList(rodrigo, joel, matias);
		List<Alumno> primerosTres =
			alumnos.stream()
				.limit(3)
				.collect(Collectors.toList());
		assertEquals(primerosTresEsperados, primerosTres);
	}

	@Test
	public void testAlumnosOrdenadosPorPromedioAsc() {
		List<Alumno> alumnosOrdenEsperado = Arrays.asList(joel, amalia, rodrigo, matias);
		List<Alumno> alumnosOrdenados =
			alumnos.stream()
				.sorted((a1, a2) -> Double.compare(a1.getPromedio(), a2.getPromedio()))
				.collect(Collectors.toList());
		assertEquals(alumnosOrdenEsperado, alumnosOrdenados);
	}

	@Test
	public void testAlumnosOrdenadosPorPromedioDesc() {
		List<Alumno> alumnosOrdenDescEsperado = Arrays.asList(matias, rodrigo, amalia, joel);
		List<Alumno> alumnosPromedioDesc =
			alumnos.stream()
				.sorted((a1, a2) -> Double.compare(a2.getPromedio(), a1.getPromedio()))
				.collect(Collectors.toList());
		assertEquals(alumnosOrdenDescEsperado, alumnosPromedioDesc);
	}

	@Test
	public void testTotalExamenesTomadosEn2020() {
		int totalExamenesTomados2020 =
			alumnos.stream()
				.mapToInt(alumno -> alumno.cantidadExamenesRendidos(2020))
				.sum();
		assertEquals(3, totalExamenesTomados2020);
	}

	@Test
	public void testCantidadDeAlumnosConPromediosMayorA8() {
		int cantidadAlumnosPromedioMayorA8 = 
			(int) alumnos.stream()
				.filter(alumno -> alumno.getPromedio() >= 8)
				.count();
		assertEquals(2, cantidadAlumnosPromedioMayorA8);
	}

	@Test
	public void testExisteIngresanteAntesDe2021() {
		boolean ingresantesAntes2021 =
			alumnos.stream()
				.anyMatch(alumno -> alumno.getAnioIngreso() < 2021);
		assertTrue(ingresantesAntes2021);
	}

	@Test
	public void testMejorPromedio() {
		Alumno mejorPromedio =
			alumnos.stream()
				.max((a1, a2) -> Double.compare(a1.getPromedio(), a2.getPromedio()))
				.orElse(null);
		assertEquals(matias, mejorPromedio);
	}

	@Test
	public void testPrimerAlumnoConM() {
		Alumno primerAlumnoNombreConLetraM =
			alumnos.stream()
				.filter(alumno -> alumno.getNombre().startsWith("M"))
				.findFirst()
				.orElse(null);
		assertEquals(matias, primerAlumnoNombreConLetraM);
	}

	@Test
	public void testMateriasCursadas() {
		List<String> materiasEsperadas = Arrays.asList("Mate 1", "Mate 2", "OO1", "OO2");
		List<String> materiasDistintas =
			alumnos.stream()
				.flatMap(alumno -> alumno.getExamenes().stream())
				.map(examen -> examen.getMateria())
				.distinct()
				.collect(Collectors.toList());
		assertEquals(materiasEsperadas, materiasDistintas);
	}
}
