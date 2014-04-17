/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viitemanageri.logiikka;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import viitemanageri.App;
import viitemanageri.viitteet.Kirja;
import viitemanageri.viitteet.Manageri;

/**
 *
 * @author glindstr
 */
public class ManageriTest {
    
    Manageri manageri;
    private final String viitetiedosto = "viitteetTest";
    
    @Before
    public void setUp() {
        File viiteTiedosto = new File(viitetiedosto);
        if (viiteTiedosto.exists()) {
            viiteTiedosto.delete();
        }
        manageri = new Manageri(viitetiedosto);
    }
     @Test
    public void palautetaanFalseJosTunnusOnJoOlemassa() {
       Kirja kirja = new Kirja("a", "b", 2014, "c", "t1");
       manageri.lisaaViiteListaan(kirja);
       
       assertFalse(manageri.onkoUniikki("t1")); 
    }
    
    @Test
    public void palautetaanTrueJosTunnusOnVapaa(){
       Kirja kirja = new Kirja("a", "b", 2014, "c", "t2");
       manageri.lisaaViiteListaan(kirja);
       assertTrue(manageri.onkoUniikki("t3"));
    }
    
    @Test
    public void tallennetaanOikeanMuotoinenTiedostoOikeaanPaikkaan(){
        Muunnin m = new Muunnin();
        
        List k = new ArrayList();
        
        k.add(new Kirja("Tekijä","nimi", 2000, "asd", "qwe"));
        
        k.add(new Kirja("Tekiasd","niasdami", 2001, "adasd", "qe"));
        
        String a = m.muunnaViitteetBibtexMuotoon(k);
        

        try {
            manageri.tallennaBibtexTiedosto(a, new java.io.File( "." ).getCanonicalPath(), "testiaaatiedosto");
            
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
        Muunnin m = new Muunnin();
        
        List k = new ArrayList();
        
        k.add(new Kirja("Tekijä","nimi", 2000, "asd", "qwe"));
        
        k.add(new Kirja("Tekiasd","niasdami", 2001, "adasd", "qe"));
        
        String a = m.muunnaViitteetBibtexMuotoon(k);
        
  
        try {
            manageri.tallennaBibtexTiedosto(a, new java.io.File( "." ).getCanonicalPath(), "*****");
             
             assertEquals(manageri.tallennaBibtexTiedosto(a, ".............................................", "..................................../"), false);
            
            
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
