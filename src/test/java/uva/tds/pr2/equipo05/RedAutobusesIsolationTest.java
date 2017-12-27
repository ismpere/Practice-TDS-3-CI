package uva.tds.pr2.equipo05;
 
import static org.junit.Assert.*;
 
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
 
@Category({Isolation.class})
public class RedAutobusesIsolationTest {

	   
    private Linea l1, l2;
   
    @Before
    public void setUp() throws Exception {
        l1= createMock(Linea.class);
        l2= createMock(Linea.class);
    }
   
    @After
    public void tearDown() throws Exception{
        verify(l1);
        verify(l2);
        l1= null;
        l2= null;
    }
   
    @Test
    public void testContieneParadaValido(){
       
        expect(l1.getId()).andReturn((int)1).times(2);
        expect(l2.getId()).andReturn((int)2).once();
       
        replay(l1); replay(l2);
       
        Linea[] lista_lineas={l1,l2};
        RedAutobuses red= new RedAutobuses(lista_lineas);
       
        boolean c = red.contains(l1);
       
        assertNotNull(red);
        assertTrue(c);
    }
   
    @Test
    public void testAddLineaValido(){
       
        Linea l3 = createMock(Linea.class);
       
        expect(l1.getId()).andReturn((int)1).once();
        expect(l2.getId()).andReturn((int)2).once();
        expect(l3.getId()).andReturn((int)3).times(3);
       
        replay(l1); replay(l2); replay(l3);
       
        Linea[] lista_lineas={l1,l2};
        RedAutobuses red= new RedAutobuses(lista_lineas);
       
        red.addLinea(l3);
       
        Linea l[] = {l1,l2,l3};
       
        assertNotNull(red);
        assertTrue(red.contains(l3));
        assertArrayEquals(l, red.getAllLineas());
       
        verify(l3);
    }
   
    @Test
    public void testDeleteLineaValido() {
 
        Linea l3 = createMock(Linea.class);
       
        expect(l1.getId()).andReturn((int)1).once();
        expect(l2.getId()).andReturn((int)2).once();
        expect(l3.getId()).andReturn((int)3).times(4);
       
        replay(l1); replay(l2); replay(l3);
       
        Linea[] lista_lineas={l1,l2,l3};
        RedAutobuses red= new RedAutobuses(lista_lineas);
       
        red.deleteLinea(l3);
       
        Linea l[] = {l1,l2};
       
        assertNotNull(red);
        assertFalse(red.contains(l3));
        assertArrayEquals(l, red.getAllLineas());
       
        verify(l3);
    }
    
    @Test
    public void testInicializaRedValido() {
       
        expect(l1.getId()).andReturn((int)1).once();
        expect(l2.getId()).andReturn((int)2).once();
       
        replay(l1); replay(l2);
       
        Linea[] lista_lineas={l1,l2};
        RedAutobuses red= new RedAutobuses(lista_lineas);
       
        assertNotNull(red);
        assertArrayEquals(lista_lineas, red.getAllLineas());
    }
   
    @Test
    public void testExistenLineasConParadasCercanasValido(){
       
        GD gd_busq = createMock(GD.class);
       
        expect(l1.getId()).andReturn((int)1).once();
        expect(l2.getId()).andReturn((int)2).once();
        expect(l1.existeParadasCercanas(eq(gd_busq), eq((double)100))).andReturn(true).once();
       
        replay(l1); replay(l2);
       
        Linea[] lista_lineas={l1,l2};
        RedAutobuses red= new RedAutobuses(lista_lineas);
       
        boolean e = red.existenLineasConParadasCercanas(gd_busq, 100);
       
        assertNotNull(red);
        assertTrue(e);
    }
 
    @Test
    public void testGetLineasConParadasCercanasValido(){
       
        GD gd_busq = createMock(GD.class);
       
        expect(l1.getId()).andReturn((int)1).once();
        expect(l2.getId()).andReturn((int)2).once();
        expect(l1.existeParadasCercanas(eq(gd_busq), eq((double)100))).andReturn(true).times(2);
        expect(l2.existeParadasCercanas(eq(gd_busq), eq((double)100))).andReturn(false).once();
       
        replay(l1); replay(l2);
       
        Linea[] lista_lineas={l1,l2};
        RedAutobuses red= new RedAutobuses(lista_lineas);
       
        Linea[] lineas_cercanas=red.getLineasConParadasCercanas(gd_busq, 100);
       
        Linea[] lcS = {l1};
       
        assertNotNull(red);
        assertNotNull(lineas_cercanas);
        assertTrue(red.existenLineasConParadasCercanas(gd_busq, 100));
        assertArrayEquals(lcS, lineas_cercanas);  
    }
   
