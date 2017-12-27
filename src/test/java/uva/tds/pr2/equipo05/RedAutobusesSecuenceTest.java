package uva.tds.pr2.equipo05;
 
import static org.junit.Assert.*;
 
import javax.sound.midi.Sequence;
 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
 
/**
 * Tests de secuencia para la clase RedAutobuses
 * @author martorb
 * @author ismpere
 *
 */
@Category({Secuence.class, Integration.class})
public class RedAutobusesSecuenceTest {
   
    private GD gd1 = new GD (41.3154608,-4.9177346);
    private GD gd2 = new GD (41.3142809,-4.9189326);
    private GD gd3 = new GD (41.3153508,-4.9176232);
    private GD gd4 = new GD (41.308344,-4.9180686);
    private GD gd5 = new GD (41.3123926,-4.9176796);
    private GD gd6 = new GD (41.3078393, -4.9181145);
    private GD gd7 = new GD (-100.00, 100.00);  
    private GD gd8 = new GD (-100.0002, 100.00);
    private GD gd9 = new GD (-100.00001, 100.00);
   
    private Parada p1 = new Parada("a",gd1);
    private Parada p2 = new Parada("b",gd2);
    private Parada p3 = new Parada("c",gd3);
    private Parada p4 = new Parada("d", gd4);
    private Parada p5 = new Parada("e", gd5);
    private Parada p6 = new Parada("f", gd6);
    private Parada p7 = new Parada("g", gd7);
    private Parada p8 = new Parada("h", gd8);
    private Parada p9 = new Parada("i", gd9);
   
    private Parada[] p_1 = {p1,p2,p3};
    private Parada[] p_2 = {p4,p5,p6};
    private Parada[] p_3 = {p7,p8,p9};
   
    private Linea l1, l2, l3;
   
    @Before
    public void setUp() throws Exception {
       
        l1= new Linea(1,p_1);
        l2= new Linea(2,p_2);
        l3= new Linea(3,p_3);
    }
   
    @After
    public void tearDown() throws Exception{
        l1= null;
        l2= null;
        l3= null;
    }
   
    @Test
    public void testSecuenciaEliminarYAñadirLineaValido() { //falla
        Linea[] lista_lineas={l1,l2,l3};
        RedAutobuses red= new RedAutobuses(lista_lineas);
       
        red.deleteLinea(l3);
        red.addLinea(l3);
       
        assertNotNull(red);
        assertArrayEquals(lista_lineas, red.getAllLineas());
    }
   
    @Test
    public void testSecuenciaAñadirYEliminarLineaValido() { //falla
        Linea[] lista_lineas={l1,l3};
        RedAutobuses red= new RedAutobuses(lista_lineas);
       
        red.addLinea(l2);
        red.deleteLinea(l2);
       
        assertNotNull(red);
        assertArrayEquals(lista_lineas, red.getAllLineas());
    }
   
    @Test
    public void testSecuenciaContainsDespuesDeEliminarLineaValido() { //falla
        Linea[] lista_lineas={l1,l2,l3};
        RedAutobuses red= new RedAutobuses(lista_lineas);
       
        red.deleteLinea(l3);
        assertFalse(red.contains(3));
    }
   
    @Test (expected = AssertionError.class)
    public void testSecuenciaEliminar2VecesMismaLineaNoValido() { //falla
        Linea[] lista_lineas={l1,l2,l3};
        RedAutobuses red= new RedAutobuses(lista_lineas);
       
        red.deleteLinea(l3);
        red.deleteLinea(l3);
    }
   
    @Test (expected = AssertionError.class)
    public void testSecuenciaEliminarHastaTenerMenosDeDosLineasNoValido() { //falla
        Linea[] lista_lineas={l1,l2,l3};
        RedAutobuses red= new RedAutobuses(lista_lineas);
       
        red.deleteLinea(l3);
        red.deleteLinea(l2);
    }
   
    @Test (expected = AssertionError.class)
    public void testSecuenciaEliminarHastaTenerMenosDeDosLineasNoValidoOtroOrden() { //falla
        Linea[] lista_lineas={l1,l2,l3};
        RedAutobuses red= new RedAutobuses(lista_lineas);
       
        red.deleteLinea(l2);
        red.deleteLinea(l3);
    }
   
    @Test (expected = AssertionError.class)
    public void testSecuenciaGetLineaPorIdQueYaNoExisteNoValido() { //falla
        Linea[] lista_lineas={l1,l2,l3};
        RedAutobuses red= new RedAutobuses(lista_lineas);
       
        red.deleteLinea(l3);
        Linea l_no_ex=red.getLinea(3);
    }
   
    @Test
    public void testSecuenciaAleatoriaGetLineaPorIdCambiaLineaValido() {
        Linea[] lista_lineas={l1,l2,l3};
        Parada[] p_4 = {p1,p5,p3};
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