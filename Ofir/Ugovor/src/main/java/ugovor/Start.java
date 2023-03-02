/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ugovor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTText;
import ugovor.controller.ObradaKorisnik;
import ugovor.model.Korisnik;
import ugovor.util.OfirException;
import ugovor.util.ProbniPodatci;
import ugovor.view.PrikazUgovora;
import ugovor.view.Prozor;

/**
 *
 * @author Lorena
 */
public class Start {

    public static void main(String[] args) throws IOException {

        //ProbniPodatci.izvedi();
        new Prozor().setVisible(true);

       String fileName = "C:\\Users\\Lorena\\Downloads\\ugovor.txt";
        String oldWord = "<kristijan>";
        String newWord = "bozepomozi";

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
            String newFileContent = fileContent.replaceAll(oldWord,newWord);

            FileWriter writer = new FileWriter(fileName);
            writer.write(newFileContent);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing to the file.");
            e.printStackTrace();
        }

    }
}
