package uva.tds.pr2.equipo05;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
/**
 * Implementacion de los test por los que se ha hecho el desarrollo TDD de la clase Linea
 * @author ismpere
 * @author martorb
 */
public class LineaTDDTest {
	
	private GD gd1 = new GD (-179.99,179.99);
	private GD gd2 = new GD (-178.99,178.99);
	private GD gd3 = new GD (-177.99,177.99);
	private Parada p1, p2, p3;
	private Parada p[] = {p1, p2, p3};

	@Before
    public void setUp() throws Exception {
        p1 = new Parada("a", gd1);
        p2 = new Parada("b", gd2);
        p3 = new Parada("c", gd3);
    }
     
    @After
    public void tearDown() throws Exception {
        p1 = null;	
        p2 = null;	
        p3 = null;
        p = null;
    }
	
	@Test
	public void testInicializaLineaValido() {
		Linea l1 = new Linea(1, p);
		
		assertNotNull(l1);
		assertEquals(1, l1.getId());
		assertEquals(p1, l1.getParadaInicio());
		assertEquals(p3, l1.getParadaFin());
		assertArrayEquals(p, l1.getParadas());
	}
	
	@Test
	public void testSetIdValido(){
		Linea l1 = new Linea(1, p);
		
		l1.setId(2);
		
		assertNotNull(l1);
		assertEquals(2, l1.getId());
		assertEquals(p1, l1.getParadaInicio());
		assertEquals(p3, l1.getParadaFin());
		assertArrayEquals(p, l1.getParadas());
	}
	
	@Test
	public void testSetParadaInicioValido(){
		Linea l1 = new Linea(1, p);
		
		GD gd4 = new GD(-150.00, 150.00);
		Parada p4 = new Parada("d", gd4);
		
		l1.setParadaInicio(p4);
		
		Parada pa2[] = {p4, p1, p2, p3};
		assertNotNull(l1);
		assertTrue(l1.contains(p4));
		assertEquals(1, l1.getId());
		assertEquals(p4, l1.getParadaInicio());
		assertEquals(p3, l1.getParadaFin());
		assertArrayEquals(pa2, l1.getParadas());
	}
	
	@Test
	public void testContieneParadaValido(){
		Linea l1 = new Linea(1, p);
		
		boolean c = l1.contains(p1);

		assertNotNull(l1);
		assertTrue(c);
	}
	
	@Test
	public void testSetParadaFinValido(){
		Linea l1 = new Linea(1, p);
		
		GD gd4 = new GD(-150.00, 150.00);
		Parada p4 = new Parada("d", gd4);
		
		l1.setParadaFin(p4);
		
		Parada pa2[] = {p1, p2, p3, p4};
		assertNotNull(l1);
		assertTrue(l1.contains(p4));
		assertEquals(1, l1.getId());
		assertEquals(p1, l1.getParadaInicio());
		assertEquals(p4, l1.getParadaFin());
		assertArrayEquals(pa2, l1.getParadas());
	}
	
	@Test
	public void testAñadeParadaIntermediaValido(){
		Linea l1 = new Linea(1, p);
		
		GD gd4 = new GD(-150.00, 150.00);
		Parada p4 = new Parada("d", gd4);
		
		l1.addParadaIntermedia(p4);
		
		Parada pa2[] = {p1, p4, p2, p3};
		assertNotNull(l1);
		assertTrue(l1.contains(p4));
		assertEquals(1, l1.getId());
		assertEquals(p1, l1.getParadaInicio());
		assertEquals(p3, l1.getParadaFin());
		assertArrayEquals(pa2, l1.getParadas());
	}
	
	@Test
	public void testAñadeParadaEnPosicionValido(){
		Linea l1 = new Linea(1, p);
		
		GD gd4 = new GD(-150.00, 150.00);
		Parada p4 = new Parada("d", gd4);
		
		l1.addParadaIntermediaAt(p4, 3);
		
		Parada pa2[] = {p1, p2, p4, p3};
		assertNotNull(l1);
		assertTrue(l1.contains(p4));
		assertEquals(1, l1.getId());
		assertEquals(p1, l1.getParadaInicio());
		assertEquals(p3, l1.getParadaFin());
		assertArrayEquals(pa2, l1.getParadas());
	}
	
	@Test
	public void testEliminaParadaIntermediaValido(){
		GD gd4 = new GD(-150.00, 150.00);
		Parada p4 = new Parada("d", gd4);
		
		Parada pa2[] = {p1, p2, p4, p3};
		
		Linea l1 = new Linea(1, pa2);
		
		l1.removeParadaIntermedia(p4);
		
		assertNotNull(l1);
		assertFalse(l1.contains(p4));
		assertEquals(1, l1.getId());
		assertEquals(p1, l1.getParadaInicio());
		assertEquals(p3, l1.getParadaFin());
		assertArrayEquals(p, l1.getParadas());
	}
	
