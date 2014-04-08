/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viitemanageri.logiikka;

import java.util.Iterator;
import java.util.List;
import viitemanageri.viitteet.Arvo;
import viitemanageri.viitteet.Viite;

/**
 *
 * @author test
 */
public class Muunnin {
    
    public Muunnin(){
        
    }
    
    
    public String muunnaViitteetBibtexMuotoon(List<Viite> listaViitteista){
        String bibtexMuodossaViitteet = "";
        for(Viite viite:listaViitteista){
            bibtexMuodossaViitteet += muunnaViiteBibtexMuotoon(viite);
        }
        
        return bibtexMuodossaViitteet;
        
    }
    
    private String muunnaViiteBibtexMuotoon(Viite muunnettavaViite){
        
        String bibtex = "@book{"+muunnettavaViite.getTunnus()+",\n";
        
        for (Arvo xa: muunnettavaViite.palautaKaikkiArvot()){
            bibtex += xa.getMuuttuja();
            bibtex += " = {";
            bibtex += muunnaEiYhteensopivatMerkitYhteensopiviksi(xa.getArvo());
            bibtex += "},\n";
        }
        
        bibtex += "}\n\n";
        System.out.print(bibtex);
        return bibtex;
        
    }
    
    private String muunnaEiYhteensopivatMerkitYhteensopiviksi(String muunnettava){
         
        muunnettava = muunnettava.replace("ä", "\\\"{a}");  
        muunnettava = muunnettava.replace("ö", "\\\"{o}"); 
        muunnettava = muunnettava.replace("å", "\\aa"); 
        
        muunnettava = muunnettava.replace("Ä", "\\\"{A}");  
        muunnettava = muunnettava.replace("Ö", "\\\"{O}"); 
        muunnettava = muunnettava.replace("Å", "\\AA"); 
        
        return muunnettava;
    }
    
}
