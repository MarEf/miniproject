

package viitemanageri.komennot;

import java.util.Map;
import viitemanageri.io.Io;
import viitemanageri.viitteet.Artikkeli;
import viitemanageri.viitteet.Inproceedins;
import viitemanageri.viitteet.Kirja;
import viitemanageri.viitteet.Manageri;
import viitemanageri.viitteet.Viite;

/**
 *
 * @author glindstr
 */
public class Lisays implements Komento{

    private Io io;
    private Manageri manageri;
    
    public Lisays(Manageri manageri, Io io){
        this.io= io;
        this.manageri = manageri;
    }
    @Override
    public void suorita() {
        io.tulosta("Lisätään viite");
        io.tulosta("Tyypit:\n   1 Kirja\n   2 Artikkeli\n   3 Inproceedins");
        while (true) {
            int tyyppi = io.lueInt("Tyypin numero: ");

            if (tyyppi == 1) {
                luoUusiKirja(io);
            } else if (tyyppi == 2) {
                luoUusiArtikkeli(io);
            } else if (tyyppi == 3) {
                luoUusiInproceedins(io);
            } else {
                io.tulosta("Viitteen tyyppi oli virheellinen");
                continue;
            }
            manageri.paivitaViiteTiedosto();
            break;

        }
    }
    
     private void luoUusiKirja(Io io) {

        String nimi = io.lueString("Nimi: ");
        String tekija = io.lueString("Tekijä: ");
        String julkaisija = io.lueString("Julkaisija: ");
        int vuosi = io.lueInt("Vuosi: ");
        String tunnus = kysyTunnus(io);

        Viite uusi = new Kirja(tekija, nimi, vuosi, julkaisija, tunnus);
        manageri.lisaaViiteListaan(uusi);
        io.tulosta("Kirja lisätty");
    }

    private void luoUusiArtikkeli(Io io) {

        String kirjoittaja = io.lueString("Kirjoittaja: ");
        String otsikko = io.lueString("Otsikko: ");
        String lehti = io.lueString("Lehti: ");
        int vuosi = io.lueInt("Vuosi: ");
        int nidenumero = io.lueInt("Nidenumero: ");
        int numero = io.lueInt("Numero: ");
        int alkusivu = io.lueInt("Alkusivu: ");
        int loppusivu = io.lueInt("Loppusivu: ");
        String tunnus = kysyTunnus(io);

        Viite uusi = new Artikkeli(
                kirjoittaja,
                otsikko,
                lehti,
                vuosi,
                nidenumero,
                numero,
                alkusivu,
                loppusivu,
                tunnus);
        manageri.lisaaViiteListaan(uusi);
        io.tulosta("Artikkeli lisätty");
    }
    
    private void luoUusiInproceedins(Io io) {

        String tekija = io.lueString("Tekijä: ");
        String otsikko = io.lueString("Otsikko: ");
        String teos = io.lueString("Teos: ");
        int vuosi = io.lueInt("Vuosi: ");
        int alkusivu = io.lueInt("Alkusivu: ");
        int loppusivu = io.lueInt("Loppusivu: ");
        String julkaisija = io.lueString("Julkaisija: ");
        String tunnus = kysyTunnus(io);

        Viite uusi = new Inproceedins(
                tekija,
                otsikko,
                teos,
                vuosi,
                alkusivu,
                loppusivu,
                julkaisija,
                tunnus);
        manageri.lisaaViiteListaan(uusi);
        io.tulosta("Inproceedings lisätty");
    }
    
    private String kysyTunnus(Io io) {
        String tunnus;
        while (true) {
            tunnus = io.lueString("Tunnus: ");
            if (manageri.onkoUniikki(tunnus)) {
                return tunnus;
            } else {
                io.tulosta("Ei uniikki, yritä uudestaan.");
            }
        }
    }
    
}
