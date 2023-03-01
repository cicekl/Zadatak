/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ugovor;

import ugovor.model.Korisnik;
import ugovor.util.ProbniPodatci;

/**
 *
 * @author Lorena
 */
public class Start {

    public static void main(String[] args) {
       
        //ProbniPodatci.izvedi();
        Korisnik k = new Korisnik();
        k.setIme("11Ado");
        k.setIBAN("HR13134358732989432");
        k.setPrezime("Markovic");
        k.setUlica("New Street");
        k.setKucniBroj("27"); 
    }
}
