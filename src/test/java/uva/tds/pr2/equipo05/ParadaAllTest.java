package uva.tds.pr2.equipo05;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
 
@RunWith(Suite.class)
@SuiteClasses({ 
    ParadaUnitTDDTest.class,
    ParadaIntegrationTDDTest.class,
    ParadaBlackBoxUnitTest.class,
    ParadaBlackBoxIntegrationTest.class,
    ParadaIsolationTest.class,
    ParadaSecuenceTest.class,})

/**
 * Suite de clases de test para todas las clases de test de Linea*
 * @author ismael
 * @author martorb
 */
public class ParadaAllTest {
 
}