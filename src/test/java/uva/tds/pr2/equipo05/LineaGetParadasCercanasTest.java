package uva.tds.pr2.equipo05;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Implementacion de los test para el metodo getParadasCercanas
 * @author ismael
 * @author martorb
 */
@Category({Integration.class})
public class LineaGetParadasCercanasTest {
	
	private GD gd1 = new GD (41.3154608,-4.9177346);
	private GD gd2 = new GD (41.3142809,-4.9189326);
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
	public void testGetParadasCercanasUnaParadaCercanaValido(){
		
		GD gd4 = new GD(41.3133848,-4.9181027); //TODO son ubicaciones aleatorias, poner una valida que lo cumpla
		
		Parada pc[] = l1.getParadasCercanas(gd4);
		
		Parada pcS[] = {p2};
		
		assertNotNull(l1);
		assertNotNull(pc);
		assertTrue(l1.existeParadasCercanas(gd4));
		assertArrayEquals(pcS, pc);
	}
	
	@Test
	public void testGetParadasCercanasVariasParadasCercanasValido(){
		
		GD gd4 = new GD(41.3153408,-4.9176332);
		
		Parada pc[] = l1.getParadasCercanas(gd4);
		
		Parada pcS[] = {p1, p2, p3};
		
		assertNotNull(l1);
		assertNotNull(pc);
		assertTrue(l1.existeParadasCercanas(gd4));
		assertArrayEquals(pcS, pc);
	}
	
	@Test
	public void testGetParadasCercanasNingunaParadaCercanaValido(){
		
		GD gd4 = new GD(-130.00, 130.00); //TODO son ubicaciones aleatorias, poner una valida que lo cumpla
		
		Parada pc[] = l1.getParadasCercanas(gd4);
		
		assertNotNull(l1);
		assertNotNull(pc);
		assertFalse(l1.existeParadasCercanas(gd4));
		assertEquals(0, pc.length);
	}
	
	@Test
	public void testNoExistenParadasCercanasValido(){
		
		GD gd4 = new GD(-140.00, 140.00); //TODO son ubicaciones aleatorias, poner una valida que lo cumpla
		
		boolean e = l1.existeParadasCercanas(gd4);
		
		assertNotNull(l1);
		assertFalse(e);
	}
}
