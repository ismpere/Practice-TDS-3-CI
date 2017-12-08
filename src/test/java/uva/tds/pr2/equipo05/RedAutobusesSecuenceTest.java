package uva.tds.pr2.equipo05;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests de secuencia para la clase RedAutobuses
 * @author martorb
 * @author ismpere
 *
 */
public class RedAutobusesSecuenceTest {
	
	private GD gd1 = new GD (-179.99,179.99);
	private GD gd2 = new GD (-178.99,178.99);
	private GD gd3 = new GD (-177.99,177.99);
	private GD gd4 = new GD (-176.99,176.99);
	
	private Parada p1,p2,p3,p4;
	private Parada p_1[] = {p1,p2,p3};
	private Parada p_2[] = {p2,p3,p4};
	private Parada p_3[] = {p4,p1,p2};
	
	private Linea l1, l2,l3;
	
	@Before
    public void setUp() throws Exception {
		
		p1= new Parada("1",gd1);
		p2= new Parada("2",gd2);
		p3= new Parada("3",gd3);
		p4= new Parada("4",gd4);
		l1= new Linea(1,p_1);
		l2= new Linea(2,p_2);
		l3= new Linea(3,p_3);
	}
	
	@After
	public void tearDown() throws Exception{
		p1= null;
		p2= null;
		p3= null;
		p4= null;
		l1= null;
		l2= null;
		l3= null;
	}
	
	@Test
	public void testSecuenciaEliminarYAñadirLineaValido() {
		Linea[] lista_lineas={l1,l2,l3};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		red.deleteLinea(l3);
		red.addLinea(l3);
		
		assertNotNull(red);
		assertArrayEquals(lista_lineas, red.getAllLineas());
	}
	
	@Test
	public void testSecuenciaAñadirYEliminarLineaValido() {
		Linea[] lista_lineas={l1,l2,l3};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		red.addLinea(l2);
		red.deleteLinea(l2);
		
		assertNotNull(red);
		assertArrayEquals(lista_lineas, red.getAllLineas());
	}
	
	@Test
	public void testSecuenciaContainsDespuesDeEliminarLineaValido() {
		Linea[] lista_lineas={l1,l2,l3};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		red.deleteLinea(l3);
		assertFalse(red.contains(3));
		
		fail("El test no falla por si solo ya que la fake implementacion de contains devuelve siempre false");
	}
	
	@Test (expected = AssertionError.class)
	public void testSecuenciaEliminar2VecesMismaLineaNoValido() {
		Linea[] lista_lineas={l1,l2,l3};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		red.deleteLinea(l3);
		red.deleteLinea(l3);
	}
	
	@Test (expected = AssertionError.class)
	public void testSecuenciaEliminarHastaTenerMenosDeDosLineasNoValido() {
		Linea[] lista_lineas={l1,l2,l3};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		red.deleteLinea(l3);
		red.deleteLinea(l2);
	}
	
	@Test (expected = AssertionError.class)
	public void testSecuenciaEliminarHastaTenerMenosDeDosLineasNoValidoOtroOrden() {
		Linea[] lista_lineas={l1,l2,l3};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		red.deleteLinea(l2);
		red.deleteLinea(l3);
	}
	
	@Test (expected = AssertionError.class)
	public void testSecuenciaGetLineaPorIdQueYaNoExisteNoValido() {
		Linea[] lista_lineas={l1,l2,l3};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		red.deleteLinea(l3);
		Linea l_no_ex=red.getLinea(3);
	}
	
	@Test
	public void testSecuenciaAleatoriaGetLineaPorIdCambiaLineaValido() {
		Linea[] lista_lineas={l1,l2,l3};
		Parada p_4[] = {p4,p3,p2};
		Linea l4=new Linea(3,p_4);
		
		RedAutobuses red= new RedAutobuses(lista_lineas);
		Linea l_3=red.getLinea(3);
		red.deleteLinea(l3);
		red.addLinea(l4);
		assertNotEquals(l_3, red.getLinea(3));
	}
	
	@Test
	public void testSecuenciaAleatoriaGetLineasConParadasCercanasValido() {
		Linea[] lista_lineas={l2,l3};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		red.addLinea(l1);
		red.deleteLinea(l2);
		assertTrue(red.existenLineasConParadasCercanas(gd3, 200.00)); //cercana l1 que añadida, luego true	
	}

}
