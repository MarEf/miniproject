/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viitemanageri.komennot;

import viitemanageri.io.Io;
import viitemanageri.suodatin.Suodattimet;
import viitemanageri.viitteet.Manageri;

/**
 *
 * @author test
 */
public class Filtteri implements Komento {
    
    private final Io io;
    private final Manageri manageri;
    private final Suodattimet s;
    

    public Filtteri(Manageri manageri, Io io, Suodattimet s) {
        this.io= io;
        this.manageri = manageri;
        this.s = s;
    }
    
    @Override
    public void suorita() {
        
        io.tulosta("Valitse toiminta:\n"
                + "   1 luo uusi suodatin\n"
                + "   2 nollaa suodattimet\n"
                + "   3 listaa suodattimet");
        
        while (true) {
            
            int tyyppi = io.lueInt("Tyypin numero: ");

            if (suoritaValinta(tyyppi)) continue;
            
            break;

        }
    }

    private boolean suoritaValinta(int tyyppi) {
        if (tyyppi == 1) {
            suodattimenLuominen();
        } else if (tyyppi == 2) {
            s.nollaaSuodattimet();
        } else if (tyyppi == 3) {
            s.listaaSuodattimet();
        } else {
            io.tulosta("Suodattimen tyyppi oli virheellinen");
            return true;
        }
        return false;
    }
    
    private void suodattimenLuominen() {
        
        io.tulosta("Luodaan suodatin");
        io.tulosta("Valitse suodatusperuste:\n"
                + "   1 Kirjoittaja\n"
                + "   2 Teoksen nimi tai otsikko\n"
                + "   3 Julkaisuvuosi");
        
        kysySuodatusperuste();
    }

    private void kysySuodatusperuste() {
        while (true) {
            
            int tyyppi = io.lueInt("Suodatusperuste: ");
            
            io.tulosta("Etsittävä arvo:\n   1 Sisältyy\n   2 Ei sisälly");
            int sisaltyyko = io.lueInt("Sisaltyyko etsittävä arvo viitteeseen: ");
                       
            if (luoAnnetunTyyppinenSuodin(tyyppi, sisaltyyko)) continue;
            
            manageri.paivitaViiteTiedosto();
            break;

        }
    }

    private boolean luoAnnetunTyyppinenSuodin(int tyyppi, int sisaltyyko) {
        if (tyyppi >= 1 && tyyppi <= 3) {
            String suodatin = io.lueString("Etsi: ");
            s.lisaaSuodatin(suodatin, tyyppi, sisaltyyko);
        } else {
            io.tulosta("Suodatusperuste on virheellinen");
            return true;
        }
        return false;
    }
}
