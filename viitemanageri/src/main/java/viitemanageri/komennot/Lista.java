

package viitemanageri.komennot;

import viitemanageri.io.Io;
import viitemanageri.viitteet.Manageri;
import viitemanageri.viitteet.Viite;

/**
 *
 * @author glindstr
 */
public class Lista implements Komento{

   private Manageri manageri;
   private Io io;

    public Lista(Io io, Manageri manageri) {
        this.manageri = manageri;
        this.io = io;
    }
   
   
    
    @Override
    public void suorita() {
        
        for (Viite k : manageri.getViitteet()) {
            io.tulosta(k.toString());
        
    }
    }
    
}
