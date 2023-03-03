/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ugovor;

import java.math.BigDecimal;
import java.text.ParseException;
import javax.swing.JOptionPane;
import ugovor.controller.ObradaKorisnik;
import ugovor.model.Korisnik;
import ugovor.util.OfirException;
import ugovor.util.ProbniPodatci;
import ugovor.util.UnosDatuma;
import static ugovor.util.UnosDatuma.UnosDatuma;
import ugovor.view.Prozor;
import ugovor.view.ProzorU;
import ugovor.view.test;


/**
 *
 * @author Lorena
 */
public class Start {

    public static void main(String[] args) throws ParseException {
       
        //ProbniPodatci.izvedi();
        
        // new Prozor().setVisible(true);
        int i = Integer.parseInt(JOptionPane.showInputDialog("Za korisnika unesite 1,ugovor 2, dokument 3"));
        
        switch (i) {
            case 1:
                new Prozor().setVisible(true);
                
                break;
            case 2:
               new ProzorU().setVisible(true);
                break;
            case 3:
                 new test().setVisible(true);
                break;
                
            default :
                JOptionPane.showMessageDialog(null, "Izlaz iz programa");
               
                break;

           
             
        }
        
      //  System.out.println(UnosDatuma("2","3","2002"));
                
        
        
    }
}
