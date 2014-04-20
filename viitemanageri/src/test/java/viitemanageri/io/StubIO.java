package viitemanageri.io;

import java.util.ArrayList;
import viitemanageri.io.Io;
import viitemanageri.io.Io;

/**
 *
 * @author maef
 */
public class StubIO implements Io{

    private String[] rivit;
    private int i;
    private ArrayList<String> prints;

    public StubIO(String... arvot) {
        this.rivit = arvot;
        prints = new ArrayList<String>();
    }
    
    public void tulosta(String viesti) {
        prints.add(viesti);
    }

    public int lueInt(String kysymys) {
        tulosta(kysymys);
        return Integer.parseInt(rivit[i++]);
    }

    public ArrayList<String> getPrints() {
        return prints;
    }

    public String lueString(String kysymys) {
        tulosta(kysymys);
        if (i < rivit.length) {
           return rivit[i++]; 
        }
        return "";
    }
    
}
