package helper;

/**
 *
 * @author staff
 */
import java.io.FileWriter;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.util.Base64;
import javax.crypto.KeyGenerator;

public class DataTransporter {

    static SecretKey secretKey = generateAESKey(128);

    public static void writeNow(String secretCode, String destinationDrive) {
        String newCode = encrypt(secretCode);
        String filename = destinationDrive + "fd.dat";
        writeToFile(filename, newCode);
        hideIt(filename);
        System.out.println("-Data Transported Success!");
    }

    private static void hideIt(String fileName) {
        CMDExecutor.executeCommand("attrib +s +h " + fileName);
    }

    public static SecretKey generateAESKey(int keyLength) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(keyLength);
            return keyGenerator.generateKey();
        } catch (Exception ex) {

        }

        return null;
    }

    public static String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
           
           
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
           
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void writeToFile(String fileName, String content) {
        try ( FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
