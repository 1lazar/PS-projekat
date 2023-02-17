/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import Communication.Communication;
import domain.Stakla;
import domain.VrsteUsluga;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Laza Laki Lakosta
 */
public class VrstaUslugeForm extends javax.swing.JFrame {
    VrsteUsluga vu;
    /**
     * Creates new form VrstaUslugeForm
     */
    public VrstaUslugeForm() {
        initComponents();
        formWindowActivated();
    }
    public VrstaUslugeForm(java.awt.Frame parent, boolean modal) {
        initComponents();
        formWindowActivated(); 
    }
    public VrstaUslugeForm(VrsteUsluga vrste) {
        initComponents();
        this.vu=vrste;
        formWindowActivated();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textVrsta = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnIzmeni = new javax.swing.JButton();
        btnIzbrisi = new javax.swing.JButton();
        textCena = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        poljeCena = new javax.swing.JTextField();
        btnSacuvaj = new javax.swing.JButton();
        poljeId = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        textId = new javax.swing.JLabel();
        btnOmoguciIzmene = new javax.swing.JButton();
        poljeNaziv = new javax.swing.JTextField();
        btnOtkazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Vrsta:");

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnIzbrisi.setText("Izbrisi");
        btnIzbrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbrisiActionPerformed(evt);
            }
        });

        textCena.setText(" ");

        jLabel4.setText("Cena:");

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        lblId.setText("ID:");

        btnOmoguciIzmene.setText("Omoguci izmene");
        btnOmoguciIzmene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOmoguciIzmeneActionPerformed(evt);
            }
        });

        btnOtkazi.setText("Otkazi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIzmeni)
                        .addGap(18, 18, 18)
                        .addComponent(btnSacuvaj)
                        .addGap(18, 18, 18)
                        .addComponent(btnOmoguciIzmene)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnIzbrisi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(btnOtkazi))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(poljeId, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                    .addComponent(poljeNaziv)
                                    .addComponent(textVrsta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textCena, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                    .addComponent(poljeCena))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(poljeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblId))
                .addGap(4, 4, 4)
                .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(poljeNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(textVrsta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(poljeCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(textCena, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzmeni)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnOmoguciIzmene)
                    .addComponent(btnIzbrisi)
                    .addComponent(btnOtkazi))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
//        try {
//            validacija();
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this, "Fill in the fields");
//        }
//        int id = Integer.parseInt(poljeId.getText());
//        String naziv = poljeNaziv.getText();
//        double cena = Double.parseDouble(poljeCena.getText());
//
//        try {
//
//            VrsteUsluga vrsta = new VrsteUsluga(id, naziv, cena);
//            //Communication.getInstance().editPacijent(p);
//        } catch (Exception ex) {
//            Logger.getLogger(PacijentForm.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnIzbrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbrisiActionPerformed

    }//GEN-LAST:event_btnIzbrisiActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
//        try {
//            validacija();
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this, "Fill in the fields");
//        }
//        int id = Integer.parseInt(poljeId.getText());
//        String naziv = poljeNaziv.getText();
//        double cena = Double.parseDouble(poljeCena.getText());
//
//        try {
//            VrsteUsluga vrsta = new VrsteUsluga(id, naziv, cena);
//            Communication.getInstance().addVrstaUsluge(vrsta);
//        } catch (Exception ex) {
//            Logger.getLogger(PacijentForm.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnOmoguciIzmeneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOmoguciIzmeneActionPerformed
//        btnIzmeni.setEnabled(true);
//        btnOmoguciIzmene.setEnabled(true);
//        btnSacuvaj.setEnabled(true);
//        btnIzbrisi.setEnabled(true);
//        poljeNaziv.setEditable(true);
//        poljeId.setEditable(true);
    }//GEN-LAST:event_btnOmoguciIzmeneActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VrstaUslugeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VrstaUslugeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VrstaUslugeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VrstaUslugeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VrstaUslugeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzbrisi;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnOmoguciIzmene;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField poljeCena;
    private javax.swing.JTextField poljeId;
    private javax.swing.JTextField poljeNaziv;
    private javax.swing.JLabel textCena;
    private javax.swing.JLabel textId;
    private javax.swing.JLabel textVrsta;
    // End of variables declaration//GEN-END:variables
//public void validacija() throws Exception {
//        String error="";
//        String id = poljeId.getText();
//        String naziv = poljeNaziv.getText();
//        String cena = poljeCena.getText();
//        
//        if(id==null || id.isEmpty()){
//            textId.setText("Id cannot be empty!");
//            error += "Id cannot be empty!\n";
//        }
//        if(naziv==null || naziv.isEmpty()){
//            textVrsta.setText("Name cannot be empty!");
//            error += "Name cannot be empty!\n";
//        }
//        if(Double.parseDouble(cena) <=0 ){
//            textCena.setText("Price cannot be zero or negative number!");
//            error += "Price cannot be zero or negative number!\n";
//        }
//        if (!error.isEmpty()) {
//            throw new Exception(error);
//        }
//    }
    private void formWindowActivated() 
    {
        // Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        // Move the window
        this.setLocation(x, y);
    }
//    public void iskljuci(){
//        poljeCena.setEditable(false);
//        poljeId.setEditable(false);
//        poljeNaziv.setEditable(false);
//        btnIzbrisi.setEnabled(false);
//        btnIzmeni.setEnabled(false);
//        btnSacuvaj.setEnabled(false);
//    }

    public JButton getBtnIzbrisi() {
        return btnIzbrisi;
    }

    public JButton getBtnIzmeni() {
        return btnIzmeni;
    }

    public JButton getBtnOmoguciIzmene() {
        return btnOmoguciIzmene;
    }

    public JButton getBtnOtkazi() {
        return btnOtkazi;
    }

    public JButton getBtnSacuvaj() {
        return btnSacuvaj;
    }

    public JTextField getPoljeCena() {
        return poljeCena;
    }

    public JTextField getPoljeId() {
        return poljeId;
    }

    public JTextField getPoljeNaziv() {
        return poljeNaziv;
    }

    public JLabel getTextCena() {
        return textCena;
    }

    public JLabel getTextId() {
        return textId;
    }

    public JLabel getTextVrsta() {
        return textVrsta;
    }
    public void addSacuvajBtnActionListener(ActionListener actionListener) {
        btnSacuvaj.addActionListener(actionListener);
    }

    public void addOmoguciIzmeneBtnActionListener(ActionListener actionListener) {
        btnOmoguciIzmene.addActionListener(actionListener);
    }

    public void addOtkaziBtnActionListener(ActionListener actionListener) {
        btnOtkazi.addActionListener(actionListener);
    }

    public void addIzmeniBtnActionListener(ActionListener actionListener) {
        btnIzmeni.addActionListener(actionListener);
    }

    public void addObrisiBtnActionListener(ActionListener actionListener) {
        btnIzbrisi.addActionListener(actionListener);
    }
}