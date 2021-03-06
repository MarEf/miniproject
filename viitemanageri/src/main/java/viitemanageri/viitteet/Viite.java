

package viitemanageri.viitteet;

import java.util.List;

/**
 *
 * @author glindstr@cs
 */
public interface Viite {
    
    public List<Arvo> palautaKaikkiArvot();

    public String getTunnus();
    
    public String getTyyppi();
    
    public int getVuosi();
    
    public String getKirjoittaja();
    
    public String getTeoksenNimi();
    
}
