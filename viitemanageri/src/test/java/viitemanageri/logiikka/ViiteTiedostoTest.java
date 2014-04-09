/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viitemanageri.logiikka;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import viitemanageri.viitteet.Artikkeli;
import viitemanageri.viitteet.Kirja;
import viitemanageri.viitteet.Viite;

/**
 *
 * @author test
 */
public class ViiteTiedostoTest {
    
    public ViiteTiedostoTest() {
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
    public void lisattyViiteLoytyyTallennetustaTiedostosta(){
        
        List<Viite> k = new ArrayList();
        
        k.add(new Kirja("Testi Testaaja", "Loremi", 2000, "Olem julkaisija", "asd"));
        
        ViiteTiedosto a = new ViiteTiedosto("viitteet");
        a.paivitaTiedosto(k);
        
        assertEquals(k.toString(), a.lataaTiedosto().toString());
    }
    
    @Test
    public void lisatytViitteetLoytyyTallennetustaTiedostosta(){
        
        List<Viite> k = new ArrayList();
        
        k.add(new Kirja("Testi Testaaja", "Loremi", 2000, "Olem julkaisija", "asd"));
        k.add(new Kirja("Tekiasd", "Juuh elikkäs", 2001, "Olen julkaisija", "dot")); 
        k.add(new Artikkeli("Keith J. Whittington", 
                "Infusing active learning into introductory programming courses", 
                "J. Comput. Small Coll.", 2004, 19, 5, 249, 259, "W04" ));

        ViiteTiedosto a = new ViiteTiedosto("viitteet");
        a.paivitaTiedosto(k);
        
        assertEquals(k.toString(), a.lataaTiedosto().toString());
        
        
        new File("viitteet").delete();
    }
    
    @Test
    public void yritetaanTallentaaViitteetVirheellisenNimiseenTiedostoon(){
        
        List<Viite> k = new ArrayList();
        
        k.add(new Kirja("Testi Testaaja", "Loremi", 2000, "Olem julkaisija", "asd"));
        k.add(new Kirja("Tekiasd", "Juuh elikkäs", 2001, "Olen julkaisija", "dot")); 
        k.add(new Artikkeli("Keith J. Whittington", 
                "Infusing active learning into introductory programming courses", 
                "J. Comput. Small Coll.", 2004, 19, 5, 249, 259, "W04" ));

        ViiteTiedosto a = new ViiteTiedosto("...................../............");
        a.paivitaTiedosto(k);
        
        assertFalse(k.toString() == a.lataaTiedosto().toString());
        
        
        new File("viitteet").delete();
    }
}
