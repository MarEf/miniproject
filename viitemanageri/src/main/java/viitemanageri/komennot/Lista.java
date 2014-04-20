    

package viitemanageri.komennot;

import static java.lang.System.out;
import viitemanageri.io.Io;
import viitemanageri.suodatin.Suodatin;
import viitemanageri.viitteet.Manageri;
import viitemanageri.viitteet.Viite;

/**
 *
 * @author glindstr
 */
public class Lista implements Komento{

   private Manageri manageri;
   private Io io;

    public Lista(Manageri manageri, Io io) {
        this.manageri = manageri;
        this.io = io;
    }
   
   
    
    @Override
    public void suorita() {
        
        for (Viite k : manageri.getViitteet()) {
            io.tulosta(k.toString());
        
    }
        
        Suodatin s;
       //s = new Suodatin( manageri.getViitteet());
        
        //s.suodatettuLista((p->p.getTyyppi() == "@book")).forEach(out::println);
    }
    
}
