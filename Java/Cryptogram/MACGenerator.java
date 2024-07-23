package Java.Cryptogram;


import java.security.Key;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
 
public class MACGenerator {
 
    public byte[] calculateMACISO9797Alg3(Key key, byte[] data) throws Exception {

        // Form the DES keys from the provided key
        Key kl = formDESKey(Arrays.copyOfRange(key.getEncoded(), 0, 8));
        Key kr = formDESKey(Arrays.copyOfRange(key.getEncoded(), 8, 16));
 
        // Padding with 0x00 bytes if data length is not a multiple of 8
        if (data.length % 8 != 0) {
            byte[] t = new byte[data.length - data.length % 8 + 8];
            System.arraycopy(data, 0, t, 0, data.length);
            data = t;
        }
 
        // MAC_CBC alg 3
        byte[] y_i = new byte[8];
        byte[] yi = new byte[8];
        for (int i = 0; i < data.length; i += 8) {
            System.arraycopy(data, i, yi, 0, yi.length);
            y_i = encryptData(xor(yi, y_i), kl);
        }

        y_i = decryptData(y_i, kr);
        y_i = encryptData(y_i, kl);
        return y_i;

    }
 
    private Key formDESKey(byte[] keyBytes) {
        return new SecretKeySpec(keyBytes, "DES");
    }
 
    private byte[] xor(byte[] a, byte[] b) {
        byte[] result = new byte[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = (byte) (a[i] ^ b[i]);
        }
        return result;
    }
 
    private byte[] encryptData(byte[] data, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data);
    }
 
    private byte[] decryptData(byte[] data, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(data);
    }
 
    public static void main(String[] args) throws Exception {

        // Example usage

        // KeyGenerator keyGen = KeyGenerator.getInstance("DESede");

        // keyGen.init(168); // DESede key length (3 * 56 bits)

        // SecretKey key = keyGen.generateKey();
        String imkKey = "894F7F9EE60B13324FCD8F020B8C8534";
        SecretKey key = new SecretKeySpec(hexStringToByteArray(imkKey), "DESede");
        MACGenerator macGen = new MACGenerator();

        byte[] data = hexStringToByteArray("0000000500000000000000000356000000000003562407160178018C7C7C0000B6"); // Replace with your data
        byte[] mac = macGen.calculateMACISO9797Alg3(key, data);
        System.out.println("MAC: " + bytesToHex(mac));
    }
 
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }

    // Method to convert hexadecimal string to byte array
    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}

 