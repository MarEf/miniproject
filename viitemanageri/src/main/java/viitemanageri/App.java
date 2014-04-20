package viitemanageri;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import viitemanageri.io.Io;
import viitemanageri.io.KonsoliIo;
import viitemanageri.komennot.Filtteri;
import viitemanageri.komennot.Komento;
import viitemanageri.komennot.Lisays;
import viitemanageri.komennot.Lista;
import viitemanageri.komennot.Tallennus;
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

    private static List<Viite> viitteet = new ArrayList<>();
    private ViiteTiedosto viitteetTiedosto;

    private static Muunnin muuntaja = new Muunnin();
    private Map<String, Komento> kommenot;

    public App(Io io) {
        this.io = io;
        kommenot = new HashMap();
        manageri = new Manageri();
        kommenot.put("lisaa", new Lisays(manageri, io));
        kommenot.put("listaa", new Lista(manageri, io));
        kommenot.put("tallenna", new Tallennus(manageri, io, muuntaja));
        kommenot.put("filtteri", new Filtteri(manageri, io));
    }
    
 

    public void aja() {
        viitteetTiedosto = new ViiteTiedosto("viitteet");
        viitteet = viitteetTiedosto.lataaTiedosto();
        io.tulosta("Tervetuloa käyttämään ViiteManageria!");

        while (true) {

            String komentoString = io.lueString("Komento (lisaa, tallenna, listaa, filtteri, exit): ");
            Komento komento = kommenot.get(komentoString);
            if (komento != null) {
                komento.suorita();
            } else if(komentoString.equals("exit")) {
                break;
            } else {
                io.tulosta("Virheellinen komento");
            }
        }
    }

   

    public static void main(String[] args) {
        //System.out.println(System.getProperty("java.version"));
        Io io = new KonsoliIo(new Scanner(System.in));
        App appi = new App(io);
        appi.aja();
    }

}
