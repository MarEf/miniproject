

package viitemanageri;

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
        System.out.println(kysymys + " ");
        return Integer.parseInt(lukija.nextLine());
    }

    @Override
    public String lueString(String kysymys) {
        System.out.println(kysymys + " ");
        return lukija.nextLine();
    }
    
}
