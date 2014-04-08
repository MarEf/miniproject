/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viitemanageri.viitteet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maria
 */
public class Artikkeli implements Viite, Serializable{
    
    private String kirjoittaja;
    private String otsikko;
    private String lehti;
    private int vuosi;
    private int nidenumero;
    private int numero;
    private int alkusivu;
    private int loppusivu;
    private String tunnus;
    private final String bibtexTyyppi = "@article";

    public Artikkeli(String kirjoittaja, String otsikko, String lehti, int vuosi, int nidenumero, int numero, int alkusivu, int loppusivu, String tunnus) {
        this.kirjoittaja = kirjoittaja;
        this.otsikko = otsikko;
        this.lehti = lehti;
        this.vuosi = vuosi;
        this.nidenumero = nidenumero;
        this.numero = numero;
        this.alkusivu = alkusivu;
        this.loppusivu = loppusivu;
        this.tunnus = tunnus;
    }

    public String getKirjoittaja() {
        return kirjoittaja;
    }

    public void setKirjoittaja(String kirjoittaja) {
        this.kirjoittaja = kirjoittaja;
    }

    public String getOtsikko() {
        return otsikko;
    }

    public void setOtsikko(String otsikko) {
        this.otsikko = otsikko;
    }

    public String getLehti() {
        return lehti;
    }

    public void setLehti(String lehti) {
        this.lehti = lehti;
    }

    public int getVuosi() {
        return vuosi;
    }

    public void setVuosi(int vuosi) {
        this.vuosi = vuosi;
    }

    public int getNidenumero() {
        return nidenumero;
    }

    public void setNidenumero(int nidenumero) {
        this.nidenumero = nidenumero;
    }

    public int getAlkusivu() {
        return alkusivu;
    }

    public void setAlkusivu(int alkusivu) {
        this.alkusivu = alkusivu;
    }

    public int getLoppusivu() {
        return loppusivu;
    }

    public void setLoppusivu(int loppusivu) {
        this.loppusivu = loppusivu;
    }
    
    @Override
    public String getTunnus() {
        return tunnus;
    }

    public void setTunnus(String tunnus) {
        this.tunnus = tunnus;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    

    @Override
    public List<Arvo> palautaKaikkiArvot() {
        List<Arvo> kaikkiArvot = new ArrayList<Arvo>();
        kaikkiArvot.add(new Arvo("author", kirjoittaja));
        kaikkiArvot.add(new Arvo("title", otsikko));
        kaikkiArvot.add(new Arvo("journal", lehti));
        kaikkiArvot.add(new Arvo("volume", ""+nidenumero));
        kaikkiArvot.add(new Arvo("number", ""+numero));
        kaikkiArvot.add(new Arvo("year", ""+vuosi));        
        kaikkiArvot.add(new Arvo("pages", alkusivu+"--"+loppusivu));
        return kaikkiArvot;
    }
    
    @Override
    public String toString() {
        return "Artikkeli{" + "kirjoittaja=" + kirjoittaja+ ", lehti=" + lehti + ", vuosi="+ vuosi+", nidenumero="+nidenumero+ ", numero="+numero + ", sivut="+alkusivu+"--"+loppusivu+ ", tunnus=" + tunnus + '}';
    }

    @Override
    public String getTyyppi() {
        return bibtexTyyppi;
    }
}
