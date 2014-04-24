package viitemanageri;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import viitemanageri.io.Io;
import viitemanageri.io.KonsoliIo;
import viitemanageri.komennot.Filtteri;
import viitemanageri.komennot.KatsoTietue;
import viitemanageri.komennot.Komento;
import viitemanageri.komennot.Lisays;
import viitemanageri.komennot.Lista;
import viitemanageri.komennot.Tallennus;
import viitemanageri.logiikka.Muunnin;
import viitemanageri.suodatin.Suodattimet;
import viitemanageri.viitteet.Manageri;

/**
* Hello world!
*
*/
public class App {

    private Io io;
    private Manageri manageri;
    private Muunnin muuntaja;
    private Map<String, Komento> kommenot;
    private static final String VIITETIEDOSTO = "viitteet";

    public App(Io io, String viitetiedosto) {
        this.io = io;
        muuntaja = new Muunnin(); 
        manageri = new Manageri(viitetiedosto); 
    }

    public void aja() {
        luoKomennot();
        io.tulosta("Tervetuloa käyttämään ViiteManageria!");

        while (true) {
            String syote = io.lueString("Komento (lisaa, tallenna, listaa, katso, suodatin, exit): ");
            
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

    private void luoKomennot() {
        kommenot = new HashMap();
        Suodattimet s = new Suodattimet(io);
        kommenot.put("lisaa", new Lisays(manageri, io));
        kommenot.put("listaa", new Lista(manageri, io, s));
        kommenot.put("tallenna", new Tallennus(manageri, io, muuntaja));
        kommenot.put("katso", new KatsoTietue(manageri, io, muuntaja));
        kommenot.put("suodatin", new Filtteri(manageri, io, s));
    }

    public static void main(String[] args) { 
        new App(new KonsoliIo(new Scanner(System.in)), VIITETIEDOSTO).aja(); 
    }

}