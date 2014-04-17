/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viitemanageri.viitteet;

import java.util.ArrayList;
import java.util.List;
import viitemanageri.logiikka.Tarkistus;
import viitemanageri.logiikka.ViiteTiedosto;

/**
 *
 * @author maef
 */
public class Manageri {
    
    private List<Viite> viitteet = new ArrayList<Viite>();
    private ViiteTiedosto viitteetTiedosto;
    private Tarkistus tarkistaja;

    public Manageri() {
        tarkistaja = new Tarkistus(viitteet);
    }
    
    private void lisaaViiteListaan(Viite uusi) {
        viitteet = viitteetTiedosto.lataaTiedosto();
        viitteet.add(uusi);
        tarkistaja.paivitaViiteet(viitteet);
    }

    private void paivitaViiteTiedosto() {
        viitteetTiedosto.paivitaTiedosto(viitteet);
    }
    
    
}
