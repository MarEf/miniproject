package viitemanageri;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import viitemanageri.io.Io;
import viitemanageri.io.KonsoliIo;
import viitemanageri.viitteet.Kirja;
import viitemanageri.logiikka.Muunna;
import viitemanageri.logiikka.Tallenna;
import viitemanageri.viitteet.Viite;

/**
 * Hello world!
 *
 */
public class App {

    private static Io io = new KonsoliIo(new Scanner(System.in));

    private static List<Viite> kirjat = new ArrayList<Viite>();

    private static Muunna muuntaja = new Muunna();
    private static Tallenna tallentaja = new Tallenna();

    public static void main(String[] args) {

        io.tulosta("Tervetuloa käyttämään ViiteManageria!");

        while (true) {

            String komento = io.lueString("Komento (lisaa, tallenna, listaa, exit): ");
            if (komento.equals("lisaa")) {
                io.tulosta("Lisätään kirja");
                String nimi = io.lueString("Nimi: ");
                String tekija = io.lueString("Tekijä: ");

                String julkaisija = io.lueString("Julkaisija: ");
                int vuosi = io.lueInt("Vuosi: ");
                String tunnus = io.lueString("Tunnus: ");

                Kirja uusi = new Kirja(tekija, nimi, vuosi, julkaisija, tunnus);
                kirjat.add(uusi);

            } else if (komento.equals("listaa")) {

                for (Viite k : kirjat) {
                    io.tulosta(k.toString());
                }

            } else if (komento.equals("tallenna")) {
                String kansio = io.lueString("Mihin kansioon: ");
                String tiedostoNimi = io.lueString("Tiedostonimi: ");
                String data = muuntaja.muunnaViitteetBibtexMuotoon(kirjat);
                if (tallentaja.tallennaTiedosto(data, kansio, tiedostoNimi)) {
                    io.tulosta("Tallennettu");
                } else {
                    io.tulosta("Ei onnistunut");
                }

            } else if (komento.equals("exit")) {
                break;
            }

        }

    }
}
