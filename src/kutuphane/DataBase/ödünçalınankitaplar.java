/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kutuphane.DataBase;

import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author meren
 */
public class ödünçalınankitaplar extends javax.swing.JFrame {
    private BorrowKitapManager borrowbookManager;
    /**
     * Creates new form adminpaneli
     */
    public ödünçalınankitaplar() {
        initComponents();
        this.setResizable(false);
        DatabaseManager databaseManager = new DatabaseManager();
        borrowbookManager = new BorrowKitapManager();
        loadKitapListToTable();
        KullanıcıManager kullanıcıManager = new KullanıcıManager();
        String loggedInUsername = kullanıcıManager.getLoggedInUsername();
        kullanıcıadı.setText(loggedInUsername);
        BorrowRepository borrow=new BorrowRepository(databaseManager);
        int odunc=borrow.numberOfBorrow();
        oduncsayisi.setText(String.valueOf(odunc));
    }
    
    private void loadKitapListToTable() {
        KullanıcıManager kullanıcıManager = new KullanıcıManager();
        String loggedInUsername = kullanıcıManager.getLoggedInUsername();
        try {
            // Kitap listesini al
            DefaultListModel<BorrowKitap> kitapListModel = borrowbookManager.getDataBooks();


            // DefaultTableModel oluştur
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Kitap Adı");
            tableModel.addColumn("Yazar Adı");
            tableModel.addColumn("Sayfa Sayısı");
            tableModel.addColumn("Türü");
            tableModel.addColumn("Kullanıcı Adı");

            // Kitap listesini DefaultTableModel'e ekle
            for (int i = 0; i < kitapListModel.getSize(); i++) {
                BorrowKitap kitap = kitapListModel.get(i);
                Object[] row = {kitap.getKitapadi(), kitap.getYazar(), kitap.getSayfaSayisi(), kitap.getKategori(),kitap.getUsername()};
                tableModel.addRow(row);
            }

            // JTable'a DefaultTableModel'i ekle
            odunctablosu.setModel(tableModel);
        } catch (SQLException e) {
            e.printStackTrace();
            // Hata durumunda gerekli işlemler yapılabilir
        }
    }
    /**
     * 
     * 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        kitapayarları = new javax.swing.JButton();
        kitaplar = new javax.swing.JButton();
        kullanıcıayarları = new javax.swing.JButton();
        çıkışyap = new javax.swing.JButton();
        anasayfa = new javax.swing.JButton();
        ödünçalınankitaplar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        kullanıcıadı = new javax.swing.JTextPane();
        kütüphanebilgileri = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        aramakutusu = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        odunctablosu = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        oduncsayisi = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Kullanıcı Adı");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 80, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kutuphane/DataBase/yeni.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 80, 70));
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        kitapayarları.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        kitapayarları.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kutuphane/DataBase/ayar ikonu.png"))); // NOI18N
        kitapayarları.setText("Kitap Ayarları");
        kitapayarları.setAutoscrolls(true);
        kitapayarları.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kitapayarları.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kitapayarlarıActionPerformed(evt);
            }
        });
        jPanel1.add(kitapayarları, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 310, 70));

        kitaplar.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        kitaplar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kutuphane/DataBase/kitap.png"))); // NOI18N
        kitaplar.setText("Kitaplar");
        kitaplar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kitaplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kitaplarActionPerformed(evt);
            }
        });
        jPanel1.add(kitaplar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 310, 70));

        kullanıcıayarları.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        kullanıcıayarları.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kutuphane/DataBase/kullanıcıikon.jpg"))); // NOI18N
        kullanıcıayarları.setText("Kullanıcı Ayarları");
        kullanıcıayarları.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kullanıcıayarları.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kullanıcıayarlarıActionPerformed(evt);
            }
        });
        jPanel1.add(kullanıcıayarları, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 310, 70));

        çıkışyap.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        çıkışyap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kutuphane/DataBase/çıkışyap.png"))); // NOI18N
        çıkışyap.setText("Çıkış Yap");
        çıkışyap.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        çıkışyap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                çıkışyapActionPerformed(evt);
            }
        });
        jPanel1.add(çıkışyap, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 310, 60));

        anasayfa.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        anasayfa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kutuphane/DataBase/anasayfa.png"))); // NOI18N
        anasayfa.setText("Anasayfa");
        anasayfa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        anasayfa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anasayfaActionPerformed(evt);
            }
        });
        jPanel1.add(anasayfa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 310, 70));

        ödünçalınankitaplar.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        ödünçalınankitaplar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kutuphane/DataBase/ödünçal.png"))); // NOI18N
        ödünçalınankitaplar.setText("Ödünç Alınan Kitaplar");
        ödünçalınankitaplar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ödünçalınankitaplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ödünçalınankitaplarActionPerformed(evt);
            }
        });
        jPanel1.add(ödünçalınankitaplar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, -1, 60));

        jScrollPane2.setViewportView(kullanıcıadı);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 80, -1));

        kütüphanebilgileri.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        kütüphanebilgileri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kutuphane/DataBase/kütüphane.png"))); // NOI18N
        kütüphanebilgileri.setText("Kütüphane Bilgileri");
        kütüphanebilgileri.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kütüphanebilgileri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kütüphanebilgileriActionPerformed(evt);
            }
        });
        jPanel1.add(kütüphanebilgileri, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 310, 70));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel9.setText("Ödünç Alınan Kitap Sayısı");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 220, 50));

        aramakutusu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aramakutusuActionPerformed(evt);
            }
        });
        jPanel2.add(aramakutusu, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 340, 40));

        odunctablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kitap Adı", "Yazar Adı", "Sayfa Sayısı", "Türü", "Kullanıcı Adı"
            }
        ));
        jScrollPane1.setViewportView(odunctablosu);
        if (odunctablosu.getColumnModel().getColumnCount() > 0) {
            odunctablosu.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 560, 350));

        jLabel10.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel10.setText("Arama Kutusu");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 140, 50));

        oduncsayisi.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jScrollPane3.setViewportView(oduncsayisi);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 70, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kitapayarlarıActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kitapayarlarıActionPerformed
        kullanıcıayarları kullanıcı = new kullanıcıayarları();
        kullanıcı.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kitapayarlarıActionPerformed

    private void kitaplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kitaplarActionPerformed
        kitaplar kitaplarFrame = new kitaplar();
        kitaplarFrame.setVisible(true);

    // Close the current frame
        this.dispose();
    }//GEN-LAST:event_kitaplarActionPerformed

    private void kullanıcıayarlarıActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kullanıcıayarlarıActionPerformed
        kullanıcıayarları kullanıcı = new kullanıcıayarları();
        kullanıcı.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kullanıcıayarlarıActionPerformed

    private void kütüphanebilgileriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kütüphanebilgileriActionPerformed
        kütüphanebilgileri kütüphane = new kütüphanebilgileri();
        kütüphane.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kütüphanebilgileriActionPerformed

    private void çıkışyapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_çıkışyapActionPerformed
         KullanıcıManager kullanıcıManager = new KullanıcıManager();
        kullanıcıManager.removeUserFromLoginTable();
        System.exit(0);
    }//GEN-LAST:event_çıkışyapActionPerformed

    private void anasayfaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anasayfaActionPerformed
        adminanasayfa anasayfa = new adminanasayfa();
        anasayfa.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_anasayfaActionPerformed

    private void aramakutusuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aramakutusuActionPerformed
        String searchKeyword = aramakutusu.getText();
        BorrowKitapManager kitapManager = new BorrowKitapManager();

    
        DefaultListModel<BorrowKitap> kitapListModel = kitapManager.searchBooks(searchKeyword);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Kitap Adı");
        tableModel.addColumn("Yazar Adı");
        tableModel.addColumn("Sayfa Sayısı");
        tableModel.addColumn("Türü");
        tableModel.addColumn("Kullanıcıadı");

        for (int i = 0; i < kitapListModel.getSize(); i++) {
            BorrowKitap kitap = kitapListModel.get(i);
            Object[] row = {kitap.getKitapadi(), kitap.getYazar(), kitap.getSayfaSayisi(), kitap.getKategori(),kitap.getUsername()};
            tableModel.addRow(row);
        }

        odunctablosu.setModel(tableModel);
    }//GEN-LAST:event_aramakutusuActionPerformed

    private void ödünçalınankitaplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ödünçalınankitaplarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ödünçalınankitaplarActionPerformed

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
            java.util.logging.Logger.getLogger(ödünçalınankitaplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ödünçalınankitaplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ödünçalınankitaplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ödünçalınankitaplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ödünçalınankitaplar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anasayfa;
    private javax.swing.JTextField aramakutusu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton kitapayarları;
    private javax.swing.JButton kitaplar;
    private javax.swing.JTextPane kullanıcıadı;
    private javax.swing.JButton kullanıcıayarları;
    private javax.swing.JButton kütüphanebilgileri;
    private javax.swing.JTextPane oduncsayisi;
    private javax.swing.JTable odunctablosu;
    private javax.swing.JButton çıkışyap;
    private javax.swing.JButton ödünçalınankitaplar;
    // End of variables declaration//GEN-END:variables
}
