package ar.edu.unlp.info.oo1.ejercicio12Solidos;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ReporteDeConstruccionTest {
	
	private Pieza cilindro;
	private Pieza esfera;
	private Pieza prisma;
	private List<Pieza> piezas;
	private ReporteDeConstruccion reporte;
	
	@BeforeEach
	public void setup() {
		this.cilindro = new Cilindro("Hierro", "Negro", 5, 10);
		this.esfera = new Esfera("Hierro", "Naranja", 5);
		this.prisma = new PrismaRectangular("Plastico", "Naranja", 1, 2, 3);
		
		this.reporte = new ReporteDeConstruccion();
		this.reporte.agregarPieza(cilindro);
		this.reporte.agregarPieza(esfera);
		this.reporte.agregarPieza(prisma);
	}
	
	@Test
	void testGetVolumenMaterial() {
		double resultado1 = this.cilindro.getVolumen() + this.esfera.getVolumen();
		double resultado2 = this.prisma.getVolumen();
		assertEquals(resultado1, this.reporte.getVolumenMaterial("Hierro"));
		assertEquals(resultado2, this.reporte.getVolumenMaterial("Plastico"));
	}
	
	@Test
	void tertGetSuperficieDeColor() {
		double resultado1 = this.cilindro.getSuperficie();
		double resultado2 = this.prisma.getSuperficie() + this.esfera.getSuperficie();
		assertEquals(resultado1, this.reporte.getSuperficieDeColor("Negro"));
		assertEquals(resultado2, this.reporte.getSuperficieDeColor("Naranja"));
	}
}
