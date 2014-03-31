

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
    
}
