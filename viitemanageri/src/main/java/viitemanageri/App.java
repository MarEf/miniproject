package viitemanageri;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import viitemanageri.io.Io;
import viitemanageri.io.KonsoliIo;
import viitemanageri.komennot.KatsoTietue;
import viitemanageri.komennot.Komento;
import viitemanageri.komennot.Lisays;
import viitemanageri.komennot.Lista;
import viitemanageri.komennot.Tallennus;
import viitemanageri.logiikka.Muunnin;
import viitemanageri.viitteet.Manageri;

/**
 * Hello world!
 *
 */
public class App {

    private Io io;
    private Manageri manageri;
    private static Muunnin muuntaja = new Muunnin();
    private Map<String, Komento> kommenot;
    private static final String VIITETIEDOSTO = "viitteet";

    public App(Io io, String viitetiedosto) {
        this.io = io;
        kommenot = new HashMap();
        manageri = new Manageri(viitetiedosto);
        kommenot.put("lisaa", new Lisays(manageri, io));
        kommenot.put("listaa", new Lista(io, manageri));
        kommenot.put("tallenna", new Tallennus(io, muuntaja, manageri));
        kommenot.put("katso", new KatsoTietue(io, manageri, muuntaja));
    }

    public void aja() {
        io.tulosta("Tervetuloa käyttämään ViiteManageria!");

        while (true) {
            String syote = io.lueString("Komento (lisaa, tallenna, listaa, katso, exit): ");
            Komento komento = kommenot.get(syote);
            if (komento != null) {
                komento.suorita();

            } else if (syote.equals("exit")) {
                break;
            } else {

                io.tulosta("Virheellinen komento");
            }
        }
    }

    public static void main(String[] args) {
        Io io = new KonsoliIo(new Scanner(System.in));
        App appi = new App(io, VIITETIEDOSTO);
        appi.aja();
    }

}
