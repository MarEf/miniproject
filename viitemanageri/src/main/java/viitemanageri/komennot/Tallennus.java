/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viitemanageri.komennot;

import viitemanageri.io.Io;
import viitemanageri.logiikka.Muunnin;
import viitemanageri.viitteet.Manageri;

/**
 *
 * @author glindstr
 */
public class Tallennus implements Komento {
    
    private Io io;
    private Muunnin muuntaja;
    private Manageri manageri;
 
    public Tallennus(Io io, Muunnin muuntaja, Manageri manageri) {
        this.io = io;
        this.muuntaja = muuntaja;
        this.manageri = manageri;
    }
    
    

    @Override
    public void suorita() {
        String kansio = io.lueString("Mihin kansioon: ");
        String tiedostoNimi = io.lueString("Tiedostonimi: ");
        String data = muuntaja.muunnaViitteetBibtexMuotoon(manageri.getViitteet());
        if (manageri.tallennaBibtexTiedosto(data, kansio, tiedostoNimi)) {
            io.tulosta("Tallennettu");
        } else {
            io.tulosta("Ei onnistunut");
        }
    }
    
    
}
