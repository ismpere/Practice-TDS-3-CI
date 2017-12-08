package uva.tds.pr2.equipo05;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

import uva.tds.pr2.equipo05.*;
import org.junit.Test;
/**
 * Implementacion de la clase de test TDD de RedAutobuses
 * @author ismpere
 * @author martorb
 */
public class RedAutobusesTDDTest {

	private GD gd1 = new GD (-179.99,179.99);
	private GD gd2 = new GD (-178.99,178.99);
	private GD gd3 = new GD (-177.99,177.99);
	private GD gd4 = new GD (-176.99,176.99);
	private GD gd5 = new GD (-175.99,175.99);
	private GD gd6 = new GD (-174.99,174.99);
	
	private Parada p1,p2,p3,p4,p5,p6;
	private Parada p_1[] = {p1,p2,p3};
	private Parada p_2[] = {p2,p3,p4};
	private Parada p_3[] = {p4,p1,p2};
	
	private Linea l1, l2,l3;

	@Before
    public void setUp() throws Exception {
		
		p1= new Parada("1",gd1);
		p2= new Parada("2",gd2);
		p3= new Parada("3",gd3);
		l1= new Linea(1,p_1);
		l2= new Linea(2,p_2);
		l3= new Linea(3,p_3);
	}
	
	@After
	public void tearDown() throws Exception{
		p1= null;
		p2= null;
		p3= null;
		l1= null;
		l2= null;
		l3=null;
	}
	
	@Test
	public void testInicializaRedValido() { 
		
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		assertNotNull(red);
		assertArrayEquals(lista_lineas, red.getAllLineas());
	}
	
	@Test
	public void testContieneParadaValido(){
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		boolean c = red.contains(l1);
		
		assertNotNull(red);
		assertTrue(c);
	}
	
	@Test
	public void testContieneParadaPorIdValido(){
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		boolean c = red.contains(1);
		
		assertNotNull(red);
		assertTrue(c);
	}
	
	@Test
	public void testAddLineaValido(){
		
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		red.addLinea(l3);
		
		Linea l[] = {l1,l2,l3};
		
		assertNotNull(red);
		assertTrue(red.contains(l3)); //TODO no se si es necesario
		assertArrayEquals(l, red.getAllLineas());
	}
	
	@Test
	public void testDeleteLineaValido() {
		
		Linea[] lista_lineas={l1,l2,l3};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		red.deleteLinea(l3);
		
		Linea l[] = {l1,l2};
		
		assertNotNull(red);
		assertFalse(red.contains(l3));
		assertArrayEquals(l, red.getAllLineas());
	}
	
	@Test
	public void testGetLineaPorIdValido(){
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		Linea l = red.getLinea(1);
		
		assertNotNull(red);
		assertNotNull(l);
		assertEquals(l1, l);
	}
	
	@Test
	public void testExistenLineasConParadasCercanasValido(){
		
		GD gd_busq= new GD(-179.98,179.99);
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		boolean e = red.existenLineasConParadasCercanas(gd_busq, 0.01);
		
		Linea[] lcS = {l1};
		
		assertNotNull(red);
		assertTrue(e);				
	}
	
	@Test
	public void testGetLineasConParadasCercanasValido(){
		
		GD gd_busq= new GD(-179.98,179.99);
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		Linea[] lineas_cercanas=red.getLineasConParadasCercanas(gd_busq, 0.01);
		
		Linea[] lcS = {l1};
		
		assertNotNull(red);
		assertNotNull(lineas_cercanas);
		assertTrue(red.existenLineasConParadasCercanas(gd_busq, 0.01));
		assertArrayEquals(lcS, lineas_cercanas);		
	}
}
