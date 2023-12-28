package helper;

import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author staff
 */
public class SecretCode {

    private String text = "my-secret-code";
    private String secretKey = "your-secret-key"; // Change this to a strong secret key
    private byte[] salt;

    public void applyRandomSalt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] iv = new byte[16];
        secureRandom.nextBytes(iv);
        this.setSalt(iv);
    }

    public String encrypt() throws Exception {
        Cipher cipher = getCipher(Cipher.ENCRYPT_MODE, secretKey, salt);
        byte[] encryptedBytes = cipher.doFinal(text.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decrypt() throws Exception {
        Cipher cipher = getCipher(Cipher.DECRYPT_MODE, secretKey, salt);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(text));
        return new String(decryptedBytes);
    }

    private Cipher getCipher(int mode, String secretKey, byte[] salt) throws Exception {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt, 65536, 256);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec secretKeySpec = new SecretKeySpec(tmp.getEncoded(), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(salt);
        cipher.init(mode, secretKeySpec, iv);

        return cipher;
    }

    /**
     * @return the originalString
     */
    public String getText() {
        return text;
    }

    /**
     * @param originalString the originalString to set
     */
    public void setText(String texts) {
        this.text = texts;
    }

    /**
     * @return the secretKey
     */
    public String getSecretKey() {
        return secretKey;
    }

    /**
     * @param secretKey the secretKey to set
     */
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * @return the salt
     */
    public byte[] getSalt() {
        return salt;
    }

    public String getHumanSalt(){
        return Base64.getEncoder().encodeToString(this.getSalt());
    }
    
    /**
     * @param salt the salt to set
     */
    public void setSalt(byte[] salt) {
        this.salt = salt;
    }
}
