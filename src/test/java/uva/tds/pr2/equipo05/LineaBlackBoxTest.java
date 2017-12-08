package uva.tds.pr2.equipo05;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Implementacion de la clase de test de caja negra (no tiene todos) de la clase Linea
 * @author ismpere
 * @author martorb
 */
public class LineaBlackBoxTest {

	private GD gd1 = new GD (-179.99,179.99); //TODO las direcciones hay que ajustarlas, son aleatorias
	private GD gd2 = new GD (-178.99,178.99);
	private GD gd3 = new GD (-177.99,177.99);
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
    public void testGetIdLineaValido(){
    	Parada p[] = {p1, p3, p2};
    	Linea l1 = new Linea(1, p);
    	
    	int id = l1.getId();
    	
    	assertNotNull(l1);
    	assertEquals(1, id);
    }
    
    @Test
    public void testGetParadasLineaValido(){
    	Parada p[] = {p1, p3, p2};
    	Linea l1 = new Linea(1, p);
    	
    	Parada pa2[] = l1.getParadas();
    	
    	assertNotNull(l1);
    	assertArrayEquals(p, pa2);
    }
    
    @Test
    public void testNoContieneParadaValido(){
    	Parada p[] = {p1, p3, p2};
    	Linea l1 = new Linea(1, p);
    	
    	GD gd4 = new GD(-100.00, 100.00);
    	Parada p4 = new Parada("d", gd4);
		
		boolean c = l1.contains(p4);

		assertNotNull(l1);
		assertFalse(c);
		
		fail("El test pasa en verde ya que la fake implementacion de contains devuelve siempre false");
    }
    
    @Test
	public void testNoHayLineasRepetidasValido(){
    	Parada p[] = {p1, p3, p2};
		Linea l1 = new Linea(1, p);
		
		GD gd4 = new GD(-150.00, 150.00); //TODO son ubicaciones aleatorias, poner una valida que lo cumpla
		Parada p4 = new Parada("d", gd4);
		GD gd5 = new GD(-140.00, 140.00); //TODO son ubicaciones aleatorias, poner una valida que lo cumpla
		Parada p5 = new Parada("d", gd5);
		
		Parada pa3[] = {p2, p4, p5};
		Linea l2 = new Linea(2, pa3);
		
		Linea l[] = {l1,l2};
		
		boolean repetidas = Linea.lineasRepetidas(l);
		
		assertNotNull(l1);
		assertNotNull(l2);
		assertFalse(repetidas);
		
		fail("El test no falla por si solo ya que la fake implementacion de lineasRepetidas devuelve siempre false");
	}
    
    @Test (expected = IllegalArgumentException.class)
    public void testInicializaNoValidoParadasNulo(){
    	Linea l1 = new Linea(1, null);
    }
    
    @Test (expected = AssertionError.class)
    public void testInicializaNoValidoDosParadas(){
    	Parada p[] = {p1, p2};
    	Linea l1 = new Linea(1, p);
    }
    
    @Test (expected = AssertionError.class)
    public void testInicializaNoValidoInicioYFinDemasiadoLejos(){
    	Parada p[] = {p1, p3, p2};
    	Linea l1 = new Linea(1, p);
    }
    
