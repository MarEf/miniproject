/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viitemanageri.logiikka;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author test
 */
public class Tallenna {
    
    public Tallenna(){
        
    }
    
    /**
     *
     * @param tallennettavaData 
     * @param sijainti sijainti johon tiedosto tallennetaan ilman /-merkkiä lopussa
     * @param tiedostonNimi tallennettavan tiedoston nimi
     * @return palauttaa tiedon onnistumisesta
     */
    public boolean tallennaTiedosto(
            String tallennettavaData, 
            String sijainti, 
            String tiedostonNimi){
        
        try {
            FileOutputStream tiedosto;
            tiedosto = new FileOutputStream(sijainti+"/"+tiedostonNimi);
            
            tiedosto.write(tallennettavaData.getBytes());
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
        
        
        return true;
        
    }
    
}