	@Test
	public void testExistenParadasCercanasValido(){
		Linea l1 = new Linea(1, p);
		
		GD gd4 = new GD(-170.00, 170.00); //TODO son ubicaciones aleatorias, poner una valida que lo cumpla
		
		boolean e = l1.existeParadasCercanas(gd4);
		
		assertNotNull(l1);
		assertTrue(e);
	}
	
	@Test
	public void testExistenParadasConCorrespondenciaValido(){
		Linea l1 = new Linea(1, p);
		
    	GD gd4 = new GD(-100.00, 100.00);
    	Parada p4 = new Parada("d", gd4);
		
		Parada pa3[] = {p1, p4, p3}; //TODO son paradas aleatorias, poner paradas que lo cumplan
		Linea l2 = new Linea(2, pa3);
		
		boolean e = l1.existeCorrespondencia(l2);
		
		assertNotNull(l1);
		assertNotNull(l2);
		assertTrue(e);
	}
	
    @Test
	public void testExistenParadasConTransbordoDirectoValido(){
    	Linea l1 = new Linea(1, p);
		
    	GD gd4 = new GD(-100.00, 100.00);
    	Parada p4 = new Parada("d", gd4);
		
		Parada pa3[] = {p1, p4, p3}; //TODO son paradas aleatorias, poner paradas que lo cumplan
		Linea l2 = new Linea(2, pa3);
		
		boolean e = l1.existeTransbordoDirecto(l2);
		
		assertNotNull(l1);
		assertTrue(e);
    }
	
	@Test
	public void testGetParadasCercanasValido(){
		Linea l1 = new Linea(1, p);
		
		GD gd4 = new GD(-150.00, 150.00); //TODO son ubicaciones aleatorias, poner una valida que lo cumpla
		
		Parada pa2[] = l1.getParadasCercanas(gd4);
		
		Parada pc[] = {p1};
		
		assertNotNull(l1);
		assertNotNull(pa2);
		assertTrue(l1.existeParadasCercanas(gd4));
		assertArrayEquals(pc, pa2);
	}
	
	@Test
	public void testGetParadasConCorrespondenciaValido(){
		Linea l1 = new Linea(1, p);
		
		GD gd4 = new GD(-150.00, 150.00); //TODO son ubicaciones aleatorias, poner una valida que lo cumpla
		Parada p4 = new Parada("d", gd4);
		GD gd5 = new GD(-140.00, 140.00); //TODO son ubicaciones aleatorias, poner una valida que lo cumpla
		Parada p5 = new Parada("d", gd5);
		
		Parada pa3[] = {p2, p4, p5};
		Linea l2 = new Linea(2, pa3);
		
		Parada pa2[] = l1.getParadasConCorrespondencia(l2);
		
		Parada pcc[] = {p2};
		
		assertNotNull(l1);
		assertNotNull(l2);
		assertNotNull(pa2);
		assertTrue(l1.existeCorrespondencia(l2));
		assertArrayEquals(pcc, pa2);
	}
	
	@Test
	public void testGetParadasConTransbordoDirectoValido(){
		Linea l1 = new Linea(1, p);
		
		GD gd4 = new GD(-150.00, 150.00); //TODO son ubicaciones aleatorias, poner una valida que lo cumpla
		Parada p4 = new Parada("d", gd4);
		GD gd5 = new GD(-140.00, 140.00); //TODO son ubicaciones aleatorias, poner una valida que lo cumpla
		Parada p5 = new Parada("d", gd5);
		
		Parada pa3[] = {p2, p4, p5};
		Linea l2 = new Linea(2, pa3);
		
		Parada pa2[] = l1.getParadasConTransbordoDirecto(l2);
		
		Parada pct[] = {p1};
		
		assertNotNull(l1);
		assertNotNull(l2);
		assertNotNull(pa2);
		assertTrue(l1.existeTransbordoDirecto(l2));
		assertArrayEquals(pct, pa2);
	}
	
	@Test
	public void testHayLineasRepetidasValido(){
		Linea l1 = new Linea(1, p);
		
		GD gd4 = new GD(-150.00, 150.00); //TODO son ubicaciones aleatorias, poner una valida que lo cumpla
		Parada p4 = new Parada("d", gd4);
		GD gd5 = new GD(-140.00, 140.00); //TODO son ubicaciones aleatorias, poner una valida que lo cumpla
		Parada p5 = new Parada("d", gd5);
		
		Parada pa3[] = {p2, p4, p5};
		Linea l2 = new Linea(2, pa3);
		
		Linea l[] = {l1,l2,l1};
		
		boolean repetidas = Linea.lineasRepetidas(l);
		
		assertNotNull(l1);
		assertNotNull(l2);
		assertTrue(repetidas);
	}
}
