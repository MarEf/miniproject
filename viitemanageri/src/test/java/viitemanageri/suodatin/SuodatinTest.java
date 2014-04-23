/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viitemanageri.suodatin;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import viitemanageri.viitteet.Artikkeli;
import viitemanageri.viitteet.Inproceedings;
import viitemanageri.viitteet.Kirja;

/**
 *
 * @author test
 */
public class SuodatinTest {
    
    public SuodatinTest() {
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
    public void testaaSuodattimenToimintaKirjalla() {
    
        Suodatin s = new Suodatin("jokinTestiSuodin", 1, true);
        
        Kirja k = new Kirja("Testi jokinTestiSuodin", "Loremi", 2000, "Olem julkaisija", "aagasd");
        
        assertTrue(s.OnkoViiteEhtojenMukainen(k)); 

    
    }
    
    @Test
    public void testaaSuodattimenToimintaArtikkelilla() {
    
        Suodatin s = new Suodatin("jokinLoreSuodin", 1, true);
        
        Artikkeli a = new Artikkeli("Keith J. jokinLoreSuodin", 
                "Infusing active learning into introductory programming courses", 
                "J. Comput. Small Coll.", 2004, 19, 5, 249, 259, "W04" );
        assertTrue(s.OnkoViiteEhtojenMukainen(a)); 

    
    }
    
    @Test
    public void testaaSuodattimenToimintaArtikkelilla2() {
    
        Suodatin s = new Suodatin("jokinLoreSuodin", 1, false);
        
        Artikkeli a = new Artikkeli("Keith J. jokinLoreSuodi", 
                "Infusing active learning into introductory programming courses", 
                "J. Comput. Small Coll.", 2004, 19, 5, 249, 259, "W04" );
        assertTrue(s.OnkoViiteEhtojenMukainen(a)); 

    
    }
    
    
    @Test
    public void testaaSuodattimenToimintaInproceedingsilla() {
    
        Suodatin s = new Suodatin("jokinLoreSuodin", 1, true);
        
        Inproceedings i = new Inproceedings("jokinLoreSuodin", 
                "Learning programming by programming: a case study", 
                "Baltic Sea '06: Proceedings of the 6th Baltic Sea conference on Computing education research: Koli Calling 2006",
                2006, 117, 119, "ACM", "HM0afdfsdfdf6");
        assertTrue(s.OnkoViiteEhtojenMukainen(i)); 

    
    }
    
    
    @Test
    public void testaaSuodattimenToimintaInproceedingsilla2() {
    
        Suodatin s = new Suodatin("jokinLoreSuodina", 1, false);
        
        Inproceedings i = new Inproceedings("jokinLoreSuodin", 
                "Learning programming by programming: a case study", 
                "Baltic Sea '06: Proceedings of the 6th Baltic Sea conference on Computing education research: Koli Calling 2006",
                2006, 117, 119, "ACM", "HM0afdfsdfdf6");
        assertTrue(s.OnkoViiteEhtojenMukainen(i)); 

    
    }
    
    
    @Test
    public void testaaSuodattimenToimintaKirjallaVertamallaTeoksenNimea() {
    
        Suodatin s = new Suodatin("Loremi", 2, true);
        
        Kirja k = new Kirja("Testi jokinTestiSuodin", "Loremi", 2000, "Olem julkaisija", "aagasd");
        
        assertTrue(s.OnkoViiteEhtojenMukainen(k)); 

    
    }
    
    @Test
    public void testaaSuodattimenToimintaKirjallaVertamallaVuotta() {
    
        Suodatin s = new Suodatin("2000", 3, true);
        
        Kirja k = new Kirja("Testi jokinTestiSuodin", "Loremi", 2000, "Olem julkaisija", "aagasd");
        
        assertTrue(s.OnkoViiteEhtojenMukainen(k)); 

    
    }
    
    @Test
    public void testaaSuodattimenToimintaKirjalla2() {
    
        Suodatin s = new Suodatin("jokinTestiSuodin", 1, false);
        
        Kirja k = new Kirja("Testi jokinTestiSuodin", "Loremi", 2000, "Olem julkaisija", "aagasd");
        
        assertTrue(!s.OnkoViiteEhtojenMukainen(k)); 

    
    }
    
    @Test
    public void testaaSuodattimenToimintaKirjallaVertamallaTeoksenNimea2() {
    
        Suodatin s = new Suodatin("Loremi", 2, false);
        
        Kirja k = new Kirja("Testi jokinTestiSuodin", "Lorem", 2000, "Olem julkaisija", "aagasd");
        
        assertTrue(s.OnkoViiteEhtojenMukainen(k)); 

    
    }
    
    @Test
    public void testaaSuodattimenToimintaKirjallaVertamallaVuotta2() {
    
        Suodatin s = new Suodatin("2000", 3, false);
        
        Kirja k = new Kirja("Testi jokinTestiSuodin", "Lorem", 2000, "Olem julkaisija", "aagasd");
        
        assertTrue(s.OnkoViiteEhtojenMukainen(k)); 

    
    }
    
    @Test
    public void testaaSuodattimenToimintaVirheelliselläSuodatusTyypilla() {
    
        Suodatin s = new Suodatin("2000", 4, true);
        
        Kirja k = new Kirja("Testi jokinTestiSuodin", "Loremi", 2000, "Olem julkaisija", "aagasd");
        
        assertTrue(s.OnkoViiteEhtojenMukainen(k)); 

    
    }
    @Test
    public void testaaSuodattimenToimintaVirheelliselläSuodatusTyypilla2() {
    
        Suodatin s = new Suodatin("2000", 4, false);
        
        Kirja k = new Kirja("Testi jokinTestiSuodin", "Loremi", 2000, "Olem julkaisija", "aagasd");
        
        assertTrue(s.OnkoViiteEhtojenMukainen(k)); 

    
    }
    
    @Test
    public void toStringOtsikko() {
    
        Suodatin s = new Suodatin("TamaOnOtsikko", 2, false);
         
        assertTrue(s.toString().contains("TamaOnOtsikko")); 

    
    }
    
    
    @Test
    public void toStringVuosi() {
    
        Suodatin s = new Suodatin("2000", 3, false);
         
        assertTrue(s.toString().contains("2000")); 

    
    }
    
    @Test
    public void toStringVirheellinenTyyppi() {
    
        Suodatin s = new Suodatin("2000", 4, false);
         
        assertTrue(s.toString().contains("Suodatusperuste: \n")); 

    
    }
}
