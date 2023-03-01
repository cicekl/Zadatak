/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugovor.controller;

import java.math.BigDecimal;
import java.util.List;
import ugovor.model.Ugovor;
import ugovor.util.OfirException;

/**
 *
 * @author Lorena
 */
public class ObradaUgovor extends Obrada<Ugovor> {

    @Override
    public List<Ugovor> čitanje() {
        return session.createQuery("from Ugovor", Ugovor.class).list();
    }

    @Override
    protected void kontrolaUnos() throws OfirException {
        kontrolaBrojaUgovora();
        kontrolaCijene();
        kontrolaNazivaProjekta();
        
    }

    @Override
    protected void kontrolaPromjena() throws OfirException {
    }

    @Override
    protected void kontrolaBrisanje() throws OfirException {
    }

    private void kontrolaPostojanjaBrojaUgovora() throws OfirException {
        if(entitet.getBrojUgovora()==null || entitet.getBrojUgovora().length()<=0 || entitet.getBrojUgovora().length()>12) {
            throw new OfirException("Broj ugovora mora biti postavljen! Maksimalan broj znakova koji treba sadržavati je 12.");
        }
        
    }

    private void kontrolaBrojaUgovora() throws OfirException {
    kontrolaPostojanjaBrojaUgovora();
    kontrolaDuplogBrojaUgovora();

    }

    private void kontrolaDuplogBrojaUgovora() throws OfirException {
     List<Ugovor> ugovori = null;
     try {
         ugovori = session.createQuery("from Ugovor" + " where u.brojUgovora:=brojUgovora",Ugovor.class).setParameter("brojUgovora",entitet.getBrojUgovora()).list();
         if(ugovori!=null && !ugovori.isEmpty()) {
         throw new OfirException("Već postoji ugovor s istim brojem ugovora u bazi!");
     }
     }catch (OfirException e) {
         
     }
        
    }

    private void kontrolaCijene() throws OfirException {
        kontrolaPostojanjaCijene();
    }

    private void kontrolaPostojanjaCijene() throws OfirException {
        if(entitet.getCijena()==null || entitet.getCijena().compareTo(BigDecimal.ZERO)<=0 || entitet.getCijena().compareTo(new BigDecimal(1000000))==1) {
            
            throw new OfirException("Cijena mora biti upisana i mora biti veća od 0 ili manja od 100 000!");
            
        }
    }

    private void kontrolaNazivaProjekta() throws OfirException {
        kontrolaPostojanjaNaziva();
        kontrolaNazivBroj();
        
    }

    private void kontrolaPostojanjaNaziva() throws OfirException {
        if(entitet.getNazivProjekta()==null) {
            throw new OfirException("Naziv projekta mora biti postavljen!");
        }
    
    }

    private void kontrolaNazivBroj() throws OfirException {
        
         boolean kontrola=false;
        
        try {
            Double.parseDouble(entitet.getNazivProjekta());
            kontrola=true;
            
        } catch (Exception e) {
            
        }
        
        if(kontrola){
            throw new OfirException("Naziv projekta ne smije biti broj!");
        }
        
    }
        
    }
    
    
    

