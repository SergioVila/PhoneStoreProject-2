/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.catalina.tribes.util.Arrays;

/**
 *
 * @author Sergio
 */
public class SandBox {

    private static String toHex(byte[] digest) {
        String hash = "";
        for (byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) {
                hash += "0";
            }
            hash += Integer.toHexString(b);
        }
        return hash;
    }

    public static byte[] charToByteArray(char[] pass) {

        byte[] b = new byte[pass.length];

        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) pass[i];
        }

        return b;
    }

    public static String getHash(char[] pass) {
        byte[] digest = null;
        byte[] buffer = charToByteArray(pass);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Error creando Hash");
        }
        return toHex(digest);
    }

    //El codigo comentado es solo para probar la funcionalidad. 
    public static void main(String[] args) {

        String p = "password";
        char[] ch = p.toCharArray();

        System.out.println("password " + getHash(ch));

        /*System.out.println("hola" + " MD5 " + getHash("hola", 1));
        System.out.println("hola" + " SHA-1 " + getHash("hola", 2));
        System.out.println("hola" + " SHA-256 " + getHash("hola", 3));
        System.out.println("hola" + " SHA-384 " + getHash("hola", 4));
        System.out.println("hola" + " SHA-512 " + getHash("hola", 5));*/
    }
}
