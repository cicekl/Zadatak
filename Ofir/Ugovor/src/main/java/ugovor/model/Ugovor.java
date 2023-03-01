/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugovor.model;

import jakarta.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Lorena
 */

@Entity
public class Ugovor extends Entitet{
    
    private String brojUgovora;
    private BigDecimal cijena;
    private String cijenaSlovima;
    private String nazivProjekta;
    private Date datum;
    

    public String getBrojUgovora() {
        return brojUgovora;
    }

    public void setBrojUgovora(String brojUgovora) {
        this.brojUgovora = brojUgovora;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    public String getCijenaSlovima() {
        return cijenaSlovima;
    }

    public void setCijenaSlovima(String cijenaSlovima) {
        this.cijenaSlovima = cijenaSlovima;
    }

    public String getNazivProjekta() {
        return nazivProjekta;
    }

    public void setNazivProjekta(String nazivProjekta) {
        this.nazivProjekta = nazivProjekta;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Ugovor() {
    }

    public Ugovor(String brojUgovora, BigDecimal cijena, String cijenaSlovima, String nazivProjekta, Date datum, Integer ID) {
        super(ID);
        this.brojUgovora = brojUgovora;
        this.cijena = cijena;
        this.cijenaSlovima = cijenaSlovima;
        this.nazivProjekta = nazivProjekta;
        this.datum = datum;
    }
    
    
    
}
