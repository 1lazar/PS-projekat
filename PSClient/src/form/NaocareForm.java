/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import Communication.Communication;
import domain.Naocare;
import java.awt.Dimension;
import java.awt.Frame;
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
public class NaocareForm extends javax.swing.JFrame {
    Naocare naocare;
    /**
     * Creates new form NaocareForm
     */
    public NaocareForm() {
        initComponents();
        //iskljuci();
    }
    public NaocareForm(java.awt.Frame parent, boolean modal) {
        initComponents();
    }
    public NaocareForm(Naocare naocare) {
        initComponents();
        formWindowActivated();
        this.naocare=naocare;
        //popuni();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        poljeModel = new javax.swing.JTextField();
        poljeMarka = new javax.swing.JTextField();
        btnIzmeni = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();
        btnOmoguciIzmene = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnIzbrisi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        poljeKolicina = new javax.swing.JTextField();
        poljeId = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textKolicina = new javax.swing.JLabel();
        textId = new javax.swing.JLabel();
        textMarka = new javax.swing.JLabel();
        textModel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        poljeCena = new javax.swing.JTextField();
        textCena = new javax.swing.JLabel();
        btnOtkazi = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnOmoguciIzmene.setText("Omoguci izmene");
        btnOmoguciIzmene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOmoguciIzmeneActionPerformed(evt);
            }
        });

        jLabel1.setText("Marka:");

        btnIzbrisi.setText("Izbrisi");
        btnIzbrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbrisiActionPerformed(evt);
            }
        });

        jLabel2.setText("Model:");

        jLabel3.setText("Kolicina:");

        lblId.setText("ID:");

        jLabel5.setText("Naocare:");

        jLabel6.setText("Cena:");

        btnOtkazi.setText("Otkazi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIzmeni)
                        .addGap(18, 18, 18)
                        .addComponent(btnSacuvaj)
                        .addGap(18, 18, 18)
                        .addComponent(btnOmoguciIzmene)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnIzbrisi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOtkazi))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(poljeCena, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textCena, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(poljeId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                .addComponent(poljeMarka, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(poljeModel)
                                .addComponent(poljeKolicina, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                .addComponent(textKolicina, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textModel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textMarka, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(poljeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblId))
                .addGap(5, 5, 5)
                .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(poljeMarka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textMarka, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(poljeModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(7, 7, 7)
                .addComponent(textModel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(poljeKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIzmeni)
                            .addComponent(btnSacuvaj)
                            .addComponent(btnOmoguciIzmene)
                            .addComponent(btnIzbrisi)
                            .addComponent(btnOtkazi))
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(poljeCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textCena, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
//        try {
//            validacija();
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this, "Fill in the fields");
//        }
//        Naocare naocare = new Naocare();
//        naocare.setId(Integer.parseInt(poljeId.getText().trim()));
//        naocare.setMarka(poljeMarka.getText().trim());
//        naocare.setModel(poljeModel.getText().trim());
//        naocare.setKolicina(Integer.parseInt(poljeKolicina.getText().trim()));
//        naocare.setCena(Double.parseDouble(poljeCena.getText().trim()));
//        
//        try {
//            Communication.getInstance().editNaocare(naocare);
//        } catch (Exception ex) {
//            Logger.getLogger(PacijentForm.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
//        try {
//            validacija();
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this, "Fill in the fields");
//        }
//        Naocare naocare = new Naocare();
//        naocare.setId(Integer.parseInt(poljeId.getText().trim()));
//        naocare.setMarka(poljeMarka.getText().trim());
//        naocare.setModel(poljeModel.getText().trim());
//        naocare.setKolicina(Integer.parseInt(poljeKolicina.getText().trim()));
//        naocare.setCena(Double.parseDouble(poljeCena.getText().trim()));
//        
//        try {
//            Communication.getInstance().addNaocare(naocare);
//        } catch (Exception ex) {
//            Logger.getLogger(PacijentForm.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnOmoguciIzmeneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOmoguciIzmeneActionPerformed
//        btnIzmeni.setEnabled(true);
//        btnOmoguciIzmene.setEnabled(true);
//        btnSacuvaj.setEnabled(true);
//        btnIzbrisi.setEnabled(true);
//        poljeMarka.setEditable(true);
//        poljeModel.setEditable(true);
//        poljeKolicina.setEditable(true);
//        poljeId.setEditable(true);

    }//GEN-LAST:event_btnOmoguciIzmeneActionPerformed

    private void btnIzbrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbrisiActionPerformed
        

    }//GEN-LAST:event_btnIzbrisiActionPerformed

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
            java.util.logging.Logger.getLogger(NaocareForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NaocareForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NaocareForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NaocareForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NaocareForm().setVisible(true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField poljeCena;
    private javax.swing.JTextField poljeId;
    private javax.swing.JTextField poljeKolicina;
    private javax.swing.JTextField poljeMarka;
    private javax.swing.JTextField poljeModel;
    private javax.swing.JLabel textCena;
    private javax.swing.JLabel textId;
    private javax.swing.JLabel textKolicina;
    private javax.swing.JLabel textMarka;
    private javax.swing.JLabel textModel;
    // End of variables declaration//GEN-END:variables
//    public void iskljuci(){
//        btnIzmeni.setEnabled(false);
//        btnSacuvaj.setEnabled(false);
//        btnIzbrisi.setEnabled(false);
//        poljeMarka.setEditable(false);
//        poljeModel.setEditable(false);
//        poljeKolicina.setEditable(false);
//        poljeId.setEditable(false);
//    }
//    public void popuni(){
//        btnIzmeni.setEnabled(false);
//        btnSacuvaj.setEnabled(false);
//        btnIzbrisi.setEnabled(false);
//        poljeMarka.setEditable(false);
//        poljeModel.setEditable(false);
//        poljeKolicina.setEditable(false);
//        poljeId.setEditable(false);
//        
//        poljeMarka.setText(naocare.getMarka());
//        poljeModel.setText(naocare.getModel());
//        poljeKolicina.setText(String.valueOf(naocare.getKolicina()));
//        poljeId.setText(String.valueOf(naocare.getId()));
//    }
//    public void validacija() throws Exception {
//        String error="";
//        String id = poljeId.getText();
//        String marka = poljeMarka.getText();
//        String model = poljeModel.getText();
//        String kolicnina = poljeKolicina.getText();
//        String cena = poljeCena.getText();
//        //String cena = poljeCena.getText();
//        
//        if(id==null || id.isEmpty()){
//            textId.setText("Id cannot be empty!");
//            error += "Id cannot be empty!\n";
//        }
//        if(marka==null || marka.isEmpty()){
//            textMarka.setText("Marka cannot be empty!");
//            error += "Marka cannot be empty!\n";
//        }
//        if(model==null || model.isEmpty()){
//            textModel.setText("Model cannot be empty!");
//            error += "Model cannot be empty!\n";
//        }
//        if(kolicnina==null || kolicnina.isEmpty()){
//            textKolicina.setText("Quantity cannot be empty!");
//            error += "Quantity cannot be empty!\n";
//        }
//        if(Integer.parseInt(kolicnina) <=0 ){
//            textKolicina.setText("Quantity cannot be zero or negative number!");
//            error += "Quantity cannot be zero or negative number!\n";
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

    public JButton getBtnIzbrisi() {
        return btnIzbrisi;
    }

    public JButton getBtnIzmeni() {
        return btnIzmeni;
    }

    public JButton getBtnOmoguciIzmene() {
        return btnOmoguciIzmene;
    }

    public JButton getBtnSacuvaj() {
        return btnSacuvaj;
    }

    public JButton getBtnOtkazi() {
        return btnOtkazi;
    }
    

    public JTextField getPoljeCena() {
        return poljeCena;
    }

    public JTextField getPoljeId() {
        return poljeId;
    }

    public JTextField getPoljeKolicina() {
        return poljeKolicina;
    }

    public JTextField getPoljeMarka() {
        return poljeMarka;
    }

    public JTextField getPoljeModel() {
        return poljeModel;
    }

    public JLabel getTextCena() {
        return textCena;
    }

    public JLabel getTextId() {
        return textId;
    }

    public JLabel getTextKolicina() {
        return textKolicina;
    }

    public JLabel getTextMarka() {
        return textMarka;
    }

    public JLabel getTextModel() {
        return textModel;
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
