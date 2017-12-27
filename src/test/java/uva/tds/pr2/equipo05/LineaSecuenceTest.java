package uva.tds.pr2.equipo05;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Implementacion de la clase de test de secuencia de Linea
 * @author ismpere
 * @author martorb
 */
@Category({Secuence.class, Unit.class})
public class LineaSecuenceTest {

	private GD gd1 = new GD (41.3154608,-4.9177346);
	private GD gd2 = new GD (41.3123926,-4.9176796);
	private GD gd3 = new GD (41.3153508,-4.9176232);
	private Parada p1, p2, p3;

	@Before
    public void setUp() throws Exception {
        p1 = new Parada("a", gd1);
        p2 = new Parada("b", gd2);
        p3 = new Parada("c", gd3);
    }
     
    @After
    public void tearDown() throws Exception {
        p1 = null;	
        p2 = null;	
        p3 = null;
    }
    
	@Test
	public void testLineaSecuenciaEliminarParadaValido() {
		GD gd4 = new GD(-160.00,160.00);
		Parada p4 = new Parada("d", gd4);
		
		Parada p[] = {p1,p2,p4,p3};
		Linea l1 = new Linea(1, p);
		
		l1.removeParadaIntermedia(p2);
		
		Parada pa2[] = {p1,p4,p3};
		
		assertArrayEquals(pa2, l1.getParadas());
		assertEquals(1, l1.getId());
	}
	
	@Test (expected = AssertionError.class)
	public void testLineaSecuenciaEliminarParadaNoValido() {
		GD gd4 = new GD(-160.00,160.00);
		Parada p4 = new Parada("d", gd4);
		
		Parada p[] = {p1,p2,p4,p3};
		Linea l1 = new Linea(1, p);
		
		l1.removeParadaIntermedia(p2);
		l1.removeParadaIntermedia(p4);
	}
	
	@Test
	public void testLineaSecuenciaAleatoriaAñadeYEliminaParadasValido() {
		Parada p[] = {p1,p2,p3};
		Linea l1 = new Linea(1, p);
		
		GD gd4 = new GD(41.3157608,-4.9175546);
		Parada p4 = new Parada("d", gd4);
		
		l1.addParadaIntermedia(p4);
		
		GD gd5 = new GD(-110.00,110.00);
		Parada p5 = new Parada("d", gd5);
		
		l1.addParadaIntermediaAt(p5, 3);
		
		Parada pa2[] = l1.getParadas();
		Parada listaP1[] = {p1, p4, p5, p2, p3};
		
		l1.removeParadaIntermedia(p5);
		Parada pa4[] = l1.getParadas();
		Parada listaP2[] = {p1, p4, p2, p3};
		
		l1.removeParadaIntermedia(p4);
		
		Parada pa3[] = l1.getParadas();
		
		assertArrayEquals(p, pa3);
		assertArrayEquals(listaP1, pa2);
		assertArrayEquals(listaP2, pa4);
		assertEquals(1, l1.getId());
	}
	
	@Test
	public void testLineaSecuenciaAleatoriaSettersValido(){
		Parada p[] = {p1,p2,p3};
		Linea l1 = new Linea(1, p);
		
		int id1 = l1.getId();
		
		GD gd4 = new GD(41.3153408,-4.9176332);
		Parada p4 = new Parada("d", gd4);
		
		l1.setParadaInicio(p4);
		Parada pi1 = l1.getParadaInicio();
		
		Parada pa2[] = l1.getParadas();
		Parada listaP1[] = {p4,p1,p2,p3};
		
		GD gd5 = new GD(41.3153598,-4.9175832);
		Parada p5 = new Parada("d", gd5);
		
		l1.setParadaFin(p5);
		Parada pf1 = l1.getParadaFin();
		
		Parada listaP2[] = {p4,p1,p2,p3,p5};
		
		l1.setId(3);
		int id2 = l1.getId();
		
		l1.setId(1);
		
		assertEquals(id1, l1.getId());
		assertEquals(p4, pi1);
		assertEquals(p5, pf1);
		assertNotEquals(id2, l1.getId());
		assertArrayEquals(listaP1, pa2);
		assertArrayEquals(listaP2, l1.getParadas());
	}
	
	@Test
	public void testSecuenciaAleatoriaGetParadas(){
		Parada p[] = {p1,p2,p3};
		Parada.existeAlgunaParadaRepetida(p);
		Linea l1 = new Linea(1, p);
		
		GD gd_bus = new GD(-140.00, 140.00);
		
		Parada pc[] = l1.getParadasCercanas(gd_bus);
		
		GD gd4 = new GD(41.308344,-4.9180686);
    	Parada p4 = new Parada("d", gd4);
    	GD gd5 = new GD(41.3153708,-4.9177132);
    	Parada p5 = new Parada("e", gd5);
		
		Parada pa3[] = {p1, p4, p5};
		Parada.existeAlgunaParadaRepetida(pa3);
		Linea l2 = new Linea(2, pa3);
		
		Parada pcc[] = l1.getParadasConCorrespondencia(l2);
		
		Parada pct[] = l1.getParadasConTransbordoDirecto(l2);
		
		l1.addParadaIntermedia(p4);
		
		Parada pcc2[] = l1.getParadasConCorrespondencia(l2);
		
		assertNotNull(l1);
		assertNotNull(l2);
		assertNotNull(pc);
		assertNotNull(pcc);
		assertNotNull(pct);
		assertNotNull(pcc2);
		assertEquals(2, pcc.length);
		assertEquals(1, pct.length);
		assertEquals(2, pcc.length);
	}
}
