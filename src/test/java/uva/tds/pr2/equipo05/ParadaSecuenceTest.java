package uva.tds.pr2.equipo05;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Implementacion de la clase de test de secuencia de Parada
 * @author ismpere
 * @author martorb
 */
public class ParadaSecuenceTest {

	private static final double ERROR_ADMISIBLE = 0.01;
	
	@Test
	public void testParadaSecuenciaAleatoriaDistanciasValido() {
		GD gd1 = new GD(-179.99,179.99);
		Parada p1 = new Parada("a", gd1);
		
		GD gd2 = new GD(-150.00,150.00);
		Parada p2 = new Parada("b", gd2);
		
		double d1 = p1.getDistanciaEntre(p2);
		double d2 = p2.getDistanciaEntre(p1);
		
		GD gd3 = new GD(-179.99,179.99);
		
		p1.setGD(gd3);
		
		double d3 = p1.getDistanciaEntre(p2);
		
		Parada p3 = new Parada("c", gd1);
		double d4 = p1.getDistanciaEntre(p3);
		
		p1.setGD(gd1);
		
		double d5 = gd1.getDistanciaAt(gd2);
		
		assertEquals(d1, d2, ERROR_ADMISIBLE);
		assertEquals(0.00, d4, ERROR_ADMISIBLE);
		assertEquals(d1, d5, ERROR_ADMISIBLE);
		assertNotEquals(d1, d3, ERROR_ADMISIBLE);
		assertEquals(gd1, p1.getGD());
		assertEquals("a", p1.getId());
	}
	
	@Test
	public void testParadaSecuenciaAleatoriaSettersValido(){
		GD gd1 = new GD(-179.99,179.99);
		Parada p1 = new Parada("a", gd1);
		
		String id1 = p1.getId();
		GD g1 = p1.getGD();
		
		p1.setId("b");
		String id2 = p1.getId();
		
		GD gd2 = new GD(-150.00,150.00);
		
		p1.setId("c");
		p1.setGD(gd2);
		
		assertNotEquals(id1, id2);
		assertNotEquals(id1, p1.getId());
		assertNotEquals(g1, p1.getGD());
		assertEquals("c", p1.getId());
		assertEquals(gd2, p1.getGD());
	}
		

}
