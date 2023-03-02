/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ugovor;

import ugovor.controller.ObradaKorisnik;
import ugovor.model.Korisnik;
import ugovor.util.OfirException;
import ugovor.util.ProbniPodatci;

/**
 *
 * @author Lorena
 */
public class Start {

    public static void main(String[] args) {
       
        //ProbniPodatci.izvedi();
        
        ObradaKorisnik ok = new ObradaKorisnik();
        
        
        Korisnik k = new Korisnik();
        k.setIBAN("HR13134358732989432");
        k.setPrezime("Marko4vic");
        k.setUlica("New Street");
        k.setKucniBroj("27"); 
        ok.setEntitet(k);
        try {
            ok.create();
        } catch (OfirException e) {
            System.out.println(e.getPoruka()
            ); 
        }
    }
}
