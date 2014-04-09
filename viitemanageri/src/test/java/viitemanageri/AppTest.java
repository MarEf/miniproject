package viitemanageri;

import java.io.File;
import org.junit.Before;
import org.junit.Test;
import viitemanageri.io.StubIO;
import static org.junit.Assert.*;

public class AppTest {
    private StubIO io;
    private App app;
    
    @Before
    public void setUp(){
        app = new App();
    }
    
    @Test
    public void kirjanLisaaminenOnnistuu(){
        io = new StubIO("lisaa", "1", "a", "b", "c", "2014", "A1", "exit");
        app.aja(io);
        assertEquals("Kirja lisätty", nViimeisinTuloste(2));
        
    }
    
    @Test
    public void artikkelinLisaaminenOnnistuu(){
        io = new StubIO("lisaa", "2", "a", "b", "c", "2014", "1", "2", "3", "4", "A2", "exit");
        app.aja(io);
        assertEquals("Artikkeli lisätty", nViimeisinTuloste(2));
        
    }
    
    @Test
    public void inProceedingsArtikkelinLisaaminenOnnistuu(){
        io = new StubIO("lisaa", "3", "a", "b", "c", "2014", "1", "2", "d", "A3", "exit");
        app.aja(io);
        assertEquals("Inproceedings lisätty", nViimeisinTuloste(2));    
    }
    
    @Test
    public void tallentaminenOnnistuu(){
        io = new StubIO("lisaa", "3", "a", "b", "c", "2014", "1", "2", "d", "A4", "tallenna", ".", "viitteet1.txt", "exit");
        app.aja(io);
        assertEquals("Tallennettu", nViimeisinTuloste(2));
    }
    
    @Test
    public void tallentaminenEiOnnistuuJosPolkuVirheellinen(){
        io = new StubIO("lisaa", "3", "a", "b", "c", "2014", "1", "2", "d", "A5", "tallenna", "No_dir", "viitteet1.txt", "exit");
        app.aja(io);
        assertEquals("Ei onnistunut", nViimeisinTuloste(2));
    }
    
    @Test
    public void viitteidenListaaminenOnnistuu(){
        io = new StubIO("listaa", "exit");
        app.aja(io);
        assertEquals("Komento (lisaa, tallenna, listaa, exit): ", nViimeisinTuloste(1));
    }
    
    @Test
    public void josViiteTyyppiVaaraSaaSyottaaUudestaan(){
        io = new StubIO("lisaa", "4", "1", "a", "b", "c", "2014", "A11", "exit");
        app.aja(io);
        assertEquals("Kirja lisätty", nViimeisinTuloste(2));
        new File("viitteet").delete();
    }
    
    private String nViimeisinTuloste(int n){
        return io.getPrints().get(io.getPrints().size()-n);
    }
}
