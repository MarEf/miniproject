package logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import viitemanageri.logiikka.Muunna;
import viitemanageri.viitteet.Kirja;

/**
 *
 * @author test
 */
public class MuunninTest {
    
    private String testiTuloste = "@book{asd,\n" +
"author = {Testi Testaaja},\n" +
"title = {Loremi},\n" +
"publisher = {Olem julkaisija},\n" +
"year = {2000},\n" +
"}\n" +
"\n";
    
    private String testiTuloste2 = "@book{asd,\n" +
"author = {Testi Testaaja},\n" +
"title = {Loremi},\n" +
"publisher = {Olem julkaisija},\n" +
"year = {2000},\n" +
"}\n" +
"\n" +
"@book{dot,\n" +
"author = {Tekiasd},\n" +
"title = {Juuh elikk\\\"{a}s},\n" +
"publisher = {Olen julkaisija},\n" +
"year = {2001},\n" +
"}\n" +
"\n";
    
    public MuunninTest() {
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
    public void muunninMuuntaaOikeinTestiSyotteen(){
        
        Muunna m = new Muunna();
        
        List k = new ArrayList();
        
        k.add(new Kirja("Testi Testaaja", "Loremi", 2000, "Olem julkaisija", "asd"));
        
        String a = m.muunnaViitteetBibtexMuotoon(k);
        assertEquals(a, testiTuloste);
    }
    
    @Test
    public void muunninMuuntaaOikeinTestiSyotteet(){
        
        Muunna m = new Muunna();
        
        List k = new ArrayList();
        
        k.add(new Kirja("Testi Testaaja", "Loremi", 2000, "Olem julkaisija", "asd"));
        
        k.add(new Kirja("Tekiasd", "Juuh elikkäs", 2001, "Olen julkaisija", "dot"));
        
        String a = m.muunnaViitteetBibtexMuotoon(k);
        assertEquals(a, testiTuloste2);
    }
}
