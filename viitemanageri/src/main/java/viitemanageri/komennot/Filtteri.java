/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viitemanageri.komennot;

import viitemanageri.io.Io;
import viitemanageri.viitteet.Manageri;

/**
 *
 * @author test
 */
public class Filtteri implements Komento {
    
    private Io io;
    private Manageri manageri;
    
    public Filtteri(Manageri manageri, Io io){
        this.io= io;
        this.manageri = manageri;
    }
    
    @Override
    public void suorita() {
        io.tulosta("Luodaan suodatin");
        io.tulosta("Valitse suodatus peruste:\n   1 Kirjoittaja\n   2 Artikkeli\n   3 Julkaisuvuosi");
        while (true) {
            int tyyppi = io.lueInt("Tyypin numero: ");

            if (tyyppi == 1) {
                
            } else if (tyyppi == 2) {
                
            } else if (tyyppi == 3) {
                
            } else {
                io.tulosta("Suodattimen tyyppi oli virheellinen");
                continue;
            }
            manageri.paivitaViiteTiedosto();
            break;

        }
    }
}
