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

@Category({Integration.class, TDD.class, Unit.class})
public class RedAutobusesIntegrationTDDTest {

	private GD gd1 = new GD (41.3154608,-4.9177346);
    private GD gd2 = new GD (41.3142809,-4.9189326);
    private GD gd3 = new GD (41.3153508,-4.9176232);
    private GD gd4 = new GD (41.308344,-4.9180686);
    private GD gd5 = new GD (41.3123926,-4.9176796);
    private GD gd6 = new GD (41.3078393, -4.9181145);
    
    private Parada p1 = new Parada("a",gd1);
    private Parada p2 = new Parada("b",gd2);
    private Parada p3 = new Parada("c",gd3);
    private Parada p4 = new Parada("d", gd4);
    private Parada p5 = new Parada("e", gd5);
    private Parada p6 = new Parada("f", gd6);
    
    private Linea l1, l2;
    private Parada lp1[], lp2[];
    
    @Before
    public void setUp() throws Exception {
    	Parada lp1[] = {p1,p2,p3};
        Parada lp2[] = {p4,p5,p6};
        l1= new Linea(1,lp1);
        l2= new Linea(2,lp2);
    }
    
    @After
    public void tearDown() throws Exception{
        l1= null;
        l2= null;
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
    public void testAddLineaValido(){
       
        GD gd4 = new GD(-100.00, 100.00);  
        GD gd5 = new GD(-100.0002, 100.00);
        GD gd6 = new GD(-100.00001, 100.00);
        Parada p4 = new Parada("d", gd4);
        Parada p5 = new Parada("d", gd5);
        Parada p6 = new Parada("d", gd6);
       
        Parada pa3[] = {p4, p5, p6};
        Linea l3 = new Linea(3, pa3);
       
        Linea[] lista_lineas={l1,l2};
        RedAutobuses red= new RedAutobuses(lista_lineas);
       
        red.addLinea(l3);
       
        Linea l[] = {l1,l2,l3};
       
        assertNotNull(red);
        assertTrue(red.contains(l3));
        assertArrayEquals(l, red.getAllLineas());
    }
   
    @Test
    public void testDeleteLineaValido() {
       
        GD gd4 = new GD(-100.00, 100.00);  
        GD gd5 = new GD(-100.0002, 100.00);
        GD gd6 = new GD(-100.00001, 100.00);
        Parada p4 = new Parada("d", gd4);
        Parada p5 = new Parada("d", gd5);
        Parada p6 = new Parada("d", gd6);
       
        Parada pa3[] = {p4, p5, p6};
        Linea l3 = new Linea(3, pa3);
       
        Linea[] lista_lineas={l1,l2,l3};
        RedAutobuses red= new RedAutobuses(lista_lineas);
       
        red.deleteLinea(l3);
       
        Linea l[] = {l1,l2};
       
        assertNotNull(red);
        assertFalse(red.contains(l3));
        assertArrayEquals(l, red.getAllLineas());
    }
	
	 @Test
	    public void testExistenLineasConParadasCercanasValido(){
	       
	        GD gd_busq = new GD (41.3143109,-4.9188026);
	        Linea[] lista_lineas={l1,l2};
	        RedAutobuses red= new RedAutobuses(lista_lineas);
	       
	        boolean e = red.existenLineasConParadasCercanas(gd_busq, 1000);
	       
	        Linea[] lcS = {l1};
	       
	        assertNotNull(red);
	        assertTrue(e);             
	    }
	
	  @Test
	    public void testGetLineasConParadasCercanasValido(){
	       
	        GD gd_busq = new GD (41.3143109,-4.9188026);
	        Linea[] lista_lineas={l1,l2};
	        RedAutobuses red= new RedAutobuses(lista_lineas);
	       
	        Linea[] lineas_cercanas=red.getLineasConParadasCercanas(gd_busq, 100);
	       
	        Linea[] lcS = {l1};
	       
	        assertNotNull(red);
	        assertNotNull(lineas_cercanas);
	        assertTrue(red.existenLineasConParadasCercanas(gd_busq, 100));
	        assertArrayEquals(lcS, lineas_cercanas);       
	    }

}
