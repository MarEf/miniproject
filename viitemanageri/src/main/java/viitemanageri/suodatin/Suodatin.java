/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viitemanageri.suodatin;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import viitemanageri.viitteet.Viite;

/**
 *
 * @author test
 * 
 * 
 */
public class Suodatin {
    
    private List<Viite> viitteet;
    
    public Suodatin(List<Viite> viitteet){
        this.viitteet = viitteet;
    }
    
    
    public List<Viite> suodatettuLista(Predicate<Viite> suodatin) {
        /*
        return viitteet
                .stream()
                .filter(suodatin)
                .collect(Collectors.toList());*/
        return null;
    }
    
    
}
