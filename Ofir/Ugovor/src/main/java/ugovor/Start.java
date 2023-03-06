/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ugovor;

import java.awt.List;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import org.hibernate.engine.spi.SessionImplementor;
import ugovor.controller.ObradaKorisnik;
import ugovor.model.Korisnik;
import ugovor.util.OfirException;
import ugovor.util.ProbniPodatci;
import ugovor.util.SearchDatabase;
import static ugovor.util.SearchDatabase.searchDatabase;
import ugovor.util.UnosDatuma;
import static ugovor.util.UnosDatuma.UnosDatuma;
import ugovor.view.Prozor;
import ugovor.view.ProzorU;
import ugovor.view.test;
import org.hibernate.Session;

import ugovor.util.HibernateUtil;
import ugovor.view.Pretraga;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;



/**
 *
 * @author Lorena
 */
public class Start {

    public static void main(String[] args) throws ParseException {
        //ProbniPodatci.izvedi();
        //new Prozor().setVisible(true);
//        int i = Integer.parseInt(JOptionPane.showInputDialog("Za korisnika unesite 1,ugovor 2, dokument 3"));
//        
//        switch (i) {
//            case 1:
//                new Prozor().setVisible(true);
//                
//                break;
//            case 2:
//               new ProzorU().setVisible(true);
//                break;
//            case 3:
//                 new test().setVisible(true);
//                break;
//                
//            default :
//                JOptionPane.showMessageDialog(null, "Izlaz iz programa");
//               
//                break;
//
//
//             
//        }
        // new Pretraga().setVisible(true);
        // System.out.println(UnosDatuma("2","3","2002")); 
        // ArrayList<Korisnik> korisnici = new ArrayList<>();
        //       ArrayList<Korisnik> marija = new ArrayList<Korisnik>(searchDatabase("Otis"));
//        for (Korisnik k: korisnici) {
//            korisnici.add()
//            
//        }
        //  for(Korisnik k:marija){
        // System.out.println(k.getIme() + " " + k.getPrezime()); 
       
         Document document = new Document("C:\\Users\\Kristijan\\Desktop\\Ugovor\\ugovor.docx");

        // Replace a specific text
        document.replace("<ime>", "Otis", false, true);
        document.replace("<prezime>", "Otiskovic", false, true);
        document.replace("<adresa>", "Prilaz", false, true);
        document.replace("<kucniBroj>", "2H", false, true);
        document.replace("<oib>", "64145066861", false, true);
        
        

        //Save the result document
        document.saveToFile("C:\\Users\\Kristijan\\Desktop\\Ugovor\\saOtisom.docx", FileFormat.Docx);
        
        new Pretraga().setVisible(true);
    }
       
    }
        
        
//        Session session = HibernateUtil.getSession();
//        session.createQuery("from Korisnik",
//                Korisnik.class).list();
        
  //      System.out.println(marija.toString());
    
        
        
        
    
    
    

