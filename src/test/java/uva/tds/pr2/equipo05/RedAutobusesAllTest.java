package uva.tds.pr2.equipo05;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
    RedAutobusesUnitTDDTest.class,
    RedAutobusesIntegrationTDDTest.class,
    RedAutobusesUnitBlackBoxTest.class,
    RedAutobusesIntegrationBlackBoxTest.class,
    RedAutobusesGetLineasConParadasCercanasTest.class,
    RedAutobusesIsolationTest.class,
    RedAutobusesSecuenceTest.class})

/**
 * Suite de clases de test para todas las clases de test de RedAutobuses*
 * @author ismpere
 * @author martorb
 */
public class RedAutobusesAllTest {
 
}