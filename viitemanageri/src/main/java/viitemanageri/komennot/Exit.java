/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viitemanageri.komennot;

/**
 *
 * @author glindstr
 */
public class Exit implements Komento{

    @Override
    public void suorita() {
        System.exit(0);
    }

    
}
