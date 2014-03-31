/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viitemanageri;

import viitemanageri.viitteet.Kirja;
import java.util.List;

/**
 *
 * @author tboehm
 */
public interface KirjaDAO {
    
    List<Kirja> listaaKaikki();
    Kirja etsiNimella(String nimi);
    void lisaa(Kirja kirja);
    
    
}
