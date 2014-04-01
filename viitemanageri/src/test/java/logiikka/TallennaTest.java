/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import viitemanageri.App;
import viitemanageri.logiikka.Muunna;
import viitemanageri.logiikka.Tallenna;
import viitemanageri.viitteet.Kirja;

/**
 *
 * @author test
 */
public class TallennaTest {
    private Object tallennettuTiedosto;
    
    public TallennaTest() {
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
    public void tallennetaanOikeanMuotoinenTiedostoOikeaanPaikkaan(){
        Muunna m = new Muunna();
        
        List k = new ArrayList();
        
        k.add(new Kirja("Tekijä","nimi", 2000, "asd", "qwe"));
        
        k.add(new Kirja("Tekiasd","niasdami", 2001, "adasd", "qe"));
        
        String a = m.muunnaViitteetBibtexMuotoon(k);
        
        Tallenna t = new Tallenna();
        try {
            t.tallennaTiedosto(a, new java.io.File( "." ).getCanonicalPath(), "testiaaatiedosto");
            
            String h = "";
            
            List<String> lines;
            lines = Files.readAllLines(Paths.get("testiaaatiedosto"),Charset.defaultCharset());
            for (String line : lines) {
                h+=line+"\n";
            }
            
            
            assertEquals(h, a);
            
            
            new File("testiaaatiedosto").delete();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @Test
    public void yritetaanTallentaaVirheellisenNiminenTiedosto(){
        Muunna m = new Muunna();
        
        List k = new ArrayList();
        
        k.add(new Kirja("Tekijä","nimi", 2000, "asd", "qwe"));
        
        k.add(new Kirja("Tekiasd","niasdami", 2001, "adasd", "qe"));
        
        String a = m.muunnaViitteetBibtexMuotoon(k);
        
        Tallenna t = new Tallenna();
        try {
            t.tallennaTiedosto(a, new java.io.File( "." ).getCanonicalPath(), "*****");
             
             assertEquals(t.tallennaTiedosto(a, ".............................................", "..................................../"), false);
            
            
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
