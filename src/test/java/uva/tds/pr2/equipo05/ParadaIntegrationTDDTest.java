package uva.tds.pr2.equipo05;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({Integration.class, TDD.class})
public class ParadaIntegrationTDDTest {
	
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
	public void testCalculaDistanciaEntreParadasExtremosValido(){
		p1 = new Parada("a", gd1);
		GD gd2 = new GD(-179.99, -179.99);
		Parada p2 = new Parada("b", gd2);
		
		double distancia = p1.getDistanciaEntre(p2);
		
		assertNotNull(p1);
		assertNotNull(p2);
		assertEquals(2600.88, distancia, ERROR_ADMISIBLE); //TODO Es un valor aleatorio, comprobar al implementar
	}
}
