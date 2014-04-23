/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viitemanageri.suodatin;



import java.util.List;
import viitemanageri.viitteet.Viite;

/**
 *
 * @author test
 * 
 * 
 */
   
    
public class Suodatin {
    private final String suodatin; 
    private final int tyyppi;
    private final boolean sisaltyyko;
     
    
    public Suodatin(String suodatin, int tyyppi, boolean sisaltyyko){ 
        this.suodatin = suodatin;
        this.tyyppi = tyyppi;
        this.sisaltyyko = sisaltyyko;
    } 

    public boolean OnkoViiteEhtojenMukainen(Viite x) {
        
        if(sisaltyyko){
            if(tyyppi == 1){
                return x.getKirjoittaja().contains(suodatin);
            }else if(tyyppi == 2){
                return true;
            }else if(tyyppi == 3){
                return Integer.toString(x.getVuosi()).contains(suodatin);
            }
            
        }else{
            
            if(tyyppi == 1){
                return !x.getKirjoittaja().contains(suodatin);
            }else if(tyyppi == 2){
                return !true;
            }else if(tyyppi == 3){
                return !Integer.toString(x.getVuosi()).contains(suodatin);
            }
        }
        return true;
    }
    
    private String tyyppi(){
        if(tyyppi == 1){
            return "tekijä";
        }else if(tyyppi == 2){
            return "";
        }else if(tyyppi == 3){
            return "vuosi";
        }
        return "";
    }
    
    private String sisaltyyko() {
        if(sisaltyyko){
            return "kyllä";
        }
        
        return "ei";
    }
    public String toString(){
        return "\tSuodatusperuste: "+tyyppi() +"\n\t Suodatin: "+suodatin+"\n\t"+" Sisaltyykö: " + sisaltyyko()+"\n";
    }
 
     
}