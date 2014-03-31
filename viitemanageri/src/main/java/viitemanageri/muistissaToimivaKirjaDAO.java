/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viitemanageri;

import java.util.List;

/**
 *
 * @author tboehm
 */
public class muistissaToimivaKirjaDAO implements KirjaDAO{
    
    private List<Kirja> kirjat;
    

    @Override
    public List<Kirja> listaaKaikki() {
        return kirjat;
    }

    @Override
    public Kirja etsiNimella(String nimi) {
        for(Kirja k : kirjat){
            if(k.getTeoksenNimi().contains(nimi))
                return k;
        }
        return null;
    }

    @Override
    public void lisaa(Kirja kirja) {
        kirjat.add(kirja);
    }
    
    
}
