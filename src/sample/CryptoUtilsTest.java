package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * A tester for the CryptoUtils class.
 * @author www.codejava.net
 *
 */
public class CryptoUtilsTest {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        String key = "1234567891011121";

        PrintWriter writer = new PrintWriter("C:/Users/evilc/git/personal-projects/src/data/test documents/important stuff.txt", "UTF-8");
        writer.println("The first line");
        writer.println("The second line");
        writer.close();

        File inputFile = new File("C:/Users/evilc/git/personal-projects/src/data/test documents/important stuff.txt");
        File encryptedFile = new File("C:/Users/evilc/git/personal-projects/src/data/test documents/document.encrypted.txt");
        File decryptedFile = new File("C:/Users/evilc/git/personal-projects/src/data/test documents/document.decrypted.txt");

        try {
            CryptoUtils.encrypt(key, inputFile, encryptedFile);
            CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
        } catch (CryptoException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        inputFile.delete();
    }
}