package uva.tds.pr2.equipo05;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

import uva.tds.pr2.equipo05.*;
import org.junit.Test;

/**
 * Implementacion de la clase de test específico del método getLineasConParadasCercanas de RedAutobuses
 * @author ismpere
 * @author martorb
 */
public class RedAutobusesGetLineasConParadasCercanasTest{
	
	private GD gd1 = new GD (-179.00,179.00); 
	private GD gd2 = new GD (-179.00,179.01); 
	private GD gd3 = new GD (-179.00,179.10);
	private GD gd4 = new GD (-179.00,179.11); 
	private GD gd5 = new GD (-179.00,179.12);
	private GD gd6 = new GD (-179.00,179.20);
	
	private Parada p1,p2,p3,p4,p5,p6;
	private Parada p_1[] = {p1,p2,p3};
	private Parada p_2[] = {p4,p5,p6};
	
	private Linea l1, l2;
	
	@Before
	public void setUp(){
		p1= new Parada("1",gd1);
		p2= new Parada("2",gd2); 
		p3= new Parada("3",gd3);
		
		p4= new Parada("4",gd4);
		p5= new Parada("5",gd5); 
		p6= new Parada("6",gd6);
		
		l1= new Linea(1,p_1);
		l2= new Linea(2,p_2);
	}
	
	@After
	public void tearDown(){
		p1= null;
		p2= null;
		p3= null;
		p4= null;
		p5= null;
		p6= null;
		l1= null;
		l2= null;
	}
	
	@Test
	public void testNoExistenLineasConParadasCercanasValido(){
		
		GD gd_busq= new GD(-179.98,179.99);
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		boolean e = red.existenLineasConParadasCercanas(gd_busq, 200.00);
		
		Linea[] lcS = {l1};
		
		assertNotNull(red);
		assertFalse(e);
		
		fail("Hacemos que falle ya que la fake implementacion de existen... devuelve siempre false");
	}
	
	@Test
	public void testGetLineasConParadasCercanasValido1LineaCercana(){
		GD gd_busq= new GD(-179.00,178.99);   //pos cercana a p1 pert. a l1
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		Linea[] lineas_cercanas=red.getLineasConParadasCercanas(gd_busq, 200.00);
		
		Linea[] l = {l1};
		
		assertNotNull(red);
		assertNotNull(lineas_cercanas);
		assertTrue(red.existenLineasConParadasCercanas(gd_busq, 200.00));
		assertArrayEquals(l, lineas_cercanas);
	}
	
	@Test
	public void testGetLineasConParadasCercanasValido2LineasCercanas(){
		GD gd_busq= new GD(-179.00,179.10);  //pos cercana a p3 y p4, de l1 y l2 resp.
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		Linea[] lineas_cercanas=red.getLineasConParadasCercanas(gd_busq, 200.00);
		
		Linea[] l = {l1,l2};
		
		assertNotNull(red);
		assertNotNull(lineas_cercanas);
		assertTrue(red.existenLineasConParadasCercanas(gd_busq, 200.00));
		assertArrayEquals(l, lineas_cercanas);
	}
	
	@Test
	public void testGetLineasConParadasCercanasValido0LineasCercanas(){
		GD gd_busq= new GD(-100.00,200.00);  //pos lejana a todas las paradas
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		Linea[] lineas_cercanas=red.getLineasConParadasCercanas(gd_busq, 200.00);
		
		assertNotNull(red);
		assertNotNull(lineas_cercanas);
		assertFalse(red.existenLineasConParadasCercanas(gd_busq, 200.00));
		assertEquals(0, lineas_cercanas.length);
	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testExistenLineasConParadasCercanasNoValidoGDNulo(){
		
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		red.existenLineasConParadasCercanas(null, 0.01);			
	}
	
	@Test (expected = AssertionError.class)
	public void testExistenLineasConParadasCercanasNoValidoRadioMenorQue0(){
		GD gd_busq= new GD(-100.00,200.00);
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		red.existenLineasConParadasCercanas(gd_busq, -0.01);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testGetLineasConParadasCercanasNoValidoGDNulo(){
		
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		red.getLineasConParadasCercanas(null, 0.01);			
	}
	
	@Test (expected = AssertionError.class)
	public void testGetLineasConParadasCercanasNoValidoRadioMenorQue0(){
		GD gd_busq= new GD(-100.00,200.00);
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		red.existenLineasConParadasCercanas(gd_busq, -0.01);
	}
}