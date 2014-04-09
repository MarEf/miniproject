package viitemanageri.logiikka;

import java.util.List;
import viitemanageri.viitteet.Viite;

public class Tarkistus {

    private List<Viite> viitteet;

    public Tarkistus(List<Viite> viitteet) {
        this.viitteet = viitteet;
    }

    public void paivitaViiteet(List<Viite> viitteet) {
        this.viitteet = viitteet;
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
}
