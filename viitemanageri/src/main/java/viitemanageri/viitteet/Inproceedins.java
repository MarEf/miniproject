/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viitemanageri.viitteet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maria
 */
public class Inproceedins implements Viite{
    
    private String tekija;
    private String otsikko;
    private String teos;
    private int vuosi;
    private int alkusivu;
    private int loppusivu;
    private String julkaisija;
    private String tunnus;

    public Inproceedins(String tekija, String otsikko, String teos, int vuosi, int alkusivu, int loppusivu, String julkaisija, String tunnus) {
        this.tekija = tekija;
        this.otsikko = otsikko;
        this.teos = teos;
        this.vuosi = vuosi;
        this.alkusivu = alkusivu;
        this.loppusivu = loppusivu;
        this.julkaisija = julkaisija;
        this.tunnus = tunnus;
    }

    public String getTekija() {
        return tekija;
    }

    public void setTekija(String tekija) {
        this.tekija = tekija;
    }

    public String getOtsikko() {
        return otsikko;
    }

    public void setOtsikko(String otsikko) {
        this.otsikko = otsikko;
    }

    public String getTeos() {
        return teos;
    }

    public void setTeos(String teos) {
        this.teos = teos;
    }

    public int getVuosi() {
        return vuosi;
    }

    public void setVuosi(int vuosi) {
        this.vuosi = vuosi;
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

    public String getJulkaisija() {
        return julkaisija;
    }

    public void setJulkaisija(String julkaisija) {
        this.julkaisija = julkaisija;
    }

    public void setTunnus(String tunnus) {
        this.tunnus = tunnus;
    }
    
    @Override
    public List<Arvo> palautaKaikkiArvot() {
        List<Arvo> kaikkiArvot = new ArrayList<Arvo>();
        kaikkiArvot.add(new Arvo("author", tekija));
        kaikkiArvot.add(new Arvo("title", otsikko));
        kaikkiArvot.add(new Arvo("booktitle", teos));
        kaikkiArvot.add(new Arvo("year", ""+vuosi));
        kaikkiArvot.add(new Arvo("pages", alkusivu+"--"+loppusivu));
        kaikkiArvot.add(new Arvo("publisher", julkaisija));
        return kaikkiArvot;
    }

    @Override
    public String getTunnus() {
        return tunnus;
    }
    
    @Override
    public String toString() {
        return "Inproceedings{" + "tekija=" + tekija + ", otsikko=" + otsikko + ", teos=" + teos + ", vuosi=" + vuosi + ", sivut=" + alkusivu+"--"+loppusivu + ", julkaisija=" + julkaisija + ", tunnus=" + tunnus + '}';
    }
}