/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viitemanageri.logiikka;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import viitemanageri.viitteet.Kirja;
import viitemanageri.viitteet.Viite;

/**
 *
 * @author gabriel
 */
public class TarkistusTest {

    private List<Viite> viitelista;
    private Tarkistus tarkastaja;

    @Before
    public void setUp() {
        viitelista = new ArrayList();        
    }

    @Test
    public void palautetaanFalseJosTunnusOnJoOlemassa() {
       Kirja kirja = new Kirja("a", "b", 2014, "c", "t1");
       viitelista.add(kirja);
       tarkastaja = new Tarkistus(viitelista);
       assertFalse(tarkastaja.onkoUniikki("t1")); 
    }
    
    @Test
    public void palautetaanTrueJosTunnusOnVapaa(){
       Kirja kirja = new Kirja("a", "b", 2014, "c", "t2");
       viitelista.add(kirja);
       tarkastaja = new Tarkistus(viitelista);
       assertTrue(tarkastaja.onkoUniikki("t3"));
    }
}
