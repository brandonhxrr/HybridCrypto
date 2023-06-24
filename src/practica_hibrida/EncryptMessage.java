package practica_hibrida;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import static practica_hibrida.Practica_Hibrida.calcularHash;
import static practica_hibrida.Practica_Hibrida.cargarClavePrivadaDesdeArchivo;
import static practica_hibrida.Practica_Hibrida.cargarClavePublicaDesdeArchivo;
import static practica_hibrida.Practica_Hibrida.cifrarRSA;
import static practica_hibrida.Practica_Hibrida.guardarEnArchivo;
import static practica_hibrida.Practica_Hibrida.leerArchivo;

public class EncryptMessage extends javax.swing.JFrame {

    int x, y; 
    static ImageIcon icon;
    static String texto;
    File privateKeyFile;
    File publicKeyFile;
    File messageFile;
    File encryptedMessageFile;
    
    
    public EncryptMessage() {
        initComponents();
        close_btn.setIcon(new ImageIcon("src/icons/close_disabled.png")); 
        title.setIcon(new ImageIcon("src/icons/favicon.png"));
        btnEncryptMessage.setIcon(new ImageIcon("src/icons/encrypt_icon.png"));
        btn_back.setIcon(new ImageIcon("src/icons/back_disabled.png")); 
        EncryptMessage.texto = texto;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        close_btn = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        btnEncryptMessage = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        btnSelectMessage = new javax.swing.JButton();
        titleImage = new javax.swing.JLabel();
        btnSelectPublicKey = new javax.swing.JButton();
        titleImage2 = new javax.swing.JLabel();
        titleKey = new javax.swing.JLabel();
        txtKey = new javax.swing.JTextField();
        txtVector = new javax.swing.JTextField();
        titleVector = new javax.swing.JLabel();
        titleImage3 = new javax.swing.JLabel();
        btnSelectPrivateKey = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
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
        title.setText("Cifrar mensaje");

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

        btn_back.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_back.setBorderPainted(false);
        btn_back.setContentAreaFilled(false);
        btn_back.setFocusable(false);
        btn_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_backMouseExited(evt);
            }
        });
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btnSelectMessage.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnSelectMessage.setText("Seleccionar archivo");
        btnSelectMessage.setBorder(null);
        btnSelectMessage.setContentAreaFilled(false);
        btnSelectMessage.setFocusPainted(false);
        btnSelectMessage.setFocusable(false);
        btnSelectMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSelectMessageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSelectMessageMouseExited(evt);
            }
        });
        btnSelectMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectMessageActionPerformed(evt);
            }
        });

        titleImage.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        titleImage.setText("Archivo de entrada");

        btnSelectPublicKey.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnSelectPublicKey.setText("Seleccionar archivo");
        btnSelectPublicKey.setBorder(null);
        btnSelectPublicKey.setContentAreaFilled(false);
        btnSelectPublicKey.setFocusPainted(false);
        btnSelectPublicKey.setFocusable(false);
        btnSelectPublicKey.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSelectPublicKeyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSelectPublicKeyMouseExited(evt);
            }
        });
        btnSelectPublicKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectPublicKeyActionPerformed(evt);
            }
        });

        titleImage2.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        titleImage2.setText("Llave pública");

        titleKey.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        titleKey.setText("LLave (16 bytes):");

        txtKey.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N

        txtVector.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N

        titleVector.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        titleVector.setText("Vector:");

        titleImage3.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        titleImage3.setText("Llave privada");

        btnSelectPrivateKey.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnSelectPrivateKey.setText("Seleccionar archivo");
        btnSelectPrivateKey.setBorder(null);
        btnSelectPrivateKey.setContentAreaFilled(false);
        btnSelectPrivateKey.setFocusPainted(false);
        btnSelectPrivateKey.setFocusable(false);
        btnSelectPrivateKey.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSelectPrivateKeyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSelectPrivateKeyMouseExited(evt);
            }
        });
        btnSelectPrivateKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectPrivateKeyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(btnEncryptMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(titleKey)
                                    .addComponent(titleVector))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtVector, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                                    .addComponent(txtKey))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(title)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(close_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleImage)
                            .addComponent(titleImage2)
                            .addComponent(titleImage3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSelectMessage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSelectPublicKey, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSelectPrivateKey, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(close_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(titleKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(titleVector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtVector, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleImage)
                    .addComponent(btnSelectMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleImage2)
                    .addComponent(btnSelectPublicKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleImage3)
                    .addComponent(btnSelectPrivateKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addComponent(btnEncryptMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnEncryptMessageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEncryptMessageMouseEntered
        btnEncryptMessage.setForeground(new java.awt.Color(51, 51, 51));
        btnEncryptMessage.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLACK, 1));
    }//GEN-LAST:event_btnEncryptMessageMouseEntered

    private void btnEncryptMessageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEncryptMessageMouseExited
        btnEncryptMessage.setForeground(java.awt.Color.BLACK);
        btnEncryptMessage.setBorder(null);
    }//GEN-LAST:event_btnEncryptMessageMouseExited

    private void btnEncryptMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptMessageActionPerformed
        if(messageFile == null){
            JOptionPane.showMessageDialog(this, "No se ha seleccionado un mensaje", "Error", JOptionPane.ERROR_MESSAGE);
        }else if(publicKeyFile == null){
            JOptionPane.showMessageDialog(this, "No se ha seleccionado la llave pública", "Error", JOptionPane.ERROR_MESSAGE);
        }else if(privateKeyFile == null){
            JOptionPane.showMessageDialog(this, "No se ha seleccionado la llave privada", "Error", JOptionPane.ERROR_MESSAGE);
        }else if(txtKey.getText().equals("")){
            JOptionPane.showMessageDialog(this, "No se ha introducido la llave de 16 bytes", "Error", JOptionPane.ERROR_MESSAGE);
        }else if(txtVector.getText().equals("")){
            JOptionPane.showMessageDialog(this, "No se ha introducido el vector de inicialización", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            
            try {
                byte[] encryptedMessage = Cipher.encryptMessageAES(messageFile.getAbsolutePath(), publicKeyFile.getParent()+"\\encrypted_message.txt", txtKey.getText(), txtVector.getText());
                //byte[] hash = calcularHash(encryptedMessage);
                
                byte[] encryptedMessageFromFile = leerArchivo(publicKeyFile.getParent()+"\\encrypted_message.txt");
                byte[] hash = calcularHash(encryptedMessageFromFile);
                PublicKey publicKey = cargarClavePublicaDesdeArchivo(publicKeyFile.getAbsolutePath());
                PrivateKey privateKey = cargarClavePrivadaDesdeArchivo(privateKeyFile.getAbsolutePath());
                
                byte[] hashCifrado = cifrarRSA(hash, privateKey);
                byte[] encryptedKey = cifrarRSA(txtKey.getText().getBytes(), publicKey);
                byte[] encryptedVector = cifrarRSA(txtVector.getText().getBytes(), publicKey);
                
                guardarEnArchivo(publicKeyFile.getParent()+"\\encrypted_hash.txt", hashCifrado);
                guardarEnArchivo(publicKeyFile.getParent()+"\\encrypted_key.txt", encryptedKey);
                guardarEnArchivo(publicKeyFile.getParent()+"\\encrypted_vector.txt", encryptedVector);
            } catch (Exception ex) {
                Logger.getLogger(EncryptMessage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnEncryptMessageActionPerformed

    private void btn_backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseEntered
        btn_back.setIcon(new ImageIcon("src/icons/back_enabled.png"));
    }//GEN-LAST:event_btn_backMouseEntered

    private void btn_backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseExited
        btn_back.setIcon(new ImageIcon("src/icons/back_disabled.png"));
    }//GEN-LAST:event_btn_backMouseExited

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    private void btnSelectMessageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectMessageMouseEntered
        btnSelectMessage.setForeground(new java.awt.Color(0, 0, 255));
    }//GEN-LAST:event_btnSelectMessageMouseEntered

    private void btnSelectMessageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectMessageMouseExited
        btnSelectMessage.setForeground(java.awt.Color.BLACK);
    }//GEN-LAST:event_btnSelectMessageMouseExited

    private void btnSelectMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectMessageActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de texto", "txt");
        fileChooser.setFileFilter(filter);
        int op = fileChooser.showOpenDialog(this);

        FileReader fr = null;
        BufferedReader br = null;
        String texto = "";

        if (op == JFileChooser.APPROVE_OPTION) {
            messageFile = fileChooser.getSelectedFile();
            btnSelectMessage.setText(messageFile.getName());
        }
    }//GEN-LAST:event_btnSelectMessageActionPerformed

    private void btnSelectPublicKeyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectPublicKeyMouseEntered
        btnSelectPublicKey.setForeground(new java.awt.Color(0, 0, 255));
    }//GEN-LAST:event_btnSelectPublicKeyMouseEntered

    private void btnSelectPublicKeyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectPublicKeyMouseExited
        btnSelectPublicKey.setForeground(java.awt.Color.BLACK);
    }//GEN-LAST:event_btnSelectPublicKeyMouseExited

    private void btnSelectPublicKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectPublicKeyActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Llave pública", "pub");
        fileChooser.setFileFilter(filter);
        int op = fileChooser.showOpenDialog(this);

        FileReader fr = null;
        BufferedReader br = null;
        String texto = "";

        if (op == JFileChooser.APPROVE_OPTION) {
            publicKeyFile = fileChooser.getSelectedFile();
            btnSelectPublicKey.setText(publicKeyFile.getName());
        }
    }//GEN-LAST:event_btnSelectPublicKeyActionPerformed

    private void btnSelectPrivateKeyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectPrivateKeyMouseEntered
        btnSelectPrivateKey.setForeground(new java.awt.Color(0, 0, 255));
    }//GEN-LAST:event_btnSelectPrivateKeyMouseEntered

    private void btnSelectPrivateKeyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectPrivateKeyMouseExited
        btnSelectPrivateKey.setForeground(java.awt.Color.BLACK);
    }//GEN-LAST:event_btnSelectPrivateKeyMouseExited

    private void btnSelectPrivateKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectPrivateKeyActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory() || file.getName().lastIndexOf('.') == -1;
            }

            @Override
            public String getDescription() {
                return "LLave privada";
            }
        });
        int op = fileChooser.showOpenDialog(this);

        if (op == JFileChooser.APPROVE_OPTION) {
            privateKeyFile = fileChooser.getSelectedFile();
            btnSelectPrivateKey.setText(privateKeyFile.getName());
        }
    }//GEN-LAST:event_btnSelectPrivateKeyActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EncryptMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EncryptMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EncryptMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EncryptMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EncryptMessage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEncryptMessage;
    private javax.swing.JButton btnSelectMessage;
    private javax.swing.JButton btnSelectPrivateKey;
    private javax.swing.JButton btnSelectPublicKey;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton close_btn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel title;
    private javax.swing.JLabel titleImage;
    private javax.swing.JLabel titleImage2;
    private javax.swing.JLabel titleImage3;
    private javax.swing.JLabel titleKey;
    private javax.swing.JLabel titleVector;
    private javax.swing.JTextField txtKey;
    private javax.swing.JTextField txtVector;
    // End of variables declaration//GEN-END:variables
}
