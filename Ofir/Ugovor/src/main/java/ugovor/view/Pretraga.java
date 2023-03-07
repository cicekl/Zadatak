/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ugovor.view;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import ugovor.model.Korisnik;
import static ugovor.util.SearchDatabase.searchDatabase;

/**
 *
 * @author Lorena
 */
public class Pretraga extends javax.swing.JFrame {

    /**
     * Creates new form Pretraga
     */
    public Pretraga() {
        initComponents();
        setTitle("Pretraga korisnika");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUnos = new javax.swing.JTextField();
        btnPretraga = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstLista = new javax.swing.JList<>();
        btnPohrani = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnPretraga.setText("Pretraži");
        btnPretraga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretragaActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstLista);

        btnPohrani.setText("Pohrani u ugovor");
        btnPohrani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPohraniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtUnos, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(btnPretraga)))
                .addGap(68, 68, 68)
                .addComponent(btnPohrani, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(351, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnPohrani, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPretraga))
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(249, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPretragaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretragaActionPerformed
        lstLista.clearSelection();
        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> list = new JList<>( model );
        String s = txtUnos.getText();
        String upit = "ime";
        ArrayList<Korisnik> marija = new ArrayList<Korisnik>(searchDatabase(s,upit));
        for(Korisnik k:marija){
        model.addElement(k.getIme() + " " + k.getPrezime() + " " + k.getOIB());
        lstLista.setModel(model);
        // txtRez.setText(k.getIme() + " " + k.getPrezime() + "\n");
        }


    }//GEN-LAST:event_btnPretragaActionPerformed

    private void btnPohraniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPohraniActionPerformed
            
        
      //  DefaultListModel<String> model = new DefaultListModel<>();
       // JList<String> list = new JList<>( model );
       //  String selectedItem = lstLista.getSelectedValue();
         String selectedItem = lstLista.getSelectedValue();
         String [] words = selectedItem.split("\\s");
         selectedItem = words[2];
    
    // Query the database for the name corresponding to the selected item
        String upit = "OIB";
        ArrayList<Korisnik> odabrano = new ArrayList<Korisnik>(searchDatabase(selectedItem,upit));
       for(Korisnik k:odabrano){
        Document document = new Document("C:\\Users\\Lorena\\Documents\\potpora.test.docx");

        // Replace a specific text
        document.replace("<ime>", k.getIme(), false, true);
        document.replace("<prezime>", k.getPrezime(), false, true);
        document.replace("<adresa>", k.getUlica(), false, true);
        document.replace("<kucniBroj>", k.getKucniBroj(), false, true);
        document.replace("<oib>", k.getOIB(), false, true);
        
    

        //Save the result document
        document.saveToFile("C:\\Users\\Lorena\\Documents\\"+k.getIme()+k.getPrezime()+".docx",FileFormat.Docx); 
       // txtPoruka.setText(k.getKucniBroj()); }
       
       JOptionPane.showMessageDialog(null, "Ugovor uspješno popunjen!");
       
       }
       
//            lstLista.addMouseListener(new MouseAdapter() {
//         public void mouseClicked(MouseEvent me) {
//            if (me.getClickCount() == 1) {
//               JList target = (JList)me.getSource();
//               int index = target.locationToIndex(me.getPoint());
//               if (index >= 0) {
//                  Object item = target.getModel().getElementAt(index);
//                   JOptionPane.showMessageDialog(null, item.toString());
//               }
//            }
//         }
//      });

    }//GEN-LAST:event_btnPohraniActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPohrani;
    private javax.swing.JButton btnPretraga;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lstLista;
    private javax.swing.JTextField txtUnos;
    // End of variables declaration//GEN-END:variables
}
