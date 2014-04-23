    

package viitemanageri.komennot;

import static java.lang.System.out;
import viitemanageri.io.Io;
import viitemanageri.suodatin.Suodattimet;
import viitemanageri.viitteet.Manageri;
import viitemanageri.viitteet.Viite;

/**
 *
 * @author glindstr
 */
public class Lista implements Komento{

    private Manageri manageri;
    private Io io;
    private Suodattimet s;

    public Lista(Manageri manageri, Io io, Suodattimet s) {
        this.manageri = manageri;
        this.io = io;
        this.s = s;
    }
   
   
    
    @Override
    public void suorita() {
        
        for (Viite k : s.palautaSuodatettuLista(manageri.getViitteet())) {
            io.tulosta(k.toString());
        }
        
    }
    
}
