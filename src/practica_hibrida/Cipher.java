package practica_hibrida;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import static practica_hibrida.Practica_Hibrida.guardarEnArchivo;


public class Cipher {
    
    static void generateKeys(Component c) {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    int op = fileChooser.showOpenDialog(c);
    
    String texto = "";
    
    if (op == JFileChooser.APPROVE_OPTION) {
        try {
            File folder = fileChooser.getSelectedFile();
            System.out.println("FOLDER: " + folder.getAbsolutePath());
            
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PublicKey clavePublica = keyPair.getPublic();
            PrivateKey clavePrivada = keyPair.getPrivate();
            
            byte[] clavePublicaBytes = clavePublica.getEncoded();
            guardarEnArchivo(folder.getAbsolutePath()+"\\id_rsa.pub", clavePublicaBytes);
            
            byte[] clavePrivadaBytes = clavePrivada.getEncoded();
            guardarEnArchivo(folder.getAbsolutePath()+"\\id_rsa", clavePrivadaBytes);
            
            JOptionPane.showMessageDialog(c, "Llaves generadas correctamente en "+ folder.getAbsolutePath(), "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(Cipher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
    public static void guardarEnArchivo(String rutaArchivo, byte[] contenido) throws Exception {
        FileOutputStream fos = new FileOutputStream(rutaArchivo);
        fos.write(contenido);
        fos.close();
    }
    
    public static byte[] encryptMessageAES(String message, String encryptedMessage, String key, String v0) {
        String AES_ALGORITHM = "AES/CBC/PKCS5Padding";
        byte[] encryptedBytes = null;
        
        try {
            byte[] keyBytes = key.getBytes("UTF-8");
            SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
            
            byte[] ivBytes = v0.getBytes("UTF-8");
            IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
            
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(AES_ALGORITHM);
            cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            
            byte[] inputBytes = Files.readAllBytes(Paths.get(message));
           
            byte[] encryptedPixelsBytes = cipher.doFinal(inputBytes);
            
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            outputStream.write(encryptedPixelsBytes);
            encryptedBytes = outputStream.toByteArray();
            
            Files.write(Paths.get(encryptedMessage), encryptedBytes);
            
            System.out.println("Mensaje cifrado correctamente");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return encryptedBytes;
    }
    
    public static String obtenerContenidoArchivo(File messageFile) throws Exception {
        byte[] bytesArchivo = Files.readAllBytes(messageFile.toPath());
        return new String(bytesArchivo, StandardCharsets.UTF_8);
    }
    
    public static byte[] decryptMessageAES(String inputFilePath, byte[] key, byte[] v0) {
        String AES_ALGORITHM = "AES/CBC/PKCS5Padding";
        byte[] decryptedBytes = null;
        
        try {
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
            
            IvParameterSpec ivSpec = new IvParameterSpec(v0);
            
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(AES_ALGORITHM);
            cipher.init(javax.crypto.Cipher.DECRYPT_MODE, keySpec, ivSpec);
            
            byte[] inputBytes = Files.readAllBytes(Paths.get(inputFilePath));
            
            
            byte[] decryptedPixelsBytes = cipher.doFinal(inputBytes);
            
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            outputStream.write(decryptedPixelsBytes);
            decryptedBytes = outputStream.toByteArray();
                       
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return decryptedBytes;
    }
    
    public static SecretKey generateRandomKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        return keyGenerator.generateKey();
    }

    public static byte[] generateRandomIV() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return iv;
    }

}
