package uva.tds.pr2.equipo05;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.After;
import org.junit.Before;
/**
 * Implementacion de los test por los que se ha hecho el desarrollo TDD de la clase Linea
 * @author ismpere
 * @author martorb
 */
@Category({Unit.class, TDD.class})
public class LineaUnitTDDTest {
	
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
	public void testContieneParadaValido(){
		Linea l1 = new Linea(1, p);
		
		boolean c = l1.contains(p1);

		assertNotNull(l1);
		assertTrue(c);
	}
	
	@Test
	public void testAñadeParadaIntermediaValido(){
		Linea l1 = new Linea(1, p);
		
		GD gd4 = new GD(41.3157608,-4.9175546);
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
		
		GD gd4 = new GD(41.3153082, -4.9174276);
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
		GD gd4 = new GD(41.3153082, -4.9174276);
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
	public void testHayLineasRepetidasValido(){
		Linea l1 = new Linea(1, p);
		
		GD gd4 = new GD(-150.00, 150.00); //TODO son ubicaciones aleatorias, poner una valida que lo cumpla
		Parada p4 = new Parada("d", gd4);
		GD gd5 = new GD(41.3142799,-4.9188526); //TODO son ubicaciones aleatorias, poner una valida que lo cumpla
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
