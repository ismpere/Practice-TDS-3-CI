package uva.tds.pr2.equipo05;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({Integration.class})
public class ParadaBlackBoxIntegrationTest {

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
	public void testCalculaDistanciaEntreParadasCercanasValido(){
    	gd1 = new GD(41.3154608, -4.9177346);
		p1 = new Parada("a", gd1);
		
		GD gd2 = new GD(41.3142809, -4.9189326);
		Parada p2 = new Parada("b", gd2);
		
		double distancia = p1.getDistanciaEntre(p2);
		
		assertNotNull(p1);
		assertNotNull(p2);
		assertEquals(176.80, distancia, ERROR_ADMISIBLE); 
	}
	
	@Test
	public void testCalculaDistanciaEntreParadasValidoParadasIguales(){
		p1 = new Parada("a", gd1);
		Parada p2 = new Parada("b", gd1);
		
		double distancia = p1.getDistanciaEntre(p2);
		
		assertNotNull(p1);
		assertNotNull(p2);
		assertEquals(0.00, distancia, ERROR_ADMISIBLE); 
	}
}
