package uva.tds.pr2.equipo05;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({Integration.class, TDD.class})
public class LineaIntegrationTDDTest {
	
	private GD gd1 = new GD (41.3154608,-4.9177346);
	private GD gd2 = new GD (41.3142809,-4.9189326);
	private GD gd3 = new GD (41.3153508,-4.9176232);
	private Parada p1 = new Parada("a", gd1);
    private Parada p2 = new Parada("b", gd2);
    private Parada p3 = new Parada("c", gd3);
	Parada[] p = {p1, p2, p3};

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
	public void testSetParadaInicioValido(){
		Linea l1 = new Linea(1, p);
		
		GD gd4 = new GD(41.3155708, -4.9178456);
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
	public void testSetParadaFinValido(){
		Linea l1 = new Linea(1, p);
		
		GD gd4 = new GD(41.3155708, -4.9178456);
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
	public void testExistenParadasCercanasValido(){
		Linea l1 = new Linea(1, p);
		
		GD gd4 = new GD(41.3153082, -4.9174276); //TODO son ubicaciones aleatorias, poner una valida que lo cumpla
		
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
		
		GD gd4 = new GD(41.3153082, -4.9174276); //TODO son ubicaciones aleatorias, poner una valida que lo cumpla
		
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

}
