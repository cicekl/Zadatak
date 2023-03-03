/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugovor.util;

import static java.lang.String.format;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author Lorena
 */
public class UnosDatuma {
    
    public static Date UnosDatuma(String dan, String mjesec, String godina) throws ParseException {
        
        String datumPrvi = dan+"-"+mjesec+"-"+godina;
        DateFormat datumDrugi = new SimpleDateFormat("yyyy-MM-dd",new Locale("hr"));
        Date datumTreci = null;
        datumTreci = datumDrugi.parse(datumPrvi);
        
        return datumTreci;
    }
    
    
    
}
