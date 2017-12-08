package uva.tds.pr2.equipo05;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Implementacion de la clase de test de Parada
 * @author ismpere
 * @author martorb
 */
public class ParadaTDDTest {
	
	private static final double ERROR_ADMISIBLE = 0.01;
	private GD gd1;
	private Parada p1;
	
	@Before
    public void setUp() throws Exception {
        gd1 = new GD (-179.99,179.99);
    }
     
    @After
    public void tearDown() throws Exception {
        gd1 = null;
        p1 = null;
    }

	@Test
	public void testInicializaParadaValido() {
		p1 = new Parada("a", gd1);
		
		assertNotNull(p1);
		assertEquals("a", p1.getId());
		assertEquals(gd1,p1.getGD());
	}
	
	@Test
	public void testSetIDValido(){
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
	public void testCalculaDistanciaEntreParadasGDValido(){
		p1 = new Parada("a", gd1);
		GD gd2 = new GD(179.99, -179.99);
		Parada p2 = new Parada("b", gd2);
		
		double distancia = p1.getDistanciaEntre(p2);
		
		assertNotNull(p1);
		assertNotNull(p2);
		assertEquals(200.00, distancia, ERROR_ADMISIBLE); //TODO Es un valor aleatorio, comprobar al implementar
	}
	
	@Test
	public void testHayParadasRepetidasValido(){
		p1 = new Parada("a", gd1);
		GD gd2 = new GD(179.99, -179.99);
		Parada p2 = new Parada("b", gd2);
		
		Parada p3[] = {p1, p2, p2};
		
		boolean repetidas = Parada.existeAlgunaParadaRepetida(p3);
		
		assertNotNull(p1);
		assertNotNull(p2);
		assertTrue(repetidas);
	}
}
