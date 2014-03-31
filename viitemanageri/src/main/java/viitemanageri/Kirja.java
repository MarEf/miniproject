

package viitemanageri;

/**
 *
 * @author glindstr@cs
 */
public class Kirja implements Viite {

   private String tekija;
   private String teoksenNimi;
   private int vuosi;
   private String julkaisija;

    public Kirja(String tekija, String teoksenNimi, int vuosi, String julkaisija) {
        this.tekija = tekija;
        this.teoksenNimi = teoksenNimi;
        this.vuosi = vuosi;
        this.julkaisija = julkaisija;
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
    
}
