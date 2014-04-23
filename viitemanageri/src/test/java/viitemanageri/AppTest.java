package viitemanageri;

import viitemanageri.io.StubIO;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import viitemanageri.io.StubIO;
import static org.junit.Assert.*;
import org.junit.Before;

public class AppTest {

    private StubIO io;
    private App app;
    private final String viitetiedosto = "viitteetTest";
    private final String bibtextiedosto = "viitteet1.txt";

    @Before
    public void setUp() {

        File bibtextTiedosto = new File(bibtextiedosto);
        File viiteTiedosto = new File(viitetiedosto);
        if (bibtextTiedosto.exists()) {
            bibtextTiedosto.delete();
        }
        if (viiteTiedosto.exists()) {
            viiteTiedosto.delete();
        }

    }

    @Test
    public void kirjanLisaaminenOnnistuu() {
        io = new StubIO("lisaa", "1", "a", "b", "c", "2014", "A1", "exit");
        app = new App(io, viitetiedosto);
        app.aja();
        assertEquals("Kirja lisätty", nViimeisinTuloste(2));

    }

    @Test
    public void artikkelinLisaaminenOnnistuu(){
        io = new StubIO("lisaa", "2", "a", "b", "c", "2014", "1", "2", "3", "4", "A2", "exit");
        app = new App(io, viitetiedosto);
        app.aja();
        assertEquals("Artikkeli lisätty", nViimeisinTuloste(2));
        
    }
    
    @Test
    public void inProceedingsArtikkelinLisaaminenOnnistuu(){
        io = new StubIO("lisaa", "3", "a", "b", "c", "2014", "1", "2", "d", "A3", "exit");
        app = new App(io, viitetiedosto);
        app.aja();
        assertEquals("Inproceedings lisätty", nViimeisinTuloste(2));
    }
    
    @Test
    public void tallentaminenOnnistuu(){
        io = new StubIO("lisaa", "3", "a", "b", "c", "2014", "1", "2", "d", "A4", "tallenna", ".", "viitteet1.txt", "exit");
        app = new App(io, viitetiedosto);
        app.aja();
        assertEquals("Tallennettu", nViimeisinTuloste(2));
    }
    
    @Test
    public void tallentaminenEiOnnistuuJosPolkuVirheellinen(){
        io = new StubIO("lisaa", "3", "a", "b", "c", "2014", "1", "2", "d", "A5", "tallenna", "No_dir", "viitteet1.txt", "exit");
        app = new App(io, viitetiedosto);
        app.aja();
        assertEquals("Ei onnistunut", nViimeisinTuloste(2));
    }
    
    @Test
    public void viitteidenListaaminenOnnistuu(){
        io = new StubIO("listaa", "exit");
        app = new App(io, viitetiedosto);
        app.aja();
        assertTrue(nViimeisinTuloste(1).contains("Komento"));
        assertFalse(nViimeisinTuloste(1).contains("Virheellinen"));
    }
    
    @Test
    public void viitteidenSuodatetunListanListausOnnistuuKunSuodatettavaArvoTasmaaViitteeseen(){
        io = new StubIO("lisaa", "1", "KirjanNIi", "Lorekk", "c", "2014", "sdyyhdyh", "suodatin", "1", "1", "1", "Lorekk", "listaa", "exit");
        app = new App(io, viitetiedosto);
        app.aja();
        assertTrue(nViimeisinTuloste(2).contains("Lore")); 
    }
    
    @Test
    public void viitteidenSuodatetunListanListausOnnistuuKunSuodatettavaArvoEiSaaOllaViitteessa(){
        io = new StubIO("lisaa", "1", "KirjanNIi", "Lorekk", "c", "2014", "sdyyhdyh", "suodatin", "1", "1", "2", "Lorekk", "listaa", "exit");
        app = new App(io, viitetiedosto);
        app.aja();
        assertTrue(!nViimeisinTuloste(2).contains("Lorekk")); 
    }
    
    @Test
    public void viitteidenSuodatetunListanListausOnnistuuKunSuodatettuArvoEiTasmaaViitteeseen(){
        io = new StubIO("lisaa", "1", "KirjanNIi", "Lorekk", "c", "2014", "sdyyhdyh", "suodatin", "1", "1", "1", "agahgaghafg", "listaa", "exit");
        app = new App(io, viitetiedosto);
        app.aja();
        assertTrue(!nViimeisinTuloste(2).contains("Lore")); 
    }
    
    
    @Test
    public void virheellinenSuodatusperuste(){
        io = new StubIO("suodatin", "1", "4", "1", "1", "1", "agahgaghafg", "exit");
        app = new App(io, viitetiedosto);
        app.aja();
        assertTrue(!nViimeisinTuloste(7).contains("Suodatusperuste on virheellinen")); 
    }
    
    @Test
    public void virheellinenSuodatusperuste2(){
        io = new StubIO("suodatin", "1", "0", "1", "1", "1", "agahgaghafg", "exit");
        app = new App(io, viitetiedosto);
        app.aja();
        assertTrue(!nViimeisinTuloste(7).contains("Suodatusperuste on virheellinen")); 
    }
    
    @Test
    public void lisataanEiUniikkiTunnus(){
        io = new StubIO("lisaa", "1", "a", "b", "c", "2014", "A1as", "lisaa", "1", "a", "b", "c", "2014", "A1as", "gaifjgis", "exit");
        app = new App(io, viitetiedosto);
        app.aja();
        assertTrue(!nViimeisinTuloste(2).contains("Ei uniikki, yritä uudestaan.")); 
    }
    
    @Test
    public void nollataanSuodatin(){
        io = new StubIO("lisaa", "1", "KirjanNIi", "Lorekk", "c", "2014", "sdyyhdyh", "suodatin", "1", "1", "1", "TamaOnTestiSuodatin", "suodatin", "2", "suodatin", "3", "exit");
        app = new App(io, viitetiedosto);
        app.aja();
        assertTrue(!nViimeisinTuloste(2).contains("TamaOnTestiSuodatin")); 
    }
    
    
    @Test
    public void josViiteTyyppiVaaraSaaSyottaaUudestaan(){
        io = new StubIO("lisaa", "4", "1", "a", "b", "c", "2014", "A11", "exit");
        app = new App(io, viitetiedosto);
        app.aja();
        assertEquals("Kirja lisätty", nViimeisinTuloste(2));
        new File("viitteet").delete();
    }
    
    private String nViimeisinTuloste(int n) {
        return io.getPrints().get(io.getPrints().size() - n);
    }
    
}