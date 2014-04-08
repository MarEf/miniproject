package viitemanageri;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import viitemanageri.io.Io;
import viitemanageri.io.KonsoliIo;
import viitemanageri.viitteet.Kirja;
import viitemanageri.logiikka.Muunnin;
import viitemanageri.logiikka.Tallenna;
import viitemanageri.logiikka.ViiteTiedosto;
import viitemanageri.viitteet.Artikkeli;
import viitemanageri.viitteet.Inproceedins;
import viitemanageri.viitteet.Viite;

/**
 * Hello world!
 *
 */
public class App {

    private static Io io = new KonsoliIo(new Scanner(System.in));

    private static List<Viite> viitteet = new ArrayList<Viite>();
    private ViiteTiedosto viitteetTiedosto;

    private static Muunnin muuntaja = new Muunnin();
    private static Tallenna tallentaja = new Tallenna();

    public App() {
    }
    
    public void aja(Io io) {
        viitteetTiedosto = new ViiteTiedosto("viiteet");
        viitteet = viitteetTiedosto.lataaTiedosto();
        io.tulosta("Tervetuloa käyttämään ViiteManageria!");

        while (true) {

            String komento = io.lueString("Komento (lisaa, tallenna, listaa, exit): ");
            if (komento.equals("lisaa")) {
                lisaaUusiViite(io);

            } else if (komento.equals("listaa")) {
                listaaViitteet(io);

            } else if (komento.equals("tallenna")) {
                luoViitteistaBibtexTiedosto(io);

            } else if (komento.equals("exit")) {
                break;
            }

        }
    }

    private void listaaViitteet(Io io) {
        for (Viite k : viitteet) {
            io.tulosta(k.toString());
        }
    }

    private void luoViitteistaBibtexTiedosto(Io io) {
        String kansio = io.lueString("Mihin kansioon: ");
        String tiedostoNimi = io.lueString("Tiedostonimi: ");
        String data = muuntaja.muunnaViitteetBibtexMuotoon(viitteet);
        if (tallentaja.tallennaTiedosto(data, kansio, tiedostoNimi)) {
            io.tulosta("Tallennettu");
        } else {
            io.tulosta("Ei onnistunut");
        }
    }

    private void lisaaUusiViite(Io io) {
        io.tulosta("Lisätään viite");
        io.tulosta("Tyypit:\n   1 Kirja\n   2 Artikkeli\n   3 Inproceedins");
        while(true){
            int tyyppi = io.lueInt("Tyypin numero: ");
            
            if(tyyppi==1){
                luoUusiKirja(io);
            }else if(tyyppi==2){
                luoUusiArtikkeli(io);
            }else if(tyyppi==3){
                luoUusiInproceedins(io);
            }else{
                io.tulosta("Viitteen tyyppi oli virheellinen");
                continue;
            }
            paivitaViiteTiedosto();
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
        viitteet.add(uusi);
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
        viitteet.add(uusi);
        io.tulosta("Artikkeli lisätty");
    }

    private String kysyTunnus(Io io) {
        return io.lueString("Tunnus: ");
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
        viitteet.add(uusi);
        io.tulosta("Inproceedins lisätty");
    }
    
    private void paivitaViiteTiedosto() {
        viitteetTiedosto.paivitaTiedosto(viitteet);
    }
    public static void main(String[] args) {
        
        App appi = new App();
        appi.aja(io);
        
//        io.tulosta("Tervetuloa käyttämään ViiteManageria!");
//
//        while (true) {
//
//            String komento = io.lueString("Komento (lisaa, tallenna, listaa, exit): ");
//            if (komento.equals("lisaa")) {
//                io.tulosta("Lisätään kirja");
//                String nimi = io.lueString("Nimi: ");
//                String tekija = io.lueString("Tekijä: ");
//
//                String julkaisija = io.lueString("Julkaisija: ");
//                int vuosi = io.lueInt("Vuosi: ");
//                String tunnus = io.lueString("Tunnus: ");
//
//                Kirja uusi = new Kirja(tekija, nimi, vuosi, julkaisija, tunnus);
//                kirjat.add(uusi);
//
//            } else if (komento.equals("listaa")) {
//
//                for (Viite k : kirjat) {
//                    io.tulosta(k.toString());
//                }
//
//            } else if (komento.equals("tallenna")) {
//                String kansio = io.lueString("Mihin kansioon: ");
//                String tiedostoNimi = io.lueString("Tiedostonimi: ");
//                String data = muuntaja.muunnaViitteetBibtexMuotoon(kirjat);
//                if (tallentaja.tallennaTiedosto(data, kansio, tiedostoNimi)) {
//                    io.tulosta("Tallennettu");
//                } else {
//                    io.tulosta("Ei onnistunut");
//                }
//
//            } else if (komento.equals("exit")) {
//                break;
//            }
//
//        }

    } 
 
}
