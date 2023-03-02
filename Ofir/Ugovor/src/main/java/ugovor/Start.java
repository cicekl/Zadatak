/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ugovor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import ugovor.controller.ObradaKorisnik;
import ugovor.model.Korisnik;
import ugovor.util.OfirException;
import ugovor.util.ProbniPodatci;
import ugovor.view.PrikazUgovora;
import ugovor.view.Prozor;
import ugovor.view.test;


/**
 *
 * @author Lorena
 */
public class Start {

    public static void main(String[] args) {
       
        //ProbniPodatci.izvedi();
        
        //new Prozor().setVisible(true);
        new test().setVisible(true);
                
        String fileName = "C:\\Users\\Lorena\\Downloads\\ugovor.txt";
        String oldWord = "<bozepomozi>";
        String newWord = "proba";

        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }
            reader.close();

            String fileContent = stringBuilder.toString();
            String newFileContent = fileContent.replaceAll(oldWord, newWord);

            FileWriter writer2 = new FileWriter("C:\\Users\\Lorena\\Downloads\\"+newWord+".txt");
            writer2.write(newFileContent);
            writer2.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing to the file.");
            e.printStackTrace();
        }
        
        
    }
}
