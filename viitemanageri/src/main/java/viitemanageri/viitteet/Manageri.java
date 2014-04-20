/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viitemanageri.viitteet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import viitemanageri.logiikka.ViiteTiedosto;

/**
 *
 * @author maef
 */
public class Manageri {

    private List<Viite> viitteet = new ArrayList<Viite>();
    private ViiteTiedosto viitteetTiedosto;

    public Manageri(String viitetiedosto) {

        viitteetTiedosto = new ViiteTiedosto(viitetiedosto);
        viitteet = viitteetTiedosto.lataaTiedosto();
    }

    public void lisaaViiteListaan(Viite uusi) {
        viitteet = viitteetTiedosto.lataaTiedosto();
        viitteet.add(uusi);
    }

    public void paivitaViiteTiedosto() {
        viitteetTiedosto.paivitaTiedosto(viitteet);
    }

    public List<Viite> getViitteet() {
        return viitteet;
    }

    public boolean onkoUniikki(String tunnus) {
        if (viitteet.isEmpty()) {
            return true;
        } else {
            for (Viite i : viitteet) {
                if (tunnus.equalsIgnoreCase(i.getTunnus())) {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean tallennaBibtexTiedosto(
            String tallennettavaData,
            String sijainti,
            String tiedostonNimi) {

        try {
            FileOutputStream tiedosto;
            tiedosto = new FileOutputStream(sijainti + "/" + tiedostonNimi);

            tiedosto.write(tallennettavaData.getBytes());
        } catch (IOException ex) {
            return false;
        }
        return true;

    }

    public Viite haeViite(String tunnus) {
        Viite viite = null;
        for (Viite v : viitteet) {
            if (v.getTunnus().equals(tunnus)) {
                viite = v;
                break;
            }
        }
        return viite;
    }

}
