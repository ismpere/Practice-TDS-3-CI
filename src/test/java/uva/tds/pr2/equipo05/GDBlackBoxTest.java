package uva.tds.pr2.equipo05;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Implementacion de la clase de test de caja negra de la clase GD
 * @author ismpere
 * @author martorb
 */
public class GDBlackBoxTest {
	
	private static final double ERROR_ADMISIBLE = 0.01;
	
	@Test
	public void testGetLatitudGDValido(){
		GD gd1 = new GD(-179.99, 179.99); //TODO las coordenadas son aleatorias, corregir cuando se implemente
		
		double latitud = gd1.getLatitud();
		
		assertNotNull(gd1);
		assertEquals(-179.99, latitud, ERROR_ADMISIBLE);
	}
	
	@Test
	public void testGetLongitudGDValido(){
		GD gd1 = new GD(-179.99, 179.99); //TODO las coordenadas son aleatorias, corregir cuando se implemente
		
		double longitud = gd1.getLongitud();
		
		assertNotNull(gd1);
		assertEquals(-179.99, longitud, ERROR_ADMISIBLE);
	}

	@Test (expected = AssertionError.class)
	public void testInicializaGDNoValidoLatitudInferior(){
		GD gd1 = new GD(-180.00, 179.99);
	}
	@Test (expected = AssertionError.class)
	public void testInicializaGDNoValidoLatitudSuperior(){
		GD gd1 = new GD(180.00, 179.99);
	}
	@Test (expected = AssertionError.class)
	public void testInicializaGDNoValidoLongitudInferior(){
		GD gd1 = new GD(-179.99, -180.00);
	}
	@Test (expected = AssertionError.class)
	public void testInicializaGDNoValidoLongitudSuperior(){
		GD gd1 = new GD(179.99, 180.00);
	}
	@Test (expected = AssertionError.class)
	public void testSetLatitudNoValidoLatitudInferior(){
		GD gd1 = new GD(-179.99, 179.99);
		
		gd1.setLatitud(-180.00);
	}
	@Test (expected = AssertionError.class)
	public void testSetLatitudNoValidoLatitudSuperior(){
		GD gd1 = new GD(-179.99, 179.99);
		
		gd1.setLatitud(180.00);
	}
	@Test (expected = AssertionError.class)
	public void testSetLongitudNoValidoLongitudInferior(){
		GD gd1 = new GD(-179.99, 179.99);
		
		gd1.setLongitud(-180.00);
	}
	@Test (expected = AssertionError.class)
	public void testSetLongitudNoValidoLongitudSuperior(){
		GD gd1 = new GD(-179.99, 179.99);
		
		gd1.setLongitud(180.00);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testCalculaDistanciaEntreDosGDNoValidoGDNulo(){
		GD gd1 = new GD(179.99, -179.99);
		GD gd2 = null;
		
		gd1.getDistanciaAt(gd2);
	}

}
