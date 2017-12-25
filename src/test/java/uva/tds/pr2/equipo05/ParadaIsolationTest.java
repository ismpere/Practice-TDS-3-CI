package uva.tds.pr2.equipo05;

import static org.junit.Assert.*;

import org.easymock.Mock;
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
public class ParadaIsolationTest {
	
	@Mock
	private GD gd1;

	private static final double ERROR_ADMISIBLE = 0.01;
	private Parada p1;
	
	@Before
    public void setUp() throws Exception {
        gd1 = createMock(GD.class);
    }
     
    @After
    public void tearDown() throws Exception {
        gd1 = null;
        p1 = null;
    }
    
	@Test
	public void testCalculaDistanciaEntreParadasExtremosValido(){
		expect(gd1.getLatitud()).andReturn(179.99);
		expect(gd1.getLongitud()).andReturn(179.99);
		expect(gd1.equals(eq(eq(gd1)))).andReturn(false).once();
		
		GD gd2 = createMock(GD.class);
		expect(gd2.getLatitud()).andReturn(-179.99);
		expect(gd2.getLongitud()).andReturn(-179.99);

		expect(gd1.getDistanciaAt(eq(gd2))).andReturn(2600.88).once();
		
		p1 = new Parada("a", gd1);
		Parada p2 = new Parada("b", gd2);
		
		double distancia = p1.getDistanciaEntre(p2);
		
		assertNotNull(p1);
		assertNotNull(p2);
		assertEquals(2600.88, distancia, ERROR_ADMISIBLE); //TODO Es un valor aleatorio, comprobar al implementar
	}

}
