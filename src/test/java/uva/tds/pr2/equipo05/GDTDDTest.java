package uva.tds.pr2.equipo05;

import uva.tds.pr2.equipo05.GD;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Implementacion de la clase de Test para GD
 * @author ismpere
 * @author martorb
 */
public class GDTDDTest {
	
	private static final double ERROR_ADMISIBLE = 0.01;
	
	@Test
	public void testInicializaGDValido() {
		GD gd1 = new GD(-179.99, 179.99); //TODO las coordenadas son aleatorias, corregir cuando se implemente
		
		assertNotNull(gd1);
		assertEquals(-179.99, gd1.getLatitud(), ERROR_ADMISIBLE);
		assertEquals(179.99, gd1.getLongitud(), ERROR_ADMISIBLE);
	}

	@Test
	public void testSetLatitudSetLongitudValido(){
		GD gd1 = new GD(-179.99, 179.99);
		
		gd1.setLatitud(-178.99);
		gd1.setLongitud(178.99);
		
		assertNotNull(gd1);
		assertEquals(-178.99, gd1.getLatitud(), ERROR_ADMISIBLE);
		assertEquals(178.99, gd1.getLongitud(), ERROR_ADMISIBLE);
		
	}
	
	@Test
	public void testCalculaDistanciaEntreDosGDValido(){
		GD gd1 = new GD(-179.99, 179.99);
		GD gd2 = new GD(179.99, -179.99);
		
		double distancia = gd1.getDistanciaAt(gd2);
		
		assertNotNull(gd1);
		assertNotNull(gd2);
		assertEquals(200.00, distancia, ERROR_ADMISIBLE); //TODO Es un valor aleatorio, comprobar al implementar
	}
}
