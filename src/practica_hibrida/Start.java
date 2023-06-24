package practica_hibrida;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Start extends javax.swing.JFrame {

    int x, y; 
    static ImageIcon icon;
    
    public Start() {
        initComponents();
        close_btn.setIcon(new ImageIcon("src/icons/close_disabled.png")); 
        title.setIcon(new ImageIcon("src/icons/favicon.png"));
        btnGenerateKeys.setIcon(new ImageIcon("src/icons/encrypt_icon.png"));
        btnEncryptMessage.setIcon(new ImageIcon("src/icons/text_icon.png"));
        btnDecryptMessage.setIcon(new ImageIcon("src/icons/image_icon.png"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        close_btn = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        btnEncryptMessage = new javax.swing.JButton();
        btnDecryptMessage = new javax.swing.JButton();
        btnGenerateKeys = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(389, 486));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        jPanel1.setMaximumSize(new java.awt.Dimension(389, 486));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });

        close_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        close_btn.setBorderPainted(false);
        close_btn.setContentAreaFilled(false);
        close_btn.setFocusable(false);
        close_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                close_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                close_btnMouseExited(evt);
            }
        });
        close_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_btnActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        title.setText("Criptografía hibrída");

        btnEncryptMessage.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnEncryptMessage.setText("Cifrar mensaje");
        btnEncryptMessage.setBorder(null);
        btnEncryptMessage.setContentAreaFilled(false);
        btnEncryptMessage.setFocusPainted(false);
        btnEncryptMessage.setFocusable(false);
        btnEncryptMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEncryptMessageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEncryptMessageMouseExited(evt);
            }
        });
        btnEncryptMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncryptMessageActionPerformed(evt);
            }
        });

        btnDecryptMessage.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnDecryptMessage.setText("Descifrar mensaje");
        btnDecryptMessage.setBorder(null);
        btnDecryptMessage.setContentAreaFilled(false);
        btnDecryptMessage.setFocusPainted(false);
        btnDecryptMessage.setFocusable(false);
        btnDecryptMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDecryptMessageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDecryptMessageMouseExited(evt);
            }
        });
        btnDecryptMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecryptMessageActionPerformed(evt);
            }
        });

        btnGenerateKeys.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnGenerateKeys.setText("Generar llaves");
        btnGenerateKeys.setBorder(null);
        btnGenerateKeys.setContentAreaFilled(false);
        btnGenerateKeys.setFocusPainted(false);
        btnGenerateKeys.setFocusable(false);
        btnGenerateKeys.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGenerateKeysMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGenerateKeysMouseExited(evt);
            }
        });
        btnGenerateKeys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateKeysActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(close_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDecryptMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEncryptMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGenerateKeys, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(title)
                    .addComponent(close_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(btnGenerateKeys, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEncryptMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDecryptMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void close_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_btnMouseEntered
        close_btn.setIcon(new ImageIcon("src/icons/close_enabled.png"));
    }//GEN-LAST:event_close_btnMouseEntered

    private void close_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_btnMouseExited
        close_btn.setIcon(new ImageIcon("src/icons/close_disabled.png"));
    }//GEN-LAST:event_close_btnMouseExited

    private void close_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_btnActionPerformed
        this.dispose();
    }//GEN-LAST:event_close_btnActionPerformed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        this.setLocation(this.getLocation().x + evt.getX()-x, this.getLocation().y + evt.getY()-y );
        this.setOpacity(0.9f);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        this.setOpacity(1f);
    }//GEN-LAST:event_jPanel1MouseReleased

    private void btnEncryptMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptMessageActionPerformed
        EncryptMessage v = new EncryptMessage();
        v.setVisible(true);
    }//GEN-LAST:event_btnEncryptMessageActionPerformed

    private void btnEncryptMessageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEncryptMessageMouseEntered
        btnEncryptMessage.setForeground(new java.awt.Color(51, 51, 51));
        btnEncryptMessage.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLACK, 1));
    }//GEN-LAST:event_btnEncryptMessageMouseEntered

    private void btnEncryptMessageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEncryptMessageMouseExited
        btnEncryptMessage.setForeground(java.awt.Color.BLACK);
        btnEncryptMessage.setBorder(null);
    }//GEN-LAST:event_btnEncryptMessageMouseExited

    private void btnDecryptMessageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDecryptMessageMouseEntered
        btnDecryptMessage.setForeground(new java.awt.Color(51, 51, 51));
        btnDecryptMessage.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLACK, 1));
    }//GEN-LAST:event_btnDecryptMessageMouseEntered

    private void btnDecryptMessageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDecryptMessageMouseExited
        btnDecryptMessage.setForeground(java.awt.Color.BLACK);
        btnDecryptMessage.setBorder(null);
    }//GEN-LAST:event_btnDecryptMessageMouseExited

    private void btnDecryptMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecryptMessageActionPerformed
        DecryptMessage v = new DecryptMessage();
        v.setVisible(true);
    }//GEN-LAST:event_btnDecryptMessageActionPerformed

    private void btnGenerateKeysMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerateKeysMouseEntered
        btnGenerateKeys.setForeground(new java.awt.Color(51, 51, 51));
        btnGenerateKeys.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLACK, 1));
    }//GEN-LAST:event_btnGenerateKeysMouseEntered

    private void btnGenerateKeysMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerateKeysMouseExited
        btnGenerateKeys.setForeground(java.awt.Color.BLACK);
        btnGenerateKeys.setBorder(null);
    }//GEN-LAST:event_btnGenerateKeysMouseExited

    private void btnGenerateKeysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateKeysActionPerformed
        Cipher.generateKeys(this);
    }//GEN-LAST:event_btnGenerateKeysActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDecryptMessage;
    private javax.swing.JButton btnEncryptMessage;
    private javax.swing.JButton btnGenerateKeys;
    private javax.swing.JButton close_btn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
