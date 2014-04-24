/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viitemanageri.suodatin;



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
        if (tyyppi<1 || tyyppi>3) {
            return true;
        }
        
        if(sisaltyyko){
            return sisaltyy(x, tyyppi, suodatin);
        }else{
            return eiSisally(x, tyyppi, suodatin);
        }
    }
    
    private String tyyppi(){
        if(tyyppi == 1){
            return "tekijä";
        }else if(tyyppi == 2){
            return "otsikko";
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
        return "  Suodatusperuste: "+tyyppi() +"\n"
                + "  Suodatin: "+suodatin+"\n"
                + "  Sisaltyykö: " + sisaltyyko()+"\n";
    }

    private boolean sisaltyy(Viite x, int tyyppi, String suodatin) {
        if(tyyppi == 1){
                return x.getKirjoittaja().contains(suodatin);
            }else if(tyyppi == 2){
                return x.getTeoksenNimi().contains(suodatin);
            }else if(tyyppi == 3){
                return Integer.toString(x.getVuosi()).contains(suodatin);
            } return false;
    } 

    private boolean eiSisally(Viite x, int tyyppi, String suodatin) {
        if(tyyppi == 1){
                return !x.getKirjoittaja().contains(suodatin);
            }else if(tyyppi == 2){
                return !x.getTeoksenNimi().contains(suodatin);
            }else if(tyyppi == 3){
                return !Integer.toString(x.getVuosi()).contains(suodatin);
            } return false;
    }
 
     
}