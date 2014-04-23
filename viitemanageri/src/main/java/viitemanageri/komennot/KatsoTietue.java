
package viitemanageri.komennot;

import viitemanageri.io.Io;
import viitemanageri.logiikka.Muunnin;
import viitemanageri.viitteet.Manageri;
import viitemanageri.viitteet.Viite;

/**
 *
 * @author gabriel
 */
public class KatsoTietue implements Komento {

    private Io io;
    private Manageri manageri;
    private Muunnin muuntaja;

    public KatsoTietue(Manageri manageri, Io io, Muunnin muuntaja) {
        this.io = io;
        this.manageri = manageri;
        this.muuntaja = muuntaja;
    }
        
    @Override
    public void suorita() {
        String tunnus = io.lueString("Tunnus: ");
        Viite viite = manageri.haeViite(tunnus);
        if (viite == null){
            io.tulosta("Virheellinen tunnus");
        }
        else {
            io.tulosta(muuntaja.muunnaViiteBibtexMuotoon(viite));
        }
    }

}
