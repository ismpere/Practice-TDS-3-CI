package uva.tds.pr2.equipo05;
 
import static org.junit.Assert.*;
 
import org.junit.After;
import org.junit.Before;
 
import uva.tds.pr2.equipo05.*;
import org.junit.Test;
import org.junit.experimental.categories.Category;
 
/**
 * Implementacion de la clase de test específico del método getLineasConParadasCercanas de RedAutobuses
 * @author ismpere
 * @author martorb
 */
@Category({Integration.class, Unit.class})
public class RedAutobusesGetLineasConParadasCercanasTest{
   
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
   
    private Parada p_1[] = {p1,p2,p3};
    private Parada p_2[] = {p4,p5,p6};
   
    private Linea l1, l2;
   
    @Before
    public void setUp() throws Exception {
       
        l1= new Linea(1,p_1);
        l2= new Linea(2,p_2);
    }
   
    @After
    public void tearDown() throws Exception{
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
    }
   
    @Test
    public void testGetLineasConParadasCercanasValido1LineaCercana(){
        GD gd_busq= new GD(41.3078890, -4.9181329);
        Linea[] lista_lineas={l1,l2};
        RedAutobuses red= new RedAutobuses(lista_lineas);
       
        Linea[] lineas_cercanas=red.getLineasConParadasCercanas(gd_busq, 200.00);
       
        Linea[] l = {l2};
       
        assertNotNull(red);
        assertNotNull(lineas_cercanas);
        assertTrue(red.existenLineasConParadasCercanas(gd_busq, 200.00));
        assertArrayEquals(l, lineas_cercanas);
    }
   
    @Test
    public void testGetLineasConParadasCercanasValido2LineasCercanas(){
        GD gd_busq= new GD(41.3123926,-4.9176796);
        Linea[] lista_lineas={l1,l2};
        RedAutobuses red= new RedAutobuses(lista_lineas);
       
        Linea[] lineas_cercanas=red.getLineasConParadasCercanas(gd_busq, 300.00);
       
        Linea[] l = {l1,l2};
       
        assertNotNull(red);
        assertNotNull(lineas_cercanas);
        assertTrue(red.existenLineasConParadasCercanas(gd_busq, 200.00));
        assertArrayEquals(l, lineas_cercanas);
    }
   
    @Test
    public void testGetLineasConParadasCercanasValido0LineasCercanas(){
        GD gd_busq= new GD(-100.00, 100.00);
        Linea[] lista_lineas={l1,l2};
        RedAutobuses red= new RedAutobuses(lista_lineas);
       
        Linea[] lineas_cercanas=red.getLineasConParadasCercanas(gd_busq, 200.00);
       
        assertNotNull(red);
        assertNotNull(lineas_cercanas);
        assertFalse(red.existenLineasConParadasCercanas(gd_busq, 200.00));
        assertEquals(0, lineas_cercanas.length);
   
    }
}