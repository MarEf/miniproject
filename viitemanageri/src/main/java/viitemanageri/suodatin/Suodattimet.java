/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viitemanageri.suodatin;

import java.util.ArrayList;
import java.util.List;
import viitemanageri.io.Io;
import viitemanageri.viitteet.Viite;

/**
 *
 * @author test
 */
public class Suodattimet {
    private List<Suodatin> listaSuodattimista;
    private final Io io;
    
    public Suodattimet(Io io){
        this.listaSuodattimista = new ArrayList<>();
        this.io = io;
    }
    
    public void lisaaSuodatin(String suodatin, int tyyppi, int sisaltyyko){
        boolean saakoSuodatinSisaltyaViitteeseen=false;
        if(sisaltyyko==1){
            saakoSuodatinSisaltyaViitteeseen=true;
        }
        Suodatin s = new Suodatin(suodatin, tyyppi, saakoSuodatinSisaltyaViitteeseen);
        listaSuodattimista.add(s);
        
    }
    
    public List<Viite> palautaSuodatettuLista(List<Viite> viitteet){
        List<Viite> suodatettuLista = new ArrayList<Viite>();
        for(Viite x:viitteet){
            if(tarkistaOnkoViiteEhtojenMukainen(x)){
                suodatettuLista.add(x);
            }
        }
        
        return suodatettuLista;
    }
    
    
    public void nollaaSuodattimet(){
        listaSuodattimista = new ArrayList<>();
    }

    private boolean tarkistaOnkoViiteEhtojenMukainen(Viite x) {
        for(Suodatin z:listaSuodattimista){
            if(!z.OnkoViiteEhtojenMukainen(x)){
                return false;
            }
        }
        return true;
    }

    public void listaaSuodattimet() {
        for(Suodatin z:listaSuodattimista){
            io.tulosta(z.toString());
        }
    }
    
    
    
}
