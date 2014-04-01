

package viitemanageri.viitteet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author glindstr@cs
 */
public class Kirja implements Viite {

    private String tekija;
    private String teoksenNimi;
    private int vuosi;
    private String julkaisija;
    private String tunnus;

    public Kirja(String tekija, String teoksenNimi, int vuosi, String julkaisija, String tunnus) {
        this.tekija = tekija;
        this.teoksenNimi = teoksenNimi;
        this.vuosi = vuosi;
        this.julkaisija = julkaisija;
        this.tunnus = tunnus;
    }      

    public String getTekija() {
        return tekija;
    }

    public void setTekija(String tekija) {
        this.tekija = tekija;
    }

    public String getTeoksenNimi() {
        return teoksenNimi;
    }

    public void setTeoksenNimi(String teoksenNimi) {
        this.teoksenNimi = teoksenNimi;
    }

    public int getVuosi() {
        return vuosi;
    }

    public void setVuosi(int vuosi) {
        this.vuosi = vuosi;
    }

    public String getJulkaisija() {
        return julkaisija;
    }

    public void setJulkaisija(String julkaisija) {
        this.julkaisija = julkaisija;
    }

    public String getTunnus() {
        return tunnus;
    }
    
    public void setTunnus(String tunnus) {
        this.tunnus = tunnus;
    }

    @Override
    public List<Arvo> palautaKaikkiArvot() {
        List<Arvo> kaikkiArvot = new ArrayList<Arvo>();
        kaikkiArvot.add(new Arvo("author", tekija));
        kaikkiArvot.add(new Arvo("title", teoksenNimi));
        kaikkiArvot.add(new Arvo("publisher", julkaisija));
        kaikkiArvot.add(new Arvo("year", ""+vuosi));
        return kaikkiArvot;
    }
    
    
}