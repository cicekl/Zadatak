/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugovor.util;
import ugovor.model.Ugovor;

import com.github.javafaker.Faker;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import ugovor.model.Korisnik;

/**
 *
 * @author Lorena
 */
public class ProbniPodatci {

    
    private Faker faker;
    private List<Ugovor> ugovor;
    private List<Korisnik> korisnik;
   private Session session;
   
   public static void izvedi() {
      new ProbniPodatci();
   }
   
   public ProbniPodatci() {
       faker = new Faker();
       ugovor = new ArrayList<>();
       korisnik = new ArrayList<>();
       session = HibernateUtil.getSession();
       session.beginTransaction();
       kreirajKorisnika();
       kreirajUgovor();
       session.getTransaction().commit();
   }

    public void kreirajKorisnika() {
        Korisnik k;
            for(int i=0;i<5;i++) {
            k = new Korisnik();
            k.setIme(faker.name().firstName());
            k.setPrezime(faker.name().lastName());
            k.setEmail(faker.internet().emailAddress());
            k.setIBAN(faker.business().creditCardNumber());
            k.setUlica(faker.address().streetAddress());
            k.setKucniBroj(faker.address().streetAddressNumber());
            session.persist(k);
            korisnik.add(k);
            }
    }

    private void kreirajUgovor() {
        Ugovor u = new Ugovor();
        for(int i=0;i<5;i++) {
        u.setBrojUgovora(faker.number().digits(6));
        u.setCijena(new BigDecimal(faker.number().randomNumber()));
        u.setCijenaSlovima(faker.animal().name());
        u.setNazivProjekta(faker.name().name());
        u.setDatum(faker.date().birthday());
        session.persist(u);
        ugovor.add(u);
    }
    }
    
    
}
