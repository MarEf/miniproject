/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viitemanageri.io;

/**
 *
 * @author glindstr@cs
 */
public interface Io {
    void tulosta(String viesti);
    int lueInt(String kysymys);
    String lueString(String kysymys);
}