    @Test (expected = AssertionError.class)
    public void testInicializaNoValidoParadasIguales(){
    	Parada p[] = {p1, p2, p2};
    	Linea l1 = new Linea(1, p);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testInicializaNoValidoParadaInicioNulo(){
    	Parada p[] = {null, p1, p2};
    	Linea l1 = new Linea(1, p);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testInicializaNoValidoParadaFinNulo(){
    	Parada p[] = {p1, p2, null};
    	Linea l1 = new Linea(1, p);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testInicializaNoValidoParadaIntermediaNulo(){
    	Parada p[] = {p1, null, p2};
    	Linea l1 = new Linea(1, p);
    }
    @Test (expected = AssertionError.class)
    public void testsetParadaInicioNoValidoDemasiadoLejos(){
    	Parada p[] = {p1, p2, p3};
    	Linea l1 = new Linea(1, p);
    	
    	GD gd4 = new GD(-100.00, 100.00);
    	Parada p4 = new Parada("d", gd4);
    	
    	l1.setParadaInicio(p4);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testsetParadaInicioNoValidoNulo(){
    	Parada p[] = {p1, p2, p3};
    	Linea l1 = new Linea(1, p);
    	
    	l1.setParadaInicio(null);
    }
    @Test (expected = AssertionError.class)
    public void testsetParadaInicioNoValidoYaExiste(){
    	Parada p[] = {p1, p2, p3};
    	Linea l1 = new Linea(1, p);
    	
    	l1.setParadaInicio(p1);
    }
    @Test (expected = AssertionError.class)
    public void testsetParadaFinNoValidoDemasiadoLejos(){
    	Parada p[] = {p1, p2, p3};
    	Linea l1 = new Linea(1, p);
    	
    	GD gd4 = new GD(-100.00, 100.00);
    	Parada p4 = new Parada("d", gd4);
    	
    	l1.setParadaFin(p4);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testsetParadaFinNoValidoNulo(){
    	Parada p[] = {p1, p2, p3};
    	Linea l1 = new Linea(1, p);
    	
    	l1.setParadaFin(null);
    }
    @Test (expected = AssertionError.class)
    public void testsetParadaFinNoValidoYaExiste(){
    	Parada p[] = {p1, p2, p3};
    	Linea l1 = new Linea(1, p);
    	
    	l1.setParadaInicio(p3);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testaddParadaIntermediaNoValidoNulo(){
    	Parada p[] = {p1, p2, p3};
    	Linea l1 = new Linea(1, p);
    	
    	l1.addParadaIntermedia(null);
    }
    @Test (expected = AssertionError.class)
    public void testaddParadaIntermediaNoValidoYaExiste(){
    	Parada p[] = {p1, p2, p3};
    	Linea l1 = new Linea(1, p);
    	
    	l1.addParadaIntermedia(p1);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testaddParadaAtPosicionNoValidoNulo(){
    	Parada p[] = {p1, p2, p3};
    	Linea l1 = new Linea(1, p);
    	
    	l1.addParadaIntermediaAt(null, 2);
    }
    @Test (expected = AssertionError.class)
    public void testaddParadaAtPosicionNoValidoPosicion0(){
    	Parada p[] = {p1, p2, p3};
    	Linea l1 = new Linea(1, p);
    	
    	l1.addParadaIntermediaAt(p1, 0);
    }
    @Test (expected = AssertionError.class)
    public void testaddParadaAtPosicionNoValidoPosicionFin(){
    	Parada p[] = {p1, p2, p3};
    	Linea l1 = new Linea(1, p);
    	
    	l1.addParadaIntermediaAt(p1, p.length+1);
    }
    @Test (expected = AssertionError.class)
    public void testaddParadaAtPosicionNoValidoPosicionInicio(){
    	Parada p[] = {p1, p2, p3};
    	Linea l1 = new Linea(1, p);
    	
    	l1.addParadaIntermediaAt(p1, 1);
    }
    @Test (expected = AssertionError.class)
    public void testaddParadaAtPosicionNoValidoPosicionNegativa(){
    	Parada p[] = {p1, p2, p3};
    	Linea l1 = new Linea(1, p);
    	
    	l1.addParadaIntermediaAt(p1, -1);
    }
    @Test (expected = AssertionError.class)
    public void testaddParadaAtPosicionNoValidoPosicionGrande(){
    	Parada p[] = {p1, p2, p3};
    	Linea l1 = new Linea(1, p);
    	
    	l1.addParadaIntermediaAt(p1, 5);
    }
    @Test (expected = AssertionError.class)
    public void testaddParadaAtPosicionNoValidoYaExiste(){
    	Parada p[] = {p1, p2, p3};
    	Linea l1 = new Linea(1, p);
    	
    	l1.addParadaIntermediaAt(p1, 2);
    }
    @Test (expected = AssertionError.class)
    public void testEliminaParadaIntermediaNoValido3Paradas(){
    	Parada p[] = {p1, p2, p3};
    	Linea l1 = new Linea(1, p);
    	
    	l1.removeParadaIntermedia(p2);
    }
    @Test (expected = AssertionError.class)
    public void testEliminaParadaIntermediaNoValidoParadaInicio(){
    	Parada p[] = {p1, p2, p3};
    	Linea l1 = new Linea(1, p);
    	
    	l1.removeParadaIntermedia(p1);
    }
    @Test (expected = AssertionError.class)
    public void testEliminaParadaIntermediaNoValidoParadaFin(){
    	Parada p[] = {p1, p2, p3};
    	Linea l1 = new Linea(1, p);
    	
    	l1.removeParadaIntermedia(p3);
    }
    @Test (expected = AssertionError.class)
    public void testEliminaParadaIntermediaNoValidoNoContieneParada(){
    	Parada p[] = {p1, p2, p3};
    	Linea l1 = new Linea(1, p);
    	
    	GD gd4 = new GD(-100.00, 100.00);
    	Parada p4 = new Parada("d", gd4);
    	
    	l1.removeParadaIntermedia(p4);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testEliminaParadaIntermediaNoValidoParadaNulo(){
    	Parada p[] = {p1, p2, p3};
    	Linea l1 = new Linea(1, p);
    	
    	l1.removeParadaIntermedia(null);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testContainsParadaNoValidoParanaNulo(){
    	Parada p[] = {p1, p2, p3};
    	Linea l1 = new Linea(1, p);
    	
    	l1.contains(null);
    }
    
	@Test (expected = IllegalArgumentException.class)
	public void testLineasRepetidasNoValidoListaVacia() {
		Boolean r=Linea.lineasRepetidas(null);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testLineasRepetidasNoValidoAlgunaLineaNula() {
		Parada p[] = {p1, p2, p3};
		Linea l1 = new Linea(1, p);
		Linea[] lista_lineas={l1,null};
		Boolean r=Linea.lineasRepetidas(lista_lineas);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testHayLineasRepetidasNoValidoLineasNulo(){
		
		Linea.lineasRepetidas(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testHayLineasRepetidasNoValidoAlgunaLineaNulo(){
		Parada p[] = {p1, p2, p3};
		Linea l1 = new Linea(1, p);
		
		Linea l[] = {l1,null};
		
		Linea.lineasRepetidas(l);
	}

}
