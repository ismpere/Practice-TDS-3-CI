package uva.tds.pr2.equipo05;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Implementacion de la clase de test  de integración TDD de RedAutobuses
 * @author ismpere
 * @author martorb
 */

@Category({Integration.class, TDD.class})
public class RedAutobusesIntegrationTDDTest {

	private GD gd1 = new GD (41.3154608,-4.9177346);
	private GD gd2 = new GD (41.3142809,-4.9189326);
	private GD gd3 = new GD (41.3153508,-4.9176232);
	
	private GD gd4 = new GD(41.308344,-4.9180686);
	private GD gd5 = new GD(41.3123926,-4.9176796);
	private GD gd6 = new GD(41.3078393, -4.9181145);
	
	private Parada p1, p2, p3, p4, p5, p6;
	
	Parada[] lp1 = {p1, p2, p3};
	Parada[] lp2 = {p4, p5, p6};
	
	@Before
    public void setUp() throws Exception {
        p1 = new Parada("a", gd1);
        p2 = new Parada("b", gd2);
        p3 = new Parada("c", gd3);
        
        p4 = new Parada("d", gd4);
    	p5 = new Parada("e", gd5);
    	p6 = new Parada("f", gd6);
    }
     
    @After
    public void tearDown() throws Exception {
        p1 = null;	
        p2 = null;	
        p3 = null;
        p4 = null;
        p5 = null;
        p6 = null;
    }
  
	@Test
	public void testInicializaRedValido() {  //integr
		Linea l1 = new Linea(1, lp1);
		Linea l2 = new Linea(2,lp2);
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		assertNotNull(red);
		assertArrayEquals(lista_lineas, red.getAllLineas());
	}
	
	@Test
	public void testExistenLineasConParadasCercanasValido(){
		
		GD gd_busq= new GD(41.3155000,-4.9177300);
		Linea l1 = new Linea(1, lp1);
		Linea l2 = new Linea(2,lp2);
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		boolean e = red.existenLineasConParadasCercanas(gd_busq, 1000);
		
		Linea[] lcS = {l1};
		
		assertNotNull(red);
		assertTrue(e);				
	}
	
	@Test
	public void testGetLineasConParadasCercanasValido(){
		
		GD gd_busq= new GD(41.3155000,-4.9177300);
		Linea l1 = new Linea(1, lp1);
		Linea l2 = new Linea(2,lp2);
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		Linea[] lineas_cercanas=red.getLineasConParadasCercanas(gd_busq,1000);
		
		Linea[] lcS = {l1};
		
		assertNotNull(red);
		assertNotNull(lineas_cercanas);
		assertTrue(red.existenLineasConParadasCercanas(gd_busq, 1000));
		assertArrayEquals(lcS, lineas_cercanas);		
	}

}
