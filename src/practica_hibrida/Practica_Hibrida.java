package practica_hibrida;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Scanner;

public class Practica_Hibrida {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Qué acción desea realizar?");
        System.out.println("1. Cifrar mensaje");
        System.out.println("2. Descifrar mensaje");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        if (opcion == 1) {
            cifrarMensaje();
        } else if (opcion == 2) {
            descifrarMensaje();
        } else {
            System.out.println("Opción inválida");
        }
    }

    public static void cifrarMensaje() throws Exception {
    // Leer el mensaje original desde un archivo de texto
    String mensajeOriginal = new String(Files.readAllBytes(Paths.get("mensaje.txt")), StandardCharsets.UTF_8);

    // Generar claves pública y privada RSA
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    keyPairGenerator.initialize(2048);
    KeyPair keyPair = keyPairGenerator.generateKeyPair();
    PublicKey clavePublica = keyPair.getPublic();
    PrivateKey clavePrivada = keyPair.getPrivate();

    // Guardar la clave pública en un archivo
    byte[] clavePublicaBytes = clavePublica.getEncoded();
    guardarEnArchivo("clave_publica.txt", clavePublicaBytes);

    // Guardar la clave privada en un archivo
    byte[] clavePrivadaBytes = clavePrivada.getEncoded();
    guardarEnArchivo("clave_privada.txt", clavePrivadaBytes);

    // Cifrar y descifrar usando AES y RSA con función hash y firma digital
    SecretKey claveAES = generarClaveAES();
    byte[] mensajeCifradoBytes = cifrarAES(mensajeOriginal.getBytes(StandardCharsets.UTF_8), claveAES);

    // Convertir el mensaje cifrado a Base64
    String mensajeCifradoBase64 = Base64.getEncoder().encodeToString(mensajeCifradoBytes);

    byte[] claveCifrada = cifrarRSA(claveAES.getEncoded(), clavePublica);

    // Calcular el hash del mensaje cifrado
    byte[] hash = calcularHash(mensajeCifradoBytes);
    byte[] hashCifrado = cifrarRSA(hash, clavePublica);

    // Firmar el hash cifrado
    byte[] firma = firmar(hashCifrado, clavePrivada);

    // Guardar el mensaje cifrado y los demás componentes en archivos de texto
    guardarEnArchivo("mensaje_cifrado.txt", mensajeCifradoBase64.getBytes(StandardCharsets.UTF_8));
    guardarEnArchivo("clave_cifrada.txt", claveCifrada);
    guardarEnArchivo("hash_cifrado.txt", hashCifrado);
    guardarEnArchivo("firma.txt", firma);

    System.out.println("Mensaje cifrado y componentes guardados en archivos de texto.");
}


    public static void descifrarMensaje() throws Exception {
        // Cargar claves pública y privada desde archivos de texto
        PublicKey clavePublica = cargarClavePublicaDesdeArchivo("clave_publica.txt");
        PrivateKey clavePrivada = cargarClavePrivadaDesdeArchivo("clave_privada.txt");

        // Leer el contenido de los archivos de texto
        byte[] mensajeCifrado = leerArchivo("mensaje_cifrado.txt");
        byte[] claveCifrada = leerArchivo("clave_cifrada.txt");
        byte[] hashCifrado = leerArchivo("hash_cifrado.txt");
        byte[] firma = leerArchivo("firma.txt");

        // Descifrar la clave AES usando RSA
        byte[] claveDescifrada = descifrarRSA(claveCifrada, clavePrivada);
        SecretKey claveAES = new SecretKeySpec(claveDescifrada, "AES");

        // Descifrar el mensaje usando AES
        byte[] mensajeCifradoBytes = Base64.getDecoder().decode(mensajeCifrado);
        String mensajeDescifrado = descifrarAES(mensajeCifradoBytes, claveAES);

        // Descifrar y verificar el hash usando RSA
        byte[] hashDescifrado = descifrarRSA(hashCifrado, clavePrivada);

        // Verificar la firma
        boolean firmaValida = verificarFirma(hashCifrado, firma, clavePublica);

        // Verificar la integridad y autenticidad del mensaje
        byte[] hashMensaje = calcularHash(mensajeDescifrado.getBytes(StandardCharsets.UTF_8));
        boolean integridadValida = MessageDigest.isEqual(hashDescifrado, hashMensaje);

        // Mostrar el resultado
        System.out.println("Mensaje descifrado: " + mensajeDescifrado);
        System.out.println("Firma válida: " + firmaValida);
        System.out.println("Integridad válida: " + integridadValida);
    }

    public static SecretKey generarClaveAES() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256); // Tamaño de clave AES de 256 bits
        return keyGenerator.generateKey();
    }

    public static byte[] cifrarAES(byte[] mensaje, SecretKey claveAES) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, claveAES);
        return cipher.doFinal(mensaje);
    }

    public static String descifrarAES(byte[] mensajeCifrado, SecretKey claveAES) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, claveAES);
        byte[] mensajeDescifrado = cipher.doFinal(mensajeCifrado);
        return new String(mensajeDescifrado, StandardCharsets.UTF_8);
    }

    public static byte[] cifrarRSA(byte[] mensaje, Key clavePublica) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, clavePublica);
        return cipher.doFinal(mensaje);
    }

    public static byte[] descifrarRSA(byte[] mensajeCifrado, Key clavePrivada) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, clavePrivada);
        return cipher.doFinal(mensajeCifrado);
    }

    public static byte[] calcularHash(byte[] mensajeCifrado) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(mensajeCifrado);
    }

    public static byte[] firmar(byte[] mensaje, PrivateKey clavePrivada) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(clavePrivada);
        signature.update(mensaje);
        return signature.sign();
    }

    public static boolean verificarFirma(byte[] mensaje, byte[] firma, PublicKey clavePublica) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(clavePublica);
        signature.update(mensaje);
        return signature.verify(firma);
    }

    public static PublicKey cargarClavePublicaDesdeArchivo(String rutaArchivo) throws Exception {
        byte[] bytesClavePublica = leerArchivo(rutaArchivo);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(bytesClavePublica);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(spec);
    }

    public static PrivateKey cargarClavePrivadaDesdeArchivo(String rutaArchivo) throws Exception {
        byte[] bytesClavePrivada = leerArchivo(rutaArchivo);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(bytesClavePrivada);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(spec);
    }

    public static byte[] leerArchivo(String rutaArchivo) throws Exception {
        return Files.readAllBytes(Paths.get(rutaArchivo));
    }

    public static void guardarEnArchivo(String rutaArchivo, byte[] contenido) throws Exception {
        FileOutputStream fos = new FileOutputStream(rutaArchivo);
        fos.write(contenido);
        fos.close();
    }
}
