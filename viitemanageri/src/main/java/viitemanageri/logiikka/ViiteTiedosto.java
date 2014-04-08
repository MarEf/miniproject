/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viitemanageri.logiikka;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream; 
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import viitemanageri.viitteet.Viite;
import viitemanageri.viitteet.Kirja;

/**
 *
 * @author test
 */
public class ViiteTiedosto{
    
    private final String tiedostonNimi;
    
    public ViiteTiedosto(String tiedostonNimi){
        this.tiedostonNimi = tiedostonNimi;
        
    }
    
    
    public void paivitaTiedosto(List<Viite> viitteet){
        try {
            ObjectOutputStream tallennus = new ObjectOutputStream(new FileOutputStream(tiedostonNimi));
            tallennus.writeObject(viitteet);
            tallennus.close();
        } catch (IOException ex) {
            Logger.getLogger(ViiteTiedosto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List<Viite> lataaTiedosto(){
        
        List<Viite> viitteet = new ArrayList<Viite>(); 
        
        try {
            ObjectInputStream lataus = new ObjectInputStream(new FileInputStream(tiedostonNimi));
            viitteet = (List<Viite>) lataus.readObject(); 
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            Logger.getLogger(ViiteTiedosto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViiteTiedosto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return viitteet;
        
    }
    
}
