package uva.tds.pr2.equipo05;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;
/**
 * Implementacion de la clase de test de caja negra de la clase GD
 * @author ismpere
 * @author martorb
 */
@Category({Unit.class})
public class GDBlackBoxTest {
	
	private static final double ERROR_ADMISIBLE = 0.01;
	
	@Test
	public void testGetLatitudGDValido(){
		GD gd1 = new GD(-179.99, 179.99); 
		
		double latitud = gd1.getLatitud();
		
		assertNotNull(gd1);
		assertEquals(-179.99, latitud, ERROR_ADMISIBLE);
	}
	
	@Test
	public void testGetLongitudGDValido(){
		GD gd1 = new GD(-179.99, 179.99); 
		
		double longitud = gd1.getLongitud();
		
		assertNotNull(gd1);
		assertEquals(179.99, longitud, ERROR_ADMISIBLE);
	}
	
	@Test
	public void testSetLatitudGDValidoPequenio(){
		GD gd1 = new GD(179.99, 179.99); 
		
		gd1.setLatitud(-179.99);
		
		assertNotNull(gd1);
		assertEquals(-179.99, gd1.getLatitud(), ERROR_ADMISIBLE);
	}
	
	@Test
	public void testSetLongitudGDValidoPequenio(){
		GD gd1 = new GD(-179.99, 179.99); 
		
		gd1.setLongitud(-179.99);
		
		assertNotNull(gd1);
		assertEquals(-179.99, gd1.getLongitud(), ERROR_ADMISIBLE);
	}
	
	@Test
	public void testCalculaDistanciaEntreDosGDValidoUbicacionesCercanas(){
		GD gd1 = new GD(41.3154608, -4.9177346);
		GD gd2 = new GD(41.3142809, -4.9189326);
		
		double distancia = gd1.getDistanciaAt(gd2);
		
		assertNotNull(gd1);
		assertNotNull(gd2);
		assertEquals(176.80, distancia, ERROR_ADMISIBLE);
	}
	
	@Test
	public void testCalculaDistanciaEntreDosGDValidoGDThis(){
		GD gd1 = new GD(41.3154608, -4.9177346);
		
		double distancia = gd1.getDistanciaAt(gd1);
		
		assertNotNull(gd1);
		assertEquals(0.00, distancia, ERROR_ADMISIBLE);
	}
	
	@Test
	public void testCalculaDistanciaEntreDosGDValidoMismasCoordenadas(){
		GD gd1 = new GD(41.3154608, -4.9177346);
		GD gd2 = new GD(41.3154608, -4.9177346);
		
		double distancia = gd1.getDistanciaAt(gd2);
		
		assertNotNull(gd1);
		assertNotNull(gd2);
		assertEquals(0.00, distancia, ERROR_ADMISIBLE);
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
	public void testInicializaGDNoValidoLatitudYLongitudInferior(){
		GD gd1 = new GD(-180.00, -180.00);
	}
	@Test (expected = AssertionError.class)
	public void testInicializaGDNoValidoLatitudYLongitudSuperior(){
		GD gd1 = new GD(180.00, 180.00);
	}
	@Test (expected = AssertionError.class)
	public void testInicializaGDNoValidoLatitudSuperiorLongitudInferior(){
		GD gd1 = new GD(180.00, -180.00);
	}
	@Test (expected = AssertionError.class)
	public void testInicializaGDNoValidoLatitudInferiorLongitudSuperior(){
		GD gd1 = new GD(-180.00, 180.00);
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
	@Test (expected = AssertionError.class)
	public void testCalculaDistanciaEntreDosGDNoValidoGDNulo(){
		GD gd1 = new GD(179.99, -179.99);
		GD gd2 = null;
		
		gd1.getDistanciaAt(gd2);
	}
}
