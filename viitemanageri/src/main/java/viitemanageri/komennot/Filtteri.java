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
    
    private Io io;
    private Manageri manageri;
    private Suodattimet s;
    

    public Filtteri(Manageri manageri, Io io, Suodattimet s) {
        this.io= io;
        this.manageri = manageri;
        this.s = s;
    }
    
    @Override
    public void suorita() {
        io.tulosta("Valitse toiminta:\n   1 luo uusi suodatin\n   2 nollaa suodattimet\n   3 listaa suodattimet");
        while (true) {
            int tyyppi = io.lueInt("Tyypin numero: ");

            if (tyyppi == 1) {
                suodattimenLuominen();
            } else if (tyyppi == 2) {
                s.nollaaSuodattimet();
            } else if (tyyppi == 3) {
                s.listaaSuodattimet();
            } else {
                io.tulosta("Suodattimen tyyppi oli virheellinen");
                continue;
            }
            manageri.paivitaViiteTiedosto();
            break;

        }
    } 
    public void suodattimenLuominen() {
        io.tulosta("Luodaan suodatin");
        io.tulosta("Valitse suodatusperuste:\n   1 Kirjoittaja\n   2 ?\n   3 Julkaisuvuosi");
        while (true) {
            int tyyppi = io.lueInt("Suodatusperuste: ");
            
            io.tulosta("Etsittävä arvo:\n   1 Sisältyy\n   2 Ei sisälly");
            int sisaltyyko = io.lueInt("Sisaltyyko etsittävä arvo viitteeseen: ");
            
            if (tyyppi == 1) {
                String suodatin = io.lueString("Etsi: ");
                s.lisaaSuodatin(suodatin, 1, sisaltyyko);
            } else if (tyyppi == 2) {
                String suodatin = io.lueString("Etsi: ");
                s.lisaaSuodatin(suodatin, 2, sisaltyyko); 
            } else if (tyyppi == 3) {
                String suodatin = io.lueString("Etsi: ");
                s.lisaaSuodatin(suodatin, 3, sisaltyyko); 
            } else {
                io.tulosta("Suodatusperuste on virheellinen");
                continue;
            }
            manageri.paivitaViiteTiedosto();
            break;

        }
    }
}
