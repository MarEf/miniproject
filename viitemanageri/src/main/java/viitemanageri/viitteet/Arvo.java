/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viitemanageri.viitteet;

/**
 *
 * @author test
 */
public class Arvo {
    private String arvo;
    private String muuttuja;
    
    public Arvo(String muuttuja, String arvo){
        this.muuttuja = muuttuja;
        this.arvo = arvo;
    }
    
    public String getMuuttuja(){
        return muuttuja;
    }
    
    public String getArvo(){
        return arvo;
    }
    
}
