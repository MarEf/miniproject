package viitemanageri;

import viitemanageri.komennot.Lisays;
import viitemanageri.komennot.Komento;
import viitemanageri.komennot.Lista;
import viitemanageri.komennot.Tallennus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import viitemanageri.io.Io;
import viitemanageri.io.KonsoliIo;
import viitemanageri.logiikka.Muunnin;
import viitemanageri.logiikka.ViiteTiedosto;
import viitemanageri.viitteet.Manageri;
import viitemanageri.viitteet.Viite;

/**
 * Hello world!
 *
 */
public class App {

    private Io io;

    private Manageri manageri;

    private static Muunnin muuntaja = new Muunnin();
    private Map<String, Komento> kommenot;

    public App(Io io, String viitetiedosto) {
        this.io = io;
        kommenot = new HashMap();
        manageri = new Manageri(viitetiedosto);
        kommenot.put("lisaa", new Lisays(manageri, io));
        kommenot.put("listaa", new Lista(io, manageri));
        kommenot.put("tallenna", new Tallennus(io, muuntaja, manageri));
    }

    public void aja() {

        io.tulosta("Tervetuloa käyttämään ViiteManageria!");

        while (true) {

            String komentoString = io.lueString("Komento (lisaa, tallenna, listaa, exit): ");
            Komento komento = kommenot.get(komentoString);
            if (komento != null) {
                komento.suorita();

            } else if (komentoString.equals("exit")) {
                break;
            } else {

                io.tulosta("Virheellinen komento");
            }
        }
    }

    public static void main(String[] args) {
        Io io = new KonsoliIo(new Scanner(System.in));
        App appi = new App(io, "viitteet");
        appi.aja();
    }

}