    @Test (expected = AssertionError.class)
    public void testAddLineaNoValidoLineaRepetida() {
       
        expect(l1.getId()).andReturn((int)1).times(2);
        expect(l2.getId()).andReturn((int)2).once();
       
        replay(l1); replay(l2);
       
        Linea[] lista_lineas={l1,l2};
        RedAutobuses red= new RedAutobuses(lista_lineas);
        red.addLinea(l1);
    }
   
    @Test (expected = AssertionError.class)
    public void testDeleteLineaNoValidoLineaNoExisteEnRed() {
       
        Linea l3 = createMock(Linea.class);
       
        expect(l1.getId()).andReturn((int)1).once();
        expect(l2.getId()).andReturn((int)2).once();
        expect(l3.getId()).andReturn((int)3).once();
       
        replay(l1); replay(l2); replay(l3);
       
        Linea[] lista_lineas={l1,l2};
        RedAutobuses red= new RedAutobuses(lista_lineas);
        red.deleteLinea(l3);
       
        verify(l3);
    }
   
    @Test
    public void testNoExistenLineasConParadasCercanasValido(){
       
        GD gd_busq = createMock(GD.class);
       
        expect(l1.getId()).andReturn((int)1).once();
        expect(l2.getId()).andReturn((int)2).once();
        expect(l1.existeParadasCercanas(eq(gd_busq), eq((double)200))).andReturn(false).once();
        expect(l2.existeParadasCercanas(eq(gd_busq), eq((double)200))).andReturn(false).once();
       
        replay(l1); replay(l2);
       
        Linea[] lista_lineas={l1,l2};
        RedAutobuses red= new RedAutobuses(lista_lineas);
       
        boolean e = red.existenLineasConParadasCercanas(gd_busq, 200.00);
       
        assertNotNull(red);
        assertFalse(e);
    }
   
    @Test
    public void testGetLineasConParadasCercanasValido1LineaCercana(){
       
        GD gd_busq = createMock(GD.class);
       
        expect(l1.getId()).andReturn((int)1).once();
        expect(l2.getId()).andReturn((int)2).once();
        expect(l1.existeParadasCercanas(eq(gd_busq), eq((double)200))).andReturn(false).times(2);
        expect(l2.existeParadasCercanas(eq(gd_busq), eq((double)200))).andReturn(true).times(2);
       
        replay(l1); replay(l2);
       
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
       
        GD gd_busq = createMock(GD.class);
       
        expect(l1.getId()).andReturn((int)1).once();
        expect(l2.getId()).andReturn((int)2).once();
        expect(l1.existeParadasCercanas(eq(gd_busq), eq((double)300))).andReturn(true).times(2);
        expect(l2.existeParadasCercanas(eq(gd_busq), eq((double)300))).andReturn(true).once();
       
        replay(l1); replay(l2);
       
        Linea[] lista_lineas={l1,l2};
        RedAutobuses red= new RedAutobuses(lista_lineas);
       
        Linea[] lineas_cercanas=red.getLineasConParadasCercanas(gd_busq, 300.00);
       
        Linea[] l = {l1,l2};
       
        assertNotNull(red);
        assertNotNull(lineas_cercanas);
        assertTrue(red.existenLineasConParadasCercanas(gd_busq, 300.00));
        assertArrayEquals(l, lineas_cercanas);
    }
   
    @Test
    public void testGetLineasConParadasCercanasValido0LineasCercanas(){
        GD gd_busq = createMock(GD.class);
       
        expect(l1.getId()).andReturn((int)1).once();
        expect(l2.getId()).andReturn((int)2).once();
        expect(l1.existeParadasCercanas(eq(gd_busq), eq((double)200))).andReturn(false).times(2);
        expect(l2.existeParadasCercanas(eq(gd_busq), eq((double)200))).andReturn(false).times(2);
       
        replay(l1); replay(l2);
       
        Linea[] lista_lineas={l1,l2};
        RedAutobuses red= new RedAutobuses(lista_lineas);
       
        Linea[] lineas_cercanas=red.getLineasConParadasCercanas(gd_busq, 200.00);
       
        assertNotNull(red);
        assertNotNull(lineas_cercanas);
        assertFalse(red.existenLineasConParadasCercanas(gd_busq, 200.00));
        assertEquals(0, lineas_cercanas.length);
    }

}
