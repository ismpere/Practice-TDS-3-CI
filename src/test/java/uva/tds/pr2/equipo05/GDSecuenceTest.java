package uva.tds.pr2.equipo05;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Implementacion de los test de secuencia de la clase GD
 * @author ismpere
 * @author martorb
 */
public class GDSecuenceTest {
	
	private static final double ERROR_ADMISIBLE = 0.01;

	@Test
	public void testGDSecuenciaAleatoriaDistanciasValido() {
		GD gd1 = new GD(-179.99,179.99);
		
		GD gd2 = new GD(-150.00,150.00);
		
		double d1 = gd1.getDistanciaAt(gd2);
		double d2 = gd2.getDistanciaAt(gd1);
		
		gd1.setLatitud(140.00);
		
		double d3 = gd1.getDistanciaAt(gd2);
		
		gd1.setLatitud(-179.99);
		
		double d4 = gd1.getDistanciaAt(gd2);
		
		assertEquals(d1, d2, ERROR_ADMISIBLE);
		assertEquals(d1, d4, ERROR_ADMISIBLE);
		assertNotEquals(d1, d3, ERROR_ADMISIBLE);
		assertEquals(140.00, gd1.getLatitud(), ERROR_ADMISIBLE);
		assertEquals(179.99, gd1.getLongitud(), ERROR_ADMISIBLE);
	}
	
	@Test
	public void testGDSecuenciaAleatoriaSettersValido(){
		GD gd1 = new GD(-179.99,179.99);
		
		double latitud1 = gd1.getLatitud();
		double longitud1 = gd1.getLongitud();
		
		gd1.setLatitud(140.00);
		double latitud2 = gd1.getLatitud();
		
		gd1.setLongitud(145.00);
		gd1.setLatitud(130.00);
		
		assertNotEquals(latitud1, latitud2, ERROR_ADMISIBLE);
		assertNotEquals(latitud1, gd1.getLatitud(), ERROR_ADMISIBLE);
		assertNotEquals(longitud1, gd1.getLongitud(), ERROR_ADMISIBLE);
		assertEquals(130.00, gd1.getLatitud(), ERROR_ADMISIBLE);
		assertEquals(145.00, gd1.getLongitud(), ERROR_ADMISIBLE);
	}

}
