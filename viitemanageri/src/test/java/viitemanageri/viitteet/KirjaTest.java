/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viitemanageri.viitteet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author test
 */
public class KirjaTest {
    
    public KirjaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    
    @Test
    public void konstruktoriAsettaaArvotOikein(){
        
        Kirja k = new Kirja("Testi Testaaja", "Loremi", 2000, "Olem julkaisija", "asd");
        assertEquals(k.getTekija(), "Testi Testaaja");
        assertEquals(k.getVuosi(), 2000);
        assertEquals(k.getJulkaisija(), "Olem julkaisija");
        assertEquals(k.getTunnus(), "asd");
        assertEquals(k.getTeoksenNimi(), "Loremi");
    }
}
