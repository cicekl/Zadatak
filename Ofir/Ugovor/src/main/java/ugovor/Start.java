/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ugovor;

import javax.swing.JOptionPane;
import ugovor.controller.ObradaKorisnik;
import ugovor.model.Korisnik;
import ugovor.util.OfirException;
import ugovor.util.ProbniPodatci;
import ugovor.view.PregledUgovora;
import ugovor.view.PrikazUgovora;
import ugovor.view.Prozor;
import ugovor.view.Test;


/**
 *
 * @author Lorena
 */
public class Start {

    public static void main(String[] args) {
       
        //ProbniPodatci.izvedi();
        
        //new Prozor().setVisible(true);
        int i = Integer.parseInt(JOptionPane.showInputDialog("Za unos korisnika unesite 1, za otvaranje dokumenta unesite 2"));
        
        switch (i) {
            case 1:
                new Prozor().setVisible(true);
                
                break;
            case 2:
                new Test().setVisible(true);
                break;
                
        }
        
        
                
        
        
        
    }
}
