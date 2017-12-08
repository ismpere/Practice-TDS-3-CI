package uva.tds.pr2.equipo05;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

import uva.tds.pr2.equipo05.*;
import org.junit.Test;

/**
 * Implementacion de la clase de test de caja negra (incompleta) de la clase RedAutobuses
 * @author martorb
 * @author ismpere
 *
 */
public class RedAutobusesBlackBoxTest {
	
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
	public void testGetAllLineasValido(){
		
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		
		Linea l[] = red.getAllLineas();
		
		assertArrayEquals(lista_lineas, l);
	}
	
	@Test (expected = AssertionError.class)
	public void testInicializaRedNoValidoSolo1Linea() {
		
		Linea[] lista_lineas={l1};
		RedAutobuses red= new RedAutobuses(lista_lineas);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInicializaRedNoValidoSinListaLineas() {
		
		RedAutobuses red= new RedAutobuses(null);
	}
	
	@Test (expected = AssertionError.class)
	public void testInicializaRedNoValidoLineasRepetidas() {
		
		Linea[] lista_lineas={l1,l1};
		RedAutobuses red= new RedAutobuses(lista_lineas);
	}
	
	@Test (expected = AssertionError.class)
	public void testGetLineaNoValidoNoExisteEnRed(){
		
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		red.getLinea(3);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddLineaNoValidoLineaNulo() {
		
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		red.addLinea(null);
	}
	
	@Test (expected = AssertionError.class)
	public void testAddLineaNoValidoLineaRepetida() {
		
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		red.addLinea(l1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testDeleteLineaNoValidoLineaNulo() {
		Linea[] lista_lineas={l1,l2,l3};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		red.deleteLinea(null);
	}
	
	@Test (expected = AssertionError.class)
	public void testDeleteLineaNoValidoLineaNoExisteEnRed() {
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		red.deleteLinea(l3);
	}
	
	@Test (expected = AssertionError.class)
	public void testDeleteLineaNoValidoQuedanMenosDeDosLineas() {
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		red.deleteLinea(l2);
	}
		
	@Test (expected = IllegalArgumentException.class)
	public void testContainsNoValidoLineaNulo() {
		Linea[] lista_lineas={l1,l2};
		RedAutobuses red= new RedAutobuses(lista_lineas);
		red.contains(null);
	}
}
