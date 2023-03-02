/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugovor.controller;

import java.util.List;
import ugovor.model.Korisnik;
import ugovor.util.DovlacenjeOIBA;
import ugovor.util.OfirException;

/**
 *
 * @author Korisnik
 */
public class ObradaKorisnik extends Obrada<Korisnik> {

    @Override
    public List<Korisnik> čitanje() {
        return session.createQuery("from Korisnik", Korisnik.class).list();
    }

    @Override
    protected void kontrolaUnos() throws OfirException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaImeNull();

    }

    @Override
    protected void kontrolaPromjena() throws OfirException {
        kontrolaImeNull();
    }

    @Override
    protected void kontrolaBrisanje() throws OfirException {

    }

    private void konrolaOib() throws OfirException {
        if (!DovlacenjeOIBA.kontrolaOIB((entitet.getOIB()))) {
            throw new OfirException("Oib nije u dobrom formatu");

        }
    }

    private void kontrolaIme() throws OfirException {

        boolean broj = false;

        try {
            Double.parseDouble(entitet.getIme());
            
            broj = true;
        } catch (Exception e) {

        }
        if (broj) {
            throw new OfirException("Ime ne moze biti broj");
        }

    }
    private void kontrolaPrezime() throws OfirException {

        boolean broj = false;

        try {
            Double.parseDouble(entitet.getPrezime());
            
            broj = true;
        } catch (Exception e) {

        }
        if (broj) {
            throw new OfirException("Prezime ne moze biti broj");
        }

    }

    private void kontrolaImeNull() throws OfirException {
        if (entitet.getIme() == null) {
            throw new OfirException("Ime i prezime ne smije biti prazno");
        }
        
    }
    
   

}
