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
import viitemanageri.logiikka.Muunnin;
import viitemanageri.viitteet.Artikkeli;
import viitemanageri.viitteet.Kirja;
import viitemanageri.viitteet.Viite;

/**
 *
 * @author test
 */
public class MuunninTest {
    
    private Muunnin m;
    
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
    
private String testiTuloste3 = "@article{W04,\n" +
"author = {Keith J. Whittington},\n" +
"title = {Infusing active learning into introductory programming courses},\n" +
"journal = {J. Comput. Small Coll.},\n" +
"volume = {19},\n" +
"number = {5},\n" +
"year = {2004},\n" +
"pages = {249--259},\n" +
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
        m = new Muunnin();
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
        
        
        List k = new ArrayList();
        
        k.add(new Kirja("Testi Testaaja", "Loremi", 2000, "Olem julkaisija", "asd"));
        
        String a = m.muunnaViitteetBibtexMuotoon(k);
        assertEquals(a, testiTuloste);
    }
    
    @Test
    public void muunninMuuntaaOikeinTestiSyotteet(){
        
        
        List k = new ArrayList();
        
        k.add(new Kirja("Testi Testaaja", "Loremi", 2000, "Olem julkaisija", "asd"));
        
        k.add(new Kirja("Tekiasd", "Juuh elikkäs", 2001, "Olen julkaisija", "dot"));
        
        String a = m.muunnaViitteetBibtexMuotoon(k);
        assertEquals(a, testiTuloste2);
    }
    
    @Test
    public void muunninMuuntaaOikeinArtikkelin(){
        List<Viite> viitelista = new ArrayList();
        viitelista.add(new Artikkeli("Keith J. Whittington", 
                "Infusing active learning into introductory programming courses", "J. Comput. Small Coll.", 2004, 19, 5, 249, 259, "W04" ));
        assertEquals(testiTuloste3, m.muunnaViitteetBibtexMuotoon(viitelista));
    }
}
