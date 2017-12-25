package uva.tds.pr2.equipo05;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
/**
 * Implementacion de la clase de test de Parada
 * @author ismpere
 * @author martorb
 */
@Category({Unit.class, TDD.class})
public class ParadaUnitTDDTest {
	
	private static final double ERROR_ADMISIBLE = 0.01;
	private GD gd1;
	private Parada p1;
	
	@Before
    public void setUp() throws Exception {
        gd1 = new GD (179.99,179.99);
    }
     
    @After
    public void tearDown() throws Exception {
        gd1 = null;
        p1 = null;
    }

	@Test
	public void testInicializaParadaIdPequenioValido() {
		p1 = new Parada("a", gd1);
		
		assertNotNull(p1);
		assertEquals("a", p1.getId());
		assertEquals(gd1,p1.getGD());
	}
	
	@Test
    public void testGetIdParadaValido(){
    	p1 = new Parada("a", gd1);
    	
    	String id = p1.getId();
    	
    	assertNotNull(gd1);
    	assertEquals("a", id);
    }
    
    @Test
    public void testGetGDParadaValido(){
    	p1 = new Parada("a", gd1);
    	
    	GD gd = p1.getGD();
    	
    	assertNotNull(gd1);
    	assertEquals(gd1, gd);
    }
	
	@Test
	public void testSetIDValidoPequenio(){
		p1 = new Parada("a", gd1);
		
		p1.setId("b");
		
		assertNotNull(p1);
		assertEquals("b",p1.getId());
		assertEquals(gd1,p1.getGD());
	}
	
	@Test
	public void testSetGDValido(){
		p1 = new Parada("a", gd1);
		GD gd2 = new GD(179.99, -179.99);
		
		p1.setGD(gd2);
		
		assertNotNull(p1);
		assertEquals("a",p1.getId());
		assertEquals(gd2,p1.getGD());
	}
	
	@Test
	public void testHayParadasRepetidasDosParadasValido(){
		p1 = new Parada("a", gd1);
		
		Parada p3[] = {p1, p1};
		
		boolean repetidas = Parada.existeAlgunaParadaRepetida(p3);
		
		assertNotNull(p1);
		assertTrue(repetidas);
	}
}
