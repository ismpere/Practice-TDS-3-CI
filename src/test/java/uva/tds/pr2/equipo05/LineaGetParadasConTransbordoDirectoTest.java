package uva.tds.pr2.equipo05;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Implementacion de los test para el metodo getParadasConTransbordo
 * @author ismael
 * @author martorb
 */
@Category({Integration.class})
public class LineaGetParadasConTransbordoDirectoTest {

	private GD gd1 = new GD (41.3154608,-4.9177346);
	private GD gd2 = new GD (41.3123926,-4.9176796);
	private GD gd3 = new GD (41.3153508,-4.9176232);
	private Parada p1, p2, p3;
	private Linea l1;
	
	@Before
    public void setUp() throws Exception {
        p1 = new Parada("a", gd1);
        p2 = new Parada("b", gd2);
        p3 = new Parada("c", gd3);
        Parada p[] = {p1, p2, p3};
        l1 = new Linea(1, p);
    }
     
    @After
    public void tearDown() throws Exception {
        p1 = null;	
        p2 = null;	
        p3 = null;
        l1 = null;
    }
    
    @Test
	public void testGetParadasConTransbordoDirectoUnaParadaConTDValido(){
    	
    	GD gd4 = new GD(41.308344,-4.9180686);
    	Parada p4 = new Parada("d", gd4);
    	GD gd5 = new GD(41.3078393, -4.9181145);
    	Parada p5 = new Parada("f", gd5);
		
		Parada pa3[] = {p4, p2, p5};
		Linea l2 = new Linea(2, pa3);
		
		Parada pct[] = l1.getParadasConTransbordoDirecto(l2);
		
		Parada pctS[] = {p2};
		
		assertNotNull(l1);
		assertNotNull(pct);
		assertTrue(l1.existeTransbordoDirecto(l2));
		assertArrayEquals(pctS, pct);
	}
	
	@Test
	public void testGetParadasConTransbordoDirectoVariasParadasConTDValido(){
		
		GD gd4 = new GD(41.308344,-4.9180686);
    	Parada p4 = new Parada("d", gd4);
		
		Parada pa3[] = {p1, p4, p3};
		Linea l2 = new Linea(2, pa3);
		
		Parada pct[] = l1.getParadasConTransbordoDirecto(l2);
		
		Parada pctS[] = {p1, p3};
		
		assertNotNull(l1);
		assertNotNull(pct);
		assertTrue(l1.existeTransbordoDirecto(l2));
		assertArrayEquals(pctS, pct);
	}
	
	@Test
	public void testGetParadasConTransbordoDirectoNingunaParadaConTDValido(){
		
		GD gd4 = new GD(41.308344,-4.9180686);
    	Parada p4 = new Parada("d", gd4);
    	GD gd5 = new GD(41.3123926,-4.9176796);
    	Parada p5 = new Parada("e", gd5);
    	GD gd6 = new GD(41.3078393, -4.9181145);
    	Parada p6 = new Parada("f", gd6);
		
		Parada pa3[] = {p4, p5, p6};
		Linea l2 = new Linea(2, pa3);
		
		Parada pct[] = l1.getParadasConTransbordoDirecto(l2);
		
		assertNotNull(l1);
		assertNotNull(pct);
		assertFalse(l1.existeTransbordoDirecto(l2));
		assertEquals(0, pct.length);
	}
	
    @Test
	public void testNoExistenParadasConTransbordoDirectoValido(){
		
    	GD gd4 = new GD(41.308344,-4.9180686);
    	Parada p4 = new Parada("d", gd4);
    	GD gd5 = new GD(41.3123926,-4.9176796);
    	Parada p5 = new Parada("e", gd5);
    	GD gd6 = new GD(41.3078393, -4.9181145);
    	Parada p6 = new Parada("f", gd6);
		
		Parada pa3[] = {p4, p5, p6}; //TODO son paradas aleatorias, poner paradas que lo cumplan
		Linea l2 = new Linea(2, pa3);
		
		boolean e = l1.existeTransbordoDirecto(l2);
		
		assertNotNull(l1);
		assertFalse(e);
	}
}
