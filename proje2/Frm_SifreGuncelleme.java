package com.mycompany.proje2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Frm_SifreGuncelleme extends javax.swing.JFrame {

    private String danismanMail;
    private String ogrenciMail;

    public Frm_SifreGuncelleme(String mail) {
        initComponents();
        this.danismanMail = mail;
        this.ogrenciMail = mail;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_yeniSİfre = new javax.swing.JPasswordField();
        txt_yeniSifreTekrar = new javax.swing.JPasswordField();
        btn_vazgec = new javax.swing.JButton();
        btn_guncelle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PASSWORD UPDATE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("New Password");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel3.setText("New Password(Again)");

        btn_vazgec.setBackground(new java.awt.Color(255, 255, 204));
        btn_vazgec.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btn_vazgec.setText("CANCEL");
        btn_vazgec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vazgecActionPerformed(evt);
            }
        });

        btn_guncelle.setBackground(new java.awt.Color(255, 255, 204));
        btn_guncelle.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btn_guncelle.setText("UPDATE");
        btn_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guncelleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_yeniSİfre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_yeniSifreTekrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(btn_vazgec, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btn_guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_yeniSİfre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_yeniSifreTekrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_vazgec)
                    .addComponent(btn_guncelle))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btn_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guncelleActionPerformed
        String sifre = txt_yeniSİfre.getText();
        Pattern pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
        Matcher matcher = pattern.matcher(txt_yeniSİfre.getText());
        if (!sifre.equals(txt_yeniSifreTekrar.getText())) {
            JOptionPane.showMessageDialog(rootPane, "The new passwords entered do not match, try again.");
        } else if (!matcher.find()) {
            JOptionPane.showMessageDialog(rootPane, "En az bir harf (büyük veya küçük) bulunmalıdır:" + "\n"
                    + "En az bir rakam bulunmalıdır" + "\n"
                    + "Şifre en az 8 karakter uzunluğunda olmalıdır");
        } else if (txt_yeniSİfre.getText() != null) {
            DB_proje.UpdateSifreDanisman(sifre, danismanMail);
            DB_proje.UpdateSifreOgrenci(sifre, ogrenciMail);
            JOptionPane.showMessageDialog(rootPane, "Password update successful.");
            this.dispose();
        }
//Danışmanın veya öğrencinin şifresini günceller.
    }//GEN-LAST:event_btn_guncelleActionPerformed
    private void btn_vazgecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vazgecActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_vazgecActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guncelle;
    private javax.swing.JButton btn_vazgec;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txt_yeniSifreTekrar;
    private javax.swing.JPasswordField txt_yeniSİfre;
    // End of variables declaration//GEN-END:variables
}
