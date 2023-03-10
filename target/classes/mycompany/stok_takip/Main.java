/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.stok_takip;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
* @file stok_takip.java
* @description Belirli bir şirketin stok durumunu kontrol eden program.
* @assignment Bahar Dönemi 1.Proje
* @date 17/05/2022
* @author Muhammed Mesut Bahadır - muhammed.bahadir@stu.fsm.edu.tr
*/
public class Main extends javax.swing.JFrame {

    static String con = "jdbc:derby://localhost:1527/StokTakip";
    Connection connect = null;
    Statement state = null;
    ResultSet result = null;
    DefaultTableModel model;
    

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(220);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(220);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(220);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(220);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(220);
        this.setTitle("Ana Ekran");
        model = (DefaultTableModel) jTable1.getModel();
        String query2 = "SELECT * FROM app.urunler";
        showTable(query2);

    }
    
    //Connection yapısını birden fazla yerde kullanacağım için bunu bir metoda dönüştürmek istedim.
    //Bu metod sayesinde kodun ileriki safhalarında yazacağım kod fazlalıklarından kurtulmuş oldum.
    //Bu metod sayesinde database ile bağlantı sağlayabiliyorum.
    public Connection baglanti() {
        try {
            connect = DriverManager.getConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(UrunEkle.class.getName()).log(Level.SEVERE, null, ex);
        }

        return connect;
    }
    
    //Ürünler isimli bir class açıp, veritabanına eklemek istediğim ürüne ait bilgileri burada da oluşturup
    //birden fazla kısımda kullanma ihtimalime karşın kod fazlalığından kaçınmak amaçlı bu metodu yazdım.
    //Bu metodu databaseden aldığım verileri Ürünler class'ı aracılığıyla tablo oluşturmak için kullandım.
    public ArrayList<Urunler> urunler(String query) {
        ArrayList<Urunler> urunlerList = new ArrayList<>();
        try {
            connect = baglanti();
            state = connect.createStatement();
            result = state.executeQuery(query);
            Urunler urun;
            while (result.next()) {
                urun = new Urunler(result.getString("urunId"), result.getString("urunAd"), result.getString("urunGrubu"), result.getString("urunAdedi"), result.getString("urunTarih"),result.getString("urunFiyat"));
                urunlerList.add(urun);
            }
            connect.close();
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(UrunEkle.class.getName()).log(Level.SEVERE, null, ex);
        }

        return urunlerList;
    }
    
    //Birden fazla tablo oluşturma ihtimalime karşın bu metodu yazdım. Üst taraftaki metoddan aldığım 
    //aldığım bilgileri tabloya aktarmamı sağlayan metoddur.
    public void showTable(String q) {
        ArrayList<Urunler> list = urunler(q);

        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getUrunId();
            row[1] = list.get(i).getUrunAd();
            row[2] = list.get(i).getUrunGrubu();
            row[3] = list.get(i).getUrunAdedi();
            row[5] = list.get(i).getUrunTarihi();
            row[4] = list.get(i).getUrunFiyati();
            
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_ekle = new javax.swing.JButton();
        btn_guncelle = new javax.swing.JButton();
        btn_sil = new javax.swing.JButton();
        btn_veriler = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        btn_listGuncelle = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mi_renkDegis = new javax.swing.JMenuItem();
        mi_aydinlikMod = new javax.swing.JMenuItem();
        mi_karanlikMod = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mi_SaatTarih = new javax.swing.JMenuItem();
        mi_Exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnl_left.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Stok Takip");

        btn_ekle.setBackground(new java.awt.Color(153, 153, 153));
        btn_ekle.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Documents\\NetBeansProjects\\Stok_Takip\\src\\main\\java\\icon\\plus.png")); // NOI18N
        btn_ekle.setText("Ürün Ekle");
        btn_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ekleActionPerformed(evt);
            }
        });

        btn_guncelle.setBackground(new java.awt.Color(153, 153, 153));
        btn_guncelle.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Documents\\NetBeansProjects\\Stok_Takip\\src\\main\\java\\icon\\contract.png")); // NOI18N
        btn_guncelle.setText("Ürün Güncelle");
        btn_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guncelleActionPerformed(evt);
            }
        });

        btn_sil.setBackground(new java.awt.Color(153, 153, 153));
        btn_sil.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Documents\\NetBeansProjects\\Stok_Takip\\src\\main\\java\\icon\\error.png")); // NOI18N
        btn_sil.setText("Ürün Sil");
        btn_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_silActionPerformed(evt);
            }
        });

        btn_veriler.setBackground(new java.awt.Color(153, 153, 153));
        btn_veriler.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Documents\\NetBeansProjects\\Stok_Takip\\src\\main\\java\\icon\\newspaper.png")); // NOI18N
        btn_veriler.setText("Veriler");
        btn_veriler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verilerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_leftLayout = new javax.swing.GroupLayout(pnl_left);
        pnl_left.setLayout(pnl_leftLayout);
        pnl_leftLayout.setHorizontalGroup(
            pnl_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_leftLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnl_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_ekle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_guncelle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_sil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_veriler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        pnl_leftLayout.setVerticalGroup(
            pnl_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_leftLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(81, 81, 81)
                .addComponent(btn_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btn_guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btn_sil, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btn_veriler, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Documents\\NetBeansProjects\\Stok_Takip\\src\\main\\java\\icon\\magnifying-glass.png")); // NOI18N

        txt_search.setBackground(new java.awt.Color(153, 153, 153));
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_searchKeyTyped(evt);
            }
        });

        btn_listGuncelle.setBackground(new java.awt.Color(153, 153, 153));
        btn_listGuncelle.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Documents\\NetBeansProjects\\Stok_Takip\\src\\main\\java\\icon\\refresh.png")); // NOI18N
        btn_listGuncelle.setText("Listeyi Güncelle");
        btn_listGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listGuncelleActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ürün ID");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btn_listGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(558, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_search)
                        .addComponent(btn_listGuncelle)
                        .addComponent(jLabel3)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jScrollPane1.setBackground(new java.awt.Color(51, 51, 51));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ürün ID", "Ürün Adı", "Ürün Grubu", "Ürün Adet", "Ürün Fiyatı (TL)", "Güncelleme Tarihi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jMenu1.setText("Menü");

        mi_renkDegis.setText("Sayfa Rengi Değiştir");
        mi_renkDegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_renkDegisActionPerformed(evt);
            }
        });
        jMenu1.add(mi_renkDegis);

        mi_aydinlikMod.setText("Aydınlık Mod");
        mi_aydinlikMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_aydinlikModActionPerformed(evt);
            }
        });
        jMenu1.add(mi_aydinlikMod);

        mi_karanlikMod.setText("Karanlık Mod");
        mi_karanlikMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_karanlikModActionPerformed(evt);
            }
        });
        jMenu1.add(mi_karanlikMod);
        jMenu1.add(jSeparator1);

        mi_SaatTarih.setText("Güncel Saat ve Tarih");
        mi_SaatTarih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_SaatTarihActionPerformed(evt);
            }
        });
        jMenu1.add(mi_SaatTarih);

        mi_Exit.setText("Uygulamadan Çık");
        mi_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_ExitActionPerformed(evt);
            }
        });
        jMenu1.add(mi_Exit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_left, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ekleActionPerformed
        //Kullanıcı butona birden fazla tıkladığında arka arkaya aynı frame'i açmasından
        //kaçınmak için bu yöntemi izledim.
        UrunEkle.getObj().setVisible(true);
    }//GEN-LAST:event_btn_ekleActionPerformed

    private void btn_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guncelleActionPerformed
        // TODO add your handling code here:
        UrunGuncelle.getObj().setVisible(true);
    }//GEN-LAST:event_btn_guncelleActionPerformed

    private void btn_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_silActionPerformed
        // TODO add your handling code here:
        UrunSil.getObj().setVisible(true);
    }//GEN-LAST:event_btn_silActionPerformed

    private void btn_verilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verilerActionPerformed
        Veriler.getObj().setVisible(true);
    }//GEN-LAST:event_btn_verilerActionPerformed

    private void btn_listGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listGuncelleActionPerformed
        model.setRowCount(0);
        if (txt_search.getText().isEmpty()) {
            String query = "SELECT * FROM app.urunler";
            showTable(query);
        } else {
            String query2 = "SELECT * FROM app.urunler WHERE urunId LIKE '%" + txt_search.getText() + "%'";
            showTable(query2);
        }
    }//GEN-LAST:event_btn_listGuncelleActionPerformed

    private void mi_renkDegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_renkDegisActionPerformed
        JColorChooser c = new JColorChooser();
        Color color = JColorChooser.showDialog(null, "Color", Color.yellow);
        pnl_left.setBackground(color);
        jPanel2.setBackground(color);
    }//GEN-LAST:event_mi_renkDegisActionPerformed

    private void mi_aydinlikModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_aydinlikModActionPerformed
        // TODO add your handling code here:
        pnl_left.setBackground(new Color(204, 204, 204));
        jPanel2.setBackground(new Color(204, 204, 204));
        btn_guncelle.setBackground(Color.WHITE);
        btn_sil.setBackground(Color.WHITE);
        btn_listGuncelle.setBackground(Color.WHITE);
        btn_veriler.setBackground(Color.WHITE);
        btn_ekle.setBackground(Color.WHITE);
    }//GEN-LAST:event_mi_aydinlikModActionPerformed

    private void mi_karanlikModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_karanlikModActionPerformed
        // TODO add your handling code here:
        pnl_left.setBackground(new Color(51, 51, 51));
        jPanel2.setBackground(new Color(51, 51, 51));
        btn_guncelle.setBackground(new Color(153, 153, 153));
        btn_sil.setBackground(new Color(153, 153, 153));
        btn_listGuncelle.setBackground(new Color(153, 153, 153));
        btn_veriler.setBackground(new Color(153, 153, 153));
        btn_ekle.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_mi_karanlikModActionPerformed

    private void mi_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_ExitActionPerformed
        // TODO add your handling code here:
        Login l1 = new Login();
        l1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mi_ExitActionPerformed

    private void mi_SaatTarihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_SaatTarihActionPerformed
        // TODO add your handling code here:
        LocalDateTime today = LocalDateTime.now();
        JDialog j1 = new JDialog();
        j1.setSize(200, 200);
        j1.setLocationRelativeTo(null);
        j1.setVisible(true);
        j1.getContentPane().setBackground(new Color(51, 51, 51));
        j1.getContentPane().setForeground(Color.white);
        j1.add(new JLabel("              " + today.getDayOfMonth() + "/" + today.getMonthValue() + "/" + today.getYear() + "    " + today.getHour() + "." + today.getMinute()));


    }//GEN-LAST:event_mi_SaatTarihActionPerformed

    private void txt_searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyTyped
        //Kullanıcının Id kismina rakam harici başka bir şey yazmamasını sağlar.
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_searchKeyTyped

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ekle;
    private javax.swing.JButton btn_guncelle;
    private javax.swing.JButton btn_listGuncelle;
    private javax.swing.JButton btn_sil;
    private javax.swing.JButton btn_veriler;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem mi_Exit;
    private javax.swing.JMenuItem mi_SaatTarih;
    private javax.swing.JMenuItem mi_aydinlikMod;
    private javax.swing.JMenuItem mi_karanlikMod;
    private javax.swing.JMenuItem mi_renkDegis;
    private javax.swing.JPanel pnl_left;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
