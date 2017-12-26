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
public class LineaIsolationTest {

	private Parada p1 = createMock(Parada.class);
    private Parada p2 = createMock(Parada.class);
    private Parada p3 = createMock(Parada.class);
	Parada[] p = {p1, p2, p3};
	
	@Before
    public void setUp() throws Exception {
		expect(p1.getDistanciaEntre(eq(p3))).andReturn((double)10.00).once();
    }
     
    @After
    public void tearDown() throws Exception {
    	verify(p1);
    }

    
	@Test
	public void testInicializaLineaValido() {
		replay(p1);
		
		Linea l1 = new Linea(1, p);
		
		assertNotNull(l1);
		assertEquals(1, l1.getId());
		assertEquals(p1, l1.getParadaInicio());
		assertEquals(p3, l1.getParadaFin());
		assertArrayEquals(p, l1.getParadas());
	}
	
	@Test
	public void testSetParadaInicioValido(){
		Parada p4 = createMock(Parada.class);
		expect(p4.getDistanciaEntre(eq(p3))).andReturn((double)10.00).once();
		
		replay(p1);
		replay(p4);
		
		Linea l1 = new Linea(1, p);
		
		l1.setParadaInicio(p4);
		
		Parada pa2[] = {p4, p1, p2, p3};
		assertNotNull(l1);
		assertTrue(l1.contains(p4));
		assertEquals(1, l1.getId());
		assertEquals(p4, l1.getParadaInicio());
		assertEquals(p3, l1.getParadaFin());
		assertArrayEquals(pa2, l1.getParadas());
		
		verify(p4);
	}
	
	@Test
	public void testSetParadaFinValido(){
		Parada p4 = createMock(Parada.class);
		expect(p4.getDistanciaEntre(eq(p1))).andReturn((double)10.00).once();
		
		replay(p1);
		replay(p4);
		
		Linea l1 = new Linea(1, p);
		
		l1.setParadaFin(p4);
		
		Parada pa2[] = {p1, p2, p3, p4};
		assertNotNull(l1);
		assertTrue(l1.contains(p4));
		assertEquals(1, l1.getId());
		assertEquals(p1, l1.getParadaInicio());
		assertEquals(p4, l1.getParadaFin());
		assertArrayEquals(pa2, l1.getParadas());
		
		verify(p4);
	}
	
	@Test
	public void testExistenParadasCercanasValido(){
		GD gd1 = createMock(GD.class);
		GD gd4 = createMock(GD.class);
		
		expect(p1.getGD()).andReturn((GD)gd1).once();
		expect(gd4.getDistanciaAt(eq(gd1))).andReturn((double)10.00).once();
		
		replay(p1);
		replay(gd4);
		
		Linea l1 = new Linea(1, p);
		
		boolean e = l1.existeParadasCercanas(gd4);
		
		assertNotNull(l1);
		assertTrue(e);
		
		verify(gd4);
	}
	
	@Test
	public void testExistenParadasConCorrespondenciaValido(){
		Parada p4 = createMock(Parada.class);
		Parada p5 = createMock(Parada.class);
		
		expect(p1.getDistanciaEntre(eq(p4))).andReturn((double)0.0).once();
		expect(p4.getDistanciaEntre(eq(p3))).andReturn((double)10.00).once();
		
		replay(p1);
		replay(p4);
		
		Linea l1 = new Linea(1, p);
		
		Parada pa3[] = {p4, p5, p3};
		Linea l2 = new Linea(2, pa3);
		
		boolean e = l1.existeCorrespondencia(l2);
		
		assertNotNull(l1);
		assertNotNull(l2);
		assertTrue(e);
		
		verify(p4);
	}
	
	@Test
	public void testExistenParadasConTransbordoDirectoValido(){
		Parada p4 = createMock(Parada.class);
		Parada p5 = createMock(Parada.class);
		GD gd1 = createMock(GD.class);
		
		expect(p4.getDistanciaEntre(eq(p3))).andReturn((double)10.00).once();
		expect(p1.getGD()).andReturn((GD)gd1).once();
		expect(p2.getGD()).andReturn((GD)gd1).once();
		expect(p3.getGD()).andReturn((GD)gd1).once();
		expect(p4.getGD()).andReturn((GD)gd1).times(3);
		
		replay(p1); replay(p2); replay(p3);
		replay(p4);
		
		Linea l1 = new Linea(1, p);
		
		Parada pa3[] = {p4, p5, p3};
		Linea l2 = new Linea(2, pa3);
		
		boolean e = l1.existeTransbordoDirecto(l2);
		
		assertNotNull(l1);
		assertNotNull(l2);
		assertTrue(e);
		
		verify(p2); verify(p3); verify(p4);
    }
	
	@Test
	public void testGetParadasCercanasValido(){
		GD gd1 = createMock(GD.class);
		GD gd4 = createMock(GD.class);
		
		expect(p1.getGD()).andReturn((GD)gd1).times(3);
		expect(p2.getGD()).andReturn((GD)gd1).once();
		expect(p3.getGD()).andReturn((GD)gd1).once();
		expect(gd4.getDistanciaAt(eq(gd1))).andReturn((double)10.00).times(5);
		
		replay(p1); replay(p2); replay(p3);
		replay(gd4);
		
		Linea l1 = new Linea(1, p);
		
		
		Parada pa2[] = l1.getParadasCercanas(gd4);
		
		Parada pc[] = {p1,p2,p3};
		
		assertNotNull(l1);
		assertNotNull(pa2);
		assertTrue(l1.existeParadasCercanas(gd4));
		assertArrayEquals(pc, pa2);
		
		verify(p2); verify(p3); verify(gd4);
	}

}
