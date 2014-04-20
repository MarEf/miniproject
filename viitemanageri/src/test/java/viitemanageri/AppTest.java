package viitemanageri;

import viitemanageri.io.StubIO;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class AppTest {
    private StubIO io;
    private App app;    
    
    
    @Before
    public void setUp() {
        try {
            File file = new File("viitteet1.txt");
            file.delete();
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(AppTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void kirjanLisaaminenOnnistuu(){
        io = new StubIO("lisaa", "1", "a", "b", "c", "2014", "A1", "exit");
        app = new App(io);
        app.aja();
        assertEquals("Kirja lisätty", nViimeisinTuloste(2));
        
    }
    
    @Test
    public void artikkelinLisaaminenOnnistuu(){
        io = new StubIO("lisaa", "2", "a", "b", "c", "2014", "1", "2", "3", "4", "A2", "exit");
        app = new App(io);
        app.aja();
        assertEquals("Artikkeli lisätty", nViimeisinTuloste(2));
        
    }
    
    @Test
    public void inProceedingsArtikkelinLisaaminenOnnistuu(){
        io = new StubIO("lisaa", "3", "a", "b", "c", "2014", "1", "2", "d", "A3", "exit");
        app = new App(io);
        app.aja();
        assertEquals("Inproceedings lisätty", nViimeisinTuloste(2));    
    }
    
    @Test
    public void tallentaminenOnnistuu(){
        io = new StubIO("lisaa", "3", "a", "b", "c", "2014", "1", "2", "d", "A4", "tallenna", ".", "viitteet1.txt", "exit");
        app = new App(io);
        app.aja();
        assertEquals("Tallennettu", nViimeisinTuloste(2));
    }
    
    @Test
    public void tallentaminenEiOnnistuuJosPolkuVirheellinen(){
        io = new StubIO("lisaa", "3", "a", "b", "c", "2014", "1", "2", "d", "A5", "tallenna", "No_dir", "viitteet1.txt", "exit");
        app = new App(io);
        app.aja();
        assertEquals("Ei onnistunut", nViimeisinTuloste(2));
    }
    
    @Test
    public void viitteidenListaaminenOnnistuu(){
        io = new StubIO("listaa", "exit");
        app = new App(io);
        app.aja();
        assertEquals("Komento (lisaa, tallenna, listaa, filtteri, exit): ", nViimeisinTuloste(1));
    }
    
    @Test
    public void josViiteTyyppiVaaraSaaSyottaaUudestaan(){
        io = new StubIO("lisaa", "4", "1", "a", "b", "c", "2014", "A11", "exit");
        app = new App(io);
        app.aja();
        assertEquals("Kirja lisätty", nViimeisinTuloste(2));
        new File("viitteet").delete();
    }
    
    private String nViimeisinTuloste(int n){
        return io.getPrints().get(io.getPrints().size()-n);
    }
}
