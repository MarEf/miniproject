

package viitemanageri.io;

import viitemanageri.io.Io;
import java.util.Scanner;

/**
 *
 * @author glindstr@cs
 */
public class KonsoliIo implements Io {
    
   private Scanner lukija;

    public KonsoliIo(Scanner lukija) {
        this.lukija = lukija;
    }      

    @Override
    public int lueInt(String kysymys) {
        while (true) {
            try {
                return Integer.parseInt(lueString(kysymys));
            } catch (NumberFormatException e) {
                tulosta("Virhe numeron muunnossa, koita uudelleen.");
            }
        }
    }

    @Override
    public String lueString(String kysymys) {
        tulosta(kysymys + " ");
        String temp;
        while (true) {
            temp = lukija.nextLine();
            if (!temp.isEmpty()) {
                return temp;
            } else {
                tulosta("Ei saa olla tyhjä!");
            }
        }
    }

    @Override
    public void tulosta(String viesti) {
        System.out.println(viesti);
    }
    
}
